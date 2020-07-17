package br.com.mateus.ejb.controleestoque.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.mateus.ejb.controleestoque.dao.GenericDAO;
import br.com.mateus.ejb.controleestoque.model.TbPrecoProduto;
	     
@Stateless
@LocalBean
public class TbPrecoProdutoDAO  extends GenericDAO<TbPrecoProduto>{
	   
	   public TbPrecoProdutoDAO() {
	   	   super(TbPrecoProduto.class);
	   }
	   
	   public List<TbPrecoProduto> getLista() {
	   	   Map<String, Object> parameters = new HashMap<String, Object>();
	   
	       return super.getLista("TbPrecoProduto.findAll", parameters);
	   }
	   
	   public List<TbPrecoProduto> findById(Integer idPrecoProduto) {
	    	Map<String, Object> parameters = new HashMap<String, Object>();
	     	StringBuilder builderSQL = new StringBuilder();
	   		StringBuilder builderWhere =  new StringBuilder();
	   		
	   		builderWhere.append(" and t.idPrecoProduto like :idPrecoProduto ");
	   		parameters.put("idPrecoProduto", idPrecoProduto);	
	   		
	   		builderSQL.append(" SELECT " );
	   		builderSQL.append(" t ");
	   		builderSQL.append(" FROM ");
	   		builderSQL.append(" TbPrecoProduto t");
	   		builderSQL.append(" WHERE ");
	   		builderSQL.append(builderWhere);
	   		builderSQL.append(" ORDER BY t.idPrecoProduto ASC ");
	   
	   		return super.getListaPorQuery(builderSQL.toString(), parameters);
	   }   
	 
}   