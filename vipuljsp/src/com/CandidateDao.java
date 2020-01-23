package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CandidateDao {
	public static Connection getConnection(){  
        Connection con=null;  
        String url="jdbc:mysql://localhost:3306/vipul";
		String dbUser="root";
		String dbPassword="Vipul@123";
        try{  
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,dbUser,dbPassword);  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
	
	 public static int save(Candidate c){  
	        int status=0;  
	        try{  
	            Connection con=CandidateDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("insert into candidate values(?, ?, ?)");
				ps.setString(1,c.getUsername());
			    ps.setString(2,c.getPasskey());
	            ps.setInt(3,c.getMobile());         
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	 
	 public static boolean validate(String name,String pass){  
		 boolean status=false; 
		 try {
		 Connection con=CandidateDao.getConnection();
		 PreparedStatement ps=con.prepareStatement("select * from candidate where username=? and passkey=?"); 
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		 }catch(Exception e) {e.printStackTrace();}
		 return status;
}
}