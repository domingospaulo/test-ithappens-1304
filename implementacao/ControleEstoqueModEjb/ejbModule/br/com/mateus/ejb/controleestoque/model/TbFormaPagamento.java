package br.com.mateus.ejb.controleestoque.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_forma_pagamento")
@NamedQueries({
	   @NamedQuery(name="TbFormaPagamento.findAll", query="SELECT t FROM TbFormaPagamento t")
})
public class TbFormaPagamento implements Serializable {
	   private static final long serialVersionUID = 1L;
	   
       @EmbeddedId
	   @SequenceGenerator(name="TB_FORMA_PAGAMENTO_ID_FORMA_PAGAMENTO_SEQ_GENERATOR", sequenceName="TB_FORMA_PAGAMENTO_ID_FORMA_PAGAMENTO_SEQ",allocationSize=1)
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_FORMA_PAGAMENTO_ID_FORMA_PAGAMENTO_SEQ_GENERATOR")
	   @Column(name="id_forma_pagamento")
	   private Integer idFormaPagamento;
	   
	   @Column(name="descricao_forma_pagamento")
	   private String descricaoFormaPagamento;
	   
	   public TbFormaPagamento() {
	   }
	   
	   public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}

	public void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	public String getDescricaoFormaPagamento() {
		   return this.descricaoFormaPagamento;
	   }

	   public void setDescricaoFormaPagamento(String descricaoFormaPagamento) {
		   this.descricaoFormaPagamento = descricaoFormaPagamento;
	   }
	   
}