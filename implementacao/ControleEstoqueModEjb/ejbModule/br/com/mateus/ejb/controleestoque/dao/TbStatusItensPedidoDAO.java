package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbStatusItensPedido;
	     
@Stateless
@LocalBean
public class TbStatusItensPedidoDAO  extends GenericDAO<TbStatusItensPedido>{
	   
	   public TbStatusItensPedidoDAO() {
	   	   super(TbStatusItensPedido.class);
	   }
	   
	   public List<TbStatusItensPedido> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbStatusItensPedido.findAll", parameters);
	   }
	   
	   public List<TbStatusItensPedido> findById(Integer idStatusItensPedido) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idStatusItensPedido like :idStatusItensPedido ");
	   		parameters.put("idStatusItensPedido", idStatusItensPedido);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbStatusItensPedido t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idStatusItensPedido ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   