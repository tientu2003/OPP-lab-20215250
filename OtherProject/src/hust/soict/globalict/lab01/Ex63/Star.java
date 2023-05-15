package hust.soict.globalict.lab01.Ex63;
import java.util.Scanner;
public class Star {
	public static void main (String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input n: ");
		
		int n = keyboard.nextInt();
		int i,j;
		String space;
		String star;
		for (i  = 1; i <= n; i++)
		{
			space = "";
			for (j = 1; j <= (n-i); j++) {
			space =  space + " "; 
			}
			star = "";
			for (j = 1; j <= 2*i - 1; j ++) {
			star =  star + "*";
			}
			System.out.println(space + star);
			
		}
	}
}
