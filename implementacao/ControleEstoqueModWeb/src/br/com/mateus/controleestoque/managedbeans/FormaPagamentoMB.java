package br.com.mateus.controleestoque.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.mateus.controleestoque.util.Constantes;
import br.com.mateus.controleestoque.util.FormaPagamentoDataModel;
import br.com.mateus.controleestoque.util.MessageUtil;
import br.com.mateus.ejb.controleestoque.facade.FormaPagamentoFacade;
import br.com.mateus.ejb.controleestoque.model.TbFormaPagamento;

@Named("formaPagamentoMB")
@ViewScoped
public class FormaPagamentoMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FormaPagamentoFacade formaPagamentoFacade;
	
	private String filtroCodigo;
	private String filtroDescricao;	
	
	private List<TbFormaPagamento> listaFormaPagamento;
	private FormaPagamentoDataModel listaFormaPagamentoModel;
	
	private TbFormaPagamento formaPagamentoEdicao;
	
	public FormaPagamentoMB() {
		this.limpaFiltro();
	}
	
	public String novaFormaPagamento(){
		this.limpaTelaManter();
		
		return Constantes.PAGINA_MANTER_FORMA_PAGAMENTO; 
	}
	
	public String editarFormaPagamento() {
		return Constantes.PAGINA_MANTER_FORMA_PAGAMENTO; 
	}
	
	public String voltarManterFormaPagamento() {
		return Constantes.PAGINA_LISTAR_FORMAS_PAGAMENTO; 	
	}
	
	public void limpaFiltro() {
		this.filtroCodigo = "";
		this.filtroDescricao = "";
		
		this.listaFormaPagamento = new ArrayList<TbFormaPagamento>();
	}	
	
	private void limpaTelaManter() {
		this.formaPagamentoEdicao = new TbFormaPagamento();
	}	

	public void filtrar(){
		try {
			this.listaFormaPagamento = formaPagamentoFacade.findAll();
			this.listaFormaPagamentoModel = new FormaPagamentoDataModel(this.listaFormaPagamento);
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);			
		} catch (Exception e) {
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
		}
	}
	
	public String salvarAtualizar() {
		try {
				
				if (this.formaPagamentoEdicao.getIdFormaPagamento() == null)
					this.formaPagamentoFacade.saveTbFormaPagamento(this.formaPagamentoEdicao);
				else
					this.formaPagamentoFacade.updateTbFormaPagamento(this.formaPagamentoEdicao);
				
				this.limpaTelaManter();
				
				PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
				MessageUtil.sucess(Constantes.MSG_SUCCESS_HEADER,  Constantes.MSG_SALVAR_FORMA_PAGAMENTO);					
				
				return Constantes.PAGINA_LISTAR_FORMAS_PAGAMENTO; 				
		} catch (Exception e) {
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);		
			
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			return Constantes.PAGINA_MANTER_FORMA_PAGAMENTO;
		}
	}

	//GETS e SETS
	public String getFiltroCodigo() {
		return filtroCodigo;
	}

	public void setFiltroCodigo(String filtroCodigo) {
		this.filtroCodigo = filtroCodigo;
	}

	public String getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(String filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public List<TbFormaPagamento> getListaFormaPagamento() {
		return listaFormaPagamento;
	}

	public void setListaFormaPagamento(List<TbFormaPagamento> listaFormaPagamento) {
		this.listaFormaPagamento = listaFormaPagamento;
	}

	public FormaPagamentoDataModel getListaFormaPagamentoModel() {
		return listaFormaPagamentoModel;
	}

	public void setListaFormaPagamentoModel(FormaPagamentoDataModel listaFormaPagamentoModel) {
		this.listaFormaPagamentoModel = listaFormaPagamentoModel;
	}

	public TbFormaPagamento getFormaPagamentoEdicao() {
		return formaPagamentoEdicao;
	}

	public void setFormaPagamentoEdicao(TbFormaPagamento formaPagamentoEdicao) {
		this.formaPagamentoEdicao = formaPagamentoEdicao;
	}
}
