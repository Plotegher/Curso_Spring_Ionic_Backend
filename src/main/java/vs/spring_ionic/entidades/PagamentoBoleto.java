package vs.spring_ionic.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class PagamentoBoleto extends Pagamento
{
   @JsonFormat(pattern = "dd/MM/yyyy")
   private Date dataVencimento;
   @JsonFormat(pattern = "dd/MM/yyyy")
   private Date dataPagamento;

   public PagamentoBoleto() {}

   public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido,
                          Date dataVencimento, Date dataPagamento)
   {
      super(id, estado, pedido);
      this.dataVencimento = dataVencimento;
      this.dataPagamento = dataPagamento;
   }

   public Date getDataVencimento()
   {
      return dataVencimento;
   }

   public void setDataVencimento(Date dataVencimento)
   {
      this.dataVencimento = dataVencimento;
   }

   public Date getDataPagamento()
   {
      return dataPagamento;
   }

   public void setDataPagamento(Date dataPagamento)
   {
      this.dataPagamento = dataPagamento;
   }
}
