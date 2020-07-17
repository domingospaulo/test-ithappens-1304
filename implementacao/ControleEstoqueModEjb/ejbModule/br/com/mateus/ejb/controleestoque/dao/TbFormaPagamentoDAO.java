package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbFormaPagamento;
	     
@Stateless
@LocalBean
public class TbFormaPagamentoDAO  extends GenericDAO<TbFormaPagamento>{
	   
	   public TbFormaPagamentoDAO() {
	   	   super(TbFormaPagamento.class);
	   }
	   
	   public List<TbFormaPagamento> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbFormaPagamento.findAll", parameters);
	   }
	   
	   public List<TbFormaPagamento> findById(Integer idFormaPagamento) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idFormaPagamento like :idFormaPagamento ");
	   		parameters.put("idFormaPagamento", idFormaPagamento);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbFormaPagamento t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idFormaPagamento ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   