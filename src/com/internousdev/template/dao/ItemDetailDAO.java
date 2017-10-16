package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class ItemDetailDAO {

	public ArrayList<ItemDTO> searchList = new ArrayList<ItemDTO>();

	/**
	 * 商品IDで商品詳細を取得しリストに格納するメソッド
	 *
	 * @throws SQLException
	 *             SQLのエラー
	 * @param itemId
	 *            商品ID
	 * @return itemList 商品情報を返す
	 */
	public ArrayList<ItemDTO> selectbyItem(int itemId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		ItemDTO dto = new ItemDTO();
		ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
		String sql = "select * from items where item_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setAuthor(rs.getString("item_author"));
				dto.setPrice(rs.getBigDecimal("item_price"));
				dto.setStock(rs.getInt("item_stock"));
				dto.setItemDetail(rs.getString("item_detail").replace("\n", "<br>"));
				dto.setItemImage(rs.getString("item_image"));
				itemList.add(dto);

				ps.close();
				con.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

}
