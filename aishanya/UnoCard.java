package aishanya;
//import priyanka.Deck;
//import priyanka.Player;
public class UnoCard
{
	public int colour;
	public int number_on_card;
	int draw_cards;
	UnoCard()
	{
		this.colour=100;
		this.number_on_card=100;
		
	}
	void setColour(int i){
		this.colour=i;
	}
	void assign(int number_on_card, int colour)
	{
		this.colour=colour;
		this.number_on_card=number_on_card;
		draw_cards=0;
		if(number_on_card==12)
			draw_cards=2;
		if(number_on_card==14)
			draw_cards=4;
	}
	void displayUnoCard()
	{
		System.out.print("CARD IS: ");
		
		if(this.number_on_card<10)
		{
			switch(this.colour) 
			{
				
				case 1:
					System.out.println(number_on_card+" "+"yellow");
					break;
				case 2:
					System.out.println(number_on_card+" "+"green");
					break;
				case 3:
					System.out.println(number_on_card+" "+"blue");
					break;
				case 4:
					System.out.println(number_on_card+" "+"red");
					break;
				
			}
		}
		else 
		{
			String str1,str2;
			if(this.number_on_card==10)
				str1="skip";
			else if(this.number_on_card==11)
				str1="reverse";
			else if(this.number_on_card==12)
				str1="draw 2";
			else if(this.number_on_card==13)
				str1="wild";
			else
				str1="wildDraw4";
			if(this.colour==0)
				str2="";
			else if(this.colour==1)
				str2="yellow";
			else if(this.colour==2)
				str2="green";
			else if(this.colour==3)
				str2="blue";
			else 
				str2="red";
			System.out.println(str1+" "+str2);
		}
		
		
		
	}
	
	
}
