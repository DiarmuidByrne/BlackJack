## GM BlackJack project
***Diarmuid Byrne***

## Usage
To run the program,
- Navigate to the directory that contains GMBlackJack
- Use the command:
java -cp GMBlackJack.jar ie.gm.blackjack.BlackJack

## Description
The project contains multiple classes:

- BlackJack.java
This contains the main method which is required to run the program.
This class also handles all the user input.
- Card.java
The card class holds information on each instantiated card object, including card name, value, and suit.
- Hand.java
Keeps track of the player and dealer hands, and adds and removes cards when needed.
- Deck.java
The deck class creates the decks and shuffles cards before each game
- Dealer.java
  used for dealing cards into dealer and player hands each turn.
  To do this, it delegates methods to dealerHand and playerHand,
  both of which are Hand objects.
- TestGMBlackJack.java
  Includes unit tests for the project


All source code can be found in the included "src" folder.
