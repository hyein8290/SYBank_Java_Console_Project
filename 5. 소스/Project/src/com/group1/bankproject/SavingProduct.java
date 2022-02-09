package com.group1.bankproject;

/**
 * SavingProduct 클래스입니다. 적금상품 정보를 저장합니다. 
 * @author 1조
 *
 */
public class SavingProduct {

	private int num;
	private String savingName;
	private double rate;
	private int period;
	/**
	 * 생성자 입니다. 원하는 값으로 객체를 생성합니다. 
	 * @param num 상품번호
	 * @param savingName 상품명
	 * @param rate 금리율 
	 * @param period 가입기간
	 */
	public SavingProduct(int num, String savingName, int rate, int period) {
		
		this.num = num;
		this.savingName = savingName;
		this.rate = rate;
		this.period = period;
		
	}
	/**
	 * 적금상품데이터의 상품번호를 가져옵니다.
	 * @return 적금상품데이터 상품번호
	 */
	public int getNum() {
		return num;
	}
	/**
	 * 적금상품데이터의 상품번호를 설정합니다.
	 * @param num 적금상품데이터 상품번호
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * 적금상품데이터의 상품명을 가져옵니다. 
	 * @return 적금상품데이터 상품명
	 */
	public String getSavingName() {
		return savingName;
	}
	/**
	 * 적금상품데이터의 상품명을 설정합니다. 
	 * @param savingName 적금상품데이터 상품명
	 */
	public void setSavingName(String savingName) {
		this.savingName = savingName;
	}

	/**
	 * 적금상품데이터의 금리율을 가져옵니다.
	 * @return 적금상품데이터 금리율
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * 적금상품데이터의 금리율을 설정합니다.
	 * @param rate 적금상품데이터 금리율
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
	/**
	 * 적금상품데이터의 가입기간을 가져옵니다.
	 * @return 적금상품데이터 가입기간 
	 */
	public int getPeriod() {
		return period;
	}
	/**
	 * 적금상품데이터의 가입기간을 설정합니다. 
	 * @param period 적금상품데이터 가입기간
	 */
	public void setPeriod(int period) {
		this.period = period;
	}
	
	/**
	 * 적금상품데이터 객체의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return String.format("SavingProduct [num=%s, savingName=%s, rate=%s, period=%s]", num, savingName, rate,
				period);
	}
	
}
