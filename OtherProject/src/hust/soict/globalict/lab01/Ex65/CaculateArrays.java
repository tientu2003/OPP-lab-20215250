package hust.soict.globalict.lab01.Ex65;
import java.util.Scanner;

public class CaculateArrays {
	public static void main (String [] args) {
	Scanner keyb = new Scanner(System.in);
	
	System.out.println("Input the number of the elements:");
	
	int n = keyb.nextInt();
	
	int A[] = new int[n];
	int sum = 0;
	System.out.println("Input arrays: ");
	for (int i = 0; i < n; i++)
		{
		A[i] = keyb.nextInt();
		sum += A[i];
		}
	int tmp;
	
	for (int i = 0; i < n - 1; i++)
		for (int j = i+1; j<n;j++) 
			if (A[j] < A[i]) {
			tmp = A[j];
			A[j] = A[i];
			A[i] = tmp;
		}
	System.out.println("Sorted arrays: ");
	for (int i = 0; i < n; i++)
	{
		System.out.printf("%d | ",A[i]);
	}
	System.out.println("\nThe sum: " + sum);
	System.out.println("The average: " +(double)sum/n);
	}
}
