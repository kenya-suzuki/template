
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport implements SessionAware {

	public static final String CONFIRM = "confirm";

	public static final String CREDIT = "credit";

	/**
	 * 数量
	 */
	private int[] quantities;

	/**
	 * 支払い方法
	 */
	public String pay;

	/**
	 * 商品削除
	 */
	public int itemDelete;

	/**
	 * 処理結果
	 */
	public String result;

	/**
	 * アイテム情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * カートリスト
	 */
	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

	/**
	 * 商品情報取得メソッド
	 *
	 * @author internous
	 */
	@SuppressWarnings("unchecked")
	public String execute() {

		if (session.get("login_user_id") != null) {
			if (session.get("cartList") != null) {
				CartList = (ArrayList<CartDTO>) session.get("cartList");
				int CartSize = CartList.size();
				for (int i = 0; i < CartSize; i++) {
					if (itemDelete == 0) {
						CartDTO dto = new CartDTO();
						dto.setUserId(CartList.get(i).getUserId());
						dto.setItemId(CartList.get(i).getItemId());
						dto.setItemName(CartList.get(i).getItemName());
						dto.setStock(CartList.get(i).getStock());
						dto.setPrice(CartList.get(i).getPrice());
						dto.setQuantities(quantities[i] + CartList.get(i).getQuantities());
						dto.setTotalPrice(CartList.get(i).getTotalPrice());
						CartList.set(i, dto);
					} else {
						if (CartList.get(i).getItemId() == itemDelete) {
							CartList.remove(i);
							return NONE;
						}
					}
				}
				session.put("cartList", CartList);
				session.put("pay", pay);
				if (pay.equals("現金払い")) {
					return CONFIRM;

				} else if (pay.equals("クレジットカード払い")) {
					return CREDIT;
				}
			}
			return ERROR;
		}
		return LOGIN;
	}

	public int[] getQuantities() {
		return quantities;
	}

	public void setQuantities(int[] quantities) {
		this.quantities = quantities;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public int getItemDelete() {
		return itemDelete;
	}

	public void setItemDelete(int itemDelete) {
		this.itemDelete = itemDelete;
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
