package com.skilldistillery.wine.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;



@Repository
@Primary
public class WineDAODbImpl implements WineDAO {
	private static final String url = "jdbc:mysql://localhost:3306/winesdb";
	private String user = "root";
	private String pass = "root";

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

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			String sql = "INSERT INTO wine (id, name, bottle_size, abv, price)" + " VALUES (?, ?, ?, ?, ?)";

			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, w.getId());
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
		List<Wine> list = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			String sql = "SELECT id, name, bottle_size, abv, price, img_url FROM wine";

			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.executeQuery();
			Wine wine = null;
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Double bottleSize = rs.getDouble(3);
				Double abv = rs.getDouble(4);
				Double price = rs.getDouble(5);
				String imgUrl= rs.getString(6);
				
				wine = new Wine(id, name, bottleSize, abv, price,imgUrl);
				list.add(wine);
			}
			
			rs.close();
			st.close();
			conn.close();
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Wine getWineById(int id) {
			Wine wine = null;
			try {
				Connection conn = DriverManager.getConnection(url, user, pass);
				String sql = "SELECT id, name, bottle_size, abv, price FROM wine WHERE id = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
					String name = rs.getString(2);
					Double bottleSize = rs.getDouble(3);
					Double abv = rs.getDouble(4);
					Double price = rs.getDouble(5);
					
					
					wine = new Wine(id, name, bottleSize, abv, price,null);

				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return wine;
		}
	@Override
	public Wine updateWine(Wine wine) {


		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "UPDATE wine SET name=?, bottle_size=?, abv=?, price=? WHERE id=?;";

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, wine.getName());
			st.setDouble(2, wine.getBottlesize());
			st.setDouble(3, wine.getAbv());
			st.setDouble(4, wine.getPrice());
			st.setInt(5, wine.getId());

			int up = st.executeUpdate();
			if (up == 1) {

				System.out.println(up + " wine updated");
				conn.close();

			} else {
				wine = null;
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wine;

	}

	@Override
	public boolean deleteWine(Wine w) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "DELETE FROM wine WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, w.getId());
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

	
}
