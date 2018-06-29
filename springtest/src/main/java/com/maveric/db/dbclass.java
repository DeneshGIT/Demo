package com.maveric.db;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.maveric.getset.getsetclass;

@Repository
public class dbclass {
	static  getsetclass modelobj = null;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	public int Checkreg(getsetclass modelobj) {
		System.out.println("ENTERED INTO NEW SQL");
	    String sql = "SELECT * FROM Accounttable WHERE Email='"+modelobj.getEmail()+"'";
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
	 
	        public Integer extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	        	int r=0;
	        	
	            if (rs.next()) 
	            {
	            	r=1;     
	            }
	            else
	            {
	            	r=0;
	            }
	            System.out.println("query--------------->"+r);
	            return r;
	        }
	 
	    });
	}

	
public int addregistertodb(getsetclass modelobj) {

		
		String name = modelobj.getname();
		String password = modelobj.getPassword();
		String email = modelobj.getEmail();
		
		    
		
			String query = "INSERT INTO Accounttable(Name,Password,Email)VALUES('"+name+"','"+password+"','"+email+"')"; 
			System.out.println(query);
			int result = jdbcTemplate.update(query);

			System.out.println("addregtodb--------------->"+result);
			System.out.println("Inserted in to DB");
			return result;
		

	}

public int LoginCheck(getsetclass modelobj) {
	System.out.println("ENTERED INTO NEW SQL");
    String sql1 = "SELECT * FROM Accounttable WHERE Email='"+modelobj.getEmail()+"' AND Password ='"+modelobj.getPassword()+"'";
    return jdbcTemplate.query(sql1, new ResultSetExtractor<Integer>() {
 
        public Integer extractData(ResultSet rs1) throws SQLException,
                DataAccessException {
        	int r=0;
        	
            if (rs1.next()) 
            {
            	r=1;     
            }
            else
            {
            	r=0;
            }
            System.out.println("query--------------->"+r);
            return r;
        }
 
    });
}
	
	
	
	
}