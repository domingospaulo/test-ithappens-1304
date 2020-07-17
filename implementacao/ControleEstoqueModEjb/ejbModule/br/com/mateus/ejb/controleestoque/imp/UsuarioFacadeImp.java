package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.UsuarioFacade;
import br.com.mateus.ejb.controleestoque.model.TbUsuario;
import br.com.mateus.ejb.controleestoque.dao.TbUsuarioDAO;

@Stateless
@LocalBean
public class UsuarioFacadeImp  implements UsuarioFacade{
	   @EJB
	   private TbUsuarioDAO tbUsuarioDAO;
	   
	   @Override
	   public List<TbUsuario> findAll() {
	   	   return tbUsuarioDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbUsuario(TbUsuario tbUsuario) {
	   	   tbUsuarioDAO.save(tbUsuario);
	   }
	   	  
	   @Override
	   public void updateTbUsuario(TbUsuario tbUsuario) {	   	   
	   		tbUsuarioDAO.update(tbUsuario);
	   }
	   
	   @Override
	   public void deleteTbUsuario(TbUsuario tbUsuario) {
	   	   tbUsuarioDAO.delete(tbUsuario, TbUsuario.class);
	   }
	   
	   @Override
	   public List<TbUsuario> findById(Integer idUsuario) {
	   	   return tbUsuarioDAO.findById(idUsuario);
	   }
} 