package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbProduto;
	     
@Stateless
@LocalBean
public class TbProdutoDAO  extends GenericDAO<TbProduto>{
	   
	   public TbProdutoDAO() {
	   	   super(TbProduto.class);
	   }
	   
	   public List<TbProduto> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbProduto.findAll", parameters);
	   }
	   
	   public List<TbProduto> findById(Integer idProduto) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idProduto like :idProduto ");
	   		parameters.put("idProduto", idProduto);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbProduto t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idProduto ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   