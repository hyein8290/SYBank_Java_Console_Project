package com.group1.bankproject;

/**
 * FundProduct 클래스입니다. 펀드상품 정보를 저장합니다.
 * @author 1조
 *
 */
public class FundProduct {

	private int num;
	private String fundName;
	private double profitRate;
	private int period;
	private double fee;
	/**
	 * 생성자 입니다. 원하는 값으로 객체를 생성합니다. 
	 * @param num 상품번호
	 * @param fundName 상품명
	 * @param profitRate 수익률
	 * @param period 가입기간
	 * @param fee 수수료
	 */
	public FundProduct(int num, String fundName, double profitRate, int period, double fee) {

		this.num = num;
		this.fundName = fundName;
		this.profitRate = profitRate;
		this.period = period;
		this.fee = fee;
		
	}
	/**
	 * 펀드상품데이터의 상품번호를 가져옵니다.
	 * @return 펀드상품데이터 상품번호
	 */
	public int getNum() {
		return num;
	}
	/**
	 * 펀드상품데이터의 상품번호를 설정합니다.
	 * @param num 펀드상품데이터 상품번호
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * 펀드상품데이터의 상품명을 가져옵니다.
	 * @return 펀드상품데이터 상품명
	 */
	public String getFundName() {
		return fundName;
	}
	/**
	 * 펀드상품데이터의 상품명을 설정합니다.
	 * @param fundName 펀드상품데이터 상품명
	 */
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	/**
	 * 펀드상품데이터의 수익률을 가져옵니다. 
	 * @return 펀드상품데이터 수익률
	 */
	public double getProfitRate() {
		return profitRate;
	}
	/**
	 * 펀드상품데이터의 수익률을 설정합니다. 
	 * @param profitRate 펀드상품데이터 수익률
	 */
	public void setProfitRate(double profitRate) {
		this.profitRate = profitRate;
	}
	/**
	 * 펀드상품데이터의 가입기간을 가져옵니다.
	 * @return 펀드상품데이터 가입기간
	 */
	public int getPeriod() {
		return period;
	}
	/**
	 * 펀드상품데이터의 가입기간을 설정합니다. 
	 * @param period 펀드상품데이터 가입기간
	 */
	public void setPeriod(int period) {
		this.period = period;
	}
	/**
	 * 펀드상품데이터의 수수료를 가져옵니다. 
	 * @return 펀드상품데이터 수수료
	 */
	public double getFee() {
		return fee;
	}
	/**
	 * 펀드상품데이터의 수수료를 설정합니다. 
	 * @param fee 펀드상품데이터 수수료
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}
	/**
	 * 펀드상품데이터 객체의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return String.format("FundProduct [num=%s, fundName=%s, profitRate=%s, period=%s, fee=%s]", num, fundName,
				profitRate, period, fee);
	}
	
	
}
