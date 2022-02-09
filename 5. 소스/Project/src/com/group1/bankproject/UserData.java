package com.group1.bankproject;

/**
 * UserData 클래스입니다. 고객 정보를 저장합니다.
 * @author 1조
 *
 */
public class UserData {
	
	private int num;
	private String id;
	private String password;
	private String name;
	private String address;
	private String jumin;
	private String tel;
	private int debt;
	
	public UserData() {
		
	}
	
	/**
	 * 생성자 입니다. 원하는 값으로 객체를 생성합니다. 
	 * @param num 고객데이터 고객번호 
	 * @param id 고객데이터 아이디 
	 * @param password 고객데이터 비밀번호
	 * @param name 고객데이터 이름
	 * @param address 고객데이터 주소
	 * @param jumin 고객데이터 주민등록번호
	 * @param tel 고객데이터 전화번호
	 * @param debt 고객데이터 부채 
	 */
	public UserData(int num, String id, String password, String name, String address, String jumin, String tel, int debt) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.jumin = jumin;
		this.tel = tel;
		this.debt = debt;		
	}

	/**
	 * 고객데이터의 아이디를 가져옵니다. 
	 * @return 고객데이터 아이디
	 */
	public String getId() {
		return id;
	}

	/**
	 * 고객데이터의 아이디를 설정합니다. 
	 * @param id 고객데이터 아이디
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 고객데이터의 비밀번호를 가져옵니다. 
	 * @return 고객데이터 비밀번호
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 고객데이터의 비밀번호를 설정합니다. 
	 * @param password 고객데이터 비밀번호
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 고객데이터의 이름을 가져옵니다. 
	 * @return 고객데이터 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * 고객데이터의 이름을 설정합니다. 
	 * @param name 고객데이터 이름
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 고객데이터의 주소를 가져옵니다. 
	 * @return 고객데이터 주소
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 고객데이터의 주소를 설정합니다. 
	 * @param address 고객데이터 주소
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 고객데이터의 주민등록번호를 가져옵니다. 
	 * @return 고객데이터 주민등록번호
	 */
	public String getJumin() {
		return jumin;
	}

	/**
	 * 고객데이터의 주민등록번호를 설정합니다. 
	 * @param jumin 고객데이터 주민등록번호
	 */
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	/**
	 * 고객데이터의 전화번호를 가져옵니다. 
	 * @return 고객데이터 전화번호
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 고객데이터의 전화번호를 설정합니다. 
	 * @param tel 고객데이터 전화번호
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	/**
	 * 고객데이터의 부채를 가져옵니다.
	 * @return 고객데이터 부채
	 */
	public int getDebt() {
		return debt;
	}

	/**
	 * 고객데이터의 부채를 설정합니다. 
	 * @param debt 고객데이터 부채
	 */
	public void setDebt(int debt) {
		this.debt = debt;
	}

	/**
	 * 고객데이터의 고객번호를 가져옵니다.
	 * @return 고객데이터 고객번호
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 고객데이터의 고객번호를 설정합니다.
	 * @param num 고객데이터 고객번호
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * 고객데이터 객체의 상태를 문자열로 반환합니다.
	 */
	@Override
	public String toString() {
		return String.format("UserData [num=%s, id=%s, password=%s, name=%s, address=%s, jumin=%s, tel=%s, debt=%s]",
				num, id, password, name, address, jumin, tel, debt);
	}
	
	
	
}
