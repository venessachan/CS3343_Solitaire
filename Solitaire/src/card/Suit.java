package card;

public enum Suit {
	SPADES(Color.BLACK,"\u2660"),
    HEARTS(Color.RED,"\u2665"),
    CLUBS(Color.BLACK,"\u2663"),
    DIAMONDS(Color.RED,"\u2666"),;

    private Color color;
    private String sign;
    

    private Suit(Color color, String sign) {
        this.color = color;
        this.sign = sign;
    }

    public Color getColor() {
        return color;
    }

	public String getSign() {
		return sign;
	}
}


