package hash_table;

public class binaryTree {
	private 
		String str; 
		binaryTree left;
		binaryTree right; 
		
	public binaryTree(){
		this.str = null;
		this.left = null;
		this.right = null;
	}
	public binaryTree(String str){
		this.str = str;
		this.left = null;
		this.right = null;
	}
	
	// this version of binary tree will only check first char of strings 
	public void insert(String newStr){
		
		// if current char is smaller, it goes to left 
		if(smallerString(newStr, str )){
			if(left != null ){
				left.insert(newStr);				
			}
			else{
				left = new binaryTree(newStr);
			}
		}
		// if current char is bigger, it goes to right
		else{
			if(right != null ){
				right.insert(newStr);
			}
			else{
				right = new binaryTree(newStr);
			}
		}
	}
	public boolean smallerString(String str1, String str2 ){		
		int length = 0;
		if (str1.length() < str2.length()){
			length = str1.length();
		}
		else{
			length = str2.length();
		}
		for(int i = 0; i< length; i++){
			if((int) str1.charAt(i) > (int) str2.charAt(i)){					
				return false;
			}
		}
		return true;
	}
	
	// searching string
	public boolean binarySearch(binaryTree root, String searchStr){
		
		if(root == null){
			return false;
		}
		
		else if(searchStr.equals(root.str)){
			return true;
		}
		else if(smallerString(searchStr,root.str)){
			if(root.left != null){
				return binarySearch(root.left, searchStr);
			}
		}
		else{
			if(root.right != null){
				return binarySearch(root.right, searchStr);
			}
		}
		return false;
	}
	
	public void printPreOrderTraversal(){
		System.out.println(str);
		if(left != null ){
			left.printPreOrderTraversal();
		}
		if( right != null){
			right.printPreOrderTraversal();
		}
	}
	
	public void printInOrderTraversal(){
		if(left != null){
			left.printInOrderTraversal();
		}
		System.out.println(str);
		if(right != null){
			right.printInOrderTraversal();
		}
	}
	
	public void printPostOrderTraversal(){
		if(left != null){
			left.printPostOrderTraversal();
		}
		if(right != null){
			right.printPostOrderTraversal();
		}
		System.out.println(str);
	}
	
	
}
