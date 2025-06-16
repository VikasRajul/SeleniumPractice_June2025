package arrayPrograms;

public class FindNumber_InArray {

	public static void main(String[] args) {
		// WAP to find a no. in given Array
		
		int a = 25;
		
		int no[] = { 11,22,89,25,79,36,99};
		System.out.println("Printing integer values ") ;

		
		for(int val : no)
		{
			System.out.print(val+" ");
			
		}
		System.out.println("Finding given no. in  array");
		for(int  value : no) {
			if(value==a)
			{
				System.out.println("Given no. "+a+ " is present in the array.");
			}
		}
		System.out.println("Array values are: ");
		for(int i=0 ; i<no.length; i++)
		{
			System.out.print(no[i]+" ");
		}

	}

}
