package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.ItensPedidoFacade;
import br.com.mateus.ejb.controleestoque.model.TbItensPedido;
import br.com.mateus.ejb.controleestoque.dao.TbItensPedidoDAO;

@Stateless
@LocalBean
public class ItensPedidoFacadeImp  implements ItensPedidoFacade{
	   @EJB
	   private TbItensPedidoDAO tbItensPedidoDAO;
	   
	   @Override
	   public List<TbItensPedido> findAll() {
	   	   return tbItensPedidoDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbItensPedido(TbItensPedido tbItensPedido) {
	   	   tbItensPedidoDAO.save(tbItensPedido);
	   }
	   	  
	   @Override
	   public void updateTbItensPedido(TbItensPedido tbItensPedido) {	   	   
	   		tbItensPedidoDAO.update(tbItensPedido);
	   }
	   
	   @Override
	   public void deleteTbItensPedido(TbItensPedido tbItensPedido) {
	   	   tbItensPedidoDAO.delete(tbItensPedido, TbItensPedido.class);
	   }
	   
	   @Override
	   public List<TbItensPedido> findById(Integer idItensPedido) {
	   	   return tbItensPedidoDAO.findById(idItensPedido);
	   }
} 