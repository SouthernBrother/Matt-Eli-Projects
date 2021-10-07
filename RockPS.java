import java.util.*;
class RockPS{
	static Scanner scan = new Scanner(System.in);
	static int choice;
	public static void main(String[]args){
		System.out.println("Welcome to Rock, Paper, Scissor!");
		while(true)
		{
			intro();
			if (choice==4)
			{
				break;
			}
			aiChoice();
		}
	}
	
	static void intro(){
		buffer();
		System.out.println("[1] Rock");
		System.out.println("[2] Paper");
		System.out.println("[3] Scissor");
		System.out.println("[4] exit");
		
		choice = scan.nextInt();
		scan.nextLine();

		switch(choice)
		{
		case 1:
			System.out.println("You chose Rock");
			break;
		case 2:
			System.out.println("You chose Paper");
			break;
		case 3:
			System.out.println("You chose Scissor");
			break;
		}
	}

	static void aiChoice(){
		int ai =(int) (Math.random()*3)+1;
		switch(ai)
		{
		case 1:
			buffer();
			System.out.println("AI chose Rock");
			break;
		case 2:
			buffer();
			System.out.println("AI chose Paper");
			break;
		case 3:
			buffer();
			System.out.println("AI chose Scissor");
			break;
		}


		buffer();
		if(choice==ai)
		{
			System.out.println("Draw");
		}		
		else if(choice==1&&ai==2) 
		{
			System.out.println("You lose!");	
		}
		else if(choice==1&&ai==3)
		{	
			System.out.println("You win!");
		}
		else if(choice==2&&ai==1)
		{
			System.out.println("You win!");
		}
		else if(choice==2&&ai==3)
		{
			System.out.println("You lose!");
		}
		else if(choice==3&&ai==1)
		{
			System.out.println("You lose!");
		}
		else if(choice==3&&ai==2)
		{
			System.out.println("You win!");
		}
	}

	static void buffer(){
		for (int i=0;i<1;i++)
		{
			try
			{
				Thread.sleep(1000);
			}	
			catch(Exception e){}
		}
	}	






}
