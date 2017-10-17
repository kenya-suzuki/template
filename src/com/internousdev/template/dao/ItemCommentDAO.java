package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.internousdev.template.util.DBConnector;

public class ItemCommentDAO {

	public int insertCommnet(String user_name, int item_id, String comment) {

		int count = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into comments (user_name, item_id, comment, registration_date, update_date)"
				+ " values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setInt(2, item_id);
			ps.setString(3, comment);
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}
