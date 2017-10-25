package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.PaymentComplateDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentComplateAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

	public String result;

	/**
	 * 商品購入情報登録完了メソッド
	 *
	 * @author internous
	 */
	@SuppressWarnings("unchecked")
	public String execute() {

		CartList = (ArrayList<CartDTO>) session.get("cartList");
		int CartSize = CartList.size();
		for (int i = 0; i < CartSize; i++) {
			int userId = CartList.get(i).getUserId();
			int itemId = CartList.get(i).getItemId();
			String itemName = CartList.get(i).getItemName();
			int count = CartList.get(i).getQuantities();
			int price = (int) CartList.get(i).getPrice();
			int totalPrice = CartList.get(i).getTotalPrice();
			String pay = (String) session.get("pay");
			try {
				PaymentComplateDAO dao = new PaymentComplateDAO();
				dao.buyItemeInfo(userId, itemId, itemName, count, price, totalPrice, pay);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < CartSize; i++) {
			CartList.remove(0);
		}

		result = SUCCESS;
		return result;
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
