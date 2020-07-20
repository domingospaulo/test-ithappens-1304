package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_produto", schema = "public")
@NamedQueries({
	   @NamedQuery(name="TbProduto.findAll", query="SELECT t FROM TbProduto t")
})
public class TbProduto implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
	   @Id
	   @SequenceGenerator(name="TB_PRODUTO_ID_PRODUTO_SEQ_GENERATOR", sequenceName="TB_PRODUTO_ID_PRODUTO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PRODUTO_ID_PRODUTO_SEQ_GENERATOR")
	   @Column(name="id_produto")
	   private Integer idProduto;
	   
	   @Column(name="descricao_produto")
	   private String descricaoProduto;
	   
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "id_preco_produto")
	   private TbPrecoProduto idPrecoProduto;
	   
	   @Column(name="codigo_barras")
	   private String codigoBarras;
	   
	   public TbProduto() {
	   }
	   
	   public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricaoProduto() {
		   return this.descricaoProduto;
	   }

	   public void setDescricaoProduto(String descricaoProduto) {
		   this.descricaoProduto = descricaoProduto;
	   }
	   
	   
	   public TbPrecoProduto getIdPrecoProduto() {
		return idPrecoProduto;
	}

	public void setIdPrecoProduto(TbPrecoProduto idPrecoProduto) {
		this.idPrecoProduto = idPrecoProduto;
	}

	public String getCodigoBarras() {
		   return this.codigoBarras;
	   }

	   public void setCodigoBarras(String codigoBarras) {
		   this.codigoBarras = codigoBarras;
	   }
	   
}