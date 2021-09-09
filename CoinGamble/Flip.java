import java.util.*;
import java.io.*;
class Flip {
        public static void main(String[] args) throws Exception{
	FileReader file = new FileReader("/home/ecoleman2/Matt-Eli-Projects/CoinGamble/HighScore.dat");
        BufferedReader reader = new BufferedReader(file);
	Scanner scan = new Scanner(System.in);
	String HighScore="";
	String line = reader.readLine();
	File userScore = new File("/home/ecoleman2/Matt-Eli-Projects/CoinGamble/HighScore.dat");
	FileWriter hscore = new FileWriter(userScore);
        BufferedWriter buffw = new BufferedWriter(hscore);
       	//	if (HighScore.equals("")){
	//		buffw.write("Nobody:0");}
	//	else{}
	
	int bet = 100;
        int amount = 0;
        String guess;
        int guess1;
	int again=1;
	boolean Continue = true;
		

	while (line != null){
		HighScore += line;
		line = reader.readLine();
	}
	System.out.println("The current HighScore is "+HighScore);
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
		amount++;
	}
	
	if (again==2){
	System.out.println("Thank you for playing! You played for "+amount+" rounds and finished with $"+bet+".");}
	else {
	System.out.println("Sorry you're all out of money. Thanks for playing!");}
	
//	File userScore = new File("/home/ecoleman2/CoinGamble/HighScore.dat");
//	FileWriter hscore = new FileWriter(userScore);
//	BufferedWriter buffw = new BufferedWriter(hscore);

	if (bet>Integer.parseInt((HighScore.split(":")[1]))){
	System.out.println("Congrats, you earned a new highscore! Please enter your name!");
	scan.nextLine();
	String NewScore=scan.nextLine();
	HighScore=(NewScore+":"+bet);
	buffw.write(HighScore);
	System.out.println("Your highscore has been set!");}

	else {
	buffw.write(HighScore); }

	buffw.close();

	reader.close();
        }

}
