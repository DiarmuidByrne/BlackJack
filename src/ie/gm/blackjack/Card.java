package ie.gm.blackjack;

/**
 * @author Diarmuid
 * Each card object is an instantiation of the Card class.
 * Card name, value and suit is saved in this class.
 */

public class Card {
	private String suit;
	private String cardName;
	private int cardValue;
	
	public Card() {
		super();
	}
	
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
}
