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

	private int numImgPath = 5;

	public ArrayList<ItemDTO> display(String category) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from items where category=? and  is_deleted=0";
		String sql2 = "select * from items_images where item_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				ItemDTO dto = new ItemDTO();
				int itemViewId = rs.getInt("item_id");
				dto.setItemId(itemViewId);
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getBigDecimal("price"));
				// dto.setImgAddress001(rs.getString("img_path2"));
				// searchList.add(dto);

				// rs.close();
				searchList.add(dto);

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
