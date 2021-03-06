//William Ledingham
//Lab 1 - Exercise 2

public class Marathon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie",
				"Phil", "Matt", "Alex", "Emma", "John", "James", "Jane",
				"Emily", "Daniel", "Neda", "Aaron", "Kate" 
				}; 
		
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243,
				334, 412, 393, 299, 343, 317, 265
				}; 
		
		Marathon M1 = new Marathon();
		
		int fastestIndex = M1.findFastest(times);
		System.out.printf("%s was fastest with a time of %d", names[fastestIndex], times[fastestIndex]);

	}
	
	public int findFastest(int[] times) 
	{
		int fastest = times[0];
		int fastestIndex = 0;
		for(int index = 1; index < times.length; index++)
		{
			if(times[index] < fastest)
			{
				fastest = times[index];
				fastestIndex = index;
			}
		}
		return fastestIndex;
	}

}
