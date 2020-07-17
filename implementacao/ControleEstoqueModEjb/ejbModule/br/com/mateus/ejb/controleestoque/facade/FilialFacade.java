package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbFilial;

@Local
public interface FilialFacade {
	   public abstract List<TbFilial> findAll();
	   public abstract void saveTbFilial(TbFilial tbFilial);
	   public abstract void updateTbFilial(TbFilial tbFilial);
	   public abstract void deleteTbFilial(TbFilial tbFilial);
	   public abstract List<TbFilial> findById(Integer idFilial);
}	   