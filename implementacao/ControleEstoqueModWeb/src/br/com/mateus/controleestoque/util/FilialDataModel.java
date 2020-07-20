package br.com.mateus.controleestoque.util;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import br.com.mateus.ejb.controleestoque.model.TbFilial;
import br.com.mateus.ejb.controleestoque.model.TbUsuario;

public class FilialDataModel extends ListDataModel<TbFilial> implements SelectableDataModel<TbFilial> {  

    public FilialDataModel() {
    }

    public FilialDataModel(List<TbFilial> data) {
        super(data);
    }

    @Override
    public TbFilial getRowData(String rowKey) {
        @SuppressWarnings("unchecked")
		List<TbFilial> filiais = (List<TbFilial>) getWrappedData();
        
        for(TbFilial filial : filiais) {
            if(filial.getIdFilial().equals(rowKey))
                return filial;
        }

        return null;
    }

    @Override
    public Object getRowKey(TbFilial car) {
        return car.getIdFilial();
    }

}

