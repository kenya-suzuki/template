package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware {

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 商品ID
	 */
	private int[] itemId;

	/**
	 * 商品名
	 */
	private String[] itemName;

	/**
	 * 単価
	 */
	private float[] price;

	/**
	 * 数量
	 */
	private int[] quantities;

	/**
	 * 小計
	 */
	private float subtotal;

	/**
	 * 在庫数
	 */
	private int[] stock;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	public String execute() {

		//if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {

			try{
				if ((int) session.get("count") <= 0) {
				}else{
					System.out.println((int) session.get("count"));
					int i = (int) session.get("count");
					session.put("itemId", itemId[i]);
					session.put("itemName", itemName[i]);
					session.put("itemPrice", price[i]);
					session.put("quantities", quantities[i]);
					session.put("stock", stock[i]);
					int count = (int) session.get("count") + 1;
					session.put("count", count);
				}
			}catch(NullPointerException e){
				session.put("itemId", itemId[0]);
				session.put("itemName", itemName[0]);
				session.put("itemPrice", price[0]);
				session.put("quantities", quantities[0]);
				session.put("stock", stock[0]);
				int count = 1;
				session.put("count", count);
				return SUCCESS;
			}


		//}
		return ERROR;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int[] getItemId() {
		return itemId;
	}

	public void setItemId(int[] itemId) {
		this.itemId = itemId;
	}

	public String[] getItemName() {
		return itemName;
	}

	public void setItemName(String[] itemName) {
		this.itemName = itemName;
	}

	public float[] getPrice() {
		return price;
	}

	public void setPrice(float[] price) {
		this.price = price;
	}

	public int[] getQuantities() {
		return quantities;
	}

	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public int[] getStock() {
		return stock;
	}

	public void setStock(int[] stock) {
		this.stock = stock;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
