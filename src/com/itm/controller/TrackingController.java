package com.itm.controller;
import java.sql.Connection;
import java.sql.ResultSet;

import com.itm.model.Tracking;

public class TrackingController {
	 public static boolean addNewRecord(Tracking T){
  	   try{
  		   Connection cn=DBHelper.openConnection();
  		                                                                                                                                        
             String q="Insert into tracking (trackingid,employeeid,tdate,ttime,description,lat,lng) values ("+T.getTrackingid()+","+T.getEmployeeid()+",'"+T.getTdate()+"','"+T.getTtime()+"','"+T.getDescription()+"','"+T.getLat()+"','"+T.getLng()+"')";
             		  
             boolean st=DBHelper.executeUpdate(cn, q);
             return (st);
         }
  	   catch(Exception e){
  		   System.out.println("TrackingController:addNewRecord:"+e);
  		   return false;	
  	   }
     }
	 
	 public static ResultSet searchByTrackingId(int tid){
		 try{
			 Connection cn=DBHelper.openConnection();
			 String q="select * from tracking where trackingid="+tid;
			 ResultSet rs=DBHelper.executeQuery(cn, q);
			 return rs;
		 }catch(Exception e){
			 System.out.println("TrackingController:searchByTrackingId: "+e);
			 return null;
		 }
	 }
}
