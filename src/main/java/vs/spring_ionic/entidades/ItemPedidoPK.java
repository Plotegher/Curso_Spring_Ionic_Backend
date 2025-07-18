package vs.spring_ionic.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreType
@Embeddable
public class ItemPedidoPK implements Serializable
{
   @ManyToOne
   @JoinColumn(name = "pedido_id")
   private Pedido pedido;

   @ManyToOne
   @JoinColumn(name = "produto_id")
   private Produto produto;

   public Pedido getPedido()
   {
      return pedido;
   }

   public void setPedido(Pedido pedido)
   {
      this.pedido = pedido;
   }

   public Produto getProduto()
   {
      return produto;
   }

   public void setProduto(Produto produto)
   {
      this.produto = produto;
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == null || getClass() != o.getClass()) return false;
      ItemPedidoPK that = (ItemPedidoPK) o;
      return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(pedido, produto);
   }
}
