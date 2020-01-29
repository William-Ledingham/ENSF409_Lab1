package lab1_ex3;
import java.util.Scanner;

/**
 * ENSF 409 Lab 1 Exercise 3
 * 
 * @author William Ledingham
 * @since 2020-01-28
 */
public class SinValidator {

private int[] SIN;

private int sumDigit(int x)
{
	int result =0;
	
	while(x > 0){
		result += x % 10;
		x = x /10;
	}
	
	return result;
}

	public SinValidator(String sin) {

		SIN = new int[9];
		int i =0;
		int counter =0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	public boolean validateSin()
	{
		
		int step1 = SIN[0] + SIN[2] + SIN[4] + SIN[6];
		int step2  = ((SIN[1]*2) / 10) + ((SIN[1]*2) % 10);
		int step3a = ((SIN[3]*2) / 10) + ((SIN[3]*2) % 10);
		int step3b = ((SIN[5]*2) / 10) + ((SIN[5]*2) % 10);
		int step3c = ((SIN[7]*2) / 10) + ((SIN[7]*2) % 10);
		int step4 = step2 + step3a + step3b + step3c;
		int step5 = step4 + step1;
		int step6 = 10 - (step5 % 10);

		if(step6 == SIN[8])
		{
			return true;
		}      
		return false;
		
	}

	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your 10 digit social insurance number"
					+ " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");
			
		}
	}

}

