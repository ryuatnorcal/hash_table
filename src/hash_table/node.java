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
	
	public static void printLinkedList(node head){
		node n =  head;
		while(n != null){
			if(n.str != null){
				System.out.println('\t'+n.str);
			}
			n = n.next;
		}
	}
	
	public static node getTail(node cur){		
		while(cur.next != null){
			cur = cur.next;
		}
		return cur;
	}
	
	public static int getCount(node cur){
		int count = 0;
		
		while(cur.next != null){
			count++;			
			cur = cur.next;
		}
		return count; 		
	}
	public static boolean equalTo(String str1,String str2){
		if(str1 == null){
			return false;
		}
		else if(str2 == null){
			return false;			
		}
		else{
			return str1.equals(str2); 
		}				
	}
	public static boolean smallerThan(String str1, String str2){
		
		// testing purpose, just checking first char 
		if(str1 == null && str2 == null ){
			return false;
		}
		else if(str1 != null && str2== null){
			return false;			
		}
		else if (str1 == null && str2 != null){
			return true;
		}
		else if((int)str1.charAt(0) < (int)str2.charAt(0)){
			return true;			
		}
		else{
			return false;
		}		
	}
	
	// since stack over flow has merge sort is a good option to sort any kind of linkedList 
	// in this practice I use merge sort. 
	// http://stackoverflow.com/questions/7168164/sorting-linked-lists-in-c/7168300#7168300
	public static node sortLinkedListByMergeSort(node head){	
		
		node merged = null;		
		int count = 0;
		if (head == null || head.next == null || head.next.next == null){
			return head; 
		}
		count = getCount(head); 
		// split in half 
		int mid = count / 2;
		node left = head;
		node right = null;
		node temp = head; 		
		int countMid = 0;
		while(temp != null){
			countMid++;
			node next = temp.next;
			if(countMid == mid){
				temp.next = null; 
				right = next; 
			}
			temp = next; 
		}
		node leftSide = sortLinkedListByMergeSort(left);
		node rightSide = sortLinkedListByMergeSort(right);
		merged = merge(leftSide, rightSide); 
		return merged; 
		
	}
	
	public static node merge(node left, node right){
		node leftSide = left;
		node rightSide = right;
		node mockHead = new node("mock");
		node linkedList = mockHead;
		// both left and right side are not at the end 
		while(leftSide != null || rightSide != null ){
			// [ bottom case ]
			// left side is null, insert right side and increment rightSide and linkedList
			if(leftSide == null){
				linkedList.next = new node(rightSide.str);
				rightSide = rightSide.next;
				linkedList = linkedList.next;				
			}
			// right side is null, insert left side and increment leftSide and linkedList  
			else if (rightSide == null){
				linkedList.next = new node(leftSide.str);
				leftSide = leftSide.next;
				linkedList = linkedList.next;								
			}
			// [non bottom case]
			else{
				// left side is smaller than right side
				// Insert smaller string in the linked list 

				if(smallerThan(leftSide.str,rightSide.str)){
					linkedList.next = new node(leftSide.str);
					leftSide = leftSide.next;
					linkedList = linkedList.next;					
				}
				// left side and right side are the same 
				// insert both in linked list				
				else if(equalTo(leftSide.str, rightSide.str)){
					linkedList.next = new node(leftSide.str);
					linkedList = linkedList.next;
					linkedList.next = new node(rightSide.str);
					linkedList = linkedList.next;
					leftSide = leftSide.next;
					rightSide = rightSide.next;
				}
				// left side is bigger than right side 
				// insert smaller right side in the linkedList 
				else{
					linkedList.next = new node(rightSide.str);
					rightSide = rightSide.next; 
					linkedList = linkedList.next;
				}				
			}
		}			
		return mockHead.next;
	}
	
	
	
}
