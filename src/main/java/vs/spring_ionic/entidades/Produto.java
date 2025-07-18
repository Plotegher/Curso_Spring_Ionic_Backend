package vs.spring_ionic.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Produto implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;
   private Double preco;

   @JsonIgnore
   @ManyToMany
   private List<Categoria> categorias = new ArrayList<>();

   @JsonIgnore
   @OneToMany(mappedBy = "id.produto")
   private Set<ItemPedido> itens = new HashSet<>();

   public Produto() {}

   public Produto(Integer id, String nome, Double preco)
   {
      this.id = id;
      this.nome = nome;
      this.preco = preco;
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

   public Double getPreco()
   {
      return preco;
   }

   public void setPreco(Double preco)
   {
      this.preco = preco;
   }

   public List<Categoria> getCategorias()
   {
      return categorias;
   }

   public void setCategorias(List<Categoria> categorias)
   {
      this.categorias = categorias;
   }

   public Set<ItemPedido> getItens()
   {
      return itens;
   }

   public void setItens(Set<ItemPedido> itens)
   {
      this.itens = itens;
   }

   @JsonIgnore
   public List<Pedido> getPedidos()
   {
      List<Pedido> lista = new ArrayList<>();
      for (ItemPedido i : itens)
      {
         lista.add(i.getPedido());
      }
      return lista;
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == null || getClass() != o.getClass()) return false;
      Produto produto = (Produto) o;
      return Objects.equals(id, produto.id);
   }

   @Override
   public int hashCode()
   {
      return Objects.hashCode(id);
   }
}
