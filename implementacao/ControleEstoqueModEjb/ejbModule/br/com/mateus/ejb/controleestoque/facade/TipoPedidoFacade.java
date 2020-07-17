package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbTipoPedido;

@Local
public interface TipoPedidoFacade {
	   public abstract List<TbTipoPedido> findAll();
	   public abstract void saveTbTipoPedido(TbTipoPedido tbTipoPedido);
	   public abstract void updateTbTipoPedido(TbTipoPedido tbTipoPedido);
	   public abstract void deleteTbTipoPedido(TbTipoPedido tbTipoPedido);
	   public abstract List<TbTipoPedido> findById(Integer idTipoPedido);
}	   