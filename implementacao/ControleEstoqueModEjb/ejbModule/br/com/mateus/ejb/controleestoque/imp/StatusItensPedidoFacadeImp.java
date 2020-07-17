package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.StatusItensPedidoFacade;
import br.com.mateus.ejb.controleestoque.model.TbStatusItensPedido;
import br.com.mateus.ejb.controleestoque.dao.TbStatusItensPedidoDAO;

@Stateless
@LocalBean
public class StatusItensPedidoFacadeImp  implements StatusItensPedidoFacade{
	   @EJB
	   private TbStatusItensPedidoDAO tbStatusItensPedidoDAO;
	   
	   @Override
	   public List<TbStatusItensPedido> findAll() {
	   	   return tbStatusItensPedidoDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbStatusItensPedido(TbStatusItensPedido tbStatusItensPedido) {
	   	   tbStatusItensPedidoDAO.save(tbStatusItensPedido);
	   }
	   	  
	   @Override
	   public void updateTbStatusItensPedido(TbStatusItensPedido tbStatusItensPedido) {	   	   
	   		tbStatusItensPedidoDAO.update(tbStatusItensPedido);
	   }
	   
	   @Override
	   public void deleteTbStatusItensPedido(TbStatusItensPedido tbStatusItensPedido) {
	   	   tbStatusItensPedidoDAO.delete(tbStatusItensPedido, TbStatusItensPedido.class);
	   }
	   
	   @Override
	   public List<TbStatusItensPedido> findById(Integer idStatusItensPedido) {
	   	   return tbStatusItensPedidoDAO.findById(idStatusItensPedido);
	   }
} 