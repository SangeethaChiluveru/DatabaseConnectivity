package com.jdbc.demos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Connection con=null;
			Statement stm=null;
			PreparedStatement pstmt=null;
			try {
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/student", "postgres","2411");
				System.out.println("connection established");
				stm=con.createStatement();
				stm.execute("insert into employee_details values('sangeetha','101','26000')");
				System.out.println("Student Insert");
				//stm.execute("insert into employee_details values('saritha','102','27000')");
				stm.execute("update employee_details set name='swetha' where id=101");
				System.out.println("Student Update");
				stm.execute("delete from employee_details where id=102");
				System.out.println("Student Delete");
				
				ResultSet rs=stm.executeQuery("select*from employee_details");
				while(rs.next()) {
					System.out.println(rs.getString("name")+" "+rs.getInt("id")+" "+rs.getInt("salary"));
				}
				String sqlquery = "insert into employee_details values(?,?,?)";
				pstmt = con.prepareStatement(sqlquery);
				pstmt.setString(1, "Browny");
				pstmt.setInt(2, 1);
				pstmt.setInt(3, 26000);
				pstmt.execute();
				
				pstmt.setString(1, "Chotu");
				pstmt.setInt(2, 2);
				pstmt.setInt(3, 27000);
				pstmt.execute();
				System.out.println("Record saved");
				

			}
			catch(ClassNotFoundException e){
				e.printStackTrace();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(stm!=null) {
						stm.close();
					}
					if(con!=null) {
						con.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
	    }
}



