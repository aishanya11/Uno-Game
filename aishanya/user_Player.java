package aishanya;

import java.util.Scanner;

public class user_Player extends Player
{
	void displayCards()
	{
		for(int p=0;p<this.playerCards.size();p++)
		{
			System.out.print(p+" ");
			this.playerCards.get(p).displayUnoCard();
		}
	}

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
