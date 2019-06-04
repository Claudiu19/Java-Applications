package lab1;

/**
 * This class generates a Magic Square using a number provided as a parameter and prints 
 * the matrix if the parameter is lesser then 10 or the magic constant and the
 * execution time if the number is greater then 10. 
 * 
 *  @author Claudiu
 *  @version 1.0
 * 
 */
public class Lab1Opt {

	//This method is used to print the Magic Square.
	public static void printSquare(int n, long[][] square)
	{
		int i, j;
		for (i=0; i<n; i++){
           for (j=0; j<n; j++)
               System.out.print(square[i][j] + " ");
           System.out.println();
       }
	}
	
	public static void main(String[] args) {
		Lab1Opt b = new Lab1Opt();
		long startTime = System.nanoTime();
		int n=Integer.parseInt(args[0]);
		if(n%2==0 || (int)n!=n)
		{
			System.out.println("Not a valid number...");
		}
		else
		{
			long[][] square = new long[n][n];
			int i=0;
			int j=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					square [i][j] = n * ((i + j + 1 + n / 2) % n) + (i + 2 * j + 1) % n + 1;
				}
			}
			
			
			//Computing the magic constant.
			long magicConst = (long)n * (n * n + 1) / 2;
			System.out.println(magicConst);
			long sum;
			
			//Checking the sum on all the rows.
			for(i=0;i<n;i++) {
				sum=0;
				for(j=0;j<n;j++)
				{
					sum=sum+square[i][j];
				}
				if(sum!=magicConst)
				{
					System.out.println(magicConst + " " + sum);
					System.out.println("Not a Magic Square -> row " + i);
					System.exit(-1);
				}
			}
			
			
			//Checking the sum on all the columns.
			for(j=0;j<n;j++) {
				sum=0;
				for(i=0;i<n;i++)
				{
					sum=sum+square[i][j];
				}
				if(sum!=magicConst)
				{
					System.out.println("Not a Magic Square -> column " + j);
					System.exit(-1);
				}
			}
			
			
			//Checking the sum on the main diagonal.
			sum=0;
			for(i=0;i<n;i++) {
				sum=sum+square[i][i];
			}
			if(sum!=magicConst)
			{
				System.out.println("Not a Magic Square -> main diagonal");
				System.exit(-1);
			}
			
			//Checking the sum on the secondary diagonal.
			sum=0;
			for(i=0;i<n;i++) {
				sum=sum+square[i][n-i-1];
			}
			if(sum!=magicConst)
			{
				System.out.println("Not a Magic Square -> secondary diagonal");
				System.exit(-1);
			}
			
			
			if(n<10)
			{
				//Printing the square
				b.printSquare(n,square);
			}
			else
			{
				//Printing the magic constant and the execution time.
				System.out.println(magicConst);
				long endTime = System.nanoTime();
				System.out.println((float)(endTime-startTime)/1_000_000_000);
			}
		}
		

	}

}
