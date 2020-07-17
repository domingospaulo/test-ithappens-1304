package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.ClienteFacade;
import br.com.mateus.ejb.controleestoque.model.TbCliente;
import br.com.mateus.ejb.controleestoque.dao.TbClienteDAO;

@Stateless
@LocalBean
public class ClienteFacadeImp  implements ClienteFacade{
	   @EJB
	   private TbClienteDAO tbClienteDAO;
	   
	   @Override
	   public List<TbCliente> findAll() {
	   	   return tbClienteDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbCliente(TbCliente tbCliente) {
	   	   tbClienteDAO.save(tbCliente);
	   }
	   	  
	   @Override
	   public void updateTbCliente(TbCliente tbCliente) {	   	   
	   		tbClienteDAO.update(tbCliente);
	   }
	   
	   @Override
	   public void deleteTbCliente(TbCliente tbCliente) {
	   	   tbClienteDAO.delete(tbCliente, TbCliente.class);
	   }
	   
	   @Override
	   public List<TbCliente> findById(Integer idCliente) {
	   	   return tbClienteDAO.findById(idCliente);
	   }
} 