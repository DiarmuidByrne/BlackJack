package ie.gm.blackjack;

import java.util.*;

/**
 * 	@author Diarmuid
 *  Dealer class used for dealing cards into dealer and player hands each turn.
 *  To do this, it delegates methods to dealerHand and playerHand, 
 *  both of which are Hand objects.
 */

public class Dealer {
	private static Deque<Card> cards;
	private static Deck d;
	private Hand playerHand, dealerHand;
	
	public Dealer() {
		d = new Deck();
		playerHand = new Hand();
		dealerHand = new Hand();
			
		reset();
	}
	
	// Deal two cards each for the player and dealer
	private void initialize() {
		playerHand.addCardToHand(cards.pop());
		playerHand.addCardToHand(cards.pop());
		dealerHand.addCardToHand(cards.pop());
		dealerHand.addCardToHand(cards.pop());
	}
		
	// Deals cards into respective hands each turn
	public void deal(boolean playerHit) {
		if(playerHit) playerHand.addCardToHand(cards.pop());
		// Ff the dealer's hand is worth 16 or more, they are forced to stand,
		// else, they must hit.
		if(dealerHand.getHandValue() < 17 && playerHand.getHandValue() <= 21)	dealerHand.addCardToHand(cards.pop());
	}
	
	// Reset cards for new game. Called when program is
	// first run and every time a new game is started.
	public void reset() {
		d.shuffleCards();
		Deque<Card> shuffledCards = new ArrayDeque<Card>(d.getCards());
		cards = shuffledCards;
		initialize();
	}
	
	public void clearHands() {
		playerHand.clearHand();
		dealerHand.clearHand();
	}
	
	public void displayDealerCards() {
		dealerHand.displayCards(true);
	}
	
	public void displayPlayerCards() {
		playerHand.displayCards(false);
	}
	
	public void displayDealerCard() {
		dealerHand.displayCard();
	}
	
	public int getDealerHandValue() {
		return dealerHand.getHandValue();
	}
	
	public int getPlayerHandValue() {
		return playerHand.getHandValue();
	}
	
	public boolean playerBust() {
		return playerHand.isBust();
	}
	
	public boolean dealerBust() {
		return dealerHand.isBust();
	}
	
	public boolean dealerHasBlackJack() {
		return dealerHand.hasBlackJack();
	}
	
	public boolean playerHasBlackJack() {
		return playerHand.hasBlackJack();
	}
	
	public void setDealerHandValue(int val) {
		dealerHand.setHandValue(val);
	}
	
	public void setPlayerHandValue(int val) {
		playerHand.setHandValue(val);
	}
	
	public boolean playerHasAce() {
		return playerHand.hasAce();
	}
	
	public boolean dealerHasAce() {
		return dealerHand.hasAce();
	}
}
