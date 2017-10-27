package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemCommentDTO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class ItemDetailDAO {

	public ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();

	public ArrayList<ItemCommentDTO> selectCommentList = new ArrayList<ItemCommentDTO>();

	/**
	 * 商品IDで商品詳細を取得しリストに格納するメソッド
	 */
	public ArrayList<ItemDTO> selectbyItem(int itemId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		ItemDTO dto = new ItemDTO();
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
				dto.setItemddd(rs.getString("item_detail"));//.replace("\n", "<br>"));
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

	/**
	 * コメントを取得するメソッド
	 */
	public ArrayList<ItemCommentDTO> selectCommentList(int itemId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from comments where item_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ItemCommentDTO Cdto = new ItemCommentDTO();

				Cdto.setComment(rs.getString("comment"));
				Cdto.setUserName(rs.getString("user_name"));
				Cdto.setRegistrationDate(rs.getString("comments.registration_date"));

				selectCommentList.add(Cdto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return selectCommentList;
	}

}
