package com.group1.bankproject;

/**
 * UserFundData 클래스입니다. 고객펀드계좌데이터 정보를 저장합니다. 
 * @author 1조
 *
 */
public class UserFundData {
	
	private int num;
	private String fundAccount;
	private int fundProductNum;
	
	/**
	 * 생성자 입니다. 원하는 값으로 객체를 생성합니다. 
	 * @param num 고객펀드계좌데이터 고객번호
	 * @param fundAccount 고객펀드계좌데이터 펀드계좌번호
	 * @param fundProductNum 고객펀드계좌데이터 펀드상품번호
	 */
	public UserFundData(int num, String fundAccount, int fundProductNum) {
		this.num = num;
		this.fundAccount = fundAccount;
		this.fundProductNum = fundProductNum;
	}
	
	/**
	 * 고객펀드계좌데이터의 고객번호를 가져옵니다.
	 * @return 고객펀드계좌데이터 고객번호
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * 고객펀드계좌데이터의 고객번호를 설정합니다. 
	 * @param num 고객펀드계좌데이터 고객번호
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * 고객펀드계좌데이터의 펀드계좌번호를 가져옵니다. 
	 * @return 고객펀드계좌데이터 펀드계좌번호
	 */
	public String getFundAccount() {
		return fundAccount;
	}
	/**
	 * 고객펀드계좌데이터의 펀드계좌번호를 설정합니다. 
	 * @param fundAccount 고객펀드계좌데이터 펀드계좌번호
	 */
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}

	/**
	 * 고객펀드계좌데이터의 펀드상품번호를 가져옵니다.
	 * @return 고객펀드계좌데이터 펀드상품번호
	 */
	public int getFundProductNum() {
		return fundProductNum;
	}

	/**
	 * 고객펀드계좌데이터의 펀드상품번호를 설정합니다. 
	 * @param fundProductNum 고객펀드계좌데이터 펀드상품번호 
	 */
	public void setFundProductNum(int fundProductNum) {
		this.fundProductNum = fundProductNum;
	}
	
	/**
	 * 고객펀드계좌데이터 객체의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return String.format("UserFundData [num=%s, fundAccount=%s, fundProductNum=%s]", num, fundAccount,
				fundProductNum);
	}
	
	

}
