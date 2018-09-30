package com.itm.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.itm.controller.CountryStateCityController;
import com.itm.controller.DBHelper;

/**
 * Servlet implementation class GetAllCountryJSON
 */
@WebServlet("/GetAllCountryJSON")
public class GetAllCountryJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCountryJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
			ResultSet rs=CountryStateCityController.getAllCountry();
			ArrayList<JSONObject> list=DBHelper.JsonEngine(rs);
			out.print(list);
		}catch(Exception e){
			out.print("Error");
		}
		out.flush();
	}

}
