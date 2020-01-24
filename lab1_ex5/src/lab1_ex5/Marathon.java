package lab1_ex5;
import java.util.*;

public class Marathon {

	public static void main(String[] args) {
		
		// Define two array lists here to store the names and the running times
		ArrayList<Integer> runningTimes = new ArrayList<Integer>();
		ArrayList<String> names	= new ArrayList<String>();
		Marathon marathon = new Marathon();
		
		// Read user input
		String sin;
		Scanner scan = new Scanner(System.in);
		while (true)
		{
			System.out.println("Please enter the name of the participant");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			// Add the name to your ArrayList
			names.add(sin);
			
			System.out.println("Please enter the running time of the participant");
			sin = scan.nextLine();
			// Add the running time to your array list
			runningTimes.add(Integer.parseInt(sin));
		}
		
		if(runningTimes.size() == 0)
		{
			System.out.printf("No participant and times were entered.");
			return;
		}
		// Call the function findFastestRunner and pass the running times array list to it
		int fastestIndex = marathon.findFastestRunner(runningTimes);
		
		 // Print the name of the fastestrunner to the console
		System.out.printf("%s was fastest with a time of %d", names.get(fastestIndex), runningTimes.get(fastestIndex));

	}
	
	
	public int findFastestRunner(ArrayList<Integer> runningTimes)
	{
		int fastestTime = runningTimes.get(0);
		int fastestIndex = 0;
		for(int i = 1; i < runningTimes.size(); i++)
		{
			if(runningTimes.get(i) < fastestTime)
			{
				fastestTime = runningTimes.get(i);
				fastestIndex = i;
			}
		}
		return fastestIndex;
	}
	

}
