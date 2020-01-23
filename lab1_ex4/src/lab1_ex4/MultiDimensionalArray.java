package lab1_ex4;
import java.util.Scanner;

public class MultiDimensionalArray {

	char[][] sentences = new char[3][60];
	int[] sentenceLength = new int[3];
	
	public void readSentences()
	{
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter first sentence: ");
		String firstSentence = scan.nextLine();
		System.out.printf("Enter second sentence: ");
		String secondSentence = scan.nextLine();
		System.out.printf("Enter third sentence: ");
		String thirdSentence = scan.nextLine();
		scan.close();
		
		sentenceLength[0] = firstSentence.length();
		sentenceLength[1] = secondSentence.length();
		sentenceLength[2] = thirdSentence.length();
		
		for(int i = 0; i < firstSentence.length(); i++)
		{
			sentences[0][i] = firstSentence.charAt(firstSentence.length() - 1 - i);
		}
		
		int wordLength = 1;
		int newSentenceIndex = 0;
		for(int i = secondSentence.length() - 1; i >= 0; i--)
		{
			if(secondSentence.charAt(i) == ' ' || i == 0)
			{
				
				for(int j = 0; j < wordLength-1; j++)
				{
					if(i == 0)
						sentences[1][newSentenceIndex] = secondSentence.charAt(i + j);
					else
						sentences[1][newSentenceIndex] = secondSentence.charAt(i + j + 1);
					newSentenceIndex++;
				}
				sentences[1][newSentenceIndex] = ' ';
				newSentenceIndex++;
				wordLength = 0;
			}
			wordLength++;
		}
		
		for(int i = 0; i < thirdSentence.length(); i++)
		{
			sentences[2][i] = thirdSentence.charAt(i);
			if(i % 5 == 0)
			{
				sentences[2][i] = Character.toUpperCase(sentences[2][i]);
			}
		}
		
		
	}
	
	public void printArray()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < sentenceLength[i]; j++)
			{
				System.out.print(sentences[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		MultiDimensionalArray A = new MultiDimensionalArray();
		
		A.readSentences();
		A.printArray();

	}

}
