package com.itm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

public class DBHelper {
	public static Connection openConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cargotracking", "root", "");
			return cn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[DBHelper:openConnection]:"+e);
			return null;
		}
	}
	
	public static boolean executeUpdate(Connection cn,String q){
		Statement smt;
		try {
			smt = cn.createStatement();
			smt.executeUpdate(q);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[DBHelper:executeUpdate]:"+e);
			return false;
		}
	}
	
	public static ResultSet executeQuery(Connection cn,String q){
		try{
			Statement smt=cn.createStatement();
			ResultSet rs=smt.executeQuery(q);
			return rs;
		}catch(Exception e){
			System.out.println("[DBHelper:executeQuery]:"+e);
			return null;
		}
	}
	
	
	public static ArrayList<JSONObject> JsonEngine(ResultSet rs){
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		try{
			ResultSetMetaData rsMeta=rs.getMetaData();
			int columnCnt=rsMeta.getColumnCount();
			
			ArrayList<String> columnName=new ArrayList<String>();
			for(int i=1;i<=columnCnt;i++){
				columnName.add(rsMeta.getColumnName(i).toUpperCase());
			}
			
			while(rs.next()){
				JSONObject obj=new JSONObject();
				for(int i=1;i<=columnCnt;i++){
					String key=columnName.get(i-1);
					String value=rs.getString(i);
					obj.put(key, value);
				}
				list.add(obj);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
