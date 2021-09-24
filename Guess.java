import java.util.*;
class Guess{
	long start = System.currentTimeMillis();
	int guess;
	int num;
	boolean playAgain=true;
	int choice;
	Scanner scan = new Scanner(System.in);
	public Guess()
	{
		 System.out.println("Welcome to guess check! I will pick a number between 1-1000 and you will try and guess that number. I will tell you if your number is above or below my number.");
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}	
		while(playAgain){
			intro();
			numberChoice();
			guessCheck();
		}
		System.out.println("Thanks for playing!");	
	}

	public static void main(String[]args)
	{
		new Guess();
	}

	public void intro() 
	{
		System.out.println("Please wait while I pick a number");
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("*");
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}		

		System.out.println("*");
		try{
			Thread.sleep(500);
		}	
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("*");
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("*");
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
		e.printStackTrace();
		}

		System.out.println("Okay I have my number! What is your guess?");
	}
	
	public void numberChoice()
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=1;i<=1000;i++)
		{
			numbers.add(i);
		}
		
		Collections.shuffle(numbers);
		num=numbers.get(0);
				
		

	}
	public void guessCheck()
	{
	int count = 0;
	while(true){
		choice=scan.nextInt();
		scan.nextLine();

		guess=choice-num;
		if (guess<0)
		{
			guess=guess*-1;
		}		

		if(choice==num)
		{
			System.out.println("You Guessed the number!");
			break;
		}
		else if (choice>num)
		{
			System.out.println("You are over the number.");
		}
		else if (choice<num)
		{
			System.out.println("You are under the number.");
		}
				
		if(guess>500)
		{
			System.out.println("You are also very far away.");
		}
		else if(guess<500 && guess>250)
		{
			System.out.println("You are also kind of far away");
		}
		else if(guess<250 && guess>100)
		{
			System.out.println("You are also pretty close");
		}
		else if(guess<100 && guess>50)
		{
			System.out.println("You are also very close");
		}
		else if(guess<50)
		{
			System.out.println("You are also VERY VERY close.");
		}
		count++;		
	}
	        	System.out.println("It took you "+count+" attempts.");
			System.out.println("Would you like to play again? Yes [y] or No [n]");
			String input = scan.nextLine();
			if(input.equalsIgnoreCase("y"))
			{
				playAgain=true;
			}
			else
			{
				playAgain=false;
			}
	}
}
