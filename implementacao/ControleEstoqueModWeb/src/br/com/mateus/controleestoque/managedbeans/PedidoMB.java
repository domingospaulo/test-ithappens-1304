package br.com.mateus.controleestoque.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.mateus.controleestoque.util.Constantes;
import br.com.mateus.controleestoque.util.MessageUtil;
import br.com.mateus.controleestoque.util.PedidoDataModel;
import br.com.mateus.ejb.controleestoque.facade.ClienteFacade;
import br.com.mateus.ejb.controleestoque.facade.EstoqueFacade;
import br.com.mateus.ejb.controleestoque.facade.FilialFacade;
import br.com.mateus.ejb.controleestoque.facade.FormaPagamentoFacade;
import br.com.mateus.ejb.controleestoque.facade.PedidoEstoqueFacade;
import br.com.mateus.ejb.controleestoque.facade.ProdutoFacade;
import br.com.mateus.ejb.controleestoque.facade.StatusPedidoFacade;
import br.com.mateus.ejb.controleestoque.facade.TipoPedidoFacade;
import br.com.mateus.ejb.controleestoque.model.TbCliente;
import br.com.mateus.ejb.controleestoque.model.TbFilial;
import br.com.mateus.ejb.controleestoque.model.TbFormaPagamento;
import br.com.mateus.ejb.controleestoque.model.TbItensPedido;
import br.com.mateus.ejb.controleestoque.model.TbPedidoEstoque;
import br.com.mateus.ejb.controleestoque.model.TbTipoPedido;

@Named("pedidoMB")
@ViewScoped
public class PedidoMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PedidoEstoqueFacade pedidoEstoqueFacade;
	
	@EJB
	private FilialFacade filialFacade;
	
	@EJB
	private TipoPedidoFacade tipoPedidoFacade;
	
	@EJB
	private FormaPagamentoFacade formaPagamentoFacade;
	
	@EJB
	private StatusPedidoFacade statusPedidoFacade;
	
	@EJB
	private ClienteFacade clienteFacade;	
	
	@EJB
	private EstoqueFacade estoqueFacade;
	
	@EJB
	private ProdutoFacade produtoFacade; 	
	
	private String filtroCodigo;
	private String filtroCliente;	
	
	private List<TbPedidoEstoque> listaPedidos;
	private PedidoDataModel listaPedidosModel;
	
	private List<TbFilial> listaFiliais;
	private List<TbTipoPedido> listaTiposPedido;

	private List<TbCliente> listaClientes;
	private List<TbFormaPagamento> listaFormasPagamento;
	
	private List<TbItensPedido> listaItensPedidos;
	
	private String tipoPedido;
	private String filial;
	private String cliente;
	private String formaPagamento;
	
	private TbPedidoEstoque pedidoEstoqueEdicao;
	
	public PedidoMB() {
		this.limpaFiltro();
	}
	
	@PostConstruct
	public void init(){
		try {
			this.listaFiliais = filialFacade.findAll();
			this.listaTiposPedido = tipoPedidoFacade.findAll();	
			this.listaFormasPagamento = formaPagamentoFacade.findAll();
			this.listaClientes = clienteFacade.findAll();
		} catch (Exception e) {
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
		}
	}
	public String novoPedidoEstoque(){
		this.limpaTelaManter();
		
		this.listaClientes = clienteFacade.findAll();
		
		return Constantes.PAGINA_MANTER_PEDIDO; 
	}
	
	public String visualizarPedidoEstoque() {
		return Constantes.PAGINA_MANTER_PEDIDO; 
	}
	
	public String voltarManterPedidoEstoque() {
		return Constantes.PAGINA_LISTAR_PEDIDOS; 	
	}
	
	public void limpaFiltro() {
		this.filtroCodigo = "";
		this.filtroCliente = "";
		
		this.listaPedidos = new ArrayList<TbPedidoEstoque>();
	}	
	
	private void limpaTelaManter() {
		this.pedidoEstoqueEdicao = new TbPedidoEstoque();
		this.listaItensPedidos = new ArrayList();
		
		this.filial = "1";
		this.tipoPedido = "1";
		this.formaPagamento = "1";
		this.cliente = "";		
	}	

	public void filtrar(){
		try {
			this.listaPedidos = pedidoEstoqueFacade.findAll();
			this.listaPedidosModel = new PedidoDataModel(this.listaPedidos);
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);			
		} catch (Exception e) {
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
		}
	}
	
	public String salvar() {
		try {
				//this.pedidoEstoqueFacade.saveTbPedidoEstoque(this.pedidoEstoqueEdicao);
				
				this.limpaTelaManter();
				
				PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
				MessageUtil.sucess(Constantes.MSG_SUCCESS_HEADER,  Constantes.MSG_SALVAR_PEDIDO);					
				
				return Constantes.PAGINA_LISTAR_PEDIDOS; 				
		} catch (Exception e) {
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);		
			
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			return Constantes.PAGINA_MANTER_PEDIDO;
		}
	}
	
	
	//GETS e SETS
	public ProdutoFacade getProdutoFacade() {
		return produtoFacade;
	}

	public void setProdutoFacade(ProdutoFacade produtoFacade) {
		this.produtoFacade = produtoFacade;
	}

	public String getFiltroCodigo() {
		return filtroCodigo;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setFiltroCodigo(String filtroCodigo) {
		this.filtroCodigo = filtroCodigo;
	}

	public String getFiltroCliente() {
		return filtroCliente;
	}

	public void setFiltroCliente(String filtroCliente) {
		this.filtroCliente = filtroCliente;
	}

	public List<TbPedidoEstoque> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<TbPedidoEstoque> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public PedidoDataModel getListaPedidosModel() {
		return listaPedidosModel;
	}

	public void setListaPedidosModel(PedidoDataModel listaPedidosModel) {
		this.listaPedidosModel = listaPedidosModel;
	}

	public List<TbFilial> getListaFiliais() {
		return listaFiliais;
	}

	public void setListaFiliais(List<TbFilial> listaFiliais) {
		this.listaFiliais = listaFiliais;
	}
	
	public List<TbFormaPagamento> getListaFormasPagamento() {
		return listaFormasPagamento;
	}

	public void setListaFormasPagamento(List<TbFormaPagamento> listaFormasPagamento) {
		this.listaFormasPagamento = listaFormasPagamento;
	}

	public List<TbTipoPedido> getListaTiposPedido() {
		return listaTiposPedido;
	}

	public void setListaTiposPedido(List<TbTipoPedido> listaTiposPedido) {
		this.listaTiposPedido = listaTiposPedido;
	}

	public List<TbCliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<TbCliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<TbItensPedido> getListaItensPedidos() {
		return listaItensPedidos;
	}

	public void setListaItensPedidos(List<TbItensPedido> listaItensPedidos) {
		this.listaItensPedidos = listaItensPedidos;
	}

	public TbPedidoEstoque getPedidoEstoqueEdicao() {
		return pedidoEstoqueEdicao;
	}

	public void setPedidoEstoqueEdicao(TbPedidoEstoque pedidoEstoqueEdicao) {
		this.pedidoEstoqueEdicao = pedidoEstoqueEdicao;
	}
}
