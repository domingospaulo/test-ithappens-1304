package br.com.mateus.controleestoque.util;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import br.com.mateus.ejb.controleestoque.model.TbCliente;

public class ClienteDataModel extends ListDataModel<TbCliente> implements SelectableDataModel<TbCliente> {  

    public ClienteDataModel() {
    }

    public ClienteDataModel(List<TbCliente> data) {
        super(data);
    }

    @Override
    public TbCliente getRowData(String rowKey) {
        @SuppressWarnings("unchecked")
		List<TbCliente> clientes = (List<TbCliente>) getWrappedData();
        
        for(TbCliente cliente : clientes) {
            if(cliente.getIdCliente().equals(rowKey))
                return cliente;
        }

        return null;
    }

    @Override
    public Object getRowKey(TbCliente car) {
        return car.getIdCliente();
    }

}

