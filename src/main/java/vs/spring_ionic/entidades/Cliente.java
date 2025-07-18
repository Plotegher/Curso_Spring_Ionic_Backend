package vs.spring_ionic.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Cliente implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;
   @Column(unique = true)
   private String email;
   private String cpfCnpj;
   // Internamente a variável tipoCliente armazena um número inteiro,
   // mas externamente, para o sistema ela expõem o objeto TipoCliente.
   private Integer tipoCliente;

   @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
   private List<Endereco> enderecos = new ArrayList<>();

   // Telefones foi implementado por uma coleção Set ao invés de criar uma classe.
   @ElementCollection
   @CollectionTable(name = "TELEFONE")
   private Set<String> telefones = new HashSet<>();

   @JsonIgnore // Os pedidos de um cliente não serão serializados
   @OneToMany(mappedBy = "cliente")
   private List<Pedido> pedidos = new ArrayList<>();

   public Cliente() {}

   public Cliente(Integer id, String nome, String email, String cpfCnpj, TipoCliente tipoCliente)
   {
      this.id = id;
      this.nome = nome;
      this.email = email;
      this.cpfCnpj = cpfCnpj;
      // Modificado para receber um Integer
      this.tipoCliente = (tipoCliente == null) ? null : tipoCliente.getCodigo();
   }

   public Integer getId()
   {
      return id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getCpfCnpj()
   {
      return cpfCnpj;
   }

   public void setCpfCnpj(String cpfCnpj)
   {
      this.cpfCnpj = cpfCnpj;
   }

   public TipoCliente getTipoCliente()
   {
      // Recebeu método da enum TipoCliente
      return TipoCliente.converteParaEnum(tipoCliente);
   }

   public void setTipoCliente(TipoCliente tipoCliente)
   {
      // Modificado para receber um Integer
      this.tipoCliente = tipoCliente.getCodigo();
   }

   public List<Endereco> getEnderecos()
   {
      return enderecos;
   }

   public void setEnderecos(List<Endereco> enderecos)
   {
      this.enderecos = enderecos;
   }

   public Set<String> getTelefones()
   {
      return telefones;
   }

   public void setTelefones(Set<String> telefones)
   {
      this.telefones = telefones;
   }

   public List<Pedido> getPedidos()
   {
      return pedidos;
   }

   public void setPedidos(List<Pedido> pedidos)
   {
      this.pedidos = pedidos;
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == null || getClass() != o.getClass()) return false;
      Cliente cliente = (Cliente) o;
      return Objects.equals(id, cliente.id);
   }

   @Override
   public int hashCode()
   {
      return Objects.hashCode(id);
   }
}
