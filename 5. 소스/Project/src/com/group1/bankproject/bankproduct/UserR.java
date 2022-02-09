package com.group1.bankproject.bankproduct;

import java.util.ArrayList;


/**
 * 
 * 계좌 관련 고객정보 데이터를 저장하는 클래스입니다.
 * 
 * @author 1조
 *
 */

public class UserR {

	private int userNum;  
	private ArrayList<Fund> fundObject;  
	private ArrayList<Savings> savingsObList;
	private ArrayList<Deposits> depositObList; 
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public ArrayList<Fund> getFundObject() {
		return fundObject;
	}
	public void setFundObject(ArrayList<Fund> fundObject) {
		this.fundObject = fundObject;
	}
	public ArrayList<Savings> getSavingsObList() {
		return savingsObList;
	}
	public void setSavingsObList(ArrayList<Savings> savingsObList) {
		this.savingsObList = savingsObList;
	}
	public ArrayList<Deposits> getDepositObList() {
		return depositObList;
	}
	public void setDepositObList(ArrayList<Deposits> depositObList) {
		this.depositObList = depositObList;
	}
	
	


	
	
	
	
}
