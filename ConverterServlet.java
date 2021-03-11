package it.itsvita.byte19.ufc9.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import it.itsvita.byte19.ufc9.converters.Converter;
import it.itsvita.byte19.ufc9.utils.Utils;

@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MS_TO_KMH = "ms_to_kmh";
	private static final String KMH_TO_MS = "kmh_to_ms";
	private static final String MS_TO_MT = "ms_to_mt";
	private static final String MT_TO_MS = "mt_to_ms";
    Converter converter;

    @Override
    public void init(ServletConfig config) throws ServletException {
        converter = new Converter();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("converter.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conversion = request.getParameter("conversion");
        float value = Float.parseFloat(request.getParameter("value"));
        float result;

        if(conversion.equals(MS_TO_KMH))
        	result= converter.convertMsKmh(value);
        else if(conversion.equals(KMH_TO_MS))
    		result= converter.convertKmhMs(value);
        else if(conversion.equals(MS_TO_MT))
        	result= converter.convertMlMt(value);
        else if(conversion.equals(MT_TO_MS))
        	result= converter.convertMtMl(value);
        else
        	result= -1;

        request.setAttribute(Utils.PARAM_RESULT, result);
		request.getRequestDispatcher("converter.jsp").forward(request, response);
    }
}