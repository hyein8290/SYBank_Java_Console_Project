package com.group1.bankproject.bankproduct;

import java.util.HashMap;



/**
 * 
 * 고객정보 데이터를 저장하는 클래스입니다.
 * 
 * @author 1조
 *
 */

public class User {

	private int userNum;  
	private String id;		
	private String password;
	private String name;
	private String address;
	private String jumin;
	private String tel;
	private int debt;
	private HashMap<String, Integer> fundMap;  
	private HashMap<Integer,String> depositMap; 
	
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getDebt() {
		return debt;
	}
	public void setDebt(int debt) {
		this.debt = debt;
	}
	public HashMap<String, Integer> getFundMap() {
		return fundMap;
	}
	
	public void setFundMap(HashMap<String, Integer> fundMap) {
		this.fundMap = fundMap;
	}
	



	public void info() {
		   String str = String.format("%d\t%s\t%s\t%s\t%s\t %s\t %s\t %d\t", userNum, id, password, name, address, jumin, tel, debt);
		   
		   System.out.println(str);
		   System.out.println(fundMap);
		   System.out.println(depositMap);
		  
	   }
	public HashMap<Integer,String> getDepositMap() {
		return depositMap;
	}
	public void setDepositMap(HashMap<Integer,String> depositMap) {
		this.depositMap = depositMap;
	}

	
	
	
	
}
