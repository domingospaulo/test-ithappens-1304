package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.ProdutoFacade;
import br.com.mateus.ejb.controleestoque.model.TbPrecoProduto;
import br.com.mateus.ejb.controleestoque.model.TbProduto;
import br.com.mateus.ejb.controleestoque.dao.TbProdutoDAO;

@Stateless
@LocalBean
public class ProdutoFacadeImp  implements ProdutoFacade{
	   @EJB
	   private TbProdutoDAO tbProdutoDAO;
	   
	   @Override
	   public List<TbProduto> findAll() {
	   	   return tbProdutoDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbProduto(TbProduto tbProduto, TbPrecoProduto tbPrecoProduto) {
	   	   tbProdutoDAO.save(tbProduto, tbPrecoProduto);
	   }
	   	  
	   @Override
	   public void updateTbProduto(TbProduto tbProduto) {	   	   
	   		tbProdutoDAO.update(tbProduto);
	   }
	   
	   @Override
	   public void deleteTbProduto(TbProduto tbProduto) {
	   	   tbProdutoDAO.delete(tbProduto, TbProduto.class);
	   }
	   
	   @Override
	   public List<TbProduto> findById(Integer idProduto) {
	   	   return tbProdutoDAO.findById(idProduto);
	   }
} 