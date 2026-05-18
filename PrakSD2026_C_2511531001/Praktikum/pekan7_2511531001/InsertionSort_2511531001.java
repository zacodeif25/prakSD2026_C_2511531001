package pekan7_2511531001;
public class InsertionSort_2511531001 {
	public static void insertionSort_2511531001 (int[] arr_1001) {
		int n_1001 = arr_1001.length;
		for (int i_1001 = 1; i_1001 < n_1001; i_1001++) {
			int key_1001 = arr_1001 [i_1001];
			int j_1001 = i_1001 - 1;
			while (j_1001 >= 0 && arr_1001 [j_1001] > key_1001) {
				arr_1001 [j_1001 + 1] = arr_1001[j_1001];
				j_1001--;
			}
			arr_1001 [j_1001+1] = key_1001;
		}
	}
	public static void main (String [] args) {
		int arr_1001 [] = {23, 78, 45, 8, 32, 56, 1};
		int n_1001 = arr_1001.length;
		System.out.printf("array yang belum terurut:\n");
		for (int i_1001 = 0; i_1001 < n_1001 ; i_1001++) 
			System.out.print(arr_1001[i_1001] + " ");
		System.out.println("");
		insertionSort_2511531001(arr_1001);
		System.out.printf("array yang terurut:\n");
		for (int i_1001 = 0; i_1001 < n_1001 ; i_1001++)
			System.out.print(arr_1001 [i_1001] + " ");
		System.out.println("");
	}

}
