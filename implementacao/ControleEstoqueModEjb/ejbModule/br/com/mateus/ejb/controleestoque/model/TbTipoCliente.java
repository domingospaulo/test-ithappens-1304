package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_tipo_cliente")
@NamedQueries({
	   @NamedQuery(name="TbTipoCliente.findAll", query="SELECT t FROM TbTipoCliente t")
})
public class TbTipoCliente implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_TIPO_CLIENTE_ID_TIPO_CLIENTE_SEQ_GENERATOR", sequenceName="TB_TIPO_CLIENTE_ID_TIPO_CLIENTE_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_TIPO_CLIENTE_ID_TIPO_CLIENTE_SEQ_GENERATOR")
	   @Column(name="id_tipo_cliente")
	   private Integer idTipoCliente;
	   
	   @Column(name="descricao_tipo_cliente")
	   private String descricaoTipoCliente;
	   
	   public TbTipoCliente() {
	   }
	   
	   public String getDescricaoTipoCliente() {
		   return this.descricaoTipoCliente;
	   }

	   public void setDescricaoTipoCliente(String descricaoTipoCliente) {
		   this.descricaoTipoCliente = descricaoTipoCliente;
	   }
	   
}