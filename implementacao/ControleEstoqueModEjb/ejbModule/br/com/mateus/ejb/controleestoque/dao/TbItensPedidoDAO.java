package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbItensPedido;
	     
@Stateless
@LocalBean
public class TbItensPedidoDAO  extends GenericDAO<TbItensPedido>{
	   
	   public TbItensPedidoDAO() {
	   	   super(TbItensPedido.class);
	   }
	   
	   public List<TbItensPedido> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbItensPedido.findAll", parameters);
	   }
	   
	   public List<TbItensPedido> findById(Integer idItensPedido) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idItensPedido like :idItensPedido ");
	   		parameters.put("idItensPedido", idItensPedido);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbItensPedido t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idItensPedido ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   