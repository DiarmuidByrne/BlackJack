package ie.gm.blackjack;

import java.util.Scanner;

/**
 * @author Diarmuid
 *	The BlackJack class contains the main method for the project.
 * 	This class allows the user to play a game of BlackJack and handles
 *  all user input.
 */

public class BlackJack {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
		Dealer d = new Dealer();
		boolean playerHit;
		// Player starts with $100 to bet. If pool reaches 0, game is over.
		int betPool = 100;
		String choice;
				
		boolean gameOver = false;
		do {
			choice = "";
			
			System.out.println("Welcome to Blackjack!");
			System.out.println("How much are you betting? ($" + betPool + " left)");

			while (!console.hasNextInt()) {
				console.next();
			}
			int currentBet = console.nextInt();
			if(currentBet > betPool) currentBet = betPool;
			
			
			d.displayPlayerCards();
			d.displayDealerCard();
			
			// Check if player or dealer has blackjack (Ace and any 10 value card)
			if(d.dealerHasBlackJack()) {
				System.out.println("Dealer got BlackJack! You lost $" + currentBet);
				gameOver = true;
				betPool -= currentBet;
			} if(d.playerHasBlackJack() && !gameOver) {
				System.out.println("You got BlackJack! You won $" + currentBet);
				betPool += currentBet;
				gameOver = true;
			}
			
			while(!gameOver) {
				System.out.println("Enter \n - 1 To Hit or \n - 2 to stand");
				choice = console.next();
				// Player chose to hit
				if("1".equals(choice)) {
					playerHit = true;
					d.deal(playerHit);
					d.displayPlayerCards();
					// Check players for bust, if so, end game.
					if(d.playerBust()) {
						d.displayDealerCards();
						System.out.println("Player is Bust! You lost $" + currentBet);
						betPool -= currentBet;
						d.clearHands();
						gameOver = true;
					} else if(d.dealerBust()) {
						d.displayDealerCards();
						System.out.println("Dealer is Bust! You won $" + currentBet);
						betPool += currentBet;
						d.clearHands();
						gameOver = true;
					}
				// Player chose to stand
				} else if ("2".equals(choice)){
					gameOver = true;
					playerHit = false;
					while(d.getDealerHandValue() < 16) d.deal(playerHit);
					d.displayPlayerCards();
					d.displayDealerCards();
					
					// If dealer or player has an ace and their hand value is 11 or less, change the hand value by 10
					if(d.playerHasAce() && d.getPlayerHandValue() <= 11) d.setPlayerHandValue(d.getPlayerHandValue()+10);
					if(d.dealerHasAce() && d.getDealerHandValue() <= 11) d.setDealerHandValue(d.getDealerHandValue()+10);
					
					// Check players for bust, if so, end game.
					if(d.dealerBust()) {
						System.out.println("Dealer is Bust! You won $" + currentBet);
						d.clearHands();
					} else if (d.getDealerHandValue() >= d.getPlayerHandValue()){
						System.out.println("Dealer wins with score of " + d.getDealerHandValue() + ". You lost $" + currentBet);
						currentBet *= -1;
					} else {
						System.out.println("You win! You won $" + currentBet);
					}
					betPool += currentBet;
				}
			}
			// End / reset game when round is over
			if(betPool <= 0) {
				gameOver = true;
				System.out.println("You're out of money! The casino kicked you out!");
			} else {
				System.out.println("Keep playing? (Y/N)");
				while (!"Y".equalsIgnoreCase(choice) && !"N".equalsIgnoreCase(choice)) {
					choice = console.next();
				}
				if("N".equalsIgnoreCase(choice)) gameOver = true;
				else  {
					d.reset();
					gameOver = false;
				}
			}
		} while (!gameOver && !"1".equals(choice) && !"2".equals(choice) && betPool > 0);
	}
}
