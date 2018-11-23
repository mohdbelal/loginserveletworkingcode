package registrationdao;

import java.sql.*;
import java.sql.SQLException;

import servelet.RegistrationForm;
import storeregistrationdetail.DataAccessException;

public class RegistrationDao {
	public void insert(RegistrationForm form) throws DataAccessException {
		Connection conn =null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//TODO : Please copy mysql-connector-5.x.x.jar to WEB-INF\lib folder
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			stmt = conn.prepareStatement("insert into tbl_register values(?,?,?,?,?,?)");
			stmt.setString(1, form.getName());
			stmt.setString(2, form.getEmail());
			stmt.setString(3, form.getCity());
			stmt.setInt(4, form.getPincode());
			stmt.setString(5, form.getUsername());
			stmt.setString(6, form.getPassword());
			stmt.executeUpdate(); //DML			
		}
		catch(Exception e) {
			//e.printStackTrace();
			throw new DataAccessException("problem while inserting data in TBL_customer table", e);
		}
		finally {
			try { stmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
	
