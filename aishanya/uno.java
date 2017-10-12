package aishanya;
import aishanya.Deck;
import aishanya.UnoCard;
import aishanya.Player;
import aishanya.comp_Player;
import aishanya.user_Player;

import java.util.*;
public class uno {
	
	//int random_colour = (result/25) + 1;
		//int random_num = (result%26)/2;
	int white=0;
	int yellow=1;
	int green=2;
	int blue=3;
	int red=4;
	int skip=10;
	int reverse=11;
	int draw2=12;
	int wild=13;
	int wild_4=14;
		
public static void main(String[] args) {
		
		System.out.println("Welcome to Uno Game");
		System.out.println();
		//System.out.println("Enter Number of players");
		Scanner scn= new Scanner(System.in);
		//Integer i;
		//i=scn.nextInt();
		//CREATING DECK OF CARDS 
		Deck Deck1= new Deck();
		
		//CREATING OBJECT OF COMPUTER PLAYER
		comp_Player computer_Player1= new comp_Player();
		
		//CREATING OBJECT OF USER PLAYER
			user_Player user_Player2= new user_Player();
			
		Deck1.distribute_cards(computer_Player1, user_Player2);
		UnoCard TopCard= new UnoCard();
		TopCard=Deck1.assignTopCard();
		System.out.print("TOP ");
		TopCard.displayUnoCard();
		
		boolean move=false;
		boolean tcupdate=false;
		
		while(computer_Player1.playerCards.isEmpty()!=true && user_Player2.playerCards.isEmpty()!=true)
		{
			UnoCard tempCard= new UnoCard();
			
			if(move==true)
			{
				System.out.println("**TURN:COMPUTER**");
				//computer_Player1.displayCards();
				
				System.out.println();
				UnoCard compPlayCard;
				compPlayCard=computer_Player1.play(TopCard);
				if(compPlayCard==null)
				{
					System.out.println("Top card does not change");
					UnoCard temp2=new UnoCard();
					temp2=Deck1.getRandomCard();
					computer_Player1.playerCards.add(temp2);
					if(move==false)  //now its coputer chance. basically next bande ki chance
						move=true;
					else
						move=false;
				}
				else
				{
					tempCard=compPlayCard;
					tcupdate=true;
				}
			}
			else
			{
				System.out.println("**TURN: USER**");
				System.out.println("Your cards are:- ");
				System.out.println();
				user_Player2.displayCards();
				int no;
				System.out.println();
				System.out.println("enter 1 to draw card and enter 2 to put card");
				no=scn.nextInt();
				if(no==1)
				{
					if(move==false)  //now its computer chance. basically next bande ki chance
						move=true;
					else
						move=false;
					user_Player2.playerCards.add(Deck1.getRandomCard());
					
				}
				else
				{
					System.out.println("enter the card you want to put");
				
				    tempCard=user_Player2.getCard(TopCard);//get card will take the card and check if it is correct. if its not will again ask for input. get card will check which card it is 
				    user_Player2.playerCards.remove(tempCard);
				    tcupdate=true;
				}
				
			}
			if(tcupdate==true)
			{
				tcupdate=false;
				//putting the previous top card back in the deck
				int number=TopCard.number_on_card;
				int col=TopCard.colour;
				int index= ((col-1)*25)+(2*number);
			//	System.out.println("col IS "+col);
				if(Deck1.arr.get(index)==null)
					Deck1.arr.set(index,TopCard);
				else
					Deck1.arr.set(index+1,TopCard);
				
				TopCard=tempCard;
				System.out.print("TOP ");
				TopCard.displayUnoCard();
				{
					//IF WILD IS TOP CARD
					if(TopCard.colour==0&&TopCard.number_on_card==13)
						{
						//nothing happens. move does not changes
						}
					// IF WILD DRAW4 IS TOP CARD
					else if(TopCard.colour==0&&TopCard.number_on_card==14)
					{
						if(move==false)
						{
							//computer draws 4 cards 
						for(int counter=0;counter<=3;counter++)
							computer_Player1.playerCards.add(Deck1.getRandomCard());
						}
						else
						{
							for(int counter=0;counter<=3;counter++)
								user_Player2.playerCards.add(Deck1.getRandomCard());
							//player draws 4 cards
						}
						//move does not change
					}
					//IF TOP CARD IS ACTION CARD
					else if(TopCard.number_on_card>=10)
					{
						if(TopCard.number_on_card==12)
						{
							if(move==false)
							{
								for(int counter=0;counter<=1;counter++)
									computer_Player1.playerCards.add(Deck1.getRandomCard());
								//computer draws 2 cards 
							}
							else
							{
								for(int counter=0;counter<=1;counter++)
									user_Player2.playerCards.add(Deck1.getRandomCard());
								//player draws 2 cards
							}
							//MOVE DOES NOT CHANGES
						}
						else
						{
							//Move does not changes
						}
					}
					//IF TOPCARD IS NORMAL NUMBER CARD
					else
					{	if(move==false)  //now its coputer chance. basically next bande ki chance
							move=true;
						else
							move=false;
					}
					
				}
				
				
					
			}
			else
			{
				
			}
			
			//CODE TO CLEAR SCREEN
			
			
		}
		if(computer_Player1.playerCards.isEmpty()==true)
			{System.out.println("Computer wins!");}
		else
			{System.out.println("You Win!");}
		
		
		//System.out.println("Press any key to distrubute cards");
		//String placeholder=scn.nextLine();
		
		
		/* CLEARING SCREEN AFTER THIS
		 * int j;
		String placeholder;
		for(j=0;j<24;j++)
		{System.out.println();}
		System.out.println("Press any key to continue");
		placeholder=scn.nextLine();
		for(j=0;j<24;j++)
		{System.out.println();}
		*/
		
		
		

	}

}