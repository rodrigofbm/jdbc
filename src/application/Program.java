package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"UPDATE seller SET BaseSalary = BaseSalary + ?" 
					+ " WHERE Id = ?;");

			st.setDouble(1, 2000.0);
			st.setInt(2, 8);

			int rowsAffected = st.executeUpdate();

			System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
