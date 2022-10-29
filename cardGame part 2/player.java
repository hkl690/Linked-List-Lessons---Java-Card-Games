import java.util.*;

public class player
{
    // instance variables 
    public int score;
    public String name;
    public cardDeck deck = new cardDeck();
    public static final Random RANDOM = new Random();
    private static final int min = 1, max = 10;
    
    /**
     * Constructor for objects of class humanPlayer
     */
    public player()
    {

    }

    public void setName(String name){
        this.name = name;
    }

    public int computerChoice()
    {
        int choice;
        for(choice = 10; this.deck.removeCard(choice) == false; choice--); 
        // if the deck does not have a 10, it subtracts and checks for 9, repeats until it finds its highest value card
        return choice;
    }
}
