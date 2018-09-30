package com.itm.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.itm.model.Admin;

public class AdminController {
	public static Admin checkLogin(String aid,String pass){
		try{
			Connection cn=DBHelper.openConnection();
			String q="select * from admin where id="+aid+" and password="+pass;
			ResultSet rs=DBHelper.executeQuery(cn, q);
			if(rs.next()){
				Admin A=new Admin();
				A.setAdmin_id(rs.getString(1));
				A.setAdmin_name(rs.getString(2));
				A.setPicture(rs.getString(3));
				return A;
			}
			else{
				return null;
			}
		}catch(Exception e){
			System.out.println("AdminController:checkLogin"+e);
			return null;
		}
	}
}
