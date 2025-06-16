package arrayPrograms;

public class Find_MinimumNumber_inArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int no[] = {11,23,745,99,89,10,626};
		
		//Array value
		System.out.println("Array values are ");
		for(int val : no)
		{
			System.out.print(val+" ");
		}
		
		
		int min = no[0];
		
		for(int val : no) 
		{
			if(val<min)
			{
				min = val;
			}
		}
       System.out.println("\nMinimum no. in an array is "+min);


	}

}
