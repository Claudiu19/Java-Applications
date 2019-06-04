package lab1;
/**
 * This class prints on the console the phrase "Hello World!", generate a number that is smaller then 1,000,000, computing it according
 * to exercise 4, then computing the sum of digits until the sum is smaller then 10, 
 * then printing the following: ""Willy-nilly, this semester I will learn " + languages[dump]. 
 * 
 *  @author Claudiu
 *  @version 1.0
 * 
 */
public class Lab1Obl {
	
	public int compute() {
		int n = (int) (Math.random() * 1_000_000);
		n=6*(n*3+0b10101+0xFF);
		return n;
	}
	
	public int findLanguage(int n)
	{
		int dump=0;
		while(n>9)
		{
			while(n>0)
			{
				dump=dump+n%10;
				n=n/10;
			}
			n=dump;
			dump=0;
		}
		return n;
	}
	
	public static void main(String[] args) {
		Lab1Obl a = new Lab1Obl();
		System.out.println("Hello World!");
		String languages[] = {"C", "C++", "C#", "Go", "Javascript","Perl","PHP","Python","Swift","Java"};
		int n = a.compute();
		int dump=a.findLanguage(n);
		System.out.println(n);
		System.out.println("Willy-nilly, this semester I will learn " + languages[dump] + "!");
	}

}
