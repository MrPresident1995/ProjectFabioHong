package it.itsvita.byte19.ufc9.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.itsvita.byte19.ufc9.database.DatabaseAccess;
import it.itsvita.byte19.ufc9.utils.Utils;

@WebServlet("/LoginHttpServlet")
public class LoginHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter(Utils.PARAM_USERNAME);
		String password = request.getParameter(Utils.PARAM_PASSWORD);

		DatabaseAccess database= Utils.loadDatabaseAccess(getServletContext());
		
		if(database.isNameDefined(name)) {
			if(database.isPasswordVerified(name, password)) {
			}
			else {	
				request.setAttribute(Utils.PARAM_WRONG_PASSWORD, "true");			
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
				return;
			}
		}
		else {			
			if(!(database.addName(name, password))) {				
				request.setAttribute(Utils.PARAM_WRONG_PASSWORD, "true");				
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
				return;
			}
		}
		
        HttpSession session = request.getSession();
        
        session.removeAttribute(Utils.PARAM_INVALIDATE);
        session.setAttribute(Utils.PARAM_USERNAME, name);
        session.setAttribute(Utils.PARAM_PASSWORD, password);
        
        Cookie lastUserCookie = null;
		String lastUserString = null;
		  
	    Cookie requestCookies[] = request.getCookies();
	   
	    if(requestCookies != null && requestCookies.length > 0) {
	    	for (int i = 0; i < requestCookies.length; i++) {
			    if(requestCookies[i].getName().equals(Utils.PARAM_LAST_LOGIN_NAME)) {
			    	lastUserCookie = requestCookies[i];
		      		break;
	     		}
	    	}
	   	}
	   
	    if(lastUserCookie == null) {
	    	lastUserCookie = new Cookie(Utils.PARAM_LAST_LOGIN_NAME, name); 
	    }
	    else {
	    	lastUserString = lastUserCookie.getValue();
	        lastUserCookie.setValue(name);
	    }
	    
	    lastUserCookie.setMaxAge(60 * 60 * 24 * 2);
	    response.addCookie(lastUserCookie);
	    
	    session.setAttribute(Utils.PARAM_LAST_LOGIN_NAME, lastUserString);
	     
	    request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
