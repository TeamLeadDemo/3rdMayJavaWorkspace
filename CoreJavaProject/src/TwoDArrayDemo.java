
public class TwoDArrayDemo {

	public static void main(String[] args) {
	
		int[][] matrixA = new int[3][2]; // recomended
		
		int[] matrixB[] = new int[3][2];
		
		int matrixC[][] = new int[3][2];
		
		int[][] matrixD = {{1,2,3}, {4,5,6}}; // array initialization
		
		int[] row1 = matrixD[0]; // pulled out the first dimension of a 2D array and stored it in a 1D array
		
		
		for(int i=0; i<matrixA.length; i++) {
			for(int j=0; j<matrixA[i].length; j++) {
				System.out.print(matrixA[i][j] + "\t"); // what is the output?
			}
			System.out.println();
		}
		
		System.out.println("-----------------");
		
		for(int i=0; i<matrixD.length; i++) {
			for(int j=0; j<matrixD[i].length; j++) {
				System.out.print(matrixD[i][j] + "\t"); 
			}
			System.out.println();
		}
	}

}
