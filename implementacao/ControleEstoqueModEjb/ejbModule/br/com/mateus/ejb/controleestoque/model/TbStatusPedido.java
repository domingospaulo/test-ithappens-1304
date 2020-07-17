package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_status_pedido")
@NamedQueries({
	   @NamedQuery(name="TbStatusPedido.findAll", query="SELECT t FROM TbStatusPedido t")
})
public class TbStatusPedido implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_STATUS_PEDIDO_ID_STATUS_PEDIDO_SEQ_GENERATOR", sequenceName="TB_STATUS_PEDIDO_ID_STATUS_PEDIDO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_STATUS_PEDIDO_ID_STATUS_PEDIDO_SEQ_GENERATOR")
	   @Column(name="id_status_pedido")
	   private Integer idStatusPedido;
	   
	   @Column(name="descricao_status_pedido")
	   private String descricaoStatusPedido;
	   
	   public TbStatusPedido() {
	   }
	   
	   public String getDescricaoStatusPedido() {
		   return this.descricaoStatusPedido;
	   }

	   public void setDescricaoStatusPedido(String descricaoStatusPedido) {
		   this.descricaoStatusPedido = descricaoStatusPedido;
	   }
	   
}