package ie.gm.blackjack;

import java.util.*;

/**
 * @author Diarmuid
 * The deck class creates the decks and
 * shuffles cards before each game.
 */
public class Deck {
	private List<Card> decks = new LinkedList<Card>();
	private String[] cardNames = new String[] { "Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King" };
	private String[] suits = new String[] { "Spades", "Clubs", "Diamonds", "hearts" };
	private final int MAX_DECKS = 3;

	public Deck() {
		for(int i=0; i<MAX_DECKS; i++) populateDeck();
	}
	
	// Adds card names and values for each card in a deck of 52
	private void populateDeck() {
		for(String suit:suits) {
			// Add names to each card
			for(String name:cardNames) {
				Card c = new Card();
				c.setCardName(name);
				c.setSuit(suit);
				
				// Set the values for the cards
				if (c.getCardName() == "10" || c.getCardName() == "Jack" 
						|| c.getCardName() == "Queen" || c.getCardName() == "King") {
					c.setCardValue(10);
				} else if (c.getCardName() != "Ace"){
					c.setCardValue(Integer.parseInt(c.getCardName()));
				} else c.setCardValue(1);
				
				decks.add(c);
			}
		}
	}
	
	// Use long int for random shuffle seed
	public void shuffleCards() {
		long seed = System.nanoTime();
		Collections.shuffle(decks, new Random(seed));
	}
	
	public static void main(String[] args) {
		new Deck();
	}
	
	public List<Card> getCards() {
		return decks;
	}
}