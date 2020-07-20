package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;
import br.com.mateus.ejb.controleestoque.model.TbStatusItensPedido;
import br.com.mateus.ejb.controleestoque.model.TbPedidoEstoque;
import br.com.mateus.ejb.controleestoque.model.TbProduto;

@Entity
@Table(name="tb_itens_pedido", schema = "public")
@NamedQueries({
	   @NamedQuery(name="TbItensPedido.findAll", query="SELECT t FROM TbItensPedido t")
})
public class TbItensPedido implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
	   @Id
	   @SequenceGenerator(name="TB_ITENS_PEDIDO_ID_ITENS_PEDIDO_SEQ_GENERATOR", sequenceName="TB_ITENS_PEDIDO_ID_ITENS_PEDIDO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_ITENS_PEDIDO_ID_ITENS_PEDIDO_SEQ_GENERATOR")
	   @Column(name="id_itens_pedido")
	   private Integer idItensPedido;
	   
	   public Integer getIdItensPedido() {
		return idItensPedido;
	}

	public void setIdItensPedido(Integer idItensPedido) {
		this.idItensPedido = idItensPedido;
	}

	@Column(name="quantidade_itens_pedido")
	   private Integer quantidadeItensPedido;
	   
	   @Column(name="valor_total_itens_pedido")
	   private float valorTotalItensPedido;
	   
	   @ManyToOne
	   @JoinColumn(name="id_status_itens_pedido")
	   private TbStatusItensPedido idStatusItensPedidoFK;
	   
	   @ManyToOne
	   @JoinColumn(name="id_pedido_estoque")
	   private TbPedidoEstoque idPedidoEstoqueFK;
	   
	   @ManyToOne
	   @JoinColumn(name="id_produto")
	   private TbProduto idProdutoFK;
	   
	   public TbItensPedido() {
	   }
	   
	   public Integer getQuantidadeItensPedido() {
		   return this.quantidadeItensPedido;
	   }

	   public void setQuantidadeItensPedido(Integer quantidadeItensPedido) {
		   this.quantidadeItensPedido = quantidadeItensPedido;
	   }
	   
	   public float getValorTotalItensPedido() {
		   return this.valorTotalItensPedido;
	   }

	   public void setValorTotalItensPedido(float valorTotalItensPedido) {
		   this.valorTotalItensPedido = valorTotalItensPedido;
	   }
	   
	   public TbStatusItensPedido getIdStatusItensPedidoFK() {
		   return this.idStatusItensPedidoFK;
	   }

	   public void setIdStatusItensPedidoFK(TbStatusItensPedido idStatusItensPedidoFK) {
		   this.idStatusItensPedidoFK = idStatusItensPedidoFK;
	   }
	   
	   public TbPedidoEstoque getIdPedidoEstoqueFK() {
		   return this.idPedidoEstoqueFK;
	   }

	   public void setIdPedidoEstoqueFK(TbPedidoEstoque idPedidoEstoqueFK) {
		   this.idPedidoEstoqueFK = idPedidoEstoqueFK;
	   }
	   
	   public TbProduto getIdProdutoFK() {
		   return this.idProdutoFK;
	   }

	   public void setIdProdutoFK(TbProduto idProdutoFK) {
		   this.idProdutoFK = idProdutoFK;
	   }
	   
}