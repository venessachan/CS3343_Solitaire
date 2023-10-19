package card;

public enum Suit {
	SPADES(Color.BLACK),
    HEARTS(Color.RED),
    DIAMONDS(Color.RED),
    CLUBS(Color.BLACK),
    OTHERS(Color.BLACK);

    private Color color;

    private Suit(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}


