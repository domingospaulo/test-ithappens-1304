package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbStatusPedido;

@Local
public interface StatusPedidoFacade {
	   public abstract List<TbStatusPedido> findAll();
	   public abstract void saveTbStatusPedido(TbStatusPedido tbStatusPedido);
	   public abstract void updateTbStatusPedido(TbStatusPedido tbStatusPedido);
	   public abstract void deleteTbStatusPedido(TbStatusPedido tbStatusPedido);
	   public abstract List<TbStatusPedido> findById(Integer idStatusPedido);
}	   