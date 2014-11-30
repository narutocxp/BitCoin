package com.bitcoin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bitcoin.model.User;
import com.bitcoin.service.UserService;
import com.bitcoin.service.WalletService;

/**
 * Servlet implementation class CheckWalletAddressServlet
 */

public class CheckWalletAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private WalletService walletService;
	@Autowired
	private UserService userService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String toAddress = request.getParameter("toAddress");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userMail = (String) session.getAttribute("USER_MAIL");
		User user = userService.get(userMail);
		if (walletService.isExistWalletAddress(toAddress))
			out.print(user.getUserName());
		else
			out.print(false);

		out.flush();
		out.close();

	}
	
	public void init(ServletConfig config) throws ServletException {  
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,  
	              config.getServletContext());  
	}  

}
