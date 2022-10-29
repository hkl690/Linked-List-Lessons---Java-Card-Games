import java.util.*;

public class player
{
    // instance variables
    public int score;
    public String name;
    public cardDeck deck = new cardDeck(); // cardDeck is a linked list
    public static final Random RANDOM = new Random(); // only for random computerChoice
    private static final int min = 1, max = 10; // only for random computerChoice

    /**
     * Constructor for objects of class humanPlayer
     */
    public player(String name)
    {
        this.name = name;
    }
    
    /* This method is to have the computer choose a random card instead of the highest value card.
     * public int computerChoice()
    {
        int computerCard = RANDOM.nextInt( max - min + 1 ) + min; // get random values 1 - 10
        while(this.deck.removeCard(computerCard) == false){ 
            // after picking a random number, checks to see if that is in its deck and will repeat if the card is not there
            computerCard= RANDOM.nextInt( max - min + 1 ) + min; // picks another random number, will stop after the removeCard == true
        }
        return computerCard;
    }*/
    
        public int computerChoice()
    {
        int choice;
        for(choice = 10; this.deck.removeCard(choice) == false; choice--); 
        // if the deck does not have a 10, it subtracts and checks for 9, repeats until it finds its highest value card
        return choice;
    }
}
