package br.com.mateus.controleestoque.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.mateus.controleestoque.util.Constantes;
import br.com.mateus.controleestoque.util.FilialDataModel;
import br.com.mateus.controleestoque.util.MessageUtil;
import br.com.mateus.ejb.controleestoque.facade.FilialFacade;
import br.com.mateus.ejb.controleestoque.model.TbFilial;

@Named("filialMB")
@ViewScoped
public class FilialMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FilialFacade filialFacade;
	
	private String filtroCodigo;
	private String filtroNome;	
	
	private List<TbFilial> listaFiliais;
	private FilialDataModel listaFiliaisModel;
	
	private TbFilial filialEdicao;
	
	public FilialMB() {
		this.limpaFiltro();
	}
	
	public String novaFilial(){
		this.filialEdicao = new TbFilial();
		
		return Constantes.PAGINA_MANTER_FILIAL; 
	}
	
	public String editarFilial() {
		return Constantes.PAGINA_MANTER_FILIAL; 
	}
	
	public String voltarManterFilial() {
		return Constantes.PAGINA_LISTAR_FILIAIS; 	
	}
	
	public void limpaFiltro() {
		this.filtroCodigo = "";
		this.filtroNome = "";
		
		this.listaFiliais = new ArrayList<TbFilial>();
	}	
	
	private void limpaTelaManter() {
		this.filialEdicao = new TbFilial();
	}	

	public void filtrar(){
		try {
			this.listaFiliais = filialFacade.findAll();
			this.listaFiliaisModel = new FilialDataModel(this.listaFiliais);
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);			
		} catch (Exception e) {
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
		}
	}
	
	public String salvarAtualizar() {
		try {
				
				if (this.filialEdicao.getIdFilial() == null)
					this.filialFacade.saveTbFilial(this.filialEdicao);
				else
					this.filialFacade.updateTbFilial(this.filialEdicao);
				
				this.limpaTelaManter();
				
				PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
				MessageUtil.sucess(Constantes.MSG_SUCCESS_HEADER,  Constantes.MSG_SALVAR_FILIAL);					
				
				return Constantes.PAGINA_LISTAR_FILIAIS; 				
		} catch (Exception e) {
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);		
			
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			return Constantes.PAGINA_MANTER_FILIAL;
		}
	}

	//GETS e SETS
	public String getFiltroCodigo() {
		return filtroCodigo;
	}

	public void setFiltroCodigo(String filtroCodigo) {
		this.filtroCodigo = filtroCodigo;
	}

	public String getFiltroNome() {
		return filtroNome;
	}

	public void setFiltroNome(String filtroNome) {
		this.filtroNome = filtroNome;
	}

	public List<TbFilial> getListaFiliais() {
		return listaFiliais;
	}

	public void setListaFiliais(List<TbFilial> listaFiliais) {
		this.listaFiliais = listaFiliais;
	}

	public TbFilial getFilialEdicao() {
		return filialEdicao;
	}

	public void setFilialEdicao(TbFilial filialEdicao) {
		this.filialEdicao = filialEdicao;
	}

	public FilialDataModel getListaFiliaisModel() {
		return listaFiliaisModel;
	}

	public void setListaFiliaisModel(FilialDataModel listaFiliaisModel) {
		this.listaFiliaisModel = listaFiliaisModel;
	}
	
}
