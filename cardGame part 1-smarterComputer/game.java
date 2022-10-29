import java.util.Scanner;

public class game
{
    public static int rounds;
    private static int choice;
    public static int humanVal;
    public static int computerVal;

    public static void main()
    {
        System.out.print("Welcome! Please enter your name: ");
        Scanner scnr = new Scanner(System.in);
        String name = scnr.nextLine();
        System.out.println("\nHere are the rules of the game:\n");
        System.out.println("\tYou and the computer both have a deck of cards with values 1-10");
        System.out.println("\tEach round, you can choose a card in your deck to play.");
        System.out.println("\tThe computer will also choose a card.");
        System.out.println("\tThe highest number gets a point.");
        System.out.println("\tWhoever has the most points at the end of the game wins!");
        System.out.println("\nPlease enter how many rounds you want to play: ");
        rounds = scnr.nextInt();
        player human = new player(name);
        human.score=0; // add this to reset the score!!
        player computer = new player("Computer");
        computer.score = 0; // add this to reset the score!!
        System.out.println(""); // this is the same as System.out.print( "\n" ); 
        for(int i = 1; i <= rounds; i++){
            System.out.print( "--------------------------------------------------\nROUND "+ i + "\n" );
            System.out.print( "Your Deck:\n" );
            human.deck.printDeck();
            System.out.print( "\n" );
            System.out.print( "Computer's Deck:\n" );
            computer.deck.printDeck();
            System.out.print( "\n" );
            System.out.println( "Please choose which card you'll play: " );
            choice = scnr.nextInt();
            while(human.deck.removeCard(choice) == false){
                // if the human player does not enter a card they have in their hand, error message prints
                System.out.println( "Invalid choice. Please try again." ); 
                System.out.print( "Your Deck:\n" );
                human.deck.printDeck();
                System.out.print( "\n" );
                System.out.println( "Please choose which card you'll play: " );
                choice = scnr.nextInt();
            }

            humanVal = choice;
            computerVal = computer.computerChoice();
            System.out.println( "You played " + choice );
            System.out.println( "Computer played " +  computerVal);
            //computer.deck.printDeck();
            if(humanVal > computerVal){
                human.score += 1;
                System.out.println(human.name + " won this round!\n");
            } else if (humanVal < computerVal){
                computer.score += 1;
                System.out.println(computer.name + " won this round!\n");
            } else{
                System.out.println("This round was a tie!\n");
            }
            human.deck.addCard();
            computer.deck.addCard();
            //System.out.println();
        }
        
        System.out.print( "--------------------------------------------------\n" );
        System.out.print("Game Finished! Scores:\n" + human.name + ": " + human.score + "\n" + computer.name + ": " + computer.score);

        if(human.score > computer.score){
            System.out.println("\n" + human.name + " won the game! Good Game!\n");
        } else if (human.score < computer.score){
            System.out.println("\n" + computer.name + " won the game! Good Game!\n");
        } else{
            System.out.println("\nThis game was a tie! Good Game!\n");
        }
    }
}
