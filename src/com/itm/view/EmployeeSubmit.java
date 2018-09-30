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
import com.itm.controller.EmployeeController;
import com.itm.model.Employee;

/**
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")
public class EmployeeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Employee E=new Employee();
		E.setEmployee_name(request.getParameter("employeename"));
		E.setDob(request.getParameter("dob"));
		E.setAddress(request.getParameter("address"));
		E.setCountry(request.getParameter("country"));
		E.setState(request.getParameter("state"));
		E.setCity(request.getParameter("city"));
		E.setMobile_no(request.getParameter("mobileno"));
		E.setPhone_no(request.getParameter("phoneno"));
		E.setQualification(request.getParameter("qualification"));
		E.setDesignation(request.getParameter("designation"));
		E.setPhoto(request.getParameter("photo"));
		E.setPassword(request.getParameter("password"));

        Part part=request.getPart("photo");
        String path="C:/Users/hp-u/workspace/CargoTracking/WebContent/images";
        FileUpload F=new FileUpload(part,path);
        E.setPhoto(F.filename);
        boolean st=EmployeeController.addNewRecord(E);
        out.println("<html>");
        if(st)
        {out.println("<b><i>Record Submitted</i></b>");
         }
        else
        {out.println("<b><i>Fail to Submit Record</i></b>");
        	
        }
        out.println("</html>");
        out.flush();
	}

}
