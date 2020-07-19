package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_tipo_pedido")
@NamedQueries({
	   @NamedQuery(name="TbTipoPedido.findAll", query="SELECT t FROM TbTipoPedido t")
})
public class TbTipoPedido implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_TIPO_PEDIDO_ID_TIPO_PEDIDO_SEQ_GENERATOR", sequenceName="TB_TIPO_PEDIDO_ID_TIPO_PEDIDO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_TIPO_PEDIDO_ID_TIPO_PEDIDO_SEQ_GENERATOR")
	   @Column(name="id_tipo_pedido")
	   private Integer idTipoPedido;
	   
	   @Column(name="descricao_tipo_pedido")
	   private String descricaoTipoPedido;
	   
	   public TbTipoPedido() {
	   }
	   
	   public Integer getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(Integer idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}

	public String getDescricaoTipoPedido() {
		   return this.descricaoTipoPedido;
	   }

	   public void setDescricaoTipoPedido(String descricaoTipoPedido) {
		   this.descricaoTipoPedido = descricaoTipoPedido;
	   }
	   
}