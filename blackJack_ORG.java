import java.util.Scanner;																			//import scanner class
public class blackJack_ORG {

	public static void shuffleDeck(String[] deck) {													//had help from page 250 & 255 from textbook
   
    	for (int i = deck.length - 1; i > 0; i--) {													//shuffle the cards for the player
    																				
    		int j = (int)(Math.random() * (i + 1));													//generating an index randomly 
    				
    			String temp = deck[i]; 											    				//swapping list i with j
    			deck[i] = deck[j];
    			deck[j] = temp;	
        }
    }
    public static String getNextCard(String[] deck) {												//gets next random card for player
        for (int i = 0; i < deck.length; i++) {
        
            if (deck[i] == null) {
                continue;
            }
            String temp = deck[i];
            deck[i] = null;
            return temp;
        }
		return null;
     }
    
    public static int getCardValue(String card) {													 //declares card values for each type
		switch (card) {
	case "King":																					 //King has value of 10 pts
			return 10;
	case "Queen":																					 //Queen has value of 10 pts
			return 10;
	case "Jack":																					 //Jack has value of 10 pts
			return 10;
	case "10":																						 //A 10 has a value of 10 pts
			return 10;
	case "9":																						 //A 9 has a value of 9 pts
			return 9;
	case "8":																						 //An 8 has a value of 8 pts
			return 8;
	case "7":																						 //A 7 has a value of 7 pts
			return 7;
	case "6":																						 //A 6 has a value of 6 pts
			return 6;
	case "5":																						 //A 5 has a value of 5 pts
			return 5;
	case "4":																						 //A 4 has a value of 4 pts
			return 4;
	case "3":																						 //A 3 has a value of 3 pts
			return 3;
	case "2":																						 //A 2 has a value of 2 pts
			return 2;
	case "Ace":																						 //Set ace to value of 11 pts (TEMPORARY)
			return 11;
		}
		return 0;
	}

    public static int getCardValues(String[] playerCards) {						   					 //create players score based on card values

		int playersTotal = 0;													   					 //start from 0 for player score
		int aces = 0;
		int cardValue = 0;
		for (int i = 0; i < playerCards.length; i++) {
			if (playerCards[i] != null) {
				cardValue = getCardValue(playerCards[i]);
				if (cardValue == 11) {
					aces = aces + 1;
				}
				playersTotal = playersTotal + cardValue;
			}
		}
		 while (playersTotal > 21 && aces > 0) {								  					 //changes ace value for player when needed(BJ rules)
	            if (aces > 0) {
	                playersTotal = playersTotal - 10;
	                aces = aces - 1;
	            }}
		return playersTotal;													  					 //returns the players total points
	}
    
    public static int getCardValuesForDealer(String[] dealerCards) {			  					 //create dealer's points based on cards

		int dealersTotal = 0;													 					 //start dealers points from 0
		int aces = 0;
		int cardValue = 0;
		for (int i = 0; i < dealerCards.length; i++) {
			if (dealerCards[i] != null) {
				cardValue = getCardValue(dealerCards[i]);
				if (cardValue == 11) {
					aces = aces + 1;
				}
				dealersTotal = dealersTotal + cardValue;
			}
		}
		 while (dealersTotal > 21 && aces > 0) {								  					//changes ace value for dealer when needed (BJ rules)
	            if (aces > 0) {
	                dealersTotal = dealersTotal - 10;
	                aces = aces - 1;
	            }
	      }
		return dealersTotal;													  					//return dealers total points 
	}
    
    public static void putInHand(String card, String[] cards) {					  					//places cards in "hand"				
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				cards[i] = card;
				return;
			}
		}
	}
    public static void main(String[] args) {
		
	String[] deck = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; //sets up the 13 cards in the deck
        
	int playerPoints = 0, dealerPoints = 0, i = 0;															
	String playerCard, dealerCard, playerChoice; 													
		
    String[] userCards = {null, null, null, null, null, null}, dealerCards = {null, null, null, null, null, null};
	
	Scanner s = new Scanner(System.in); 															
		
	System.out.println("Welcome to Black Jack!"); 													
		
		shuffleDeck(deck);																			
		
		playerCard = getNextCard(deck);  															//randomly selects cards for player
		putInHand(playerCard,userCards);															//gives player the card
		playerPoints = getCardValues(userCards);													//grabs values for players card
		System.out.println("Your Card" + ": " + playerCard);										//tells player their card
		
		playerCard = getNextCard(deck);  															//randomly selects cards for player
		putInHand(playerCard,userCards);															//gives player another card
		System.out.println("Your Card" + ": " + playerCard);										//tells player their second card
		playerPoints = getCardValues(userCards);													//grab values for players card
		System.out.println("Your current points: " + playerPoints);									//tells player current points
			
		dealerCard = getNextCard(deck);																//gets random card for dealer
		putInHand(dealerCard, dealerCards);															//gives dealer the card 
		System.out.println("Dealer's Card" + ": " + dealerCard); 									//prints out dealers first card
		dealerPoints = getCardValuesForDealer(dealerCards);
		System.out.println("Dealer's current points: " + dealerPoints);
		dealerCard = getNextCard(deck); 															//gets second card for dealer but doesn't show
		putInHand(dealerCard, dealerCards);															//puts it in dealers hand 
		
	if 	(playerPoints == 21) {
		System.out.println("You win!");																//if player gets 21 pts they win
		}
			
		System.out.println("Would you like to Hit, Stay, or Quit?"); 								//asks player what they want to do
			playerChoice = s.next().toUpperCase();												//allows the player to enter game choice
		
		if (playerChoice.equals("HIT")) { 															//lets player get more cards
		 
		do { 																						//loop for hitting 
			playerCard = getNextCard(deck);
			putInHand(playerCard, userCards);
			System.out.println("Your next card: " + playerCard); 									//prints out players next card
			playerPoints = getCardValues(userCards);
			
		System.out.println("Your current points: " + playerPoints + 
					"\nDealer's current Points: " + dealerPoints); 									//shows players & dealers current points
			 						
		if (playerPoints > 21) {																
                System.out.println("You lose!");													//if player has more than 21 pts they lose
         }
		else if (playerPoints == 21) {
				System.out.println("You win!");
			}
         
		System.out.println("Hit again or Stay?"); 													//prompt user
		playerChoice = s.next().toUpperCase();														//ignore case sensitivity 
			
		} 
		while (playerChoice.equals("HIT")); { 														//loop for hitting 
			}
		}
		if (playerChoice.equals("STAY")) { 															//lets player keep current cards and move to dealer's turn
			 																						//dealers turn
		dealerPoints = getCardValuesForDealer(dealerCards);
			 
		System.out.println("Dealer's next card: " + dealerCard);									//tell player the dealers first card
			
		if (dealerPoints <= 17) { 																	//if dealer has less than 17 points he hits
				dealerCard = getNextCard(deck);														//gives him the next card for the hit
				putInHand(dealerCard, dealerCards);													//adds to dealers hand 
				dealerPoints = getCardValuesForDealer(dealerCards);
				System.out.println("Dealer's next card: " + dealerCard);							
		}
		if (dealerPoints <= 17) {
				dealerCard = getNextCard(deck);														//gives him the next card for the hit
				putInHand(dealerCard, dealerCards);													//adds to dealers hand 
				dealerPoints = getCardValuesForDealer(dealerCards);
				System.out.println("Dealer's next card: " + dealerCard);
		}
			System.out.println("Dealer's points: " + dealerPoints +									//shows dealers final points
							"\nYour Points: " + playerPoints);										//shows players final points
																									//game rules
		if (playerPoints == 21) { 																	
				System.out.println("You Win!");
		}
		else if (playerPoints <= 21 && playerPoints > dealerPoints) {								 
				System.out.println("You Win!");
		}
		else if (playerPoints < dealerPoints && dealerPoints <= 21) { 
				System.out.println("You lose!");
		}	}
		if (playerPoints == dealerPoints) {															//if player & dealer have same points they tie
			System.out.println("It's a tie!");
		}
		if (dealerPoints > 21) {
			 System.out.println("You win!");
		}
		
		else if (playerChoice.equals("QUIT")) { 													//lets the player quit the game
			System.out.println("Thanks for playing!");
		}
		else {
		System.out.println("Invalid Response");
	}
		
		s.close();
	}
}
