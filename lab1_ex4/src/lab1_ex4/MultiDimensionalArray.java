package lab1_ex4;
import java.util.Scanner;

public class MultiDimensionalArray {

	char[][] sentences = new char[3][60];
	
	public void readSentences()
	{
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter first sentence: ");
		String firstSentence = scan.nextLine();
		System.out.printf("Enter second sentence: ");
		String secondSentence = scan.nextLine();
		System.out.printf("Enter third sentence: ");
		String thirdSentence = scan.nextLine();
		
		for(int i = 0; i < firstSentence.length(); i++)
		{
			sentences[0][i] = firstSentence.charAt(firstSentence.length() - 1 - i);
		}
		
		for(int i = secondSentence.length() - 1; i >= 0; i--)
		{
			if(secondSentence.charAt(i) == ' ')
			{
				int j = 0;
				while(secondSentence.charAt(i + 1) != ' ' || i + 1 > secondSentence.length() - 1 )
				{
					sentences[1][j] = secondSentence.charAt(i + 1);
					j++;
				}
				sentences[1][j] = ' ';
			}
		}
		
		for(int i = 0; i < thirdSentence.length(); i++)
		{
			sentences[2][i] = thirdSentence.charAt(i);
			if(thirdSentence.charAt(i) % 5 == 0)
			{
				sentences[2][i] = Character.toUpperCase(sentences[2][i]);
			}
		}
		
		
	}
	
	public void printArray()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 60; j++)
			{
				System.out.println(sentences[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		MultiDimensionalArray A = new MultiDimensionalArray();
		
		A.readSentences();
		A.printArray();

	}

}
