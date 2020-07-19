package br.com.mateus.controleestoque.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.mateus.controleestoque.util.ClienteDataModel;
import br.com.mateus.controleestoque.util.Constantes;
import br.com.mateus.controleestoque.util.MessageUtil;
import br.com.mateus.ejb.controleestoque.facade.ClienteFacade;
import br.com.mateus.ejb.controleestoque.facade.TipoClienteFacade;
import br.com.mateus.ejb.controleestoque.model.TbCliente;
import br.com.mateus.ejb.controleestoque.model.TbTipoCliente;

@Named("clienteMB")
@ViewScoped
public class ClienteMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade clienteFacade;
	
	@EJB
	private TipoClienteFacade tipoClienteFacade;
	
	private String filtroNome;
	private String filtroDocumento;
	
	private TbCliente clienteEdicao;
	private String tipoCliente;
	
	private List<TbTipoCliente> listaTipoCliente;
	private List<TbCliente> listaClientes;
	private ClienteDataModel listaClientesModel;
	
	
	public ClienteMB() {
		this.limpaFiltro();
	}
	
	public String novoCliente(){
		this.clienteEdicao = new TbCliente();
		this.tipoCliente = "1";
		
		return Constantes.PAGINA_MANTER_CLIENTE; 
	}
	
	public String editarCliente() {
		return Constantes.PAGINA_MANTER_CLIENTE; 
	}
	
	public String voltarManterCliente() {
		return Constantes.PAGINA_LISTAR_CLIENTES; 	
	}

	public void filtrar(){
		try {
			this.listaClientes = clienteFacade.findAll();
			this.listaClientesModel = new ClienteDataModel(this.listaClientes);
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);			
		} catch (Exception e) {
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
		}
	}
	
	public void limpaFiltro() {
		this.filtroNome = "";
		this.filtroDocumento = "";
		
		this.listaClientes = new ArrayList<TbCliente>();
	}
	
	private void limpaTelaManter() {
		this.tipoCliente = "1";
		
		this.clienteEdicao = new TbCliente();
	}
	
	public String salvarAtualizar() {
		try {
				if (this.clienteEdicao.getIdCliente() == null)
					this.clienteFacade.saveTbCliente(this.clienteEdicao);
				else
					this.clienteFacade.updateTbCliente(this.clienteEdicao);
				
				this.limpaTelaManter();
				
				PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
				MessageUtil.sucess(Constantes.MSG_SUCCESS_HEADER,  Constantes.MSG_SALVAR_CLIENTE);					
				
				return Constantes.PAGINA_LISTAR_CLIENTES; 				
		} catch (Exception e) {
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);		
			
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			return Constantes.PAGINA_MANTER_CLIENTE;
		}
	}

	public TipoClienteFacade getTipoClienteFacade() {
		return tipoClienteFacade;
	}

	public void setTipoClienteFacade(TipoClienteFacade tipoClienteFacade) {
		this.tipoClienteFacade = tipoClienteFacade;
	}

	public String getFiltroNome() {
		return filtroNome;
	}

	public void setFiltroNome(String filtroNome) {
		this.filtroNome = filtroNome;
	}

	public String getFiltroDocumento() {
		return filtroDocumento;
	}

	public void setFiltroDocumento(String filtroDocumento) {
		this.filtroDocumento = filtroDocumento;
	}

	public TbCliente getClienteEdicao() {
		return clienteEdicao;
	}

	public void setClienteEdicao(TbCliente clienteEdicao) {
		this.clienteEdicao = clienteEdicao;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<TbTipoCliente> getListaTipoCliente() {
		return listaTipoCliente;
	}

	public void setListaTipoCliente(List<TbTipoCliente> listaTipoCliente) {
		this.listaTipoCliente = listaTipoCliente;
	}

	public List<TbCliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<TbCliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ClienteDataModel getListaClientesModel() {
		return listaClientesModel;
	}

	public void setListaClientesModel(ClienteDataModel listaClientesModel) {
		this.listaClientesModel = listaClientesModel;
	}
	
}
