package com.itm.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConsigneeLogout
 */
@WebServlet("/ConsigneeLogout")
public class ConsigneeLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsigneeLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			 HttpSession sesc=request.getSession();
	        	sesc.invalidate(); 
	        	response.sendRedirect("ConsigneeLogin"); 
	         }
        catch(Exception e)
        {
       	   response.sendRedirect("ConsigneeLogin"); 
        }
	}
}
