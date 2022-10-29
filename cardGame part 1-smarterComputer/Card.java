public class Card
{
    // Data stored in the node
    private int value;        

    // Reference to our next node
    public Card next;        

    public Card( int val )  
    {
        this.value = val;

        // set the next to null
        // as a default
        this.next = null;
    }

    public int getValue()  
    {
        return this.value;
    }
}
