package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_status_itens_pedido")
@NamedQueries({
	   @NamedQuery(name="TbStatusItensPedido.findAll", query="SELECT t FROM TbStatusItensPedido t")
})
public class TbStatusItensPedido implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_STATUS_ITENS_PEDIDO_ID_STATUS_ITENS_PEDIDO_SEQ_GENERATOR", sequenceName="TB_STATUS_ITENS_PEDIDO_ID_STATUS_ITENS_PEDIDO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_STATUS_ITENS_PEDIDO_ID_STATUS_ITENS_PEDIDO_SEQ_GENERATOR")
	   @Column(name="id_status_itens_pedido")
	   private Integer idStatusItensPedido;
	   
	   @Column(name="descricao_status_itens_pedido")
	   private Integer descricaoStatusItensPedido;
	   
	   public TbStatusItensPedido() {
	   }
	   
	   public Integer getDescricaoStatusItensPedido() {
		   return this.descricaoStatusItensPedido;
	   }

	   public void setDescricaoStatusItensPedido(Integer descricaoStatusItensPedido) {
		   this.descricaoStatusItensPedido = descricaoStatusItensPedido;
	   }
	   
}