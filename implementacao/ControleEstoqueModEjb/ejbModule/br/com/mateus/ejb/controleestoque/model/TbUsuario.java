package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_usuario", schema = "public")
@NamedQueries({
	   @NamedQuery(name="TbUsuario.findAll", query="SELECT t FROM TbUsuario t")
})
public class TbUsuario implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
	   @Id
	   @SequenceGenerator(name="TB_USUARIO_ID_USUARIO_SEQ_GENERATOR", sequenceName="TB_USUARIO_ID_USUARIO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_USUARIO_ID_USUARIO_SEQ_GENERATOR")
	   @Column(name="id_usuario")
	   private Integer idUsuario;
	   
	   @Column(name="nome_usuario")
	   private String nomeUsuario;
	   
	   @Column(name="login_usuario")
	   private String loginUsuario;
	   
	   @Column(name="senha_usuario")
	   private String senhaUsuario;
	   
	   public TbUsuario() {
	   }
	   
	   public String getNomeUsuario() {
		   return this.nomeUsuario;
	   }

	   public void setNomeUsuario(String nomeUsuario) {
		   this.nomeUsuario = nomeUsuario;
	   }
	   
	   public String getLoginUsuario() {
		   return this.loginUsuario;
	   }

	   public void setLoginUsuario(String loginUsuario) {
		   this.loginUsuario = loginUsuario;
	   }
	   
	   public String getSenhaUsuario() {
		   return this.senhaUsuario;
	   }

	   public void setSenhaUsuario(String senhaUsuario) {
		   this.senhaUsuario = senhaUsuario;
	   }

		public Integer getIdUsuario() {
			return idUsuario;
		}
	
		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}
}