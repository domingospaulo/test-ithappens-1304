package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;
import br.com.mateus.ejb.controleestoque.model.TbFilial;
import br.com.mateus.ejb.controleestoque.model.TbProduto;

@Entity
@Table(name="tb_estoque")
@NamedQueries({
	   @NamedQuery(name="TbEstoque.findAll", query="SELECT t FROM TbEstoque t")
})
public class TbEstoque implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_ESTOQUE_ID_ESTOQUE_SEQ_GENERATOR", sequenceName="TB_ESTOQUE_ID_ESTOQUE_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_ESTOQUE_ID_ESTOQUE_SEQ_GENERATOR")
	   @Column(name="id_estoque")
	   private Integer idEstoque;
	   
	   @Column(name="quantidade_estoque")
	   private Integer quantidadeEstoque;
	   
	   @ManyToOne
	   @JoinColumn(name="id_filial")
	   private TbFilial idFilialFK;
	   
	   @ManyToOne
	   @JoinColumn(name="id_produto")
	   private TbProduto idProdutoFK;
	   
	   public TbEstoque() {
	   }
	   
	   public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Integer getQuantidadeEstoque() {
		   return this.quantidadeEstoque;
	   }

	   public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		   this.quantidadeEstoque = quantidadeEstoque;
	   }
	   
	   public TbFilial getIdFilialFK() {
		   return this.idFilialFK;
	   }

	   public void setIdFilialFK(TbFilial idFilialFK) {
		   this.idFilialFK = idFilialFK;
	   }
	   
	   public TbProduto getIdProdutoFK() {
		   return this.idProdutoFK;
	   }

	   public void setIdProdutoFK(TbProduto idProdutoFK) {
		   this.idProdutoFK = idProdutoFK;
	   }
	   
}