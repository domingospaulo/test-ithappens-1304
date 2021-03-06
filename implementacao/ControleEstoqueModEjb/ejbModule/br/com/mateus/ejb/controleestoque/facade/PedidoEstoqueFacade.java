package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbPedidoEstoque;

@Local
public interface PedidoEstoqueFacade {
	   public abstract List<TbPedidoEstoque> findAll();
	   public abstract void saveTbPedidoEstoque(TbPedidoEstoque tbPedidoEstoque);
	   public abstract void updateTbPedidoEstoque(TbPedidoEstoque tbPedidoEstoque);
	   public abstract void deleteTbPedidoEstoque(TbPedidoEstoque tbPedidoEstoque);
	   public abstract List<TbPedidoEstoque> findById(Integer idPedidoEstoque);
}	   