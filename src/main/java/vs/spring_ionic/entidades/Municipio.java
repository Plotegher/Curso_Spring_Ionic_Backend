package vs.spring_ionic.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Municipio implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;

   @ManyToOne
   @JoinColumn(name = "estado_id")
   private Estado estado;

   public Municipio() {}

   public Municipio(Integer id, String nome, Estado estado)
   {
      this.id = id;
      this.nome = nome;
      this.estado = estado;
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

   public Estado getEstado()
   {
      return estado;
   }

   public void setEstado(Estado estado)
   {
      this.estado = estado;
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == null || getClass() != o.getClass()) return false;
      Municipio municipio = (Municipio) o;
      return Objects.equals(id, municipio.id);
   }

   @Override
   public int hashCode()
   {
      return Objects.hashCode(id);
   }
}
