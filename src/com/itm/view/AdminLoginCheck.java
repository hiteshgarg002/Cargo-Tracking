package com.itm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itm.controller.AdminController;
import com.itm.model.Admin;

/**
 * Servlet implementation class AdminLoginCheck
 */
@WebServlet("/AdminLoginCheck")
public class AdminLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Cookie c[]=request.getCookies();
		if(c==null){
		String aid=request.getParameter("aid");
		String password=request.getParameter("password");
		Admin A=AdminController.checkLogin(aid,password);
		if(A!=null){
			Cookie u=new Cookie("username",aid);
			Cookie p=new Cookie("password",password);
			u.setMaxAge(10000000);
			p.setMaxAge(10000000);
		    response.addCookie(u);
		    response.addCookie(p);
			HttpSession ses=request.getSession();
			  ses.putValue("SADMIN", A);
			  ses.putValue("LTIME", new java.util.Date());
			response.sendRedirect("AdminHome");
		}
		else{
			out.print("Invalid ID/Password");
		}
		}
		else{
			String aid=request.getParameter("aid");
			String password=request.getParameter("password");
			Cookie user=null;
			Cookie pass=null;
			for(int i=0;i<c.length;i++){
				if(c[i].getName().equals("username")){
					user=c[i];
					
				}
				if(c[i].getName().equals("password")){
					pass=c[i];
				}
				break;
			}
			Admin A=AdminController.checkLogin(aid,password);
			if(A!=null){
				HttpSession ses=request.getSession();
				  ses.putValue("SADMIN", A);
				  ses.putValue("LTIME", new java.util.Date());
				  response.sendRedirect("AdminHome");
			}
			else{
				out.print("Invalid ID/Password");
			}
		}
	}

}
