package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbStatusPedido;
	     
@Stateless
@LocalBean
public class TbStatusPedidoDAO  extends GenericDAO<TbStatusPedido>{
	   
	   public TbStatusPedidoDAO() {
	   	   super(TbStatusPedido.class);
	   }
	   
	   public List<TbStatusPedido> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbStatusPedido.findAll", parameters);
	   }
	   
	   public List<TbStatusPedido> findById(Integer idStatusPedido) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idStatusPedido like :idStatusPedido ");
	   		parameters.put("idStatusPedido", idStatusPedido);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbStatusPedido t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idStatusPedido ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   