package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware {

	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 単価
	 */
	private int price;

	/**
	 * 数量
	 */
	private int quantities;

	/**
	 * 在庫数
	 */
	private int stock;

	/**
	 * カートリスト
	 */
	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	@SuppressWarnings("unchecked")
	public String execute() {
		if (session.get("login_user_id") == null) {
			CartDTO dto = new CartDTO();
			if (quantities <= stock) {
				userId = (int) session.get("userId");
				dto.setUserId(userId);
				dto.setItemId(itemId);
				dto.setItemName(itemName);
				dto.setStock(stock);
				dto.setPrice(price);
				dto.setQuantities(quantities);
				dto.setTotalPrice(price * quantities);
				if (session.get("cartList") != null) {
					CartList = (ArrayList<CartDTO>) session.get("cartList");
					int cartSize = CartList.size();
					for (int i = 0; i < cartSize; i++) {
						if (CartList.get(i).getItemId() == itemId) {
							int ListIndex = i;
							CartDTO dto2 = new CartDTO();
							dto2.setUserId(CartList.get(ListIndex).getUserId());
							dto2.setItemId(CartList.get(ListIndex).getItemId());
							dto2.setItemName(CartList.get(ListIndex).getItemName());
							dto2.setStock(CartList.get(ListIndex).getStock());
							dto2.setPrice(CartList.get(ListIndex).getPrice());
							dto2.setQuantities(CartList.get(ListIndex).getQuantities() + quantities);
							dto2.setTotalPrice(CartList.get(ListIndex).getTotalPrice() + price * quantities);
							if (ListIndex >= 0 && cartSize >= 1) {
								CartList.set(ListIndex, dto2);
								session.put("cartList", CartList);
								return SUCCESS;
							}
						}
					}
				}
				CartList.add(dto);
				session.put("cartList", CartList);
				return SUCCESS;
			}
			return ERROR;
		}
		return ERROR;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartDTO> getCartList() {
		return CartList;
	}

	public void setCartList(ArrayList<CartDTO> cartList) {
		CartList = cartList;
	}

}
