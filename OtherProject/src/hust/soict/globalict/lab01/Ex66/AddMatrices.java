package hust.soict.globalict.lab01.Ex66;
public class AddMatrices {
	public static void main(String[] args) {
		int n = 2; // the number of row
		int m = 3; // the number of column
			 
		int a[][]={{1,2,3},{4,5,6}}; 
		int b[][]={{1,1,1},{1,1,1}};
		int c[][]=new int[n][m];
		
		System.out.print("The Result:\n");
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
			    c[i][j] = a[i][j]+b[i][j];
			    System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}
