package com.itm.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itm.controller.DispatchController;
import com.itm.model.Dispatch;

/**
 * Servlet implementation class DispatchSubmit
 */
@WebServlet("/DispatchSubmit")
public class DispatchSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	/*
	 * 
	 * 
	 * http://localhost:88/CargoTracking/DispatchSubmit?
	 * &dispatchdate=ee&dispatchtime=ee&consigner=5&consignee=2&productdesc=ee&producttype=Liquid&totalbox=ee&quantInbox=e&amount=e&chargeofdispatch=e&dispatchfrom=e&dispa
	 * tchto=e&dispatchby=Sea+Route&veichelno=e&approxday=e	
	 */
		PrintWriter out=response.getWriter();
		Dispatch D=new Dispatch();
		D.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
	    D.setDispatch_Date(request.getParameter("dispatchdate"));
	    D.setDispatch_Time(request.getParameter("dispatchdate"));
	    D.setConsigner_Id(Integer.parseInt(request.getParameter("consigner")));
	    D.setConsignee_Id(Integer.parseInt(request.getParameter("consignee")));
        D.setProduct_Desc(request.getParameter("productdesc"));
       	D.setProduct_Type(request.getParameter("producttype"));
       	D.setTotal_Box(request.getParameter("totalbox"));
       	D.setQuantity_In_Box(request.getParameter("quantInbox"));
       	D.setAmount(request.getParameter("quantInbox"));
       	D.setCharge_Of_Dispatch(request.getParameter("chargeofdispatch"));
        D.setDispatch_From(request.getParameter("dispatchfrom"));
        D.setDispatch_To(request.getParameter("dispatchto"));
	    D.setDispatch_By(request.getParameter("dispatchby"));
	    D.setVeichel_No(request.getParameter("veichelno"));
	    D.setApproxdays(request.getParameter("approxday"));
	    
	    boolean st=DispatchController.addNewRecord(D);
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
