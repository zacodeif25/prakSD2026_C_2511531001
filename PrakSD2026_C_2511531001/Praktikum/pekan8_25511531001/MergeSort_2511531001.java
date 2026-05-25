package pekan8_25511531001;
public class MergeSort_2511531001 {
	void merge_1001 (int [] arr_1001, int l_1001, int m_1001, int r_1001) {
		// find sizes of two subarrays to be merged
		int n1_1001 = m_1001- l_1001 + 1;
		int n2_1001 = r_1001 - m_1001;
		/* create temp arrays */
		int L_1001 [] = new int [n1_1001];
		int R_1001 [] = new int [n2_1001];
		/*copy data to temp arrays */
		for (int i_1001 = 0; i_1001 < n1_1001; ++i_1001) 
			L_1001[i_1001] = arr_1001[l_1001+i_1001];
		for (int j_1001 = 0; j_1001< n2_1001; ++j_1001)
			R_1001[j_1001] = arr_1001 [m_1001 + 1 + j_1001];
		int i_1001 = 0, j_1001 =0;
		//initial index merged subarray array
		int k_1001 = l_1001;
		while (i_1001 < n1_1001 && j_1001 < n2_1001) {
			if (L_1001[i_1001] <= R_1001[j_1001]) {
				arr_1001[k_1001] = L_1001 [i_1001];
				i_1001++;
			} else {
				arr_1001 [k_1001] = R_1001 [j_1001];
				j_1001++;
			}
			k_1001++;
		}
		
		/* copy remaining elements of L [] if any */
		while (i_1001 < n1_1001) {
			arr_1001 [k_1001] = L_1001[i_1001];
			i_1001++;
			k_1001++;
		}
		/* copy remaining elements of R [] if any */
		while (j_1001 < n2_1001) {
			arr_1001 [k_1001] = R_1001[j_1001];
			j_1001++;
			k_1001++;
		}
	}
	
	void sort_1001 ( int arr_1001[], int l_1001, int r_1001) {
		if (l_1001 < r_1001) {
			//find the middle point
			int m_1001 = (l_1001+r_1001)/2;
			//sort first and second halves
			sort_1001 (arr_1001, l_1001, m_1001);
			sort_1001 (arr_1001, m_1001 + 1 , r_1001);
			//merge the sorted halves
			merge_1001 (arr_1001, l_1001, m_1001, r_1001);
		}
	}
	
	/* a utility function to print array of size n */
	static void printArray_1001 (int arr_1001 []) {
		int n_1001 = arr_1001.length;
		for ( int i_1001 = 0 ; i_1001 < n_1001; ++i_1001)
			System.out.print(arr_1001 [i_1001] + " ");
		System.out.println();
	}
	
	public static void main (String args[]) {
		int arr_1001[] = {12, 11, 13, 5, 6, 7};
		System.out.println("Sebelum terurut: ");
		printArray_1001(arr_1001);
		MergeSort_2511531001 ob_1001 = new MergeSort_2511531001();
		ob_1001.sort_1001(arr_1001, 0, arr_1001.length - 1);
		System.out.println("\nSesudah Terurut menggunakan merge sort");
		printArray_1001(arr_1001);
	}
}


