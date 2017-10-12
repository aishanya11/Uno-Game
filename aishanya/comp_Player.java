package aishanya ;

public class comp_Player extends Player
{
	void displayCards()
	{
		System.out.println("you dont need to see this");
		for(int p=0;p<this.playerCards.size();p++)
		{
			System.out.print(p+" ");
			if (this.playerCards.get(p)==null)
			{ System.out.println("we are breaking the loop");
				break;}
			this.playerCards.get(p).displayUnoCard();
		}
	}
	
	UnoCard play(UnoCard TopCard)
	{
		
		int index1=-1;
		int index2=-1;
		int index3=-1;
		for(int i=0;i<this.playerCards.size();i++)
		{
			if(this.playerCards.get(i)==null)
			{
				System.out.println("we are breaking the lopp");
				break;
			}
			if(this.playerCards.get(i).colour==TopCard.colour)
				index1=i;
			if(this.playerCards.get(i).number_on_card==TopCard.number_on_card)
				index2=i;
			if(this.playerCards.get(i).colour==0)
				index3=i;
			
		}
		UnoCard temp=new UnoCard();
		if(index1!=-1)
		{
			
			temp.colour=this.playerCards.get(index1).colour;
			temp.number_on_card=this.playerCards.get(index1).number_on_card;
			this.playerCards.remove(index1);
			
		}
		else if(index2!=-1)
		{
			temp.colour=this.playerCards.get(index2).colour;
			temp.number_on_card=this.playerCards.get(index2).number_on_card;
			this.playerCards.remove(index2);
		}
		else if(index3!=-1)
		{
			temp.colour=this.playerCards.get(index3).colour;
			temp.number_on_card=this.playerCards.get(index3).number_on_card;
			this.playerCards.remove(index3);
		}
		else
		{
			//COMPUTER DRAWS CARD
			temp=null;
			
			
		}
		//System.out.println("temp is ");
		//temp.displayUnoCard();
		return temp;
	}
	
}