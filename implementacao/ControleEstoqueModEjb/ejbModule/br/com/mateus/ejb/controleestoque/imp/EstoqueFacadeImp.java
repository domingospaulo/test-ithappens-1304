package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.EstoqueFacade;
import br.com.mateus.ejb.controleestoque.model.TbEstoque;
import br.com.mateus.ejb.controleestoque.dao.TbEstoqueDAO;

@Stateless
@LocalBean
public class EstoqueFacadeImp  implements EstoqueFacade{
	   @EJB
	   private TbEstoqueDAO tbEstoqueDAO;
	   
	   @Override
	   public List<TbEstoque> findAll() {
	   	   return tbEstoqueDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbEstoque(TbEstoque tbEstoque) {
	   	   tbEstoqueDAO.save(tbEstoque);
	   }
	   	  
	   @Override
	   public void updateTbEstoque(TbEstoque tbEstoque) {	   	   
	   		tbEstoqueDAO.update(tbEstoque);
	   }
	   
	   @Override
	   public void deleteTbEstoque(TbEstoque tbEstoque) {
	   	   tbEstoqueDAO.delete(tbEstoque, TbEstoque.class);
	   }
	   
	   @Override
	   public List<TbEstoque> findById(Integer idEstoque) {
	   	   return tbEstoqueDAO.findById(idEstoque);
	   }
} 