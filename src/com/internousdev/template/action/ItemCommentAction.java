package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ItemCommentDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCommentAction extends ActionSupport implements SessionAware {

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 3605665212657821344L;

	/**
	 * ユーザー ID
	 */

	private String userName;

	/**
	 *  アイテムID
	 */

	private int itemId;

	/**
	 * コメント内容
	 */

	private String comment;

	/**
	 * セッション情報
	 */
	public Map<String, Object> session;

	/**
	 * コメントを追加するための実行メソッド
	 * @return ユーザー情報が取得 =SUCCESS 失敗 =ERROR
	 */

	public String execute() {
		String result = ERROR;

		if (session.containsKey("loginUser")) {

			// ユーザーIDを取得
			String userName = (String) session.get("name");
			ItemCommentDAO dao = new ItemCommentDAO();

			if (dao.insertCommnet(userName, itemId, comment) > 0) {
				result = SUCCESS;
			}

		}
		return result;

	}

	/**
	 * ユーザーIDを取得するメソッド
	 *
	 * @return user_id ユーザーID
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * ユーザーIDを格納するメソッド
	 *
	 * @param user_id
	 *            ユーザーID
	 */
	public void setUser_id(String userName) {
		this.userName = userName;
	}

	/**
	 * コメント内容を取得するメソッド
	 *
	 * @return comment コメント内容
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * コメント内容を格納するメソッド
	 *
	 * @param comment
	 *            コメント内容
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * セッションを取得するメソッド
	 *
	 * @return session セッション情報
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッションを格納するメソッド
	 *
	 * @param session
	 *            セッション情報
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * アイテムIDを所得するメソッド
	 *
	 * @return search_recipe_id 検索するレシピＩＤ
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * アイテムIDを格納するメソッド
	 *
	 * @param search_recipe_id
	 *            検索するレシピID
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
