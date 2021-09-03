import java.util.*;
class Flip {
        public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int bet = 100;
        int amount = 0;
        String guess;
        int guess1;
	int again=1;
	boolean Continue = true;

        System.out.println("You have $100");
	
	while (again==1 && Continue){
        
        System.out.println("How much Would you like to bet? Please enter an amount.");
                int userInput=scan.nextInt();
		String m=scan.nextLine();
        bet=bet-userInput;

        System.out.println("You now have $"+bet+". Would you like to bet on heads or tails?");

        guess=scan.nextLine();

        if (guess.equalsIgnoreCase("heads")){
                 guess1=1;}
        else {
                 guess1=2;}

	int x = (int)(Math.random()*2)+1;

        if(guess1==x){
                bet=bet+userInput*2;}


        if (x==1){
                System.out.println("Heads");}

        else {
                System.out.println("Tails");}

        if (guess1==x){
                System.out.println("You guessed correct!");}
        else {
                System.out.println("Better luck next time.");}

        System.out.println("You now have $"+bet+". Would you like to go again? (1) for yes (2) for no.");
         again=scan.nextInt();
       	 
	if (bet>0){
		Continue=true;}
	else{
		Continue=false;}
	}
	if (again==2){
	System.out.println("Thank you for playing! You played for "+amount+" rounds and finished with $"+bet+".");}
	else {
	System.out.println("Sorry you're all out of money. Thanks for playing!");}
        }

}
