package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.internousdev.template.dao.ItemDetailDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemCommentDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailAction extends ActionSupport {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 265702236011588767L;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * ユーザーID
	 */
	public int userId;

	/**
	 * メッセージ
	 */
	public boolean msg;

	/**
	 * 商品リスト
	 */
	private List<ItemDTO> itemList;

	/**
	 * アイテムIDリスト
	 */
	private List<CartDTO> itemIdList;

	/**
	 * 在庫数をリストに格納
	 */
	private ArrayList<Integer> stockList;

	/**
	 * 商品一覧表示用リスト
	 */
	private ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();

	/**
	 * 商品一覧表示用リスト
	 */
	private ArrayList<ItemCommentDTO> commentttt = new ArrayList<ItemCommentDTO>();

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 商品一覧表示用リストの生成
	 *
	 */
	public String execute() throws SQLException {
		String result = ERROR;
		ItemDetailDAO dao = new ItemDetailDAO();
		displayList = dao.selectbyItem(itemId);
		commentttt = dao.selectCommentList(itemId);
		if (displayList.size() != 0) {
			result = SUCCESS;
		}
		return result;
	}

	/**
	 * 実行メソッド 商品詳細ページに遷移するメソッド
	 *
	 * @return result SUCCESS、ERROR
	 * @throws SQLException
	 *             エラー処理
	 */
	public String execute2() throws SQLException {
		String result = ERROR;
		ItemDetailDAO dao = new ItemDetailDAO();
		stockList = new ArrayList<Integer>();
		itemList = dao.selectbyItem(itemId);
		if (session.containsKey("userId")) {
			setUserId((int) session.get("userId"));
		}
		for (int i = 1; i <= itemList.get(0).getStock(); i++) {
			if (i >= 10) {
				break;
			}
			stockList.add(i);
		}

		for (CartDTO dto : itemIdList) {
			if (dto.getItemId() == itemId) {
				setMsg(true);
			}
		}
		return result;

	}

	/**
	 * 商品IDを取得するメソッド
	 *
	 * @return itemId 商品ID
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * 商品IDを格納するメソッド
	 *
	 * @param itemId
	 *            セットする itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * 商品一覧表示用リストを取得するメソッド
	 *
	 * @return displayList 商品一覧表示用リスト
	 */
	public ArrayList<ItemDTO> getDisplayList() {
		return displayList;
	}

	/**
	 * 商品一覧表示用リストを格納するメソッド
	 *
	 * @param displayList
	 *            セットする displayList
	 */
	public void setDisplayList(ArrayList<ItemDTO> displayList) {
		this.displayList = displayList;
	}

	/**
	 * 商品一覧表示用リストを取得するメソッド
	 *
	 * @return displayList 商品一覧表示用リスト
	 */
	public ArrayList<ItemCommentDTO> getCommentttt() {
		return this.commentttt;
	}

	/**
	 * 商品一覧表示用リストを格納するメソッド
	 *
	 * @param displayList
	 *            セットする displayList
	 */
	public void setCommentttt(ArrayList<ItemCommentDTO> commentttt) {
		this.commentttt = commentttt;
	}

	/**
	 * @return stockList
	 */
	public ArrayList<Integer> getStockList() {
		return stockList;
	}

	/**
	 * @param stockList
	 *            セットする stockList
	 */
	public void setStockList(ArrayList<Integer> stockList) {
		this.stockList = stockList;
	}

	/**
	 * @return msg
	 */
	public boolean isMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            セットする msg
	 */
	public void setMsg(boolean msg) {
		this.msg = msg;
	}

	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
