package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbItensPedido;

@Local
public interface ItensPedidoFacade {
	   public abstract List<TbItensPedido> findAll();
	   public abstract void saveTbItensPedido(TbItensPedido tbItensPedido);
	   public abstract void updateTbItensPedido(TbItensPedido tbItensPedido);
	   public abstract void deleteTbItensPedido(TbItensPedido tbItensPedido);
	   public abstract List<TbItensPedido> findById(Integer idItensPedido);
}	   