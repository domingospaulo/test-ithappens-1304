package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbTipoPedido;
	     
@Stateless
@LocalBean
public class TbTipoPedidoDAO  extends GenericDAO<TbTipoPedido>{
	   
	   public TbTipoPedidoDAO() {
	   	   super(TbTipoPedido.class);
	   }
	   
	   public List<TbTipoPedido> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbTipoPedido.findAll", parameters);
	   }
	   
	   public List<TbTipoPedido> findById(Integer idTipoPedido) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idTipoPedido like :idTipoPedido ");
	   		parameters.put("idTipoPedido", idTipoPedido);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbTipoPedido t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idTipoPedido ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   