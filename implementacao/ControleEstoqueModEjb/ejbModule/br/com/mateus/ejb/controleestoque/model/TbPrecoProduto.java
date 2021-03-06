package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import br.com.mateus.ejb.controleestoque.model.TbProduto;

@Entity
@Table(name="tb_preco_produto", schema = "public")
@NamedQueries({
	   @NamedQuery(name="TbPrecoProduto.findAll", query="SELECT t FROM TbPrecoProduto t")
})
public class TbPrecoProduto implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
	   @Id
	   @SequenceGenerator(name="TB_PRECO_PRODUTO_ID_PRECO_PRODUTO_SEQ_GENERATOR", sequenceName="TB_PRECO_PRODUTO_ID_PRECO_PRODUTO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PRECO_PRODUTO_ID_PRECO_PRODUTO_SEQ_GENERATOR")
	   @Column(name="id_preco_produto")
	   private Integer idPrecoProduto;
	   
	   @Column(name="preco_unitario")
	   private double precoUnitario;
	   
	   @Column(name="inicio_vigencia")
	   private Date inicioVigencia;
	   
	   @Column(name="fim_vigencia")
	   private Date fimVigencia;
	   
	   @OneToOne(mappedBy = "idPrecoProduto")
	   private TbProduto idProdutoFK;
	   
	   public TbPrecoProduto() {
	   }
	   
	   public Integer getIdPrecoProduto() {
		return idPrecoProduto;
	}

	public void setIdPrecoProduto(Integer idPrecoProduto) {
		this.idPrecoProduto = idPrecoProduto;
	}

	public double getPrecoUnitario() {
		   return this.precoUnitario;
	   }

	   public void setPrecoUnitario(double precoUnitario) {
		   this.precoUnitario = precoUnitario;
	   }
	   
	   public Date getInicioVigencia() {
		   return this.inicioVigencia;
	   }

	   public void setInicioVigencia(Date inicioVigencia) {
		   this.inicioVigencia = inicioVigencia;
	   }
	   
	   public Date getFimVigencia() {
		   return this.fimVigencia;
	   }

	   public void setFimVigencia(Date fimVigencia) {
		   this.fimVigencia = fimVigencia;
	   }
	   
	   public TbProduto getIdProdutoFK() {
		   return this.idProdutoFK;
	   }

	   public void setIdProdutoFK(TbProduto idProdutoFK) {
		   this.idProdutoFK = idProdutoFK;
	   }
	   
}