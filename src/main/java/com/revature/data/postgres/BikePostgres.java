package com.revature.data.postgres;

import java.util.Set;
import com.revature.data.BikeDAO;
import com.revature.models.Bike;
import com.revature.util.ConnectionUtil;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BikePostgres implements BikeDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	public int create(Bike dataToAdd) {
		int createId = 0;
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "Insert into bike (id, bike_year, bike_brand, bike_color)" + "values (default, ?,?,?,?)";

			String[] keys = { "id" };
			PreparedStatement prepStmt = conn.prepareStatement(sql, keys);
			prepStmt.setString(1, dataToAdd.getBrand());
			prepStmt.setString(2, dataToAdd.getColor());
			prepStmt.setInt(3, dataToAdd.getYear());

			prepStmt.executeUpdate();
			ResultSet resultSet = prepStmt.getGeneratedKeys();
			if (resultSet.next()) {
				createId = resultSet.getInt("id");
				conn.commit(); // commits the database changes
			} else {
				conn.rollback(); // or rolls it back
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return createId;
	}

	@Override
	public Set<Bike> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Bike dataToUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bike getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Bike dataToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Bike> getByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bike> getByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}
}
