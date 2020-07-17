package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.PrecoProdutoFacade;
import br.com.mateus.ejb.controleestoque.model.TbPrecoProduto;
import br.com.mateus.ejb.controleestoque.dao.TbPrecoProdutoDAO;

@Stateless
@LocalBean
public class PrecoProdutoFacadeImp  implements PrecoProdutoFacade{
	   @EJB
	   private TbPrecoProdutoDAO tbPrecoProdutoDAO;
	   
	   @Override
	   public List<TbPrecoProduto> findAll() {
	   	   return tbPrecoProdutoDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbPrecoProduto(TbPrecoProduto tbPrecoProduto) {
	   	   tbPrecoProdutoDAO.save(tbPrecoProduto);
	   }
	   	  
	   @Override
	   public void updateTbPrecoProduto(TbPrecoProduto tbPrecoProduto) {	   	   
	   		tbPrecoProdutoDAO.update(tbPrecoProduto);
	   }
	   
	   @Override
	   public void deleteTbPrecoProduto(TbPrecoProduto tbPrecoProduto) {
	   	   tbPrecoProdutoDAO.delete(tbPrecoProduto, TbPrecoProduto.class);
	   }
	   
	   @Override
	   public List<TbPrecoProduto> findById(Integer idPrecoProduto) {
	   	   return tbPrecoProdutoDAO.findById(idPrecoProduto);
	   }
} 