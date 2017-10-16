package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class ItemViewDAO {

	ArrayList<ItemDTO> searchList = new ArrayList<ItemDTO>();



	public ArrayList<ItemDTO> display(int categoryId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from items where category_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ItemDTO dto = new ItemDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setAuthor(rs.getString("item_author"));
				dto.setItemImage(rs.getString("item_image"));
				searchList.add(dto);
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
