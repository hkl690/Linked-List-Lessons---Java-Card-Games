import java.util.*;

public class cardDeck
{
    // Reference to our head node
    public Card head;        
    public static final Random RANDOM = new Random();
    private static final int min = 1, max = 4; // max can be changed to a higher value

    //determine the size of the playing deck.
    private int deckSize = 10;

    public cardDeck()  
    {
        // set the next to null as a default
        this.head = null;
        // creating the card decks
        for(int i = 0; i < deckSize; i++){
            // random was moved from addCard in Part 1 to here because we will not always
            // be adding random cards anymore, some cards are already created
            this.addCard(RANDOM.nextInt( max - min + 1 ) + min);
        }
    }

    public void addCard(int val)
    {
        // val refers to humanVal and computerVal, those will be passed in here
        // whenever new cards need to be added/created
        Card c = new Card(val);
        // Set the new node's next pointer to point at what head is referring to.
        c.next = this.head;
        // Set the head to refer to the new node.
        this.head = c;
    }

    public boolean removeCard( int value )
    {
        // There is no actual deletion, the pointers will move around the node 
        // that is being removed from the deck which will no longer be used
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

    public int countCards()
    {
        int i = 0;
        for( Card p = this.head; p != null; p = p.next ) 
        {
            i++;
        }
        return i;
    }
}
