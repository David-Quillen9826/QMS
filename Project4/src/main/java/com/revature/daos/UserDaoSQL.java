package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoSQL implements UserDao {

	User extractUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("user_id");
		String rsUsername = rs.getString("username");
		String rsPassword = rs.getString("password");
		int role = rs.getInt("role");
		return new User(id, rsUsername, rsPassword, role);
	}

	public int save(User u) {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO qms_users (user_id, username, password) " + " VALUES (users_id_seq.nextval ,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());

			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public List<User> findAll() {
		try (Connection c = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM qms_users";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				users.add(extractUser(rs));
			}

			return users;

			// TODO Auto-generated catch block
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public User findById() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByUsernameAndPassword(String username, String password) {
		try (Connection c = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM qms_users WHERE ers_username = ? AND ers_password = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			// i am here
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractUser(rs);
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
