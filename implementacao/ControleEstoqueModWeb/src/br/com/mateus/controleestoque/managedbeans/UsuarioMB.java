package br.com.mateus.controleestoque.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.mateus.controleestoque.util.Constantes;
import br.com.mateus.controleestoque.util.MessageUtil;
import br.com.mateus.controleestoque.util.UsuarioDataModel;
import br.com.mateus.ejb.controleestoque.facade.UsuarioFacade;
import br.com.mateus.ejb.controleestoque.model.TbUsuario;

@Named("usuarioMB")
@ViewScoped
public class UsuarioMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioFacade usuarioFacade;
	
	private String filtroLogin;
	private String filtroNome;
	private String senha;
	private String confirmeSenha;
	
	private List<TbUsuario> listaUsuarios;
	private UsuarioDataModel listaUsuariosModel;
	
	private TbUsuario usuarioEdicao;
	
	public UsuarioMB() {
		this.limpaFiltro();
	}
	
	public String novoUsuario(){
		this.limpaTelaManter();
		
		return Constantes.PAGINA_MANTER_USUARIO; 
	}
	
	public String editarUsuario() {
		return Constantes.PAGINA_MANTER_USUARIO; 
	}
	
	public String voltarManterUsuario() {
		return Constantes.PAGINA_LISTAR_USUARIOS; 	
	}

	public void filtrar(){
		try {
			this.listaUsuarios = usuarioFacade.findAll();
			this.listaUsuariosModel = new UsuarioDataModel(this.listaUsuarios);
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);			
		} catch (Exception e) {
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
		}
	}

	public void limpaFiltro() {
		this.filtroLogin = "";
		this.filtroNome = "";
		
		this.listaUsuarios = new ArrayList<TbUsuario>();
	}
	
	private boolean validarSenha(){
		if (this.senha.equals(this.confirmeSenha))
			return true;
		else
			return false;
	}
	
	private void limpaTelaManter() {
		this.senha = "";
		this.confirmeSenha = "";	
		
		this.usuarioEdicao = new TbUsuario();
	}
	
	public String salvarAtualizar() {
		try {
			if (this.validarSenha()) {
				this.usuarioEdicao.setSenhaUsuario(this.senha);
				
				if (this.usuarioEdicao.getIdUsuario() == null)
					this.usuarioFacade.saveTbUsuario(usuarioEdicao);
				else
					this.usuarioFacade.updateTbUsuario(usuarioEdicao);
				
				this.limpaTelaManter();
				
				PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
				MessageUtil.sucess(Constantes.MSG_SUCCESS_HEADER,  Constantes.MSG_SALVAR_USUARIO);					
				
				return Constantes.PAGINA_LISTAR_USUARIOS; 				
			}else {
				this.limpaTelaManter();
				
				PrimeFaces.current().executeScript(Constantes.PF_DIALOG);	
				MessageUtil.warn(Constantes.MSG_WARN_HEADER,  Constantes.MSG_WARN);	
				
				return Constantes.PAGINA_MANTER_USUARIO;
			}
		} catch (Exception e) {
			PrimeFaces.current().executeScript(Constantes.PF_DIALOG);		
			
			MessageUtil.error(Constantes.MSG_ERROR_HEADER, Constantes.MSG_ERRO_SISTEMA);	
			e.printStackTrace();
			
			return Constantes.PAGINA_MANTER_USUARIO;
		}
	}
	
	//GETS e SETS
	public String getFiltroLogin() {
		return filtroLogin;
	}

	public UsuarioDataModel getListaUsuariosModel() {
		return listaUsuariosModel;
	}

	public void setListaUsuariosModel(UsuarioDataModel listaUsuariosModel) {
		this.listaUsuariosModel = listaUsuariosModel;
	}
	public void setFiltroLogin(String filtroLogin) {
		this.filtroLogin = filtroLogin;
	}

	public String getFiltroNome() {
		return filtroNome;
	}

	public void setFiltroNome(String filtroNome) {
		this.filtroNome = filtroNome;
	}

	public List<TbUsuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<TbUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public TbUsuario getUsuarioEdicao() {
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(TbUsuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmeSenha() {
		return confirmeSenha;
	}

	public void setConfirmeSenha(String confirmeSenha) {
		this.confirmeSenha = confirmeSenha;
	}
	
}