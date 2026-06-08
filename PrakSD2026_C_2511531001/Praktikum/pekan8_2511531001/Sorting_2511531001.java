package pekan8_2511531001;

class Lagu_2511531001 {
	//deklarasi variabel
	String judul_1001;
	String penyanyi_1001;
	int durasi_1001;
	
	// konstruktor
	public Lagu_2511531001 (String j_1001, String p_1001, int d_1001 ) {
		this.judul_1001 = j_1001;
		this.penyanyi_1001 = p_1001;
		this.durasi_1001 = d_1001;
	}
}
	
public class Sorting_2511531001 {
	
	Lagu_2511531001 [] dataLagu_1001;
	int jumlahLagu_1001;
	
	public Sorting_2511531001 () {
		dataLagu_1001 = new Lagu_2511531001 [20]; //array maksimal hanya berisikan 20 data lagu
		jumlahLagu_1001 = 0;
	}
	
	// method mengisi data awal (minimal 7 lagu)
	public void inputData_1001 () {
	    dataLagu_1001 [0] = new Lagu_2511531001("Just The Way You Are", "Bruno Mars", 221);
	    dataLagu_1001 [1] = new Lagu_2511531001("Grenade", "Bruno Mars", 222);
	    dataLagu_1001 [2] = new Lagu_2511531001("Locked Out Of Heaven", "Bruno Mars", 233);
	    dataLagu_1001 [3] = new Lagu_2511531001("When I Was Your Man", "Bruno Mars", 214);
	    dataLagu_1001 [4] = new Lagu_2511531001("Treasure", "Bruno Mars", 178);
	    dataLagu_1001 [5] = new Lagu_2511531001("The Lazy Song", "Bruno Mars", 190);
	    dataLagu_1001 [6] = new Lagu_2511531001("That's What I Like", "Bruno Mars", 208);
	    dataLagu_1001 [7] = new Lagu_2511531001("Versace on the Floor", "Bruno Mars", 261);
	    dataLagu_1001 [8] = new Lagu_2511531001("Marry You", "Bruno Mars", 230);
	    jumlahLagu_1001 = 9;
	}
	
	//method menampilkan data sebelum/sesudah sorting
	public void tampilData_1001() {
		for (int i_1001 = 0; i_1001 < jumlahLagu_1001; i_1001++) {
			System.out.println((i_1001+1) + ". " + dataLagu_1001[i_1001].judul_1001 + "- " + dataLagu_1001[i_1001].durasi_1001 + " detik");
		}
	}
	
	//method utama quick sort (urutan durasi ascending)
	public void quickSort_1001 () {
		quickSort_1001 (dataLagu_1001, 0, jumlahLagu_1001 -1);
	}
	
	// rekursif quick sort
	private void quickSort_1001 (Lagu_2511531001 [] arr_1001, int low_1001, int high_1001) {
		if (low_1001 < high_1001) {
			int pi_1001 = partition_1001 (arr_1001, low_1001, high_1001);
			quickSort_1001(arr_1001, low_1001, pi_1001-1);
			quickSort_1001(arr_1001, pi_1001+ 1, high_1001);
		}
	}
	
	private int partition_1001 (Lagu_2511531001 [] arr_1001, int low_1001, int high_1001) {
		int pivot_1001 = arr_1001[high_1001].durasi_1001;
		int i_1001 = low_1001 - 1;
		for (int j_1001 = low_1001; j_1001 < high_1001 ; j_1001++) {
			if (arr_1001[j_1001].durasi_1001 <= pivot_1001) {
				i_1001++;
				
				Lagu_2511531001 temp_1001 = arr_1001 [i_1001];
				arr_1001 [i_1001] = arr_1001 [j_1001];
				arr_1001 [j_1001] = temp_1001;
			}
		}
		Lagu_2511531001 temp_1001 = arr_1001[i_1001 + 1];
		arr_1001 [i_1001+1] = arr_1001[high_1001];
		arr_1001 [high_1001] = temp_1001;
		return i_1001 + 1;
	}
	
	public static void main (String [] args) {
		Sorting_2511531001 playlist_1001 = new Sorting_2511531001();
		
		System.out.println("=== Sorting Playlist dengan Algoritma Quick Sort ====");
		System.out.print("NIM = 2511531001");
		
		playlist_1001.inputData_1001();
		System.out.println("\nData sebelum Sorting: ");
		playlist_1001.tampilData_1001();
		
		playlist_1001.quickSort_1001();
		
		System.out.println("\n Data Setelah Quick Sort (Durasi Asc): ");
		playlist_1001.tampilData_1001();
	}
	
}
