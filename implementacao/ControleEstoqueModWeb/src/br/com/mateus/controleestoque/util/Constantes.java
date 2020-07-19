package br.com.mateus.controleestoque.util;

public class Constantes {

	//NAVEGAÇÃO
	public static final String PAGINA_PRINCIPAL = "/pages/principal.jsf?faces-redirect=true";
	public static final String PAGINA_LOGIN = "/login.jsf?faces-redirect=true";
	public static final String PAGINA_MANTER_USUARIO = "/pages/usuario/manterUsuario.jsf?faces-redirect=true";
	public static final String PAGINA_LISTAR_USUARIOS = "/pages/usuario/listarUsuarios.jsf?faces-redirect=true";
	
	//MENSAGENS GERAL
	public static final String MSG_ERRO_SISTEMA = "Falha no sistema. Tente novamente ou entre em contato com o administrador !";
	public static final String MSG_SUCCESS_HEADER = "Sucesso!";
	public static final String MSG_ERROR_HEADER = "Erro!";
	public static final String MSG_WARN_HEADER = "Atenção!";
	public static final String MSG_WARN = "As senhas informadas não conferem!";
	
	//MENSAGENS USUARIO
	public static final String MSG_SALVAR_USUARIO = "Usuário salvo com sucesso !";
	
	//MENSAGENS LOGIN
	public static final String MSG_LOGOFF_HEADER = "Logoff";
	public static final String MSG_LOGOFF = "Você Saiu do Controle de Estoque!";
}
