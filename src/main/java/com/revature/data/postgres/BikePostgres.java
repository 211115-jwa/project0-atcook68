package com.revature.data.postgres;

import java.util.Set;
import com.revature.data.BikeDAO;
import com.revature.models.Bike;
import com.revature.util.ConnectionUtil;

import java.util.HashSet;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BikePostgres implements BikeDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int create(Bike dataToAdd) {
		int createId = 0;

		try (Connection conn = connUtil.getConnection()) { // try with resources
			conn.setAutoCommit(false);
			String sql = "Insert into bikes (id,year,brand,model,color,status)" + "values (default, ?,?,?,?,?)";

			String[] key = { "id" };
			PreparedStatement prepStmt = conn.prepareStatement(sql, key);
			// setting the values for the sql insertions
			prepStmt.setInt(1, dataToAdd.getYear());
			prepStmt.setString(2, dataToAdd.getBrand());
			prepStmt.setString(3, dataToAdd.getModel());
			prepStmt.setString(4, dataToAdd.getColor());
			prepStmt.setString(5, dataToAdd.getStatus());

			// then the update can execute
			prepStmt.executeUpdate();
			ResultSet resultSet = prepStmt.getGeneratedKeys();
			if (resultSet.next()) {
				createId = resultSet.getInt("id");
				conn.commit(); // commits the database changes
			} else {
				conn.rollback(); // or rolls it back
			}
		} catch (SQLException e) {
			e.printStackTrace(); // displays the stack trace
		}
		return createId;
	}

	@Override
	public Bike getById(int id) {
		Bike bike = null;
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bikes where id=?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, id);

			ResultSet resultSet = prepStmt.executeQuery();
			if (resultSet.next()) {
				bike = new Bike();
				bike.setId(id);
				bike.setYear(resultSet.getInt("year"));
				bike.setBrand(resultSet.getString("brand"));
				bike.setModel(resultSet.getString("model"));
				bike.setModel(resultSet.getString("color"));
				bike.setStatus(resultSet.getString("available"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bike;
	}

	@Override
	public void update(Bike dataToUpdate) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "update bikes set " + "year=?,brand=?,model=?,color=?,status=? " + "where id=?";

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, dataToUpdate.getYear());
			prepStmt.setString(2, dataToUpdate.getBrand());
			prepStmt.setString(3, dataToUpdate.getModel());
			prepStmt.setString(4, dataToUpdate.getColor());
			prepStmt.setInt(5, dataToUpdate.getId());
			int rowsAffected = prepStmt.executeUpdate();
			if (rowsAffected == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Bike dataToDelete) {
		// TODO Auto-generated method stub
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "delete from bikes " + "where id=?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setInt(1, dataToDelete.getId());
			int rowsAffected = prepStmt.executeUpdate();

			if (rowsAffected == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Set<Bike> getAll() {
		Set<Bike> allBikes = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bikes";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				Bike bike = new Bike(); // creating a new bike object
				bike.setId(resultSet.getInt("id"));
				bike.setYear(resultSet.getInt("year"));
				bike.setBrand(resultSet.getString("brand"));
				bike.setModel(resultSet.getString("model"));
				bike.setColor(resultSet.getString("color"));
				bike.setStatus(resultSet.getString("available"));
				allBikes.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBikes;
	}

	@Override
	public Set<Bike> getByBrand(String brand) {
		Set<Bike> allBikes = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bikes " + "where brand=?";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Bike bike = new Bike();
				bike.setId(resultSet.getInt("id"));
				bike.setYear(resultSet.getInt("year"));
				bike.setBrand(resultSet.getString("brand"));
				bike.setModel(resultSet.getString("model"));
				bike.setColor(resultSet.getString("color"));
				bike.setStatus(resultSet.getString("available"));
				allBikes.add(bike);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allBikes;
	}

	@Override
	public Set<Bike> getByModel(String model) {
		Set<Bike> allBikes = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bikes " + "where model=?";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Bike bike = new Bike();
				bike.setId(resultSet.getInt("id"));
				bike.setYear(resultSet.getInt("year"));
				bike.setBrand(resultSet.getString("brand"));
				bike.setModel(resultSet.getString("model"));
				bike.setColor(resultSet.getString("color"));
				bike.setStatus(resultSet.getString("available"));
				allBikes.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allBikes;
	}

	@Override
	public Set<Bike> getByColor(String color) {
		Set<Bike> allBikes = new HashSet<>();
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bikes " + "where color=?";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				Bike bike = new Bike();
				bike.setId(resultSet.getInt("id"));
				bike.setYear(resultSet.getInt("year"));
				bike.setBrand(resultSet.getString("brand"));
				bike.setModel(resultSet.getString("model"));
				bike.setColor(resultSet.getString("color"));
				bike.setStatus(resultSet.getString("available"));
				allBikes.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allBikes;
	}

	@Override
	public Bike getById() {
		/*
		 * Bike bike = null; try (Connection conn = connUtil.getConnection()) { String
		 * sql = "select * from bikes where id=?"; PreparedStatement prepStmt =
		 * conn.prepareStatement(sql); prepStmt.setInt(1, id);
		 * 
		 * ResultSet resultSet = prepStmt.executeQuery(); if (resultSet.next()) { bike =
		 * new Bike(); bike.setId(id); bike.setYear(resultSet.getInt("year"));
		 * bike.setBrand(resultSet.getString("brand"));
		 * bike.setModel(resultSet.getString("model"));
		 * bike.setModel(resultSet.getString("color")); } } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */return null;
	}

	@Override
	public Set<Bike> getByStatus(String status) {
		Set<Bike> allBikes = new HashSet<>();

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bikes where status=?";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				Bike bike = new Bike();
				bike.setId(resultSet.getInt("id"));
				bike.setYear(resultSet.getInt("year"));
				bike.setBrand(resultSet.getString("brand"));
				bike.setModel(resultSet.getString("model"));
				bike.setColor(resultSet.getString("color"));
				bike.setStatus(resultSet.getString("available"));
				allBikes.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allBikes;
	}

}
