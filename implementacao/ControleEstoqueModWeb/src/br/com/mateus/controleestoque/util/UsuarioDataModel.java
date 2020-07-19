package br.com.mateus.controleestoque.util;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import br.com.mateus.ejb.controleestoque.model.TbUsuario;

public class UsuarioDataModel extends ListDataModel<TbUsuario> implements SelectableDataModel<TbUsuario> {  

    public UsuarioDataModel() {
    }

    public UsuarioDataModel(List<TbUsuario> data) {
        super(data);
    }

    @Override
    public TbUsuario getRowData(String rowKey) {
        @SuppressWarnings("unchecked")
		List<TbUsuario> usuarios = (List<TbUsuario>) getWrappedData();
        
        for(TbUsuario usuario : usuarios) {
            if(usuario.getIdUsuario().equals(rowKey))
                return usuario;
        }

        return null;
    }

    @Override
    public Object getRowKey(TbUsuario car) {
        return car.getIdUsuario();
    }

}

