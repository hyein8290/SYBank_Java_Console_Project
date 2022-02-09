package com.group1.bankproject.bankproduct;

/**
 * 
 * 펀드계좌 데이터를 저장하는 클래스입니다.
 * 
 * @author 1조
 *
 */

public class Fund {
	
	private int userNum;
	private String fundAccount;
	private String fundNum;
	private int fundMoney;
	private double rate;
	private String fundName;
	private int fundSequence;
	
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getFundAccount() {
		return fundAccount;
	}
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	public String getFundNum() {
		return fundNum;
	}
	public void setFundNum(String fundNum) {
		this.fundNum = fundNum;
	}
	public int getFundMoney() {
		return fundMoney;
	}
	public void setFundMoney(int fundMoney) {
		this.fundMoney = fundMoney;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	public void fundInfo() {
		
		System.out.printf("%d %s %s %s %d %f\n",this.userNum,
											this.fundName,
											this.fundAccount,
											this.fundNum,
											this.fundMoney,
											this.rate);
		
		
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public int getFundSequence() {
		return fundSequence;
	}
	public void setFundSequence(int fundSequence) {
		this.fundSequence = fundSequence;
	}
	
	

}
