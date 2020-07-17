package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbUsuario;

@Local
public interface UsuarioFacade {
	   public abstract List<TbUsuario> findAll();
	   public abstract void saveTbUsuario(TbUsuario tbUsuario);
	   public abstract void updateTbUsuario(TbUsuario tbUsuario);
	   public abstract void deleteTbUsuario(TbUsuario tbUsuario);
	   public abstract List<TbUsuario> findById(Integer idUsuario);
}	   