package com.itm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Cookie c[] = request.getCookies();
		if (c == null) {
			out.print("<html><form action=AdminLoginCheck method=post>");
			out.println(
					"<tabel><caption><b><i>Administation Login</i></b></caption></br><tr><td>Admin Id: <input type=text name=aid></td></br>");
			out.println("<td>Password: <input type=password name=password></td></br>");
			out.println("<td><input type=submit name=sign in><td><tr></table></form></html>");
		} else {
			Cookie user = null;
			Cookie pass = null;
			for (int i = 0; i < c.length; i++) {
				if (c[i].getName().equals("username")) {
					user = c[i];
				}
				if (c[i].getName().equals("password")) {
					pass = c[i];
				}
				break;
			}
			response.sendRedirect("AdminHome");
		}
	}
}
