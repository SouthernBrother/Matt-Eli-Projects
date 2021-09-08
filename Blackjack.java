import java.util.*;
class Blackjack{
	public static void main(String[]args){
	int dealer;
	int player;
	int card;

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

//	for(int i=0;i<shuffle.size();i++){
//		System.out.println(shuffle.get(i));
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
	System.out.println("Your two cards are");
	
	Collections.shuffle(shuffle);
	card = shuffle.get(0);
	player = value.get(card);
	System.out.println(deck.get(card));	
	card = shuffle.get(1);
	System.out.println(deck.get(card));
	player=((player)+(value.get(card)));
	System.out.println(player);
		
	}
}
