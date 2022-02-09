package com.group1.bankproject.bankproduct;

/**
 * 
 * 예금계좌 데이터를 저장하는 클래스입니다.
 * 
 * @author 1조
 *
 */

public class Deposits {
	
	private int userNum;
	private String account;
	private String date;
	private int refundMoney;
	
	
	
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getRefundMoney() {
		return refundMoney;
	}
	public void setRefundMoney(int refundMoney) {
		this.refundMoney = refundMoney;
	}
	

	
	
	
	
	
}
