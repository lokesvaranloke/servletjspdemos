package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		readFromDB();
		
//		insertIntoDB();
		
//		updateIntoDB();
		
//		deleteFromDB();
	}
	
	private static void deleteFromDB() {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
				Statement st = conn.createStatement();){
			int rowsDeleted = st.executeUpdate("delete from account where accno=1");
			System.out.println("Number of rows inserted : "+rowsDeleted);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	private static void updateIntoDB() {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
				Statement st = conn.createStatement();){
			int rowsUpdated = st.executeUpdate("update account set balance=150000 where accno =3");
			System.out.println("Number of rows inserted : "+rowsUpdated);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	private static void insertIntoDB() {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
				Statement st = conn.createStatement();){
			int rowsInserted = st.executeUpdate("insert into account values(3,'Marry','Lucy',30000)");
			System.out.println("Number of rows inserted : "+rowsInserted);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	private static void readFromDB() {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
				Statement st = conn.createStatement();){
			ResultSet rs = st.executeQuery("select * from account");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + ", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
