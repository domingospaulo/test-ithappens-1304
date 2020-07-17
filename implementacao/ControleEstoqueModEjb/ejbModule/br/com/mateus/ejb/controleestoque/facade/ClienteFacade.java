package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbCliente;

@Local
public interface ClienteFacade {
	   public abstract List<TbCliente> findAll();
	   public abstract void saveTbCliente(TbCliente tbCliente);
	   public abstract void updateTbCliente(TbCliente tbCliente);
	   public abstract void deleteTbCliente(TbCliente tbCliente);
	   public abstract List<TbCliente> findById(Integer idCliente);
}	   