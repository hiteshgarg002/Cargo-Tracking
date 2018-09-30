package com.itm.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import com.itm.model.Employee;

public class EmployeeController {
	public static boolean addNewRecord(Employee E){
		try{
			Connection cn=DBHelper.openConnection();
			String q="insert into employee(employee_name,dob,address,country,state,city,phone_no,mobile_no,qualifiation,designation,photo,password)values('"+E.getEmployee_name()+"','"+E.getDob()+"','"+E.getAddress()+"','"+E.getCountry()+"','"+E.getState()+"','"+E.getCity()+"','"+E.getPhone_no()+"','"+E.getMobile_no()+"','"+E.getQualification()+"','"+E.getDesignation()+"','"+E.getPhoto()+"','"+E.getPassword()+"')";
			boolean st=DBHelper.executeUpdate(cn, q);
			return st;
		}catch(Exception e){
			System.out.println("EmployeeController:addNewRecord:"+e);
			return false;
		}
	}

	public static ResultSet displayAll()
    {
		try{
    	Connection cn=DBHelper.openConnection();
    	String q="select employeeid,employeename,dob,address,(select countryname from country C where C.countryid=CC.country),(select statename from state S where S.stateid=CC.state), (select cityname from city CI where CI.cityid=CC.city) ,Phone,mobile,qualification,designation,photograph from Employee CC";
    	ResultSet rs=DBHelper.executeQuery(cn, q);
    	return(rs);
      }
    catch(Exception e)
    {System.out.println("EmployeeController:displayAll:"+e);
    return null;	
    }
    }	

  public static Employee displayById(int cid)
  {
	  try{
  	Connection cn=DBHelper.openConnection();
  	String q="select id,employee_name,dob,address,country,(select countryname from country C where C.countryid=CC.country),state,(select statename from state S where S.stateid=CC.state),city, (select cityname from city CI where CI.cityid=CC.city) ,phone_no,mobile_no,qualification,designation,photo from Employee CC where CC.id="+cid;
  	ResultSet rs=DBHelper.executeQuery(cn, q);
  	if(rs.next()){
  		Employee E=new Employee();
  	    E.setId(Integer.parseInt(rs.getString(1)));
  	    E.setEmployee_name(rs.getString(2));
  	    E.setDob(rs.getString(3));
  	    E.setAddress(rs.getString(4));
  	    E.setCountry(rs.getString(5)+","+rs.getString(6));
  	    E.setState(rs.getString(7)+","+rs.getString(8));
  	    E.setCity(rs.getString(9)+","+rs.getString(10));
  	    E.setPhone_no(rs.getString(11));
  	    E.setMobile_no(rs.getString(12));
  	    E.setQualification(rs.getString(13));
  	    E.setDesignation(rs.getString(14));
  	    E.setPhoto(rs.getString(15));
  		return(E);
  	}
  	else
  	{
  	return(null);	
  	}
  	 
    }
  catch(Exception e)
  {
	  System.out.println("EmployeeController:displayById:"+e);
      return null;	
    }
  }	

  public static boolean editRecord(Employee E)
  {
	try{
         Connection cn=DBHelper.openConnection();
  	     String q="update employee set employee_name='"+E.getEmployee_name()+"',dob='"+E.getDob()+"',address='"+E.getAddress()+"',country='"+E.getCountry()+"',state='"+E.getState()+"',city='"+E.getCity()+"',phone_no='"+E.getPhone_no()+"',mobile_no='"+E.getMobile_no()+"',qualification='"+E.getQualification()+"',designation='"+E.getDesignation()+"' where id="+E.getId();
  	     boolean st=DBHelper.executeUpdate(cn, q);
  	     return(st);
       }catch(Exception e) {
    	   System.out.println("EmployeeController:editRecord:"+e);
           return false;	
       }
    }

  
  
  
  public static boolean updatePicture(Employee E)
  {
	  try{
  	Connection cn=DBHelper.openConnection();
  	String q="update employee set photo='"+E.getPhoto()+"' where id="+E.getId();
  	boolean st=DBHelper.executeUpdate(cn, q);
  	return(st);

  }
  catch(Exception e)
  {
	  System.out.println("EmployeeController:updatePicture:"+e);
  return false;	
  }
  }

  
  public static boolean deleteRecord(int id)
  {
	  try{
  	Connection cn=DBHelper.openConnection();
  	String q="Delete from employee where id="+id;
  			 
  	boolean st=DBHelper.executeUpdate(cn, q);
  	return(st);

  }
  catch(Exception e)
  {
	  System.out.println("EmployeeController:deleteRecord:"+e);
      return false;	
  }
  } 
  
  public static Employee checkLogin(String aid,String pass){
		try{
			Connection cn=DBHelper.openConnection();
			String q="select * from employee where mobile_no="+aid+" and password="+pass;
			ResultSet rs=DBHelper.executeQuery(cn, q);
			if(rs.next()){
				Employee E=new Employee();
				E.setId(Integer.parseInt(rs.getString(1)));
				E.setMobile_no(rs.getString(9));
				E.setEmployee_name(rs.getString(2));
				E.setPhoto(rs.getString(12));
				return E;
			}
			else{
				return null;
			}
		}catch(Exception e){
			System.out.println("EmployeeController:checkLogin"+e);
			return null;
		}
	}

}
