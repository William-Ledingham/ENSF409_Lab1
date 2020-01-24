//William Ledingham
//Lab 1 - Exercise 1s

package lab1_ex1;

public class Exercise_1 {

	public static void main(String[] args) {
		
		double argsLength = args.length;
		double sum = 0;
		for(int i = 0; i < argsLength; i++)
		{
			sum += Double.parseDouble(args[i]);
		}
		System.out.printf("The average of the arguments: %10.3f\n", sum/argsLength);

	}
}
