package com.group1.bankproject;

/**
 * UserAccountData 클래스입니다. 고객예금계좌 정보를 저장합니다.
 * @author 1조
 *
 */
public class UserAccountData {
	
	private int num;
	private String account;
	
	public UserAccountData() {
		
	}
	/**
	 * 생성자 입니다. 원하는 값으로 객체를 생성합니다.
	 * @param num 고객번호
	 * @param account 예금계좌번호
	 */
	public UserAccountData(int num, String account) {
		this.num = num;
		this.account = account;
	}
	/**
	 * 고객예금계좌데이터의 고객번호를 가져옵니다. 
	 * @return 고객예금계좌데이터 고객번호
	 */
	public int getNum() {
		return num;
	}
	/**
	 * 고객예금계좌데이터의 고객번호를 설정합니다. 
	 * @param num 고객예금계좌데이터 고객번호
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * 고객예금계좌데이터의 예금계좌번호를 가져옵니다. 
	 * @return 고객예금계좌데이터 예금계좌번호
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 고객예금계좌데이터의 예금계좌번호를 설정합니다. 
	 * @param account 고객예금계좌데이터 예금계좌번호
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	
}
