import java.util.*;
class Pit{
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);

		char[][] field = new char[10][10];
	
		initializeField(field);
		char[][] pitField = fieldWithPits(field);

		int pRow = 9;
		int pCol = 0;

		char dir='o';

		do
		{
			print(field);
			System.out.println("Enter a direction w(up), a(left), s(down), d(right)");
				int count = countPits(pitField,pRow,pCol);
				System.out.println("There are "+count+" pit(s) around you.");
			dir = scan.nextLine().charAt(0);
			if(isValidDirection(pRow,pCol,dir))
			{
				System.out.print("\033[H\033[2J");
				System.out.flush();
				
				pCol=changePlayerCol(pCol,dir);
				pRow=changePlayerRow(pRow,dir);
				field[pRow][pCol]='^';
				pastMoves(field);
				field[pRow][pCol]='^';				
	
				if (fallInPit(pitField,pRow,pCol))
				{
					System.out.println("You fell in a pit");
					changeToX(field,pitField,pRow,pCol);
					pRow=9;
					pCol=0;
					field[pRow][pCol]='^';
				}
				if(pRow==0&&pCol==9)
				{
					System.out.println("Congrats You Win!");
					break;
				}
			}
			else
			{
				System.out.print("\033[H\033[2J");
				System.out.flush();

				System.out.println("invalid direction");
			}
			
		}

		while(dir != 'x');

	}

	static void initializeField(char[][] arr){
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j<arr[i].length; j++)
			{
				arr[i][j]= '=';
			}
		}
		arr[9][0]='^';
	}

	static int countPits(char[][] pitArr, int row, int col){
		int count = 0;
			if(col+1>0&&col+1<9)
			{
				if(pitArr[row][col+1]=='X')
				{
					count++;	
				}
			}
			if(col-1>0&&col-1<9)
			{					if(pitArr[row][col-1]=='X')
				{
					count++;
				}
			}
			if(row+1>0&&row+1<9)
			{
				if(pitArr[row+1][col]=='X')
				{
					count++;
				}
			}
			if(row-1>0&&row-1<9)
			{
				if(pitArr[row-1][col]=='X')
				{
					count++;
				}
			}
		return count;	
	}
	
	static void print(char[][] m){
		for (char[] arr:m)
		{
			for(char elm:arr)
			{
				System.out.print(elm + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static boolean isValidDirection(int row, int col, char dir){
		boolean valid = true;
		switch (dir)
		{
			case 'w':
				row=row-1;
				break;
			case 'a':
				col=col-1;
				break;
			case 's':
				row=row+1;
				break;
			case 'd':
				col=col+1;
				break;
		}
		if (row<0||row>9)
		{
			valid = false;
		}
		if (col<0||col>9)
		{
			valid = false;
		}
		return valid;
	}
	
	static void pastMoves(char[][] arr){
		for(int i = 0; i<arr.length; i++)
		{
			for (int j = 0; j<arr.length; j++)
			{
				if(arr[i][j]=='^')
				{
					arr[i][j]='.';
				}	
			}
		}
	}
	
	static int changePlayerRow(int row, char dir){
		switch (dir)
		{
			case 'w':
				row=row-1;
				break;
			case 's':
				row=row+1;
				break;
			default:
				break;
		}
		return row;
	}

	static int changePlayerCol(int col, char dir){
		switch (dir)
		{
			case 'a':
				col=col-1;
				break;
			case 'd':
				col=col+1;
				break;
			default:
				break;
		}
		return col;
	}
	
	static char[][] fieldWithPits(char[][] arr){
		char [][] pitField = new char [10][10];

		for (int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				pitField[i][j]=arr[i][j];
			}
		}

		createHorizontalPits(pitField,5,4,2);
		createVerticalPits(pitField,3,7,4);
		createDiagnolPits(pitField,0,6,3);
		createVerticalPits(pitField,0,1,6);
		createHorizontalPits(pitField,8,3,5);
	
		return pitField;	

	}
		
	static boolean fallInPit( char[][] pitField,int row, int col){
		boolean fall = false;
		if(pitField[row][col]=='X')
		{
			fall=true;
		}
		return fall;	
	}
		
	static void changeToX(char[][] gameField, char[][] pitField, int row, int col){
		gameField[row][col]=pitField[row][col];	
	}
	
	static void createHorizontalPits(char[][] f, int row, int col, int len){
		for (int i = 0; i < len; i++)
		{
			f[row][col+i]='X';
		}
	}

	static void createVerticalPits(char[][] f, int row, int col, int len){
		for (int i = 0; i < len; i++)
		{
			f[row+i][col]='X';
		}
	}
	static void createDiagnolPits(char[][] f, int row, int col, int len){
		for (int i = 0; i < len; i++)
		{
			f[row+i][col-i]='X';
		}
	}
}
