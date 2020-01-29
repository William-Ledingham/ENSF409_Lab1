package lab1_ex6;

/**
 * ENSF 409 Lab 1 Exercise 6
 * 
 * @author William Ledingham
 * @since 2020-01-28
 *
 */
public class Clock {

	private int day, hour, minute, second;

	
	public Clock(int day, int hour, int minute, int second)
	{
		this.day = day;
		
		if(hour >= 0 && hour <= 23)
			this.hour = hour;
		else
			this.hour = 0;
		
		if(minute >= 0 && minute <= 59)
			this.minute = minute;
		else
			this.minute = 0;
		
		if(second >= 0 && second <= 59)
			this.second = second;
		else
			this.second = 0;
	}
	
	public Clock()
	{
		this(0,0,0,0);
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) 
	{
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) 
	{
		if(hour >= 0 && hour <= 23)
			this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) 
	{
		if(minute >= 0 && minute <= 59)
			this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second)
	{
		if(second >= 0 && second <= 59)
			this.second = second;
	}
	
	
	public void increment(int secondIncrement)
	{
		second += secondIncrement;
		if(second / 60 != 0)
		{
			minute += second / 60;
			second = second % 60;
			
			if(minute / 60 != 0)
			{
				hour += minute / 60;
				minute = minute % 60;
				
				if(hour / 24 != 0)
				{
					day += hour / 24;
					hour = hour % 24;
				}
			}
		}
	}
	
	public int calculateTotalSeconds()
	{
		return second + (minute * 60) + (hour * 60 * 60) + (day * 24 * 60 * 60);
	}
	
	public static void main(String[] args) 
	{
		// Create elapsed time with the default values of zeros for day, hour,
		// minute and second.
		Clock t1 = new Clock(); // Default constructor
		// sets hour to 23
		t1.setHour(23);
		// sets day to 1
		t1.setDay(1);
		// sets minute to 59
		t1.setMinute(59);
		// sets day to 16
		t1.setSecond(16);
		// prints: 1:23:59:16
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
		// increments time t1 by 44 seconds:
		t1.increment(44);
		// prints: 2:0:0:0
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
		// prints the total elapsed time in seconds: 172,800
		System.out.printf("The elapsed time in seconds is: %d\n", t1.calculateTotalSeconds());
		
		System.out.println("Test t2:");
		// REPEAT SIMILAR TESTS FOR t2
		 //Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
		Clock t2 = new Clock(3, 1, 4, 5);
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
		t2.increment(60+55+1);
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" +t2.getMinute() + ":" + t2.getSecond());
		System.out.printf("The elapsed time in seconds is: %d", t2.calculateTotalSeconds());

		
	}
}
