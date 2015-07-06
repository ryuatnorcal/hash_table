package hash_table;

public class Driver {
	public static void main(String args []){
		String PROMPT = "\n=== MEARGE SORT ===";
		String PROMPT1 = "\n=== HASH TABLE EXAMPLE ==="; 
		String PROMPT2 = "\n=== BINARY SEARCH TREE (INSERT) ===";
		String PROMPT3 = "\n=== Pre-Order Traversal ===";
		String PROMPT4 = "\n=== In-Order Traversal ===";
		String PROMPT5 = "\n=== Post-Order Traversal ===";
		String PROMPT6 = "\n=== SEARCH A WORD ===";
		String PROMPT7 = "\n=== DELETION ===";
		int table_size = 12;
		int key = 0;
		String[] str = {"something","omg","awesine","donuts","have","eaten","by", "wizerd","and","GECO",
						"resard","has","upset","because","the","donuts","came","from","dounkindonuts", 
						"There","is","no","one","insure","by","GECO's","insurance","because","everyone","has",
						"State","firm","._!SLDo9238490"};
		String[] search = {"something","Ope","java","omg","c++","awesine","donuts","redbull","the",
						"donuts","came","google","._!SLDo9238490","yahoo"};
		String[] deletion = {"because","has","GECO","omg","c++","awesine","donuts"};
		int mid = str.length / 2;
		System.out.println(PROMPT1);	
		/***************************************** 
		 *  create hash table 
		 * ***************************************/
		hashes h = new hashes(table_size);
		
		for(int x=0; x < 33; x++){
			key = h.hash(str[x], table_size);		
			h.insert(str[x],key);
		}
		
		h.printAll();
		/****************************************** 
		 *  Sort hash table by merge sort 
		 * ***************************************/
		System.out.println(PROMPT);
		h.mergeSort();
		h.printAll();
		
		/****************************************** 
		 *  insert nodes in binary search tree 
		 * ***************************************/
		System.out.println(PROMPT2);
		String midStr = str[mid];
		binaryTree b = new binaryTree(midStr);
		for(int i =0; i< 33; i++){
			b.insert(str[i]);
		}
				
		System.out.println(PROMPT3);
		b.printPreOrderTraversal();
		
		System.out.println(PROMPT4);
		b.printInOrderTraversal();
		
		System.out.println(PROMPT5);
		b.printPostOrderTraversal();
		
		System.out.println(PROMPT6);
		boolean consequence = false;
		for(int i=0; i< 13; i++){
			consequence = b.binarySearch(b,search[i]);
			System.out.println("Searching For "+ search[i]+"\t:\t"+consequence);	
		}
		
		/****************************************** 
		 *  deletion nodes in binary search tree 
		 * ***************************************/
		System.out.println(PROMPT7);
		for(int i = 0; i< 7; i++ ){
			b = b.delete(deletion[i]);
			System.out.println("=== Deleting For \" "+ deletion[i]+ "\" ===");
			b.printInOrderTraversal();
		}
		
	}		
}
