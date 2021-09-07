import java.util.*;
class Blackjack{
	public static void main(String[]args){



	deckOfCards();
	}	


	

	public static void deckOfCards(){
	ArrayList<String> deck = new ArrayList<String>();

	int c = 2;
	for(int i=0;i<9;i++){
		deck.add(c+" of Clubs");
		c++;
		}
	for(int i=0;i<9;i++){
               System.out.println(deck.get(i));
	}

	int h = 2;
	for(int i=0;i<9;i++){
		deck.add(h+" of Hearts");
		h++;
		}
	for(int i=9;i<18;i++){
               System.out.println(deck.get(i));
	}
	int d = 2;
	for(int i=0;i<9;i++){
		deck.add(d+" of Diamonds");
		d++;
		}
	for(int i=18;i<27;i++){
               System.out.println(deck.get(i));
	}
	int s = 2;
	for(int i=0;i<9;i++){
		deck.add(s+" of Spades");
		s++;
		}
	for(int i=27;i<36;i++){
               System.out.println(deck.get(i));
	}
	}
}
