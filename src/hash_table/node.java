package hash_table;

public class node {
	protected 
		node next; 
		String str; 

	// constructor 
	public node(){		
		next = null;	
		str = null;
	}
	// first node 
	public node(String word){
		next = new node();	
		str = word;
	}
	
	
	// second to end 
	public node(node cur, String str){
		node n = new node();		
		cur.next = n;		
		n.str = str;
		n.next = null;
	}
	
	public void printLinkedList(node head){
		node n =  head;
		while(n != null){
			if(n.str != null){
				System.out.println('\t'+n.str);
			}
			n = n.next;
		}
	}
	
	public node getTail(node cur){		
		while(cur.next != null){
			cur = cur.next;
		}
		return cur;
	}
	
}
