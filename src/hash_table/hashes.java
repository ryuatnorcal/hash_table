package hash_table;

public class hashes {
	
	node hash_table[];
	
	// constructor
	public hashes(){
		
	}
	
	public hashes(int table_size){
		hash_table = new node[table_size];	
		// declare has nodes 
		for(int i=0; i < table_size; i++ ){
			hash_table[i] = new node();			
		}
	}
	
	public int hash(String str, int table_size){
		int sum = 0;
		// string cannot be null 
		if(str == null){
			return -1;
		}
		else{
			for(int x=0; x < str.length(); x++){
				sum = sum + str.length();
			}
		}
		return sum % table_size;
	}
	
	public void insert(String str, int key){
		// if hash_table[key] does not have any node yet		
		if(hash_table[key] == null){
			hash_table[key] = new node(str);			
		}
		// hash_table[key] has contents
		else{			
			node target = hash_table[key];
			target = target.getTail(target);
			node new_node = new node(target, str);						
		}
	}
	
	public void printAll(){
		node nodes = null;
		for(int i=0; i<hash_table.length; i++){
			nodes = hash_table[i];
			System.out.println("Table # " + i );
			nodes.printLinkedList(hash_table[i]);
		}
	}
	
	public node getTargetLinkedList(int index) {
		node selectedNode = null; 
		selectedNode = hash_table[index];
		return selectedNode; 
	}
	
	public void mergeSort(){		
		node head = null;
		for(int i=0; i < hash_table.length; i++){
			head = hash_table[i];
			if(head.next != null){
			// merging sort has currently problem to sort by one step 
			// it will takes multiple steps to complete its sorting 
				head = node.sortLinkedListByMergeSort(head);
				head = node.sortLinkedListByMergeSort(head);
				head = node.sortLinkedListByMergeSort(head);
				head = node.sortLinkedListByMergeSort(head);
				head = node.sortLinkedListByMergeSort(head);
				hash_table[i] = head;
			}	
		}	
	}
	
	
}
