package lab1_ex7;

public class SimpleList {

	private class Node {
		int item;
		Node next;
	}
	
	private Node headM;
	private int sizeM;
	
	
	public SimpleList() 
	{
		headM = new Node();
		sizeM = 0;
	}
	
	
	public int size()
	{
		return sizeM;
	}
	
	public void push_back(int item)
	{
		
	}
	
	public void push_front(int item)
	{
		
	}
	
	public void pop_back(int item)
	{
		
	}
	
	public int get(int n)
	{
		if(n < 0 || n >= sizeM)
		{
			System.out.printf("\n Illegal Access. Program Terminates...");
			System.exit(1);
		}
	}
	
	public void set(int i, int v)
	{
		
	}
	
	public void insert(int theItem, int n)
	{
		
	}
	
	public void remove(int n)
	{
		
	}
	
	public void clear()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}