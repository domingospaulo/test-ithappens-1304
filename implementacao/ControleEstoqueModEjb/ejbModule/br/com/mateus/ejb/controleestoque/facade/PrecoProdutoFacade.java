package br.com.mateus.ejb.controleestoque.facade;

import java.util.List;
import javax.ejb.Local;
import br.com.mateus.ejb.controleestoque.model.TbPrecoProduto;

@Local
public interface PrecoProdutoFacade {
	   public abstract List<TbPrecoProduto> findAll();
	   public abstract void saveTbPrecoProduto(TbPrecoProduto tbPrecoProduto);
	   public abstract void updateTbPrecoProduto(TbPrecoProduto tbPrecoProduto);
	   public abstract void deleteTbPrecoProduto(TbPrecoProduto tbPrecoProduto);
	   public abstract List<TbPrecoProduto> findById(Integer idPrecoProduto);
}	   