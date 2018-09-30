package com.itm.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itm.controller.ConsigneeController;
import com.itm.model.Consignee;

/**
 * Servlet implementation class ConsigneeEditDelete
 */
@WebServlet("/ConsigneeEditDelete")
public class ConsigneeEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsigneeEditDelete() {
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
		String btn = request.getParameter("btn");
		if (btn.equals("Edit")) {
			Consignee C = new Consignee();
			C.setId(Integer.parseInt(request.getParameter("cid")));
			C.setFirm_name(request.getParameter("firmname"));
			C.setRegistration_no(request.getParameter("registrationno"));
			C.setOwner_name(request.getParameter("ownername"));
			C.setContact_person(request.getParameter("contactperson"));
			C.setMobile_no(request.getParameter("mobileno"));
			C.setPhone_no(request.getParameter("phoneno"));
			C.setEmail(request.getParameter("email"));
			C.setAddress(request.getParameter("address"));
			if (request.getParameter("city").equals("-Select-")) {
				C.setCountry(request.getParameter("icountry"));
				C.setState(request.getParameter("istate"));
				C.setCity(request.getParameter("icity"));
			} else {
				C.setCountry(request.getParameter("country"));
				C.setState(request.getParameter("state"));
				C.setCity(request.getParameter("city"));
			}
			C.setDeals_in(request.getParameter("dealsin"));
			C.setWebsite(request.getParameter("website"));
			@SuppressWarnings("unused")
			boolean st = ConsigneeController.editRecord(C);
			response.sendRedirect("ConsignerDisplayAll");
		} else if (btn.equals("Delete")) {
			@SuppressWarnings("unused")
			boolean st = ConsigneeController.deleteRecord(Integer.parseInt(request.getParameter("cid")));
			response.sendRedirect("ConsigneeDisplayAll");
		}

	}

}
