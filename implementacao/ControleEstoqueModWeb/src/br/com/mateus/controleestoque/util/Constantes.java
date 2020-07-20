package br.com.mateus.controleestoque.util;

public class Constantes {
	
	public static final String PF_DIALOG = "PF('statusDialog').hide();";

	//NAVEGAÇÃO
	public static final String PAGINA_PRINCIPAL = "/pages/principal.jsf?faces-redirect=true";
	public static final String PAGINA_LOGIN = "/login.jsf?faces-redirect=true";
	public static final String PAGINA_MANTER_USUARIO = "/pages/usuario/manterUsuario.jsf?faces-redirect=true";
	public static final String PAGINA_LISTAR_USUARIOS = "/pages/usuario/listarUsuarios.jsf?faces-redirect=true";
	public static final String PAGINA_MANTER_CLIENTE = "/pages/cliente/manterCliente.jsf?faces-redirect=true";
	public static final String PAGINA_LISTAR_CLIENTES = "/pages/cliente/listarClientes.jsf?faces-redirect=true";
	public static final String PAGINA_MANTER_FILIAL = "/pages/filial/manterFilial.jsf?faces-redirect=true";
	public static final String PAGINA_LISTAR_FILIAIS = "/pages/filial/listarFiliais.jsf?faces-redirect=true";
	public static final String PAGINA_MANTER_FORMA_PAGAMENTO = "/pages/formaPagamento/manterFormaPagamento.jsf?faces-redirect=true";
	public static final String PAGINA_LISTAR_FORMAS_PAGAMENTO = "/pages/formaPagamento/listarFormaPagamento.jsf?faces-redirect=true";	
	public static final String PAGINA_MANTER_PRODUTO = "/pages/produto/manterProduto.jsf?faces-redirect=true";
	public static final String PAGINA_LISTAR_PRODUTOS = "/pages/produto/listarProdutos.jsf?faces-redirect=true";	
	public static final String PAGINA_MANTER_PEDIDO = "/pages/pedido/novoPedido.jsf?faces-redirect=true";
	public static final String PAGINA_LISTAR_PEDIDOS = "/pages/pedido/listarPedidos.jsf?faces-redirect=true";	
	
	//MENSAGENS GERAL
	public static final String MSG_ERRO_SISTEMA = "Falha no sistema. Tente novamente ou entre em contato com o administrador !";
	public static final String MSG_SUCCESS_HEADER = "Sucesso!";
	public static final String MSG_ERROR_HEADER = "Erro!";
	public static final String MSG_WARN_HEADER = "Atenção!";
	public static final String MSG_WARN = "As senhas informadas não conferem!";
	
	//MENSAGENS TELAS
	public static final String MSG_SALVAR_USUARIO = "Usuário salvo com sucesso !";
	public static final String MSG_SALVAR_FILIAL = "Filial salvo com sucesso !";
	public static final String MSG_SALVAR_CLIENTE = "Cliente salvo com sucesso !";
	public static final String MSG_SALVAR_FORMA_PAGAMENTO = "Forma de Pagamento salva com sucesso !";
	public static final String MSG_SALVAR_PRODUTO = "Produto salvo com sucesso !";
	public static final String MSG_SALVAR_PEDIDO = "Pedido cadastrado com sucesso !";
	
	public static final String MSG_ATUALIZAR_USUARIO = "Usuário atualizado com sucesso !";
	public static final String MSG_ATUALIZAR_FILIAL = "Filial atualizada com sucesso !";
	public static final String MSG_ATUALIZAR_CLIENTE = "Cliente atualizado com sucesso !";
	public static final String MSG_ATUALIZAR_PRODUTO = "Produto atualizado com sucesso !";
	public static final String MSG_ATUALIZAR_FORMA_PAGAMENTO = "Forma de Pagamento atualizada com sucesso !";
	
	//MENSAGENS LOGIN
	public static final String MSG_LOGOFF_HEADER = "Logoff";
	public static final String MSG_LOGOFF = "Você Saiu do Controle de Estoque!";
}
