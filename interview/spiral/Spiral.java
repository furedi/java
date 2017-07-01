/**
 * Let us display a n*m matrix in a spiral order starting from the upper left corner.
 * 
 * Járjunk be egy n*m-es mátrixot spirál alakban a bal felső sarokból indulva.
 * 
 * @author John
 * @version 0.2
 * @date 2017.06.25
 * 
 */
// package spiral;

public class Spiral {
	// === MAIN method ===
	public static void main(String[] args) {
		// --- Create the test matrix!
		int line=(args.length > 0)?Integer.parseInt(args[0]):3;
		int column=(args.length > 1)?Integer.parseInt(args[1]):4;
		
		int[][] matrix = new int[line][column];
		fillMatrix(matrix,line,column);
		
		System.out.println("Let us display a n*m matrix in a spiral order starting from the upper left corner.");
		
		// --- Print test matrix!
		System.out.println("Test matrix:");
		listDefault(matrix,line,column);
		
		// *** List matrix elements in spiral order ***
		System.out.println("Elements in spiral order:");
		SpiralWay spWay = new SpiralWay();
		System.out.println(spWay.getSpiralList(matrix.clone()));
	}
	
	// === List the matrix in line order! 
	public static void listDefault(int[][] mx, int n, int m){
		int i=0;
		while(i<n){
			int j=0;
			while (j<m) {
				System.out.printf("%3d ",mx[i][j]);
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println();
	}
	
	// === Fill the test matrix with number!
	public static void fillMatrix(int[][] mx,int n,int m){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mx[i][j]=1+j+i*m;
			}
		}
	}
}
