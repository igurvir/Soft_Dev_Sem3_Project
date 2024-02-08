/**
/**
AUTHOR- GURVIR SINGH 991675538 (7TH FEB, 2024)
 */
 
package ca.sheridancollege.project;


import java.util.Scanner;


public class Game {
    //ENCAPSULATION so private variables
    private   int round_no =1;
    private static final int MAX_ROUNDS = 10; 
    private Player player1;
    private Player player2;

    //Constructor
    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    // Method to start the game
    public void start() {
        int roundsPlayed = 0;
        // Initialize and shuffle the deck
        GroupOfCards deck = new GroupOfCards();
        initializeDeck(deck);
        deck.shuffle();

        // Deal cards to players
        dealCards(deck);

        // Main game loop
        while (roundsPlayed < MAX_ROUNDS) {
            System.out.print("Round Number "+round_no);
            round_no++; //increment
            playRound();
            displayScores();
            roundsPlayed++; //increment
        }

        // Determine the overall winner
        displayWinner();
    }

    private void initializeDeck(GroupOfCards deck) {
        // Create a standard deck of cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                deck.addCard(card);
            }
        }
    }

    private void dealCards(GroupOfCards deck) {
        // Distribute cards to players
        while (deck.drawCard() != null) {
            player1.drawCard(deck.drawCard());
            player2.drawCard(deck.drawCard());
        }
    }

    private void playRound() {
    // Players draw a card each
    Card card1 = player1.playCard();
    Card card2 = player2.playCard();

    // Check if either card is null (indicating an empty hand)
    if (card1 == null || card2 == null) {
        System.out.println("Game over! One player is out of cards.");
        return;
    }

    // Display details of the round
    System.out.println("\n---  Cards Drawn ---");
    System.out.println(player1.getName() + " drew: " + card1);
    System.out.println(player2.getName() + " drew: " + card2);

    // Compare the cards
    int result = card1.getRank().compareTo(card2.getRank());

    // Determine the winner of the round
    if (result > 0) {
        System.out.println(player1.getName() + " wins the round!");
        player1.getHand().addCard(card1);
        player1.getHand().addCard(card2);
    } else if (result < 0) {
        System.out.println(player2.getName() + " wins the round!");
        player2.getHand().addCard(card2);
        player2.getHand().addCard(card1);
    } else {
        System.out.println("It's a tie! Drawing cards again...");
        player1.getHand().addCard(card1);
        player2.getHand().addCard(card2);
    }

    // Prompt the user to continue to the next round
    System.out.println("Press Enter to continue to the next round.");
    new Scanner(System.in).nextLine();
}



    private void displayScores() {
    System.out.println("\n--- Scores ---");
    System.out.println(player1.getName() + ": " + player1.getHand().size() + " cards");
    System.out.println(player2.getName() + ": " + player2.getHand().size() + " cards");
    System.out.println("---------------");
}


    private void displayWinner() {
        if (player1.getHand().isEmpty()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println(player1.getName() + " wins the game!");
        }
    }

    public static void main(String[] args) {
        Game warGame = new Game("Player 1", "Player 2");
        warGame.start();
    }
}
