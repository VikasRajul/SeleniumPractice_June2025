package arrayPrograms;

public class Find_MaximunNumber_inArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int no[] = {11,23,745,99,89,10,626};
		
		//Array value
		System.out.println("Array values are ");
		for(int val : no)
		{
			System.out.print(val+" ");
		}
		
		
		int max = no[0];
		
		for(int val : no) 
		{
			if(val>max)
			{
				max = val;
			}
		}
       System.out.println("\nMaxium no. in an array is "+max);
	}

}
