package br.com.mateus.controleestoque.util;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import br.com.mateus.ejb.controleestoque.model.TbProduto;

public class ProdutoDataModel extends ListDataModel<TbProduto> implements SelectableDataModel<TbProduto> {  

    public ProdutoDataModel() {
    }

    public ProdutoDataModel(List<TbProduto> data) {
        super(data);
    }

    @Override
    public TbProduto getRowData(String rowKey) {
        @SuppressWarnings("unchecked")
		List<TbProduto> produtos = (List<TbProduto>) getWrappedData();
        
        for(TbProduto produto : produtos) {
            if(produto.getIdProduto().equals(rowKey))
                return produto;
        }

        return null;
    }

    @Override
    public Object getRowKey(TbProduto car) {
        return car.getIdProduto();
    }

}

