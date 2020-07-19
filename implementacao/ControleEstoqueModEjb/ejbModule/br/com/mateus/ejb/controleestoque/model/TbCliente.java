package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;
import br.com.mateus.ejb.controleestoque.model.TbTipoCliente;

@Entity
@Table(name="tb_cliente")
@NamedQueries({
	   @NamedQuery(name="TbCliente.findAll", query="SELECT t FROM TbCliente t")
})
public class TbCliente implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_CLIENTE_ID_CLIENTE_SEQ_GENERATOR", sequenceName="TB_CLIENTE_ID_CLIENTE_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_CLIENTE_ID_CLIENTE_SEQ_GENERATOR")
	   @Column(name="id_cliente")
	   private Integer idCliente;
	   
	   @Column(name="email_cliente")
	   private String emailCliente;
	   
	   @Column(name="telefone_cliente")
	   private String telefoneCliente;
	   
	   @Column(name="nome_cliente")
	   private String nomeCliente;
	   
	   @Column(name="documento_cliente")
	   private String documentoCliente;
	   
	   @ManyToOne
	   @JoinColumn(name="id_tipo_cliente")
	   private TbTipoCliente idTipoClienteFK;
	   
	   public TbCliente() {
	   }
	   
	   public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmailCliente() {
		   return this.emailCliente;
	   }

	   public void setEmailCliente(String emailCliente) {
		   this.emailCliente = emailCliente;
	   }
	   
	   public String getTelefoneCliente() {
		   return this.telefoneCliente;
	   }

	   public void setTelefoneCliente(String telefoneCliente) {
		   this.telefoneCliente = telefoneCliente;
	   }
	   
	   public String getNomeCliente() {
		   return this.nomeCliente;
	   }

	   public void setNomeCliente(String nomeCliente) {
		   this.nomeCliente = nomeCliente;
	   }
	   
	   public String getDocumentoCliente() {
		   return this.documentoCliente;
	   }

	   public void setDocumentoCliente(String documentoCliente) {
		   this.documentoCliente = documentoCliente;
	   }
	   
	   public TbTipoCliente getIdTipoClienteFK() {
		   return this.idTipoClienteFK;
	   }

	   public void setIdTipoClienteFK(TbTipoCliente idTipoClienteFK) {
		   this.idTipoClienteFK = idTipoClienteFK;
	   }
	   
}