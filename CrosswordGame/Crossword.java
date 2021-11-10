import java.util.*;
import java.io.*;
class Crossword{
	public static void main(String[]args){
		File f = null;
		Scanner input = null;
				

		try
		{
			f = new File(args[0]);
			input = new Scanner(f);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println("Please enter puzzle file name.");
			return;
		}
		
		input.useDelimiter(":|\n");

		String title = input.nextLine();
		char [][] board = new char [input.nextInt()][input.nextInt()];

		int numDown = input.nextInt();
		int numAcc = input.nextInt();	

		String [][] down = new String [numDown][3];
		String [][] across = new String [numAcc][3];
		
		input.next();
		for(int i = 0; i < numDown; i++)
		{
			int j=0;
			for  (j = 0; j<3; j++)
			{
				down[i][j]=input.next();		
			}
				
		}

		input.next();
                for(int i = 0; i < numAcc; i++)
                {
                        int j=0;
                        for  (j = 0; j<3; j++)
                        {
                                across[i][j]=input.next();
                        }

                }

		initializeBoard(board);
		for(int i = 0;i<down.length;i++ )
		{
			int j=0;
			insertWordDown(board,Integer.parseInt(down[i][j]),down[i][j+2].length());
		}

		for(int i = 0;i<across.length;i++ )
                {
                        int j=0;
                        insertWordAcross(board,Integer.parseInt(across[i][j]),across[i][j+2].length());
                }

		
		playGame(board,down,across);
	}

	static void playGame(char[][] c,String[][] down,String[][] across){
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> correctWords = new ArrayList<String>();
		while(true)
		{
			printBoard(c);
			System.out.println("Please enter a word. For a hint enter Across [a] or Down [d]");
			String input = scan.nextLine();			
		
			Random rand = new Random();
			int num = 0+rand.nextInt(across.length);

			int num2 = 0+rand.nextInt(down.length);	
	
			if (checkIfGuessed(correctWords,input)==false)
			{	
				if (input.equalsIgnoreCase("a"))
				{
					System.out.println("Number of letters: "+(across[num][2].length()));
					System.out.println("Hint: "+across[num][1]);		
				}
				else if (input.equalsIgnoreCase("d"))
				{
					System.out.println("Number of letters: "+(down[num2][2].length()));
					System.out.println("Hint: "+down[num2][1]);		
					
				}
				else
				{
					for (int i = 0;i<across.length;i++)
					{
						if (input.equalsIgnoreCase(across[i][2]))
						{
							insertCorrectAcross(c,Integer.parseInt(across[i][0]),input);		
							correctWords.add(input);	
						}
					}
					for (int z = 0;z<down.length;z++)
					{
						if (input.equalsIgnoreCase(down[z][2]))
						{
							insertCorrectDown(c,Integer.parseInt(down[z][0]),input);
							correctWords.add(input);																			
						}
					}
				}
			}
			else if (checkIfGuessed(correctWords,input)==true)
			{
				System.out.println("You already guessed that word.");
			}
			if(correctWords.size()==(down.length+across.length))
			{
				printBoard(c);
				break;
			}		
		}
		System.out.println("Congrats you solved the puzzle!");
	}

	static void insertWordDown(char[][] c, int start, int len){
		int blength = c[0].length;		

		int row = (start-1)/blength;
		int col = (start-1)%blength;	
	
		for (int i = 0; i<len; i++)
		{
			c[row][col]='\u25A1';
			row++;
						
		}
	}

	static void insertCorrectDown(char[][] c, int start,String word){
		int blength = c[0].length;		

		int row = (start-1)/blength;
		int col = (start-1)%blength;	
	
        	char[] wordArr = word.toCharArray();
        
		for (int i = 0; i<wordArr.length; i++)
		{
			c[row][col]=wordArr[i];
			row++;
						
		}
	}


	static void insertWordAcross(char[][] c, int start, int len){
		int blength = c[0].length;

                int row = (start-1)/blength;
                int col = (start-1)%blength;

                for (int i = 0; i<len; i++)
                {
                        c[row][col]='\u25A1';
                        col++;

                }

	}
	static void insertCorrectAcross(char[][] c, int start, String word){
		int blength = c[0].length;

                int row = (start-1)/blength;
                int col = (start-1)%blength;

        	char[] wordArr = word.toCharArray();        
		
		for (int i = 0; i<wordArr.length; i++)
                {
                        c[row][col]=wordArr[i];
                        col++;

                }

	}
	
	static void initializeBoard(char [][] c){
		for (int i = 0; i < c.length; i++)
		{
			for (int j = 0; j < c[i].length; j++)
			{
				c[i][j] = '\u25a0';
			}
		}
	}
	
	static void printBoard(char [][] c){
		for (char[] arr:c)
		{
			for(char elm:arr)
			{
				System.out.print(elm + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static boolean checkIfGuessed(ArrayList<String> guessedWords, String input){
		boolean check = false;

		for(int i = 0; i<guessedWords.size();i++)
		{
			if(guessedWords.get(i).equalsIgnoreCase(input))
			{
				check = true;
			}
		}
		return check;
	}

	static void print(String [][] s){
                for (String[] arr:s)
                {
                        for(String elm:arr)
                        {
                                System.out.print(elm + ":");
                        }
                        System.out.println();
                }
                System.out.println();
        }

}	
