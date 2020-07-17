package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.FormaPagamentoFacade;
import br.com.mateus.ejb.controleestoque.model.TbFormaPagamento;
import br.com.mateus.ejb.controleestoque.dao.TbFormaPagamentoDAO;

@Stateless
@LocalBean
public class FormaPagamentoFacadeImp  implements FormaPagamentoFacade{
	   @EJB
	   private TbFormaPagamentoDAO tbFormaPagamentoDAO;
	   
	   @Override
	   public List<TbFormaPagamento> findAll() {
	   	   return tbFormaPagamentoDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbFormaPagamento(TbFormaPagamento tbFormaPagamento) {
	   	   tbFormaPagamentoDAO.save(tbFormaPagamento);
	   }
	   	  
	   @Override
	   public void updateTbFormaPagamento(TbFormaPagamento tbFormaPagamento) {	   	   
	   		tbFormaPagamentoDAO.update(tbFormaPagamento);
	   }
	   
	   @Override
	   public void deleteTbFormaPagamento(TbFormaPagamento tbFormaPagamento) {
	   	   tbFormaPagamentoDAO.delete(tbFormaPagamento, TbFormaPagamento.class);
	   }
	   
	   @Override
	   public List<TbFormaPagamento> findById(Integer idFormaPagamento) {
	   	   return tbFormaPagamentoDAO.findById(idFormaPagamento);
	   }
} 