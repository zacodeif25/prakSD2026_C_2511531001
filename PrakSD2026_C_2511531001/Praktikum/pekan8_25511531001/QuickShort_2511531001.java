package pekan8_25511531001;
public class QuickShort_2511531001 {
	static void swap_1001 (int [] arr_1001, int  i_1001, int j_1001) {
		int temp_1001 = arr_1001 [i_1001];
		arr_1001[i_1001]= arr_1001[j_1001];
		arr_1001[j_1001]= temp_1001;
	}
	
	//metode tambahan untuk mengatur pivot menggunakan median of three
	static void medianOfThree_1001(int[] arr_1001, int low_1001, int high_1001) {
		int mid_1001 = low_1001 + (high_1001 - low_1001)/2;
		
		//urutlan elemen low, mid, high
		if (arr_1001[low_1001] > arr_1001[mid_1001]) {
			swap_1001(arr_1001, low_1001, high_1001);
		}
		
		if (arr_1001[low_1001] > arr_1001[high_1001]) {
			swap_1001(arr_1001, low_1001, high_1001);
		}
		
		if (arr_1001[low_1001] > arr_1001[high_1001]) {
			swap_1001(arr_1001, mid_1001, high_1001);
		}
		swap_1001 (arr_1001, mid_1001, high_1001);
	}
	
	static int partition_1001 (int[] arr_1001, int low_1001, int high_1001) {
		//panggil fungsi medianOfThree sebelum menentukan pivot 
		medianOfThree_1001 (arr_1001, low_1001, high_1001);
		
		int pivot_1001 = arr_1001 [high_1001];
		int i_1001 = (low_1001 -1);
		
		for (int j_1001 = low_1001; j_1001 <= high_1001-1; j_1001++) {
			//jika elemen saat ini lebih kecil dari atau sama dengan pivot
			if (arr_1001[j_1001] < pivot_1001) {
				//increment indeks elemen yang lebih kecil
				i_1001++;
				swap_1001(arr_1001, i_1001, j_1001);
			}
		}
		swap_1001(arr_1001,i_1001+1,high_1001);
		return (i_1001+1);
	}
	
	static void quickSort_2511531001 (int [] arr_1001, int low_1001, int high_1001) {
		if (low_1001 < high_1001) {
			int pi_1001 = partition_1001 (arr_1001, low_1001, high_1001);
			quickSort_2511531001(arr_1001, low_1001, pi_1001-1);
			quickSort_2511531001(arr_1001, pi_1001+ 1, high_1001);
		}
	}
	
	public static void printArr_1001 (int [] arr_1001) {
		for (int i_1001 = 0; i_1001 < arr_1001.length; i_1001++) {
			System.out.print(arr_1001[i_1001]+ " ");
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		int arr_1001 [] = {10, 7, 8, 9, 1, 5};
		int n_1001 = arr_1001.length;
		System.out.print("Data sebelum diurukan: ");
		printArr_1001(arr_1001);
		
		quickSort_2511531001(arr_1001, 0, n_1001 - 1);
		System.out.print("Data Terurut quicksort : ");
		printArr_1001(arr_1001);

	}
}
