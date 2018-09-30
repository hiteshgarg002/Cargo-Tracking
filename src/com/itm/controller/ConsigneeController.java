package com.itm.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.itm.model.Consignee;
import com.itm.model.Consigner;

public class ConsigneeController {
	public static boolean addNewRecord(Consignee C){
		try{
			Connection cn=DBHelper.openConnection();
			String q="insert into consignee(firm_name,registration_no,owner_name,contact_person,mobile_no,phone_no,email,address,country,state,city,deals_in,website,firmlogo,password)values('"+C.getFirm_name()+"','"+C.getRegistration_no()+"','"+C.getOwner_name()+"','"+C.getContact_person()+"','"+C.getMobile_no()+"','"+C.getPhone_no()+"','"+C.getEmail()+"','"+C.getAddress()+"','"+C.getCountry()+"','"+C.getState()+"','"+C.getCity()+"','"+C.getDeals_in()+"','"+C.getWebsite()+"','"+C.getFirmlogo()+"','"+C.getPassword()+"')";
			boolean st=DBHelper.executeUpdate(cn, q);
			return st;
		}catch(Exception e){
			System.out.println("ConsigneeController:addNewRecord:"+e);
			return false;
		}
	}
	
	public static ResultSet displayAll(){
		Connection cn=DBHelper.openConnection();
		String q="select id,firm_name,registration_no,owner_name,contact_person,mobile_no,phone_no,email,address,(select countryname from country C where C.countryid=CC.country),(select statename from state S where S.stateid=CC.state),(select cityname from city C where C.cityid=CC.city),deals_in,website,firmlogo from consignee CC";
		ResultSet rs=DBHelper.executeQuery(cn, q);
		return rs;
	}
	public static Consignee displayById(int cid){
		try{
			Connection cn=DBHelper.openConnection();
			String q="select id,firm_name,registration_no,owner_name,contact_person,mobile_no,phone_no,email,address,country,(select countryname from country C where C.countryid=CC.country),state,(select statename from state S where S.stateid=CC.state),city, (select cityname from city CI where CI.cityid=CC.city) ,deals_in,website,firmlogo from consignee CC where CC.id="+cid;
			ResultSet rs=DBHelper.executeQuery(cn, q);
			if(rs.next()){
				Consignee C=new Consignee();
				C.setId(Integer.parseInt(rs.getString(1)));
				  C.setFirm_name(rs.getString(2));
				  C.setRegistration_no(rs.getString(3));
				  C.setOwner_name(rs.getString(4));
				  C.setContact_person(rs.getString(5));
				  C.setMobile_no(rs.getString(6));
				  C.setPhone_no(rs.getString(7));
				  C.setEmail(rs.getString(8));
				  C.setAddress(rs.getString(9));
				  C.setCountry(rs.getString(10)+","+rs.getString(11));
				  C.setState(rs.getString(12)+","+rs.getString(13));
				  C.setCity(rs.getString(14)+","+rs.getString(15));
				  C.setDeals_in(rs.getString(16));
				  C.setWebsite(rs.getString(17));
				  C.setFirmlogo(rs.getString(18));
				  return C;
			}
			else{
				return null;
			}
		}catch(Exception e){
			return null;
		}
	}
	public static boolean editRecord(Consignee c)
	{try{
		Connection cn=DBHelper.openConnection();
		String q="update consignee set firmname='"+c.getFirm_name()+"',registration_no='"+c.getRegistration_no()+"',ownername='"+c.getOwner_name()+"',contactperson='"+c.getContact_person()+"',mobileno='"+c.getMobile_no()+"',phoneno='"+c.getPhone_no()+"',email='"+c.getEmail()+"',address='"+c.getAddress()+"',country='"+c.getCountry()+"',state='"+c.getState()+"',city='"+c.getCity()+"',deals_in='"+c.getDeals_in()+"',website='"+c.getWebsite()+"' where id="+c.getId();
		System.out.println(q);
		boolean st=DBHelper.executeUpdate(cn, q);
		return(st);

	}
	catch(Exception e)
	{System.out.println("ConsigneeController:editRecord:"+e);
	return false;	
	}
	}
	
	public static boolean deleteRecord(int id)
	{try{
		Connection cn=DBHelper.openConnection();
		String q="Delete from consignee where id="+id;
				 
		boolean st=DBHelper.executeUpdate(cn, q);
		return(st);

	}
	catch(Exception e)
	{System.out.println("ConsigneeController:editRecord:"+e);
	return false;	
	}
	}
	
	public static boolean updatePicture(Consigner C)
	{
		try{
		Connection cn=DBHelper.openConnection();
		String q="update  consignee set firmlogo='"+C.getFirmlogo()+"' where id="+C.getId();
		System.out.println(q);
		boolean st=DBHelper.executeUpdate(cn, q);
		return(st);
	  }catch(Exception e){
		  System.out.println("ConsigneeController:updatePicture:"+e);
	      return false;	
	     }
	   }
	
	public static  Consignee checkPassword(String cid,String password)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String q="select * from consignee where id='"+cid+"' and password='"+password+"'";
			ResultSet rs=DBHelper.executeQuery(cn, q);
			if(rs.next())
			{
				Consignee C=new Consignee();
				C.setId(Integer.parseInt(rs.getString(1)));
				C.setFirmlogo(rs.getString(2));
				C.setFirmlogo(rs.getString(15));
				return(C);
			}
			else
			{
				return(null);
			}
		}
		catch(Exception e)
		{
			System.out.println("ConsigneeCheckPassword"+e);
			return null;
			
		}
	}
}

	



