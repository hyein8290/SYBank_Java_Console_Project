package com.group1.bankproject.additionalWork;

import java.util.ArrayList;
/**
 * 
 * @author 1조
 * 로그인시 불러들인 개인정보를 이용하기 편하게 해주기위한 클래스입니다.
 * 로그인할때 개인정보를 저장해주는 역할을 하며, 로그인회원의 정보를 찾기위해 루프문을 반복적으로 이용해야하는 상황을 탈피하기위해 만들어진 클래스입니다.
 */
public class CurrentUser {
	
	private static int num;
	private static String name;
	private static int debt;
	private static String password;
	private static String jumin;
	private static ArrayList<String> accountList = new ArrayList<String>();
	/**
	 * 기본생성자입니다.
	 */
	public CurrentUser() {
		
	}

	public static String getJumin() {
		return jumin;
	}

	public static void setJumin(String jumin) {
		CurrentUser.jumin = jumin;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static void setPassword(String password) {
		CurrentUser.password = password;
	}
	
	public static int getNum() {
		return num;
	}
	
	public static void setNum(int num) {
		CurrentUser.num = num;
	}
	
	public static String getName() {
		return name;
	}
	
	public static void setName(String name) {
		CurrentUser.name = name;
	}

	public static int getDebt() {
		return debt;
	}

	public static void setDebt(int debt) {
		CurrentUser.debt = debt;
	}

	public static ArrayList<String> getAccountList() {
		return accountList;
	}

	public static void setAccountList(String accountList) {
		CurrentUser.accountList.add(accountList);
	}
	
	
	
	
}
