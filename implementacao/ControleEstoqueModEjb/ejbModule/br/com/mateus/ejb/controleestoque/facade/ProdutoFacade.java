package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbProduto;

@Local
public interface ProdutoFacade {
	   public abstract List<TbProduto> findAll();
	   public abstract void saveTbProduto(TbProduto tbProduto);
	   public abstract void updateTbProduto(TbProduto tbProduto);
	   public abstract void deleteTbProduto(TbProduto tbProduto);
	   public abstract List<TbProduto> findById(Integer idProduto);
}	   