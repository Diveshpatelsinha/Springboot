package firstpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	
	public void createDatabase() {
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdiv", "root", "1234" );
			
			Statement stm = con.createStatement();
			String query = "create table student (id int(3), name varchar(50),email varchar(100))";
			
			stm.execute(query);
			
			System.out.println("table created successfully");
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTable() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdiv", "root", "1234" );
			
			Statement stm = con.createStatement();
			String query = "create table student (id int(3), name varchar(50),email varchar(100))";
			
			stm.execute(query);
			
			System.out.println("table created successfully");
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void createData() {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdiv", "root", "1234" );
			
//			Statement stm = con.createStatement();
//			String query = "insert into student VALUES (1, 'Divesh','divesh@gmail.com') ";
			
//			stm.execute(query);
			
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO student(id, name, email) VALUES(?,?,?)"
					);
			
			ps.setInt(1, 2);
			ps.setString(2, "aditya");
			ps.setString(3, "adi@gmail.com");
			
			ps.executeUpdate();
			
			
			
			System.out.println("data inserted successfully");
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void createData2() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdiv", "root", "1234" );
			

			
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO student(id, name, email) VALUES(?,?,?)"
					);
			
			   // ID
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine(); //  important (clear buffer)

            // NAME
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            // EMAIL
            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            // SET VALUES
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
			
			ps.executeUpdate();
			
			
			
			System.out.println("data inserted successfully");
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void readData() {
		  try {
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/dbdiv", "root", "1234"
	            );

	            Statement stmt = con.createStatement();

	            String query = "SELECT * FROM student";

	            ResultSet rs = stmt.executeQuery(query);

	            // loop through result
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("email");

	                System.out.println(id + " " + name + " " + email);
	            }

	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	public void updateData(int id, String name, String email) {
		
		try {
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dbdiv", "root", "1234"	
			);
					
		PreparedStatement ps = con.prepareStatement(
				"UPDATE student SET name = ?, email= ? WHERE id = ?"
				);
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, id);
		
		int rows = ps.executeUpdate();
		
		if(rows>0) {
			System.out.println("Student updated successfully");
		}else {
			System.out.println("Student not found");
		}
		
		con.close();
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	public void deleteData(int id) {
		
		try {
			Connection con = DriverManager.getConnection(
			
				"jdbc:mysql://localhost:3306/dbdiv", "root", "1234"
			);
			
			PreparedStatement ps = con.prepareStatement(
				"DELETE FROM student WHERE id = ?"
					);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			System.out.println("data deleted successfully");
			
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}

	public void updateData2(int id, String name) {
		
		try {
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/dbdiv", "root", "1234"	
			);
					
		PreparedStatement ps = con.prepareStatement(
				"UPDATE student SET id = ? WHERE name = ?"
				);
		
		ps.setInt(1, id);
		ps.setString(2, name);
//		ps.setString(2, email);
		
		int rows = ps.executeUpdate();
		
		if(rows>0) {
			System.out.println("Student updated successfully");
		}else {
			System.out.println("Student not found");
		}
		
		con.close();
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}
