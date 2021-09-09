import java.util.*;
class Blackjack{
	public static void main(String[]args)throws InterruptedException{
	long start = System.currentTimeMillis();
	Scanner scan = new Scanner(System.in);
	int dealer=0;
	int player=0;
	int card=0;
	int bet=1000;
	boolean newHand=true;
	boolean playAgain=true;
	
	ArrayList<String> deck = new ArrayList<String>();
	ArrayList<Integer> value = new ArrayList<Integer>();
	ArrayList<Integer> shuffle = new ArrayList<Integer>();
	for(int i=0;i<4;i++){
		int v=2;
		for(int x=0;x<10;x++){
			value.add(v);
			v++;}
		for(int y=0;y<3;y++){
			value.add(10);
		}
	}
	for(int i=0;i<51;i++){
		shuffle.add(i);
	}
//	for(int i=0;i<value.size();i++){
//		System.out.println(value.get(i));}
// For checkin Value Arraylist
	
	int c = 2;
	for(int i=0;i<9;i++){
		deck.add(c+" of Clubs");
		c++;
		}
	deck.add("Ace of Clubs");
	deck.add("Jack of Clubs");
	deck.add("Queen of Clubs");
	deck.add("King of Clubs");

	int h = 2;
	for(int i=0;i<9;i++){
		deck.add(h+" of Hearts");
		h++;
		}
	deck.add("Ace of Hearts");
	deck.add("Jack of Hearts");
	deck.add("Queen of Hearts");
	deck.add("King of Hearts");

	int d = 2;
	for(int i=0;i<9;i++){
		deck.add(d+" of Diamonds");
		d++;
		}
	deck.add("Ace of Diamonds");
	deck.add("Jack of Diamonds");
	deck.add("Queen of Diamonds");
	deck.add("King of Diamonds");
	
	int s = 2;
	for(int i=0;i<9;i++){
		deck.add(s+" of Spades");
		s++;
		}
	deck.add("Ace of Spades");
	deck.add("Jack of Spades");
	deck.add("Queen of Spades");
	deck.add("King of Spades");

//	for(int i=0;i<deck.size();i++){
//		System.out.println(deck.get(i));}
// For checking Deck  arrayList

	System.out.println("Welcome to BlackJack!");
	System.out.println("House Rule #1: Ace=11 unless you bust when you draw it, if that's the case Ace=1.");
	System.out.println("House Rule #2: If you draw 21 before the dealer you automatically Win.");
	System.out.println("House Rule #3: Wins are worth 2x your bet but a BlackJack win is worth 3x.");
while(playAgain){
	System.out.println("You have $"+bet+".  How much would you like to bet?");
	int wager = scan.nextInt();
	scan.nextLine();
	bet=bet-wager;	
	
	while(newHand){ 
	Thread.sleep(1000);
	System.out.println("Your two cards are");
	
	Collections.shuffle(shuffle);
	
		
	player = value.get(shuffle.get(card));
	Thread.sleep(1000);
	System.out.println(deck.get(shuffle.get(card)));	
	
	card ++;
	
	Thread.sleep(1000);
	System.out.println(deck.get(shuffle.get(card)));
	player=((player)+(value.get(shuffle.get(card))));
	if(value.get(shuffle.get(card))==11&&player>21){
		player=player-10;
	}
	Thread.sleep(1000);
	System.out.println("You currently have "+player);
	if(player==21){
		break;
	}
	card ++;
	
	dealer=value.get(shuffle.get(card));
	Thread.sleep(1000);
	System.out.println("The Dealer currently has "+deck.get(shuffle.get(card))+" for a total of "+dealer);
	Thread.sleep(1000);
	
	System.out.println("Would you like to Hit (h) or Stand (s)?");
	String hitOrStand = scan.nextLine();
	
	if (hitOrStand.equalsIgnoreCase("h")){
		card++;
		Thread.sleep(1000);
		System.out.println("Your new card is "+deck.get(shuffle.get(card)));
		player=((player)+(value.get(shuffle.get(card))));
        	if(value.get(shuffle.get(card))==11&&player>21){
         	       player=player-10;
       		}
		Thread.sleep(1000);
		if(player==21){
			break;
		}
		System.out.println("Your new total is "+player);
	}
	if(player>21){
		break;
	}
	else{}	
	
	if(hitOrStand.equalsIgnoreCase("h")){
		Thread.sleep(1000);
		System.out.println("Would you like to Hit (h) or Stand (s)?");
		String hitOrStand2 = scan.nextLine();
		
		if (hitOrStand2.equalsIgnoreCase("h")){
			card++;
			Thread.sleep(1000);
			System.out.println("Your new card is "+deck.get(shuffle.get(card)));
        		player=((player)+(value.get(shuffle.get(card))));
        		if(value.get(shuffle.get(card))==11&&player>21){
                		player=player-10;
       			}
			Thread.sleep(1000);
			if(player==21){
				break;
			}		
			System.out.println("Your new total is "+player);
			if(player>21){
				break;
			}
			Thread.sleep(1000);
			System.out.println("Would you like to Hit (h) or Stand (s)?");
			hitOrStand2 = scan.nextLine();
			if (hitOrStand2.equalsIgnoreCase("h")){
				card++;
				Thread.sleep(1000);
				System.out.println("Your new card is "+deck.get(shuffle.get(card)));
        			player=((player)+(value.get(shuffle.get(card))));
        		if(value.get(shuffle.get(card))==11&&player>21){
                		player=player-10;
       			}
			Thread.sleep(1000);
		if(player==21){
			break;
		}	
			System.out.println("Your new total is "+player);
			if(player>21){
				break;
			}
		
			Thread.sleep(1000);
			System.out.println("Would you like to Hit (h) or Stand (s)?");
			hitOrStand2 = scan.nextLine();
			if (hitOrStand2.equalsIgnoreCase("h")){
				card++;
				Thread.sleep(1000);
				System.out.println("Your new card is "+deck.get(shuffle.get(card)));
        			player=((player)+(value.get(shuffle.get(card))));
        		if(value.get(shuffle.get(card))==11&&player>21){
                		player=player-10;
       			}
			Thread.sleep(1000);
			if(player==21){
			break;
		}	
			System.out.println("Your new total is "+player);
			if(player>21){
				break;
			}
		
	
	}
	}
	
}
}
	if(player>21){
		break;
	}
	card++;	
	Thread.sleep(1000);
        System.out.println("The Dealers new card is "+deck.get(shuffle.get(card)));			
	dealer=((dealer)+(value.get(shuffle.get(card))));
	
	Thread.sleep(1000);
	System.out.println("The Dealer now has "+dealer);
	
	while(dealer<17){
		card++;

		Thread.sleep(1000);
        	System.out.println("The Dealers new card is "+deck.get(shuffle.get(card)));
        	dealer=((dealer)+(value.get(shuffle.get(card))));
        		if(value.get(shuffle.get(card))==11&&dealer>21){
                		dealer=dealer-10;
       			}
		Thread.sleep(1000);
       		System.out.println("The Dealer now has "+dealer);

	}
	break;

}
	if(dealer>21){
		Thread.sleep(1000);
		System.out.println("Since the Dealer has "+dealer+" they bust, you Win!");
		bet=bet+(wager*2);
	}
	else if(dealer<=21&&player<=21){
		if(dealer>player){
		Thread.sleep(1000);
		System.out.println("The Dealer Wins!");
		}
		else if(dealer==player){
		Thread.sleep(1000);
			System.out.println("It's a draw!");
		bet=bet+wager;
		}
		else if (player==21){
			Thread.sleep(1000);
			System.out.println("BlackJack! You Win!");
		bet=bet+(wager*3);
		}	
		else{
		Thread.sleep(1000);
			System.out.println("You Win!");
		bet=bet+(wager*2);
		}
	}
	else if(player>21){
		Thread.sleep(1000);
		System.out.println("Since you have "+player+" you bust, The Dealer Wins!");
	}
	System.out.println("You now have $"+bet);
	if (bet<=0){
		System.out.println("You're all out of money.");
	break;
	}
	System.out.println("Would you like to play again? Yes (y), No (n).");
	String replay = scan.nextLine();
	if(replay.equalsIgnoreCase("n")){
		playAgain=false;		
	}
	else{
		playAgain=true;
	}
 
}
System.out.println("Thanks for playing, you finished with $"+bet+"!");
}	
}
