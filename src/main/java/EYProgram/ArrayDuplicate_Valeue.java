package EYProgram;

import java.util.HashMap;
import java.util.Map;

public class ArrayDuplicate_Valeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strArr = {"ABC", "DEF", "PQR", "ABC", "DEF", "ABC"};		
	
		//Declare a map with String and Integer 
		Map<String , Integer> hashmap = new HashMap<String, Integer>();
		
		//put all value to hashmap. getOrDefault method return the value of each String and if its not found sets to zero. Then we are adding it by 1.
		for(String val : strArr ) {
			hashmap.put(val, hashmap.getOrDefault(val, 0) +1);
			
		}
		
		//The entrySet() method returns a set of all the key-value pairs as Map.Entry objects.
        //Using Map.Entry<K, V> allows you to extract the key and value in each iteration with entry.getKey() and entry.getValue() respectively.
		for(Map.Entry<String, Integer> entry : hashmap.entrySet()) {
			System.out.println(entry.getKey() + " : " +entry.getValue());
		}
		

	}

}
