import java.util.*;

public class cardDeck
{
    // Reference to our head node
    public Card head;        
    public static final Random RANDOM = new Random();
    private static final int min = 1, max = 10;
    
    //determine the size of the playing deck.
    private int deckSize = 5;

    public cardDeck()  
    {
        // set the next to null
        // as a default
        this.head = null;
        for(int i = 0; i < deckSize; i++){
        this.addCard();
        }
    }

    public void addCard()
    {
        int randomNum = RANDOM.nextInt( max - min + 1 ) + min;
        Card c = new Card(randomNum);
        // Set the new node's next pointer to point at 
        // what head is referring to.
        c.next = this.head;
        // Set the head to refer to the new node.
        this.head = c;
    }

    public boolean removeCard( int value )
    {
        Card previous = null;

        for( Card p = this.head; p != null; p = p.next )
        {
            if( p.getValue() == value )
            {
                if( p == head )
                {
                    head = head.next;
                }
                else
                {
                    previous.next = p.next;
                }
                p = null;
                return true;
            }
            previous = p;
        }
        return false;
    }

    public void printDeck()
    {
        for( Card p = this.head; p != null; p = p.next )
        {
            // Assume there is a getValue() method
            // in the Node class
            System.out.print( p.getValue() + " " );
        }
        System.out.print( "\n" );

    }
}
