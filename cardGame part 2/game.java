import java.util.Scanner;

public class game
{
    public static int rounds;
    private static int choice1;
    private static int choice2;
    public static int human1Val;
    public static int human2Val;
    public static int computerVal;
    private static boolean player2;
    public static player human1 = new player();
    public static player human2 = new player();
    public static player computer = new player();
    public static void main()
    {
        System.out.print("Welcome! Please enter your name: ");
        Scanner scnr = new Scanner(System.in);
        String name = scnr.nextLine();
        human1.setName(name);
        human1.score=0; // add this to reset the score!!
        cardDeck humanDeck1 = new cardDeck();
        System.out.println("\nHere are the rules of the game:\n\tPlease keep your decks private!\n\tBoth players both have a deck of cards with values 1-10.\n\tEach round, both players choose a card in their decks to play.\n\tThe highest number gets a point.\n\tWhoever has the most points at the end of the game wins!");
        System.out.print("\nPlease enter how many rounds you want to play: ");
        rounds = scnr.nextInt();
        scnr.nextLine();
        System.out.print("\nDo you want to play with another human or the computer? Y for human, anything else for computer. ");
        String input = scnr.nextLine();
        switch(input){
            case "Y":
            case "y":
                player2 = true;
                break;
            default:
                player2 = false;
        }

        if(player2 == true){
            System.out.print("\nPlease enter player 2's name: ");
            name = scnr.nextLine();
            human2.setName(name);
            human2.score = 0; // add this to reset the score!!
            cardDeck humanDeck2 = new cardDeck();
        } else{
            computer.setName("Computer");
            computer.score = 0; // add this to reset the score!!
            cardDeck computerDeck = new cardDeck();
        }
        
        if(player2 == true){
            for(int i = 1; i <= rounds; i++){
                System.out.println(human1.name + ": Press enter to see your cards. " + human2.name + ": please look away!");
                scnr.nextLine();
                //This will hide the cards from the other player on the screen.
                for(int j=0; j<100; j++) {
                   System.out.println(); 
                }
                System.out.println("\nHere are the rules of the game:\n");
                System.out.println("\tPlease keep your decks private!");
                System.out.println("\tBoth players both have a deck of cards with values 1-10.");
                System.out.println("\tEach round, both players choose a card in their decks to play.");
                System.out.println("\tThe highest number gets a point.");
                System.out.println("\tWhoever has the most points at the end of the game wins!");
                System.out.print( "--------------------------------------------------\nROUND "+ i + "\n" );
                System.out.print( human1.name + "'s Deck:\n" );
                human1.deck.printDeck();
                System.out.print( "\n" );
                //System.out.print( "Computer's Deck:\n" );
                //computer.deck.printDeck();
                //System.out.print( "\n" );
                System.out.println( "Please choose which card you'll play: " );
                choice1 = scnr.nextInt();

                while(human1.deck.removeCard(choice1) == false){
                    System.out.println( "Invalid choice. Please try again." );
                    System.out.print( human1.name + "'s Deck:\n" );
                    human1.deck.printDeck();
                    System.out.print( "\n" );
                    System.out.println( "Please choose which card you'll play: " );
                    choice1 = scnr.nextInt();
                }

                scnr.nextLine(); // important to run this line to execute properly

                for(int j=0; j<100; j++) {
                    System.out.println();  
                }
                System.out.println(human2.name + ": Press enter to see your cards. " + human1.name + ": please look away!");
                scnr.nextLine();
                
                for(int j=0; j<100; j++) {
                    System.out.println();  
                }
                System.out.println("\nHere are the rules of the game:\n");
                System.out.println("\tPlease keep your decks private!");
                System.out.println("\tBoth players both have a deck of cards with values 1-10.");
                System.out.println("\tEach round, both players choose a card in their decks to play.");
                System.out.println("\tThe highest number gets a point.");
                System.out.println("\tWhoever has the most points at the end of the game wins!");
                System.out.print( "--------------------------------------------------\nROUND "+ i + "\n" );
                System.out.print( human2.name + "'s Deck:\n" );
                human2.deck.printDeck();
                System.out.print( "\n" );
                //System.out.print( "Computer's Deck:\n" );
                //computer.deck.printDeck();
                //System.out.print( "\n" );
                System.out.println( "Please choose which card you'll play: " );
                choice2 = scnr.nextInt();

                while(human2.deck.removeCard(choice2) == false){
                    System.out.println( "Invalid choice. Please try again." );
                    System.out.print( human2.name + "'s Deck:\n" );
                    human2.deck.printDeck();
                    System.out.print( "\n" );
                    //System.out.print( "Computer's Deck:\n" );
                    //computer.deck.printDeck();
                    //System.out.print( "\n" );
                    System.out.println( "Please choose which card you'll play: " );
                    choice2 = scnr.nextInt();

                }
                scnr.nextLine();
                
                for(int j=0; j<100; j++) {
                   System.out.println(); 
                }
                
                human1Val = choice1;
                human2Val = choice2;
                
                System.out.println( human1.name + " played " + choice1 );
                System.out.println( human2.name + " played " +  choice2);
                //computer.deck.printDeck();
                if(human1Val > human2Val){
                    human1.score += 1;
                    System.out.println(human1.name + " won this round!\n");
                } else if (human1Val < human2Val){
                    human2.score += 1;
                    System.out.println(human2.name + " won this round!\n");
                } else{
                    System.out.println("This round was a tie!\n");
                }
                
                human1.deck.addCard();
                human2.deck.addCard();
                System.out.println();
            }

            System.out.print( "--------------------------------------------------\n" );
            System.out.print("Game Finished! Scores:\n" + human1.name + ": " + human1.score + "\n" + human2.name + ": " + human2.score);

            if(human1.score > human2.score){
                System.out.println("\n" + human1.name + " won the game! Good Game!\n");
            } else if (human1.score < human2.score){
                System.out.println("\n" + human2.name + " won the game! Good Game!\n");
            } else{
                System.out.println("\nThis game was a tie! Good Game!\n");
            }
        } else{
            for(int i = 1; i <= rounds; i++){
                System.out.print( "--------------------------------------------------\nROUND "+ i + "\n" );
                System.out.print( "Your Deck:\n" );
                human1.deck.printDeck();
                System.out.print( "\n" );
                //System.out.print( "Computer's Deck:\n" );
                //computer.deck.printDeck();
                //System.out.print( "\n" );
                System.out.println( "Please choose which card you'll play: " );
                choice1 = scnr.nextInt();
                
                while(human1.deck.removeCard(choice1) == false){
                    System.out.println( "Invalid choice. Please try again." );
                    System.out.print( "Your Deck:\n" );
                    human1.deck.printDeck();
                    System.out.print( "\n" );
                    //System.out.print( "Computer's Deck:\n" );
                    //computer.deck.printDeck();
                    //System.out.print( "\n" );
                    System.out.println( "Please choose which card you'll play: " );
                    choice1 = scnr.nextInt();
                }

                human1Val = choice1;
                computerVal = computer.computerChoice();
                
                System.out.println( "You played " + choice1 );
                System.out.println( "Computer played " +  computerVal);
                //computer.deck.printDeck();
                if(human1Val > computerVal){
                    human1.score += 1;
                    System.out.println(human1.name + " won this round!\n");
                } else if (human1Val < computerVal){
                    computer.score += 1;
                    System.out.println(computer.name + " won this round!\n");
                } else{
                    System.out.println("This round was a tie!\n");
                }
                human1.deck.addCard();
                computer.deck.addCard();
                System.out.println();
            }
            System.out.print( "--------------------------------------------------\n" );
            System.out.print("Game Finished! Scores:\n" + human1.name + ": " + human1.score + "\n" + computer.name + ": " + computer.score);

            if(human1.score > computer.score){
                System.out.println("\n" + human1.name + " won the game! Good Game!\n");
            } else if (human1.score < computer.score){
                System.out.println("\n" + computer.name + " won the game! Good Game!\n");
            } else{
                System.out.println("\nThis game was a tie! Good Game!\n");
            }
        }
    }
}
