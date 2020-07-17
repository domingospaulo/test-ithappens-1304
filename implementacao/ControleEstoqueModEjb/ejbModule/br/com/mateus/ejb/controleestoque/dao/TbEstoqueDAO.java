package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbEstoque;
	     
@Stateless
@LocalBean
public class TbEstoqueDAO  extends GenericDAO<TbEstoque>{
	   
	   public TbEstoqueDAO() {
	   	   super(TbEstoque.class);
	   }
	   
	   public List<TbEstoque> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbEstoque.findAll", parameters);
	   }
	   
	   public List<TbEstoque> findById(Integer idEstoque) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idEstoque like :idEstoque ");
	   		parameters.put("idEstoque", idEstoque);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbEstoque t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idEstoque ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   