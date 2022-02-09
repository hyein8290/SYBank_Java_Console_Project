package com.group1.bankproject.deposit;

import java.util.Calendar;

/**
 * 
 * 고객별 예금 계좌 정보를 담는 클래스
 * @author 1조
 *
 */
public class IndividualAccount implements Comparable<IndividualAccount> {
	
	private Calendar transTime;
	private String transType;
	private int transMoney;
	private int money;
	
	/**
	 * 기본 생성자. "1990-01-01", "", 0, 0을 가집니다.
	 */
	public IndividualAccount() {
		this("1900-01-01", "", 0, 0);
	}
	
	/**
	 * 
	 * IndividualAccount 클래스의 생성자
	 * @param transTime 거래날짜
	 * @param transType 거래유형
	 * @param transMoney 거래금액
	 * @param money 잔액
	 */
	public IndividualAccount(String transTime, String transType, int transMoney, int money) {
		
		setTransTime(transTime);
		this.transType = transType;
		this.transMoney = transMoney;
		this.money = money;
	}

	/**
	 * 거래날짜를 가져옵니다.
	 * @return 거래날짜
	 */
	public Calendar getTransTime() {
		return transTime;
	}

	/**
	 * 거래날짜를 설정합니다.
	 * @param transTimeStr 거래날짜
	 */
	public void setTransTime(String transTimeStr) {
		
		Calendar transTime = Calendar.getInstance();
		
		int firstIndex = transTimeStr.indexOf("-");
		int lastIndex = transTimeStr.lastIndexOf("-");
		
		int year = Integer.parseInt(transTimeStr.substring(0, firstIndex));
		int month = Integer.parseInt(transTimeStr.substring(firstIndex + 1, lastIndex)) - 1;
		int date = Integer.parseInt(transTimeStr.substring(lastIndex + 1));
				
		transTime.set(year, month, date);
		
		this.transTime = transTime;
	}
	
	/**
	 * 거래유형을 가져옵니다.
	 * @return 거래유형
	 */
	public String getTransType() {
		return transType;
	}

	/**
	 * 거래유형을 설정합니다.
	 * @param transType 거래유형
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	/**
	 * 거래금액을 가져옵니다.
	 * @return 거래금액
	 */
	public int getTransMoney() {
		return transMoney;
	}
	
	/**
	 * 거래금액을 설정합니다.
	 * @param transMoney 거래금액
	 */
	public void setTransMoney(int transMoney) {
		this.transMoney = transMoney;
	}
	
	/**
	 * 잔액을 가져옵니다.
	 * @return 잔액
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * 잔액을 설정합니다.
	 * @param money 잔액
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int compareTo(IndividualAccount o) {
		
		return o.getTransTime().compareTo(this.getTransTime());
	}


}