package com.skilldistillery.wine.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class WineDAODbImpl implements WineDAO {
	private static final String url = "http://13.58.140.51:8080/MVCProject/";
	private String user = "wino@localhost";
	private String pass = "wino";

	
	public WineDAODbImpl() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.err.println("Error loading MySQL Driver!!!");
	}
}
	@Override
	public Wine addWine(Wine w) {
		String url = "http://13.58.140.51:8080/MVCProject/";
		String user = "wino@localhost";
		String pass = "wino";

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			String sql = "INSERT INTO wine (id, name, bottle_size, abv, price)"
					+ " VALUES (?, ?, ?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1,w.getId());
			st.setString(2, w.getName());
			st.setDouble(3, w.getBottlesize());
			st.setDouble(4, w.getAbv());
			st.setDouble(5, w.getPrice());
			
		

			int uc = st.executeUpdate();
			if (uc == 1) {
				ResultSet keys = st.getGeneratedKeys();
				if (keys.next()) {
					int newWineId = keys.getInt(1);
					w.setId(newWineId);
					System.out.println(uc + " new wine created");
					conn.close();

				}
			} else {
				w = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			w = null;
		}
		return w;
	}


	@Override
	public List<Wine> getAllWines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wine getWineById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wine updateWine(Wine w) {
		String url = "http://13.58.140.51:8080/MVCProject/";
		String user = "wino@localhost";
		String pass = "wino";


		try {
			Connection conn = DriverManager.getConnection(url, user, pword);
			String sql = "UPDATE wine SET name=?, bottle_size=?, abv=? price=?" + "WHERE id=?";

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,w.getTitle());
			st.setString(2, w.getDescription());
			st.setInt(3, w.getId());

			int uc = st.executeUpdate();
			if (uc == 1) {

				System.out.println(uc + " film record updated");
				conn.close();

			} else {
				film = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			film = null;
		}
		return film;
	}



		return null;
	}

	@Override
	public boolean deleteWine(Wine w) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "DELETE FROM wine WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Wine.getId());
			stmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}



		return null;
	}
	

	}
