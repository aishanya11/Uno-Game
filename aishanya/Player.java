package aishanya;
import aishanya.Deck;
import aishanya.UnoCard;

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{ 
	int n ;
	ArrayList<UnoCard> playerCards = new ArrayList<UnoCard>(n);
	
	UnoCard getCard(UnoCard TopCard)
	{
		//System.out.println("enter your card");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		UnoCard card = new UnoCard();
		card = this.playerCards.get(n);
		if(card.colour==TopCard.colour || card.number_on_card == TopCard.number_on_card || card.colour==0||TopCard.colour==0)
		{
			return card;
		}
		else
		{
			this.getCard(TopCard);
		}
		return card;
	}

}