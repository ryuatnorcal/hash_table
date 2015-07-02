package hash_table;

public class Driver {
	public static void main(String args []){
		int table_size = 9;
		int key = 0;
		String[] str = {"something","omg","awesine","donuts","have","eaten","by", "wizerd","and","GECO",
						"resard","has","upset","because","the","donuts","came","from","dounkindonuts", 
						"There","is","no","one","insure","by","GECO's","insurance","because","everyone","has",
						"State","firm","._!SLDo9238490"};
		hashes h = new hashes(table_size);
		
		for(int x=0; x < 33; x++){
			key = h.hash(str[x], table_size);		
			h.insert(str[x],key);
		}
		
		h.printAll();
	}
}
