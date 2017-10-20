
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.PaymentDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport implements SessionAware {

	public static final String CONFIRM = "confirm";

	public static final String CREDIT = "credit";

	/**
	 * アイテム情報を取得
	 */
	public PaymentDAO buyItemDAO = new PaymentDAO();

	/**
	 * 数量
	 */
	private int quantities;

	/**
	 * 支払い方法
	 */
	public int pay;

	/**
	 * アイテム情報を格納
	 */
	public Map<String, Object> session;

	/**
	 * カートリスト
	 */
	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();

	/**
	 * 処理結果
	 */
	public String result;

	/**
	 * 商品情報取得メソッド
	 *
	 * @author internous
	 */
	public String execute() {

		if (session.get("login_user_id") != null) {
			if (session.get("cartList") != null) {
				CartList = (ArrayList<CartDTO>) session.get("cartList");
				int CartSize = CartList.size();
				for (int i = 0; i < CartSize; i++) {
					CartList.get(i).setQuantities(quantities);
					session.put("cartList", CartList);
				}
				if (pay == 1) {
					return CONFIRM;

				} else if (pay == 2) {
					return CREDIT;
				}
			}
			return ERROR;
		}
		return LOGIN;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
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
