package br.com.mateus.controleestoque.util;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import br.com.mateus.ejb.controleestoque.model.TbPedidoEstoque;

public class PedidoDataModel extends ListDataModel<TbPedidoEstoque> implements SelectableDataModel<TbPedidoEstoque> {  

    public PedidoDataModel() {
    }

    public PedidoDataModel(List<TbPedidoEstoque> data) {
        super(data);
    }

    @Override
    public TbPedidoEstoque getRowData(String rowKey) {
        @SuppressWarnings("unchecked")
		List<TbPedidoEstoque> pedidos = (List<TbPedidoEstoque>) getWrappedData();
        
        for(TbPedidoEstoque pedido : pedidos) {
            if(pedido.getIdPedidoEstoque().equals(rowKey))
                return pedido;
        }

        return null;
    }

    @Override
    public Object getRowKey(TbPedidoEstoque car) {
        return car.getIdPedidoEstoque();
    }

}

