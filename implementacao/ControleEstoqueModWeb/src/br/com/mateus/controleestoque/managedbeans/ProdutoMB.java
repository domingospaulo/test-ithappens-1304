package br.com.mateus.controleestoque.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.mateus.controleestoque.util.Constantes;
import br.com.mateus.controleestoque.util.MessageUtil;
import br.com.mateus.controleestoque.util.ProdutoDataModel;
import br.com.mateus.ejb.controleestoque.facade.PrecoProdutoFacade;
import br.com.mateus.ejb.controleestoque.facade.ProdutoFacade;
import br.com.mateus.ejb.controleestoque.model.TbPrecoProduto;
import br.com.mateus.ejb.controleestoque.model.TbProduto;

@Named("produtoMB")
@ViewScoped
public class ProdutoMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProdutoFacade produtoFacade;
	
	@EJB
	private PrecoProdutoFacade precoProdutoFacade;
	
	private String filtroCodigoBarras;
	private String filtroDescricao;	
	private double valorProduto;
	
	private List<TbProduto> listaProduto;
	private ProdutoDataModel listaProdutosModel;
	
	private TbProduto produtoEdicao;
	
	public ProdutoMB() {
		this.limpaFiltro();
	}
	
	public String novoProduto(){
		this.limpaTelaManter();
		
		return Constantes.PAGINA_MANTER_PRODUTO; 
	}
	
	public String editarProduto() {
		return Constantes.PAGINA_MANTER_PRODUTO; 
	}
	
	public String voltarManterProduto() {
		return Constantes.PAGINA_LISTAR_PRODUTOS; 	
	}
	
	public void limpaFiltro() {
		this.filtroCodigoBarras = "";
		this.filtroDescricao = "";
		
		this.listaProduto = new ArrayList<TbProduto>();
	}	
	
	private void limpaTelaManter() {
		this.produtoEdicao = new TbProduto();
		this.valorProduto = 0;
	}	

	public void filtrar(){
		try {
			this.listaProduto = produtoFacade.findAll();
			this.listaProdutosModel = new ProdutoDataModel(this.listaProduto);
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);			
		} catch (Exception e) {
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
		}
	}
	
	public String salvarAtualizar() {
		try {
				if (this.produtoEdicao.getIdProduto() == null) {
					TbPrecoProduto precoProduto = new TbPrecoProduto();
					precoProduto.setIdProdutoFK(this.produtoEdicao);
					precoProduto.setInicioVigencia(new Date());
					precoProduto.setPrecoUnitario(this.valorProduto);
					
					this.produtoEdicao.setIdPrecoProduto(precoProduto);
					produtoFacade.saveTbProduto(this.produtoEdicao, precoProduto);
				}else {
					if (this.produtoEdicao.getIdPrecoProduto().getPrecoUnitario() == this.valorProduto) {
						produtoFacade.updateTbProduto(this.produtoEdicao);
					}else {
						TbPrecoProduto precoAnterior = this.produtoEdicao.getIdPrecoProduto();
						precoAnterior.setFimVigencia(new Date());
						
						precoProdutoFacade.updateTbPrecoProduto(precoAnterior);
						
						TbPrecoProduto novoPreco = new TbPrecoProduto();
						novoPreco.setIdProdutoFK(this.produtoEdicao);
						novoPreco.setInicioVigencia(new Date());
						novoPreco.setPrecoUnitario(this.valorProduto);
						
						precoProdutoFacade.saveTbPrecoProduto(novoPreco);
						
						this.produtoEdicao.setIdPrecoProduto(novoPreco);
						produtoFacade.updateTbProduto(this.produtoEdicao);
					}
				}
				
				this.limpaTelaManter();
				
				PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
				MessageUtil.sucess(Constantes.MSG_SUCCESS_HEADER,  Constantes.MSG_SALVAR_PRODUTO);					
				
				return Constantes.PAGINA_LISTAR_PRODUTOS; 				
		} catch (Exception e) {
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);		
			
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			return Constantes.PAGINA_MANTER_PRODUTO;
		}
	}

	public String getFiltroCodigoBarras() {
		return filtroCodigoBarras;
	}

	public void setFiltroCodigoBarras(String filtroCodigoBarras) {
		this.filtroCodigoBarras = filtroCodigoBarras;
	}

	public String getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(String filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public List<TbProduto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<TbProduto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public ProdutoDataModel getListaProdutosModel() {
		return listaProdutosModel;
	}

	public void setListaProdutosModel(ProdutoDataModel listaProdutosModel) {
		this.listaProdutosModel = listaProdutosModel;
	}

	public TbProduto getProdutoEdicao() {
		return produtoEdicao;
	}

	public void setProdutoEdicao(TbProduto produtoEdicao) {
		this.produtoEdicao = produtoEdicao;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
}
