package br.com.mateus.controleestoque.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.mateus.ejb.controleestoque.model.TbUsuario;
  
public class AdminFilter implements Filter {
  
    public void destroy() {
    }
  
    public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException {
    	
       HttpServletRequest req = (HttpServletRequest) request;
       HttpServletResponse res = (HttpServletResponse) response;
       
       HttpSession sess = ((HttpServletRequest) request).getSession(true);
       
       TbUsuario usuario = null;
       
       if (sess.getAttribute("tbUsuario") != null)
    	   usuario = (TbUsuario) sess.getAttribute("tbUsuario");
       
       boolean loggedIn = false;
       
       if (sess.getAttribute("loggedIn") != null)
    	   loggedIn = (boolean) sess.getAttribute("loggedIn");
       
       if (usuario == null || (usuario != null && loggedIn == false)) {
    	   req.getSession().invalidate();
		   req.getRequestDispatcher("/login.jsf?faces-redirect=true").forward(request, response); 
       }
  
       chain.doFilter(request, response);
  
    }
  
    public void init(FilterConfig arg0) throws ServletException {
    }

}