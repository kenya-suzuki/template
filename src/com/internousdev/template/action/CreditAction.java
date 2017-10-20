package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.CreditUtil;
import com.opensymphony.xwork2.ActionSupport;

public class CreditAction extends ActionSupport implements SessionAware {

	/**
	 * クレジット種類
	 */
	private String creditCardType;

	/**
	 * クレジット番号
	 */
	private String creditNumber;

	/**
	 * クレジット名義
	 */
	private String nameE;

	/**
	 * セキュリティコード
	 */
	private String securityCode;

	/**
	 * 有効期限（月）
	 */
	private int expirationMonth;

	/**
	 * 有効期限（年）
	 */
	private int expirationYear;

	/**
	 * セッション情報
	 */
	private Map<String, Object> session;

	/**
	 * カートリスト
	 */
	private ArrayList<CartDTO> CartList = new ArrayList<CartDTO>();


	/**
	 * エラーメッセージ
	 */
	private String errmsg2;

	/**
	 * 実行メソッド クレジットの種類を判別
	 *
	 * @author kenya suzuki
	 * @since 2017/09/19
	 * @version 1.0
	 * @return ERROR SUCCESS
	 */
	public String execute() {

		CartList = (ArrayList<CartDTO>) session.get("cartList");

		if (session.get("login_user_id") != null) {
			try {
				if (creditNumber.length() >= 6) {

					CreditUtil util = new CreditUtil(creditCardType, creditNumber);

					if (util.brandCheck()) {

						if (securityCode.startsWith("123")) {

							if (util.creditCheck(securityCode, expirationYear, expirationMonth, nameE)) {
								return SUCCESS;

							} else {
								errmsg2 = "*入力された情報に間違いがあります。";

								return ERROR;
							}
						} else if (securityCode.startsWith("00")) {
							if (util.creditCheck(securityCode, expirationYear, expirationMonth, nameE)) {
								return SUCCESS;
							} else {
								errmsg2 = "*入力された情報に間違いがあります。";

								return ERROR;
							}

						} else {
							errmsg2 = "*入力された情報に間違いがあります。";

							return ERROR;
						}
					} else {
						errmsg2 = "*入力された情報に間違いがあります。";

						return ERROR;
					}
				}
			} catch (NullPointerException e) {
				return ERROR;
			}
		}
		return LOGIN;
	}

	/**
	 * エラーメッセージ取得メソッド
	 *
	 * @return mrrmsg2 エラーメッセージ
	 */
	public String getErrmsg2() {
		return errmsg2;
	}

	/**
	 * エラーメッセージ格納メソッド
	 *
	 * @param errmsg2
	 *            セット errmsg2
	 */
	public void setErrmsg2(String errmsg2) {
		this.errmsg2 = errmsg2;
	}

	/**
	 * クレジット種類取得メソッド
	 *
	 * @return creditId クレジット種類
	 */
	public String getCreditCardType() {
		return creditCardType;
	}

	/**
	 * クレジット種類格納メソッド
	 *
	 * @param creditId
	 *            セット creditId
	 */
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	/**
	 * クレジット番号取得メソッド
	 *
	 * @return creditNumber クレジット番号
	 */
	public String getCreditNumber() {
		return creditNumber;
	}

	/**
	 * クレジット番号格納メソッド
	 *
	 * @param creditNumber
	 *            セット creditNumber
	 */
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}

	/**
	 * クレジット名義取得メソッド
	 *
	 * @return nameE クレジット名義
	 */
	public String getNameE() {
		return nameE;
	}

	/**
	 * クレジット名義格納メソッド
	 *
	 * @param nameE
	 *            セット nameE
	 */
	public void setNameE(String nameE) {
		this.nameE = nameE;
	}

	/**
	 * セキュリティコード取得メソッド
	 *
	 * @return securityCode セキュリティコード
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * セキュリティコード格納メソッド
	 *
	 * @param securityCode
	 *            セット securityCode
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	/**
	 * 有効期限（月）取得メソッド
	 *
	 * @return expirationMonth 有効期限（月）
	 */
	public int getExpirationMonth() {
		return expirationMonth;
	}

	/**
	 * 有効期限（月）格納メソッド
	 *
	 * @param expirationMonth
	 *            セット expirationMonth
	 */
	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	/**
	 * 有効期限（年）取得メソッド
	 *
	 * @return expirationYear 有効期限（年）
	 */
	public int getExpirationYear() {
		return expirationYear;
	}

	/**
	 * 有効期限（年）格納メソッド
	 *
	 * @param expirationYear
	 *            セット expirationYear
	 */
	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	/**
	 * セッション情報取得メソッド
	 *
	 * @return session セッション情報
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション情報格納メソッド
	 *
	 * @param session
	 *            セット session
	 */
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
