package com.group1.bankproject.bankproduct;

/**
 * 
 * 적금계좌 데이터를 저장하는 클래스입니다.
 * 
 * @author 1조
 *
 */


public class Savings {
	
	private int userNum;
	private String savingsAccount;
	private String savingsNum;
	private int savingsMoney;
	private double rate;
	private String savingsName;
	private int savingsSequence;
	
	
	
	public String getSavingsName() {
		return savingsName;
	}
	public void setSavingsName(String savingsName) {
		this.savingsName = savingsName;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getSavingsAccount() {
		return savingsAccount;
	}
	public void setSavingsAccount(String savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	public String getSavingsNum() {
		return savingsNum;
	}
	public void setSavingsNum(String savingsNum) {
		this.savingsNum = savingsNum;
	}
	public int getSavingsMoney() {
		return savingsMoney;
	}
	public void setSavingsMoney(int savingsMoney) {
		this.savingsMoney = savingsMoney;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	/**
	 * 적금 정보를 출력하는 메소드입니다.
	 */
public void savingsInfo() {
		
		System.out.printf("%d %s %s %s %d %f\n",this.userNum,
											this.savingsName,
											this.savingsAccount,
											this.savingsNum,
											this.savingsMoney,
											this.rate);
		
		
	}

public int getSavingsSequence() {
	return savingsSequence;
}
public void setSavingsSequence(int savingsSequence) {
	this.savingsSequence = savingsSequence;
}
	
	

}
