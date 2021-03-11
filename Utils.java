package it.itsvita.byte19.ufc9.utils;

import javax.servlet.ServletContext;

import it.itsvita.byte19.ufc9.database.DatabaseAccess;

public class Utils {
	public static final String PARAM_USERNAME = "username";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_DATE = "currentDate";
    public static final String PARAM_DATABASE_ACCESS = "databaseAccess";
    public static final String PARAM_WRONG_PASSWORD = "wrongPassword";
    public static final String PARAM_RESULT = "result";
    public static final String PARAM_LAST_LOGIN_NAME = "lastUser";
    public static final String PARAM_INVALIDATE = "invalidate";
    
    // Load database from servlet context, shared by all servlets (or add to context if none is defined)
    public static DatabaseAccess loadDatabaseAccess(ServletContext servletContext) {
        DatabaseAccess databaseAccess = (DatabaseAccess)servletContext.getAttribute(PARAM_DATABASE_ACCESS);
        
        if(databaseAccess == null) {
            databaseAccess = new DatabaseAccess(); 
            servletContext.setAttribute(PARAM_DATABASE_ACCESS, databaseAccess);
        }
        
        return databaseAccess;
    }
}