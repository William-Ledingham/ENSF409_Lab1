package lab1_ex7;


/**
 * Implementation of a simple linked list.
 * 
 * Has functionality to get, set, add, and remove any node.
 * 
 * @author William Ledingham
 * @version 1.0
 * @since 2020-01-27
 *
 */
public class SimpleList {

	/**
	 * Node of a linked list.
	 * Holds an integer item and the next Node. 
	 * @author William Ledingham
	 * @version 1.0
	 * @since 2020-01-27
	 */
	private class Node {
		/**
		 * Integer item of the node.
		 */
		int item;
		/**
		 * Node object that is next in the linked list.
		 */
		Node next;
	}
	
	/**
	 * Node at the start of the linked list. 
	 */
	private Node headM;
	/**
	 * Number of nodes in the linked list.
	 */
	private int sizeM;
	
	/**
	 * Constructs an empty linked list with no nodes.
	 * 
	 * headM = null; sizeM = 0;
	 */
	public SimpleList() 
	{
		headM = null;
		sizeM = 0;
	}
	
	/**
	 * Returns the number of nodes in the linked list.
	 * 
	 * @return Number of nodes.
	 */
	public int getSize()
	{
		return sizeM;
	}
	
	/**
	 * Inserts a new node at the end of the linked list. 
	 * @param item the new node's item value.
	 */
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
	
	/**
	 * Inserts a new node at the start of the linked list. 
	 * @param item the new node's item value.
	 */
	public void pushFront(int item)
	{
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = headM;
		headM = newNode;
		sizeM++;
	}
	
	/**
	 * Returns the item value at the specified node. 
	 * @param n the index of the node.
	 * @return item of the nth node.
	 */
	public int getNode(int n)
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
	
	/**
	 * Sets the item value at the specified node. 
	 * @param n the index of the node.
	 * @param v the item value to be change to.
	 */
	public void setNode(int n, int v)
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
	
	/**
	 * Inserts a new node at any specified position in the linked list. 
	 * @param itemA the new item value.
	 * @param n the index of the new node to be inserted.
	 */
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
	
	/**
	 * Removes the node at a specified index. 
	 * @param n the index of the specified node. 
	 */
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
	/**
	 * Removes all nodes from linked list and sets size to zero. 
	 */
	public void clear()
	{
		headM = null;
		sizeM = 0;
	}
	
	/**
	 * Prints all of the item values in the linked list.
	 * Does so in increasing index position.
	 */
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
	
	/**
	 * Main function of program.
	 * Runs through testing the of the linked list class.
	 * @param args default
	 */
	public static void main(String[] args) 
	{
		SimpleList list = new SimpleList();
	    
	    System.out.printf("\nList just after creation -- is empty.");
	    
	    list.pushFront(50);
	    System.out.printf("\nAfter calling push_front. list must have: 50\n");
	    list.print();
	    
	    list.pushBack(440);
	    
	    list.setNode(0,770);
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