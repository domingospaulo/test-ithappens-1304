package br.com.mateus.controleestoque.util;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import br.com.mateus.ejb.controleestoque.model.TbFormaPagamento;

public class FormaPagamentoDataModel extends ListDataModel<TbFormaPagamento> implements SelectableDataModel<TbFormaPagamento> {  

    public FormaPagamentoDataModel() {
    }

    public FormaPagamentoDataModel(List<TbFormaPagamento> data) {
        super(data);
    }

    @Override
    public TbFormaPagamento getRowData(String rowKey) {
        @SuppressWarnings("unchecked")
		List<TbFormaPagamento> formasPagamento = (List<TbFormaPagamento>) getWrappedData();
        
        for(TbFormaPagamento formaPagamento : formasPagamento) {
            if(formaPagamento.getIdFormaPagamento().equals(rowKey))
                return formaPagamento;
        }

        return null;
    }

    @Override
    public Object getRowKey(TbFormaPagamento car) {
        return car.getIdFormaPagamento();
    }

}

