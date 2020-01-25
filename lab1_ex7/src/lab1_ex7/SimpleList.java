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
		headM = null;
		sizeM = 0;
	}
	
	public int size()
	{
		return sizeM;
	}
	
	public void pushBack(int item)
	{
		Node newNode = new Node();
		if(newNode == null)
		{
	        System.out.printf("\nNo memory available to create a node\n");
	        System.exit(1);
		}
		
		newNode.item = item;
		
		if(headM == null)
		{
			newNode.next = headM;
			headM = newNode;
		}
		else
		{
			Node p = headM;
			while(p.next != null)
			{
				p = p.next;
			}
			p.next = newNode;
			newNode.next = null;
		}
		sizeM++;
	}
	
	public void pushFront(int item)
	{
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = headM;
		headM = newNode;
		sizeM++;
	}
	
	public void popBack(int item)
	{
		
	}
	
	public int get(int n)
	{
		if(n < 0 || n >= sizeM)
		{
			System.out.printf("\n Illegal Access. Program Terminates...");
			System.exit(1);
		}
		
		Node p = headM;
		for(int i = 0; i < n; i++)
		{
			p = p.next;
		}		
		return p.item;
	}
	
	public void set(int n, int v)
	{
		if(n < 0 || n >= sizeM)
		{
			System.out.printf("\n Illegal Access. Program Terminates...");
			System.exit(1);
		}	
		
		Node p = headM;
		for(int i = 0; i < n; i++)
		{
			p = p.next;
		}
		
		p.item = v;
		
	}
	
	public void insert(int itemA, int n)
	{
		if(n < 0 || n > sizeM)
		{
			return;
		}
		else if(n == 0)
		{
			pushFront(itemA);
		}
		else if(n == sizeM)
		{
			pushBack(itemA);
		}
		else
		{
			Node newNode = new Node();
			if(newNode == null)
			{
				System.out.println("Sorry memory is unavailable to create a new node.\n");
				return;
			}
			newNode.item = itemA;
			
			Node before = headM;
			Node after = headM.next;
			int i = 1;
			while(i < n)
			{
				before = after;
				after = after.next;
				i++;
			}
			newNode.next = after;
			before.next = newNode;
			sizeM++;
		}
	}
	
	public void remove(int n)
	{
	    if (headM == null || n < 0 || n >= sizeM)
	        return;
	    Node beDeleted;
	    Node before;
	    
	    if(n == 0)
	    {
	        beDeleted = headM;
	        headM = headM.next;
	    }
	    else
	    {
	        before = headM;
	        beDeleted = before.next;
	        
	        int i = 1;
	        while (i < n)
	        {
	            before = beDeleted;
	            beDeleted = before.next;
	            i++;
	        }
	        
	        before.next = beDeleted.next;
	    }
	    sizeM--;
	}
	
	public void clear()
	{
		headM = null;
		sizeM = 0;
	}
	
	public void print()
	{	
		if(headM != null)
		{
			Node p = headM;
			while(p != null)
			{
				System.out.printf("%d  ", p.item);
				p = p.next;
			}
		}		
		
	}
	
	public static void main(String[] args) 
	{
		SimpleList list = new SimpleList();
	    
	    System.out.printf("\nList just after creation -- is empty.");
	    
	    list.pushFront(50);
	    System.out.printf("\nAfter calling push_front. list must have: 50\n");
	    list.print();
	    
	    list.pushBack(440);
	    
	    list.set(0,770);
	    System.out.printf("\nAfter calling push_back and set function list must have: 770  440\n");
	    list.print();
	    
	    list.pushBack(330);
	    list.pushBack(220);
	    list.pushBack(110);
	    
	    System.out.printf("\nAfter three more calls to push_back, list must have: 770, 440, 330, 220, 110\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(2);
	    System.out.printf("\nAfter removing two nodes. list must have: 440, 330, 110\n");
	    list.print();
	    list.insert(40, 3); //insert node with the value of 40 at the 4th position
	    list.insert(20, -1); // do nothing
	    list.insert(30, 30000); // do nothing
	    list.insert(10, 0); //insert node with the value of 10 at the 1st position
	    list.insert(33, 2); // insert node with the value 33 at the 3rd position
	    
	    System.out.printf("\nTwo  more nodes inserted, must have: 10, 440, 33, 330, 110, 40\n");
	    list.print();
	    
	    list.remove(0);
	    list.remove(1);
	    list.remove(2);
	    list.remove(3);
	    list.remove(4);
	    list.remove(5);
	    System.out.printf("\nAfter 6 removes, list must have: 440, 330, 40: \n");
	    list.print();
	    
	    list.clear();
	    System.out.printf("\nAfter call to clear, list must be empty:\n");
	    list.print();
	    
	    list.pushBack(331);
	    list.pushBack(221);
	    list.pushBack(111);
	    
	    System.out.printf("\nAfter three calls to push_back, list must have: 331, 221, 111\n");
	    list.print();
	}

}