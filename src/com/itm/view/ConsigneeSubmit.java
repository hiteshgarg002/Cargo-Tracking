package com.itm.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.softech.FileUpload;
import com.itm.controller.ConsigneeController;
import com.itm.model.Consignee;

/**
 * Servlet implementation class ConsigneeSubmit
 */
@WebServlet("/ConsigneeSubmit")
public class ConsigneeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsigneeSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Consignee C = new Consignee();
		C.setFirm_name(request.getParameter("firmname"));
		C.setRegistration_no(request.getParameter("registrationno"));
		C.setOwner_name(request.getParameter("ownername"));
		C.setContact_person(request.getParameter("contactperson"));
		C.setMobile_no(request.getParameter("mobileno"));
		C.setPhone_no(request.getParameter("phoneno"));
		C.setEmail(request.getParameter("email"));
		C.setAddress(request.getParameter("address"));
		C.setCountry(request.getParameter("country"));
		C.setState(request.getParameter("state"));
		C.setCity(request.getParameter("city"));
		C.setDeals_in(request.getParameter("dealsin"));
		C.setWebsite(request.getParameter("website"));
		C.setFirmlogo(request.getParameter("firmlogo"));
		C.setPassword(request.getParameter("password"));

		Part part = request.getPart("firmlogo");
		String path = "C:/Users/hp-u/workspace/CargoTracking/WebContent/images";
		FileUpload F = new FileUpload(part, path);
		C.setFirmlogo(F.filename);
		boolean st = ConsigneeController.addNewRecord(C);
		out.println("<html>");
		if (st) {
			out.println("<b><i>Record Submitted</i></b>");
		} else {
			out.println("<b><i>Fail to Submit Record</i></b>");

		}
		out.println("</html>");
		out.flush();
	}

}
