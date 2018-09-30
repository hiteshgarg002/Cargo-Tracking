package com.itm.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.itm.controller.EmployeeController;
import com.itm.model.Employee;

/**
 * Servlet implementation class EmployeeEditDelete
 */
@WebServlet("/EmployeeEditDelete")
public class EmployeeEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
	
		String btn=request.getParameter("btn");
		if(btn.equals("Edit"))
		{
			Employee E=new Employee();
			E.setId(Integer.parseInt(request.getParameter("cid")));
			E.setEmployee_name(request.getParameter("employeename"));
			E.setDob(request.getParameter("dob"));
			E.setAddress(request.getParameter("address"));
	        if(request.getParameter("city").equals("-Select-"))
	        { E.setCountry(request.getParameter("icountry"));
	        E.setState(request.getParameter("istate"));
	        E.setCity(request.getParameter("icity"));
	        }
	        else
	        {
	        E.setCountry(request.getParameter("country"));
	        E.setState(request.getParameter("state"));
	        E.setCity(request.getParameter("city"));
	        }
	        E.setPhone_no(request.getParameter("phoneno"));
	        E.setMobile_no(request.getParameter("mobileno"));
	        
	        E.setQualification(request.getParameter("qualification"));
	        E.setDesignation(request.getParameter("designation"));
	        @SuppressWarnings("unused")
			boolean st=EmployeeController.editRecord(E);
			response.sendRedirect("EmployeeDisplayAll");
		}
		else if(btn.equals("Delete"))
		{
			@SuppressWarnings("unused")
			boolean st=EmployeeController.deleteRecord(Integer.parseInt(request.getParameter("cid")));
		    response.sendRedirect("EmployeeDisplayAll");
		}
		else if(btn.equals("Update"))
		{
			Employee E=new Employee();
			E.setId(Integer.parseInt(request.getParameter("cid")));
		
			Part part=request.getPart("photograph");
	        String path="F:/Eclipse Mars/eclipse/CargoTracking/WebContent/images";
	        FileUpload F=new FileUpload(part,path);
	        E.setPhoto(F.filename);
	        @SuppressWarnings("unused")
			boolean st=EmployeeController.updatePicture(E);
			response.sendRedirect("EmployeeDisplayAll");
		}
	}
}
