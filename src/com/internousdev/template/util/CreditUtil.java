package com.internousdev.template.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.util.db.mysql.MySqlConnector;

public class CreditUtil {
	int creditBrand = 0;
	String brandName = null;
	String creditNumber = null;

	public CreditUtil(int creditBrand, String creditNumber) {
		this.creditNumber = creditNumber;
		if (creditBrand == 1) {
			this.brandName = "visa";
		} else if (creditBrand == 2) {
			this.brandName = "mastercard";
		} else if (creditBrand == 3) {
			this.brandName = "americanexpress";
		}
	}

	public CreditUtil(String brandName, String creditNumber) {
		this.brandName = brandName;
		this.creditNumber = creditNumber;
	}

	public boolean brandCheck() {
		String checkNumber = this.creditNumber.substring(0, 6);
		Connection con = new MySqlConnector("creditcard_manager").getConnection();
		String sql = "select * from m_creditcard_type where card_number = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, checkNumber);
			ResultSet rs = ps.executeQuery();
			if ((rs.next()) && (rs.getString("card_name").equals(this.brandName))) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean creditCheck(String securityCode, int expirationYear, int expirationMonth, String nameE) {
		Connection con = new MySqlConnector(this.brandName).getConnection();
		String query = "select * from credit_card where credit_number =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, this.creditNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (this.creditNumber.equals(rs.getString("credit_number"))) {
					if (Integer.parseInt(securityCode) == rs.getInt("security_code")) {
						if ((expirationMonth == rs.getInt("expiration_month"))
								&& (expirationYear == rs.getInt("expiration_year"))
								&& (nameE.equals(rs.getString("name_e")))) {
							return true;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int selectInsert(String projectName, int amountAll) {
		int ret = 0;
		String insert = null;
		Connection con = new MySqlConnector(this.brandName).getConnection();
		insert = "insert into user_history(login_id, name_e, corporation_name, spend, payment) VALUES(?, ?, ?, ?, ?)";
		String sql = "select * from credit_card where credit_number = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, this.creditNumber);
			ResultSet rs = ps.executeQuery();
			PreparedStatement psInsert = con.prepareStatement(insert);
			while (rs.next()) {
				psInsert.setString(1, rs.getString("login_id"));
				psInsert.setString(2, rs.getString("name_e"));
				psInsert.setString(3, projectName);
				psInsert.setInt(4, amountAll);
				psInsert.setInt(5, amountAll);
				ret = psInsert.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}