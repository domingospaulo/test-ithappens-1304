package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.TipoPedidoFacade;
import br.com.mateus.ejb.controleestoque.model.TbTipoPedido;
import br.com.mateus.ejb.controleestoque.dao.TbTipoPedidoDAO;

@Stateless
@LocalBean
public class TipoPedidoFacadeImp  implements TipoPedidoFacade{
	   @EJB
	   private TbTipoPedidoDAO tbTipoPedidoDAO;
	   
	   @Override
	   public List<TbTipoPedido> findAll() {
	   	   return tbTipoPedidoDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbTipoPedido(TbTipoPedido tbTipoPedido) {
	   	   tbTipoPedidoDAO.save(tbTipoPedido);
	   }
	   	  
	   @Override
	   public void updateTbTipoPedido(TbTipoPedido tbTipoPedido) {	   	   
	   		tbTipoPedidoDAO.update(tbTipoPedido);
	   }
	   
	   @Override
	   public void deleteTbTipoPedido(TbTipoPedido tbTipoPedido) {
	   	   tbTipoPedidoDAO.delete(tbTipoPedido, TbTipoPedido.class);
	   }
	   
	   @Override
	   public List<TbTipoPedido> findById(Integer idTipoPedido) {
	   	   return tbTipoPedidoDAO.findById(idTipoPedido);
	   }
} 