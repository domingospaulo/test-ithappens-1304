package br.com.mateus.controleestoque.managedbeans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.mateus.controleestoque.util.Constantes;
import br.com.mateus.ejb.controleestoque.model.TbUsuario;

@Named("loginMB")
@ViewScoped
public class LoginMB implements Serializable{
	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private boolean loggedIn;
	
	public LoginMB() {
	}
	
	public String logar() {
		this.loggedIn = true;
		
		//Setando Usuário na sessão
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tbUsuario", new TbUsuario());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggedIn", this.loggedIn);
		
		return Constantes.PAGINA_PRINCIPAL;	
	}
	
	public String deslogarSistema(){
		this.loggedIn = false;
		
		//Setando Usuário na sessão
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tbUsuario", null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggedIn", this.loggedIn);
		
        FacesMessage msg = new FacesMessage(Constantes.MSG_LOGOFF, Constantes.MSG_LOGOFF_HEADER );
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("loginMB", null);
		session.invalidate();
		
		return Constantes.PAGINA_LOGIN;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
