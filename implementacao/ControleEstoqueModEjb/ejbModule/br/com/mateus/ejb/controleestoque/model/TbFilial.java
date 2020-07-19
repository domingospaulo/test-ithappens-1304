package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_filial")
@NamedQueries({
	   @NamedQuery(name="TbFilial.findAll", query="SELECT t FROM TbFilial t")
})
public class TbFilial implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_FILIAL_ID_FILIAL_SEQ_GENERATOR", sequenceName="TB_FILIAL_ID_FILIAL_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_FILIAL_ID_FILIAL_SEQ_GENERATOR")
	   @Column(name="id_filial")
	   private Integer idFilial;
	   
	   @Column(name="telefone_filial")
	   private String telefoneFilial;
	   
	   @Column(name="nome_filial")
	   private String nomeFilial;
	   
	   public TbFilial() {
	   }
	   
	   public Integer getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(Integer idFilial) {
		this.idFilial = idFilial;
	}

	public String getTelefoneFilial() {
		   return this.telefoneFilial;
	   }

	   public void setTelefoneFilial(String telefoneFilial) {
		   this.telefoneFilial = telefoneFilial;
	   }
	   
	   public String getNomeFilial() {
		   return this.nomeFilial;
	   }

	   public void setNomeFilial(String nomeFilial) {
		   this.nomeFilial = nomeFilial;
	   }
	   
}