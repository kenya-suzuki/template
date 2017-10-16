package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.ItemViewDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemViewAction extends ActionSupport {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 8119766214351162676L;

	/**
	 * カテゴリーId
	 */
	private int categoryId;

	/**
	 * サーチリスト
	 */
	public ArrayList<ItemDTO> searchList = new ArrayList<ItemDTO>();

	/**
	 * 実行メソッド
	 *
	 * @return success or error
	 */
	public String execute() {
		String result = ERROR;

		ItemViewDAO dao = new ItemViewDAO();

		searchList = dao.display(categoryId);

		if (searchList.size() > 0) {
			result = SUCCESS;
		}
		return result;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * サーチリストを取得するメソッド
	 *
	 * @return searchList サーチリスト
	 */
	public ArrayList<ItemDTO> getSearchList() {
		return searchList;
	}

	/**
	 * サーチリストを格納するメソッド
	 *
	 * @param searchList
	 */
	public void setSearchList(ArrayList<ItemDTO> searchList) {
		this.searchList = searchList;
	}

}
