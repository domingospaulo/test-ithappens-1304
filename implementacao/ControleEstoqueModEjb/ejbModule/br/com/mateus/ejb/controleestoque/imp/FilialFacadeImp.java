package br.com.mateus.ejb.controleestoque.imp;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.facade.FilialFacade;
import br.com.mateus.ejb.controleestoque.model.TbFilial;
import br.com.mateus.ejb.controleestoque.dao.TbFilialDAO;

@Stateless
@LocalBean
public class FilialFacadeImp  implements FilialFacade{
	   @EJB
	   private TbFilialDAO tbFilialDAO;
	   
	   @Override
	   public List<TbFilial> findAll() {
	   	   return tbFilialDAO.getLista();
	   }
	   
	   @Override
	   public void saveTbFilial(TbFilial tbFilial) {
	   	   tbFilialDAO.save(tbFilial);
	   }
	   	  
	   @Override
	   public void updateTbFilial(TbFilial tbFilial) {	   	   
	   		tbFilialDAO.update(tbFilial);
	   }
	   
	   @Override
	   public void deleteTbFilial(TbFilial tbFilial) {
	   	   tbFilialDAO.delete(tbFilial, TbFilial.class);
	   }
	   
	   @Override
	   public List<TbFilial> findById(Integer idFilial) {
	   	   return tbFilialDAO.findById(idFilial);
	   }
} 