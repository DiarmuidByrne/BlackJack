package ie.gm.blackjack;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Diarmuid
 * This class contains all test cases for the project
 */

public class TestGMBlackJack {
	Deck deck;
	Dealer d = new Dealer();
	Hand pHand, dHand;
	Deque<Card> cards;
	
	
	@Before
	public void initialize() {
		deck = new Deck();
		dHand = new Hand();
		pHand = new Hand();
		cards = new ArrayDeque<Card>(deck.getCards());
	}

	@Test
	public void testDeckInitialization() {
		d.reset();
	}
	
	@Test
	public void testAddCards() {
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
	}
	
	@Test
	public void testBustHand() {
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
		dHand.addCardToHand(cards.pop());
		
		System.out.println(dHand.getHandValue());
		assertTrue(dHand.isBust());
	}
	
	@Test
	public void testClearHand() {	
		dHand.clearHand();
		System.out.println(dHand.getHandValue());
		assertTrue(dHand.getHandValue() == 0);
	}
	
	@Test
	public void testCompareHands() {
		pHand.addCardToHand(cards.pop());
		assertTrue(dHand.getHandValue() < pHand.getHandValue());
	}

}
