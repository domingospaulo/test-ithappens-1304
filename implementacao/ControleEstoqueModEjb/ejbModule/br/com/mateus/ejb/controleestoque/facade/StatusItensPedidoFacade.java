package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbStatusItensPedido;

@Local
public interface StatusItensPedidoFacade {
	   public abstract List<TbStatusItensPedido> findAll();
	   public abstract void saveTbStatusItensPedido(TbStatusItensPedido tbStatusItensPedido);
	   public abstract void updateTbStatusItensPedido(TbStatusItensPedido tbStatusItensPedido);
	   public abstract void deleteTbStatusItensPedido(TbStatusItensPedido tbStatusItensPedido);
	   public abstract List<TbStatusItensPedido> findById(Integer idStatusItensPedido);
}	   