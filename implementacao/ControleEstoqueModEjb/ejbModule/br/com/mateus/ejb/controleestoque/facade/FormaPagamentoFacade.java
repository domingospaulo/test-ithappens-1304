package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbFormaPagamento;

@Local
public interface FormaPagamentoFacade {
	   public abstract List<TbFormaPagamento> findAll();
	   public abstract void saveTbFormaPagamento(TbFormaPagamento tbFormaPagamento);
	   public abstract void updateTbFormaPagamento(TbFormaPagamento tbFormaPagamento);
	   public abstract void deleteTbFormaPagamento(TbFormaPagamento tbFormaPagamento);
	   public abstract List<TbFormaPagamento> findById(Integer idFormaPagamento);
}	   