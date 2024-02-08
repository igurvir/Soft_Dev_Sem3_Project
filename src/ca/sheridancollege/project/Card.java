/**
AUTHOR- GURVIR SINGH 991675538 (7TH FEB, 2024)
 */
package ca.sheridancollege.project;

//Card class
public class Card {
    //private variables 
    //private variables for ENCAPSULATION
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        //constructor for initializing object 
        this.suit = suit;
        this.rank = rank;
    }
    //getter for suit
    public String getSuit() {
        return suit;
    }
    //getter for rank
    public String getRank() {
        return rank;
    }
    
    
    @Override
    //override is done to create custom string representation of the card
    public String toString() {
        //this will return what card the player has drawn
        return rank + " of " + suit;
    }
}
