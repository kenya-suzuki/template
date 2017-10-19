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
	private float price;

	/**
	 * 数量
	 */
	private int quantities;

	/**
	 * 小計
	 */
	private float subtotal;

	/**
	 * 在庫数
	 */
	private int stock;

	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

	private ArrayList<CartDTO> CartList2 = new ArrayList<CartDTO>();

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	public String execute() {
		if (session.get("login_user_id") != null) {
			CartDTO dto = new CartDTO();
			if (quantities <= stock) {
				userId = (int) session.get("userId");
				dto.setUserId(userId);
				dto.setItemId(itemId);
				dto.setItemName(itemName);
				dto.setStocks(stock);
				dto.setPrice(price);
				dto.setQuantities(quantities);
				if (session.get("cartList") != null) {
					CartList2.addAll((ArrayList<CartDTO>)session.get("cartList"));
					int sizeCount = CartList2.size();
					int count = -1;
					for (int i = 0; i < sizeCount; i++) {
						if (CartList2.get(i).getItemId() == itemId) {
							CartDTO dto2 = new CartDTO();
							dto2.setUserId(CartList2.get(i).getUserId());
							dto2.setItemId(CartList2.get(i).getItemId());
							dto2.setItemName(CartList2.get(i).getItemName());
							dto2.setStocks(CartList2.get(i).getStocks());
							dto2.setPrice(CartList2.get(i).getPrice() + dto.getPrice());
							dto2.setQuantities(CartList2.get(i).getQuantities() + dto.getQuantities());
							count = i;
							CartList.add(dto2);
							break;
						}
					}
					for (int j = 0; j < sizeCount; j++) {
						if (j != count) {
							CartDTO dto2 = new CartDTO();
							dto2.setUserId(CartList2.get(j).getUserId());
							dto2.setItemId(CartList2.get(j).getItemId());
							dto2.setItemName(CartList2.get(j).getItemName());
							dto2.setStocks(CartList2.get(j).getStocks());
							dto2.setPrice(CartList2.get(j).getPrice());
							dto2.setQuantities(CartList2.get(j).getQuantities());
							CartList.add(dto2);
							CartDTO dto3 = new CartDTO();
							dto3.setUserId(userId);
							dto3.setItemId(itemId);
							dto3.setItemName(itemName);
							dto3.setStocks(stock);
							dto3.setPrice(price);
							dto3.setQuantities(quantities);
							CartList.add(dto3);
						}else{
							continue;
						}
					}

					session.put("cartList", CartList);
					return SUCCESS;
				}
			}
			CartList.add(dto);
			session.put("cartList", CartList);
			return SUCCESS;
		} else {
			return ERROR;
		}
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
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

	public ArrayList<CartDTO> getCartList2() {
		return CartList2;
	}

	public void setCartList2(ArrayList<CartDTO> cartList2) {
		CartList = cartList2;
	}

}
