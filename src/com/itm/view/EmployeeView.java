package com.itm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeView
 */
@WebServlet("/EmployeeView")
public class EmployeeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
        out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
        out.println("<script src='asset/csc.js'></script>");
        out.println("<script src='asset/cnsCheck.js'></script>");
        out.println("<html>");
        out.println("<a href=EmployeeDisplayAll>Display All Employee</a><br>");
        out.println("<form action=EmployeeSubmit method=post enctype='multipart/form-data'>");
        out.println("<table width=70%>");
        out.println("<caption><b><i>Employee Registration</i></b></caption>");
        out.println("<tr>");
        out.println("<td><b><i>Employee Name:</i></b></td><td><input type=text name=employeename required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>DOB:</i></b></td><td><input type=date  required name=dob size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Address:</i></b></td><td><input type=text name=address required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Country:</i></b></td><td><select id=country name=country></select></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>State:</i></b></td><td><select id=state name=state><option>-Select-</option></select></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>City:</i></b></td><td><select id=city name=city><option>-Select-</option></select></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Mobile No:</i></b></td><td><input type=text name=mobileno required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Phone No:</i></b></td><td><input type=text name=phoneno required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Qualification:</i></b></td><td><input type=text name=qualification required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Designation:</i></b></td><td><input type=text name=designation required size=30></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Photo:</i></b></td><td><input type=file required name=photo></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Password:</i></b></td><td><input type=password required name=password size=30 id=password></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Confirm Password:</i></b></td><td><input type=password required name=cpassword size=30 id=cpassword>&nbsp;&nbsp;&nbsp;<span id=msg></span></td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><input type=submit id=btn></td><td><input type=reset></td>");
        out.println("</tr>");
        out.println("</table></form></html>");
        out.flush();
	}

}
