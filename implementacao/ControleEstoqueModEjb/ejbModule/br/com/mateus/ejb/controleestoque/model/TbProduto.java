package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_produto")
@NamedQueries({
	   @NamedQuery(name="TbProduto.findAll", query="SELECT t FROM TbProduto t")
})
public class TbProduto implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_PRODUTO_ID_PRODUTO_SEQ_GENERATOR", sequenceName="TB_PRODUTO_ID_PRODUTO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PRODUTO_ID_PRODUTO_SEQ_GENERATOR")
	   @Column(name="id_produto")
	   private Integer idProduto;
	   
	   @Column(name="descricao_produto")
	   private String descricaoProduto;
	   
	   @Column(name="id_preco_produto")
	   private Integer idPrecoProduto;
	   
	   @Column(name="codigo_barras")
	   private String codigoBarras;
	   
	   public TbProduto() {
	   }
	   
	   public String getDescricaoProduto() {
		   return this.descricaoProduto;
	   }

	   public void setDescricaoProduto(String descricaoProduto) {
		   this.descricaoProduto = descricaoProduto;
	   }
	   
	   public Integer getIdPrecoProduto() {
		   return this.idPrecoProduto;
	   }

	   public void setIdPrecoProduto(Integer idPrecoProduto) {
		   this.idPrecoProduto = idPrecoProduto;
	   }
	   
	   public String getCodigoBarras() {
		   return this.codigoBarras;
	   }

	   public void setCodigoBarras(String codigoBarras) {
		   this.codigoBarras = codigoBarras;
	   }
	   
}