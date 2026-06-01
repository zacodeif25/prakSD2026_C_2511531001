package pekan8_2511531001;
public class ShellSort_2511531001 {
	public static void ShellSort_2511531001(int [] A) {
		int n_1001 = A.length;
		int gap_1001 = n_1001/2;
		while (gap_1001 >0) {
			for ( int i_1001 = gap_1001 ; i_1001 < n_1001; i_1001++) {
				int temp_1001 = A[i_1001];
				int j_1001 = i_1001;
				while ( j_1001>= gap_1001 && A[j_1001 - gap_1001 ] > temp_1001) {
					A[j_1001]= A[j_1001 - gap_1001];
					j_1001 = j_1001 - gap_1001;
				}
				A[j_1001] = temp_1001;
			}
			gap_1001 = gap_1001/2;
		}
	}
	
	public static void main (String [] args) {
		int [] data_1001 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
		System.out.print("Sebelum : ");
		printArray_2511531001(data_1001);
		
		ShellSort_2511531001(data_1001);
		
		System.out.print("Sesudah (Shell Sort): ");
		printArray_2511531001(data_1001);
	}
	
	public static void printArray_2511531001 (int [] arr) {
		for (int i_1001 : arr) System.out.print(i_1001 + " ");
		System.out.println();
	}
}
