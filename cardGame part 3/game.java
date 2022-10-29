import java.util.Scanner;

public class game
{
    public static int rounds;
    private static int choice;
    public static int humanVal;
    public static int computerVal;
    private static int[][] cardHolder = new int[4][2]; 
    // this 2D array holds the tie-breaking cards needed for 2 players

    public static void main()
    {
        System.out.print("Welcome! Please enter your name: ");
        Scanner scnr = new Scanner(System.in);
        String name = scnr.nextLine();
        System.out.println("\nHere are the rules of the game:\n");
        System.out.println("\tYou and the computer both have a deck of cards with values 1-4.");
        System.out.println("\tEach round, you can choose a card in your deck to play.");
        System.out.println("\tThe computer will also choose a card.");
        System.out.println("\tThe highest number gets a point.");
        System.out.println("\tIn the case of a tie, 3 random cards will be added to the pot,");
        System.out.println("\tand the next card played with the highest value will win all the cards.");
        System.out.println("\tIn the case of another tie, all the cards will be thrown out to keep the game simple.");
        System.out.println("\tWhoever has all the cards at the end of the game wins!");
        // DO NOT NEED!!!! System.out.print("\nPlease enter how many rounds you want to play: "); 
        // DO NOT NEED!!!! rounds = scnr.nextInt();
        player human = new player(name);
        player computer = new player("Computer");
        cardDeck humanDeck = new cardDeck();
        cardDeck computerDeck = new cardDeck();

        for(int i = 1; true; i++)
        {
            System.out.print( "\n--------------------------------------------------\nROUND "+ i + "\n" );
            System.out.print( "Your Deck:\n" );
            human.deck.printDeck();
            System.out.print( "\n" );
            System.out.print( "You have " + human.deck.countCards() + " cards.\n" + "Computer has " + computer.deck.countCards() + " cards.\n" );
            //computer.deck.printDeck();
            //System.out.print( "\n" );
            System.out.println( "Please choose which card you'll play: " );
            choice = scnr.nextInt();
            while(human.deck.removeCard(choice) == false)
            {
                System.out.println( "Invalid choice. Please try again." );
                System.out.print( "Your Deck:\n" );
                human.deck.printDeck();
                System.out.print( "\n" );
                //System.out.print( "Computer's Deck:\n" );
                //computer.deck.printDeck();
                //System.out.print( "\n" );
                System.out.println( "Please choose which card you'll play: " );
                choice = scnr.nextInt();
            }

            humanVal = choice;
            computerVal = computer.computerChoice();
            System.out.println( "You played " + choice );
            System.out.println( "Computer played " +  computerVal);
            //computer.deck.printDeck();

            if(humanVal > computerVal)
            {
                //human.score += 1;
                System.out.println(human.name + " won this round!\n");
                // both players get a new card
                human.deck.addCard(humanVal);
                human.deck.addCard(computerVal);
            } 
            
            else if (humanVal < computerVal)
            {
                //computer.score += 1;
                System.out.println(computer.name + " won this round!\n");
                // both players get a new card
                computer.deck.addCard(humanVal);
                computer.deck.addCard(computerVal);
            } 
            
            else
            {
                if(human.deck.countCards() <= 0 || computer.deck.countCards() <= 0) break;
                System.out.println("This round was a tie!\n\nCollecting 3 more cards from " + human.name + " and 3 more cards from " + computer.name + ".\n");
                cardHolder[0][0] = humanVal;
                // stores the card the human played
                cardHolder[0][1] = computerVal;
                // stores the card the computer played
                int cardCollection = 0;
                
                // if players have less than 3 cards left in their hands, match the amounts
                if(human.deck.countCards() <= 3 || computer.deck.countCards() <= 3) 
                {
                    cardCollection = (human.deck.countCards() < computer.deck.countCards()) ? (human.deck.countCards()) : (computer.deck.countCards()); 
                    // common shorthand for a condition statement, in pseudocode: 
                    // if the human.deck.countCards is < computer.deck.countCards, assign cardCollection to human.deck.countCards,
                    // else assign cardCollection to computer.deck.countCards 
                    
                    if(human.deck.countCards() < computer.deck.countCards()) 
                    {
                        System.out.println(human.name + " has " + cardCollection + " cards, so collecting " + (cardCollection - 1) + " cards instead.\n");

                    }
                    
                    else 
                    {
                        System.out.println(computer.name + " has " + cardCollection + " cards left, so collecting " + (cardCollection - 1) + " cards instead.\n");
                    }
                    cardCollection--;
                }
                
                else
                {
                    cardCollection = 3;
                }
                System.out.print("\n");
                //System.out.print("\n" + cardHolder[0][0] + " " + cardHolder[0][1]);

                for(int j = 1; j <= cardCollection; j++)
                {
                    cardHolder[j][0] = human.computerChoice();
                    cardHolder[j][1] = computer.computerChoice();
                    //System.out.print(" " + cardHolder[j][0] + " " + cardHolder[j][1]);
                }
                
                boolean invalid = false;
                
                do{
                    if(invalid == true) System.out.println( "Invalid choice. Please try again." );
                    invalid = false;
                    System.out.print( "Your Deck:\n" );
                    human.deck.printDeck();
                    System.out.print( "\n" );
                    //System.out.print( "Computer's Deck:\n" );
                    //computer.deck.printDeck();
                    //System.out.print( "\n" );
                    System.out.println( "Please choose which card you'll play in the tiebreaker: " );
                    choice = scnr.nextInt();
                } while(human.deck.removeCard(choice) == false);
                
                humanVal = choice;
                computerVal = computer.computerChoice();
                System.out.println( "You played " + choice );
                System.out.println( "Computer played " +  computerVal);

                if(humanVal > computerVal)
                {
                    //human.score += 1;
                    System.out.println(human.name + " won this round, plus the held values!\n");
                    human.deck.addCard(humanVal);
                    human.deck.addCard(computerVal);
                    for(int k = 0; k <= cardCollection; k++){
                        human.deck.addCard(cardHolder[k][0]);
                        human.deck.addCard(cardHolder[k][1]);
                    }
                } 
                else if (humanVal < computerVal)
                {
                    //computer.score += 1;
                    System.out.println(computer.name + " won this round, plus the held values!\n");
                    computer.deck.addCard(humanVal);
                    computer.deck.addCard(computerVal);
                    for(int k = 0; k <= cardCollection; k++){
                        computer.deck.addCard(cardHolder[k][0]);
                        computer.deck.addCard(cardHolder[k][1]);
                    }
                }
                else
                {
                    System.out.println("This round was another tie! Throwing away all cards.\n");
                }
            }
            if(human.deck.countCards() <= 0 || computer.deck.countCards() <= 0) 
            {
                break;
            }
        }
        System.out.print( "--------------------------------------------------\n" );

        if(human.deck.countCards() <= 0 && computer.deck.countCards() > 0)
        {
            System.out.println(human.name + " ran out of cards! " + computer.name + " wins with " + computer.deck.countCards() + " held cards! Good game!\n");
        }
        else if(computer.deck.countCards() <= 0 && human.deck.countCards() > 0)
        {
            System.out.println(computer.name + " ran out of cards! " + human.name + " wins with " + human.deck.countCards() + " held cards! Good game!\n");
        }
        else
        {
            System.out.println("Everyone ran out of cards! Good game!\n");
        }
        //System.out.print("Game Finished! Scores:\n" + human.name + ": " + human.score + "\n" + computer.name + ": " + computer.score);

        /*if(human.score > computer.score){
        System.out.println("\n" + human.name + " won the game! Good Game!\n");
        } else if (human.score < computer.score){
        System.out.println("\n" + computer.name + " won the game! Good Game!\n");
        } else{
        System.out.println("\nThis round was a tie! Good Game!\n");
        }*/
    }
}

/**
 * Write a description of class game here.
 *
 * @author Darean Wilde
 * @version 0.1
 */
