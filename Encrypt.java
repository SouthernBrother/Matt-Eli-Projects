import java.util.*;
class Encrypt{
	static Scanner scan = new Scanner(System.in);
	public static void main(String[]args){
		System.out.println("Please enter the password.");
		String pass = scan.nextLine();
		if(pass.equals("matt&eli"))
		{
			options();
		}
		else
		{	
			System.out.println("Wrong password entered");
		}
	}

	static void options(){
		while (true)
		{
			System.out.println("[1] Encrypt");
			System.out.println("[2] Decrpyt");
			System.out.println("[3] Exit");

			int opt = scan.nextInt();
			scan.nextLine();

			switch (opt)
			{
			case 1:
				System.out.println("Enter message to be encrypted");
				String enc = scan.nextLine();
				String newEnc = encrypt(enc);
				System.out.println("Encrypted Message:");
				System.out.println(newEnc);
				break;
			case 2:
				System.out.println("Enter message to be decrypted");
				String dec = scan.nextLine();
				String newDec = de(dec);
				System.out.println("Decrypted Message:");
				System.out.println(newDec);
				break;					
			}
			
			if(opt==3)
			{
				break;
			}	
		}	
	}
	
	static String encrypt(String s){
		String encode = Base64.getEncoder().encodeToString(s.getBytes());
		return encode;
	}

	static String de(String s){
		byte[] decodedBytes = Base64.getDecoder().decode(s);
		String decode = new String(decodedBytes);
		
		return decode;
	}



}
