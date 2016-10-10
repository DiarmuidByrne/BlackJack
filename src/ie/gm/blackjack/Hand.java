package ie.gm.blackjack;

import java.util.*;

/**
 * @author Diarmuid
 *	This class will keep record of the cards in 
 * 	The player and the dealer hands, as well as the values
 *  of each hand.
 */

public class Hand {
	private int handValue = 0;
	private List<Card> cards = new LinkedList<Card>();
	private boolean hasAce = false;
	private boolean has10Card = false;
	private boolean bust = false;
	
	public Hand() {
		super();
	}
	
	public void addCardToHand(Card c) {
		cards.add(c);
		handValue+=c.getCardValue();
		if (c.getCardName() == "Ace") hasAce = true;
		if (c.getCardValue() == 10) has10Card = true;
		if (handValue > 21) bust = true;
	}
	
	public void displayCards(boolean dealer) {
		if (dealer) System.out.println("Dealer cards are: ");
		else System.out.println("Player cards are: ");
		for (Card c : cards) System.out.println(" - " + c.getCardName() + " of " + c.getSuit());
	}
	
	public void clearHand() {
		cards.clear();
		hasAce = false;
		has10Card = false;
		bust = false;
		handValue = 0;
	}
	
	
	// Display first card in Dealer's hand, face up.
	public void displayCard() {
		System.out.println("Dealer cards are: ");
		
		for (int i=1; i<cards.size(); i++) System.out.println(" - " + cards.get(i).getCardName() + " of " + cards.get(i).getSuit());
		System.out.println(" - ???");
	}
	
	public boolean hasBlackJack() {
		return hasAce && has10Card;
	}
	
	public boolean isBust() {
		return bust;
	}
	
	public int getHandValue() {
		return handValue;
	}
	
	public void setHandValue(int val) {
		handValue = val;
	}

	public boolean hasAce() {
		return hasAce;
	}
	
}
