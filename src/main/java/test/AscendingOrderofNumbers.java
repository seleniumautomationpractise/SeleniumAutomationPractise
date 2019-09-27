package test;

public class AscendingOrderofNumbers 
{
	public static void main(String args[])throws Exception
	{
		int a[] = {27,94,104,1,44,81,53,32,68,16,79};
		
		int temp;
		
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = i+1; j < a.length; j++) 
			{
				if (a[i]>a[j]) 
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				} 
			}
			
			System.out.println("Asc : "+a[i]);
		}
	}
}