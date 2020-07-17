package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.StatusPedidoFacade;
import br.com.mateus.ejb.controleestoque.model.TbStatusPedido;
import br.com.mateus.ejb.controleestoque.dao.TbStatusPedidoDAO;

@Stateless
@LocalBean
public class StatusPedidoFacadeImp  implements StatusPedidoFacade{
	   @EJB
	   private TbStatusPedidoDAO tbStatusPedidoDAO;
	   
	   @Override
	   public List<TbStatusPedido> findAll() {
	   	   return tbStatusPedidoDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbStatusPedido(TbStatusPedido tbStatusPedido) {
	   	   tbStatusPedidoDAO.save(tbStatusPedido);
	   }
	   	  
	   @Override
	   public void updateTbStatusPedido(TbStatusPedido tbStatusPedido) {	   	   
	   		tbStatusPedidoDAO.update(tbStatusPedido);
	   }
	   
	   @Override
	   public void deleteTbStatusPedido(TbStatusPedido tbStatusPedido) {
	   	   tbStatusPedidoDAO.delete(tbStatusPedido, TbStatusPedido.class);
	   }
	   
	   @Override
	   public List<TbStatusPedido> findById(Integer idStatusPedido) {
	   	   return tbStatusPedidoDAO.findById(idStatusPedido);
	   }
} 