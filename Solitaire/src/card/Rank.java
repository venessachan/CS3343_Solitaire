package card;

public enum Rank {
	A(1,"A"),
	_2(2,"2"),
	_3(3,"3"),
	_4(4,"4"),
	_5(5,"5"),
	_6(6,"6"),
	_7(7,"7"),
	_8(8,"8"),
	_9(9,"9"),
	_10(10,"10"),
	J(11,"J"),
	Q(12,"Q"),
	K(13,"K");
	
	private Integer num;
	private String sign;

	private Rank(Integer num, String sign) {
		this.num = num;
		this.sign = sign;
	}

	public Integer getNum() {
		return num;
	}
	
	public String getSign() {
		return sign;
	}

}
