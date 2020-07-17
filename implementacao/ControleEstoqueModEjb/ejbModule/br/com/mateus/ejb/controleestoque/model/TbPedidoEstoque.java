package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import br.com.mateus.ejb.controleestoque.model.TbFilial;
import br.com.mateus.ejb.controleestoque.model.TbStatusPedido;
import br.com.mateus.ejb.controleestoque.model.TbCliente;
import br.com.mateus.ejb.controleestoque.model.TbUsuario;
import br.com.mateus.ejb.controleestoque.model.TbTipoPedido;

@Entity
@Table(name="tb_pedido_estoque")
@NamedQueries({
	   @NamedQuery(name="TbPedidoEstoque.findAll", query="SELECT t FROM TbPedidoEstoque t")
})
public class TbPedidoEstoque implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_PEDIDO_ESTOQUE_ID_PEDIDO_ESTOQUE_SEQ_GENERATOR", sequenceName="TB_PEDIDO_ESTOQUE_ID_PEDIDO_ESTOQUE_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PEDIDO_ESTOQUE_ID_PEDIDO_ESTOQUE_SEQ_GENERATOR")
	   @Column(name="id_pedido_estoque")
	   private Integer idPedidoEstoque;
	   
	   @Column(name="data_pedido")
	   private Date dataPedido;
	   
	   @Column(name="id_forma_pagamento")
	   private Integer idFormaPagamento;
	   
	   @Column(name="observacao_pedido_estoque")
	   private String observacaoPedidoEstoque;
	   
	   @ManyToOne
	   @JoinColumn(name="id_filial")
	   private TbFilial idFilialFK;
	   
	   @ManyToOne
	   @JoinColumn(name="id_status_pedido")
	   private TbStatusPedido idStatusPedidoFK;
	   
	   @ManyToOne
	   @JoinColumn(name="id_cliente")
	   private TbCliente idClienteFK;
	   
	   @ManyToOne
	   @JoinColumn(name="id_usuario")
	   private TbUsuario idUsuarioFK;
	   
	   @ManyToOne
	   @JoinColumn(name="id_tipo_pedido")
	   private TbTipoPedido idTipoPedidoFK;
	   
	   public TbPedidoEstoque() {
	   }
	   
	   public Date getDataPedido() {
		   return this.dataPedido;
	   }

	   public void setDataPedido(Date dataPedido) {
		   this.dataPedido = dataPedido;
	   }
	   
	   public Integer getIdFormaPagamento() {
		   return this.idFormaPagamento;
	   }

	   public void setIdFormaPagamento(Integer idFormaPagamento) {
		   this.idFormaPagamento = idFormaPagamento;
	   }
	   
	   public String getObservacaoPedidoEstoque() {
		   return this.observacaoPedidoEstoque;
	   }

	   public void setObservacaoPedidoEstoque(String observacaoPedidoEstoque) {
		   this.observacaoPedidoEstoque = observacaoPedidoEstoque;
	   }
	   
	   public TbFilial getIdFilialFK() {
		   return this.idFilialFK;
	   }

	   public void setIdFilialFK(TbFilial idFilialFK) {
		   this.idFilialFK = idFilialFK;
	   }
	   
	   public TbStatusPedido getIdStatusPedidoFK() {
		   return this.idStatusPedidoFK;
	   }

	   public void setIdStatusPedidoFK(TbStatusPedido idStatusPedidoFK) {
		   this.idStatusPedidoFK = idStatusPedidoFK;
	   }
	   
	   public TbCliente getIdClienteFK() {
		   return this.idClienteFK;
	   }

	   public void setIdClienteFK(TbCliente idClienteFK) {
		   this.idClienteFK = idClienteFK;
	   }
	   
	   public TbUsuario getIdUsuarioFK() {
		   return this.idUsuarioFK;
	   }

	   public void setIdUsuarioFK(TbUsuario idUsuarioFK) {
		   this.idUsuarioFK = idUsuarioFK;
	   }
	   
	   public TbTipoPedido getIdTipoPedidoFK() {
		   return this.idTipoPedidoFK;
	   }

	   public void setIdTipoPedidoFK(TbTipoPedido idTipoPedidoFK) {
		   this.idTipoPedidoFK = idTipoPedidoFK;
	   }
	   
}