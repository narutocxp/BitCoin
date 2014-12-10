package com.bitcoin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckVcodeServlet
 */
public class CheckVcodeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  
		   String vcode=request.getParameter("vcode");
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=response.getWriter();
		   HttpSession session=request.getSession();
		   
		   if(((String)session.getAttribute(RANDOMCODEKEY)).toLowerCase().equals(vcode))
			   out.print(true);
		   
		   else 
		       out.print(false);	
		
		   out.flush();
		   out.close();
	}
       
}
