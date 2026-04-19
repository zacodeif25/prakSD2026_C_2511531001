package pekan2_2511531001; // Mendeklarasikan paket tempat kelas ini disimpan untuk organisasi kode.

import java.util.ArrayList; // Mengimpor kelas ArrayList untuk menggunakan struktur data list dinamis.
import java.util.Scanner; // Mengimpor kelas Scanner untuk menangani input dari pengguna.

public class Playlist_2511531001 {
	// Method statis untuk menampilkan pilihan menu playlist kepada pengguna.
	public static void tampilkanMenu_2511531001() {
		System.out.println("\n\n======= Menu PLAYLIST :D, NIM :2511531001 ======");
		System.out.println("1. Tambah Lagu");
		System.out.println("2. Lihat Playlist");
		System.out.println("3. Hapus Lagu");
		System.out.println("4. Keluar");
	}
	
	// Method untuk menambahkan objek Musik baru ke dalam ArrayList menggunakan operasi add.
	public static void tambahLagu_2511531001(ArrayList<Musik_2511531001> list, Scanner zs) {
		System.out.println("\nHalooo, silakan masukkan data lagu kamu yaa");
		System.out.print("Masukkan Judul: ");
		String judul_1001 = zs.nextLine(); // Membaca input string satu baris penuh dari pengguna.
		System.out.print("Masukkan Nama Penyanyi: ");
		String penyanyi_1001 = zs.nextLine();
		System.out.print("Masukkan Durasi (detik): ");
		int durasi_1001 = zs.nextInt(); // nextInt membaca nilai integer dari input pengguna.
		list.add(new Musik_2511531001 (judul_1001,penyanyi_1001,durasi_1001)); // add menyisipkan elemen baru ke akhir ArrayList.
		System.out.print("Data lagu kamu berhasil ditambahkan ! :-)\n");
	}
	
	// Method untuk menampilkan seluruh elemen dalam ArrayList menggunakan enhanced for-loop.
	public static void lihatPlayList_2511531001 (ArrayList<Musik_2511531001> list) {
		if (list.isEmpty()) { // isEmpty memeriksa apakah ArrayList tidak mengandung elemen sama sekali.
			System.out.println("\nyaah, playlist lagu kamu masih kosong nih :[");
			System.out.println("silakan pilih menu \"1\" untuk menambahkan lagu ke playList kamu!");
		} else {
			System.out.println("\nBerikut semua playlist yang kamu punya >O<");
			System.out.println("=============YOUR PLAYLIST================");
			System.out.println("Total Lagu : " + list.size()); // size mengembalikan jumlah elemen dalam ArrayList.
			int nomor= 1;
			for (Musik_2511531001 song : list) { // Enhanced for-loop untuk iterasi otomatis melalui setiap elemen list.
				System.out.println(nomor + "." +song);
				nomor++;
			}
			System.out.print("============================================");
		}
	}
	
	// Method untuk menghapus elemen dari ArrayList berdasarkan indeks yang dipilih pengguna.
	public static void hapusLagu_2511531001(ArrayList<Musik_2511531001> list, Scanner zs) {
		if (list.isEmpty()) {
			System.out.println("\nyaah, playlist lagu kamu masih kosong nih :[");
			System.out.println("silakan pilih menu \"1\" untuk menambahkan lagu terlebih dahulu");
			return; // return menghentikan eksekusi method dan kembali ke pemanggil.
		}
		
		System.out.println("\nSilakan pilih nomor lagu yang ingin dihapus:");
		System.out.println("==============DAFTAR JUDUL LAGU================ ");
		for (int z= 0; z< list.size(); z++) { // Loop for tradisional untuk mengakses elemen berdasarkan indeks.
			System.out.println((z+1) + ". " + list.get(z).judul_1001);} // get mengakses elemen pada indeks tertentu.
		
		System.out.println("================================================");
		System.out.print("Masukkan nomor lagu (1-" + list.size() + "): ");
		
		int indeksHapus_1001;
		if (zs.hasNextInt()) { // hasNextInt memeriksa apakah input berikutnya adalah integer valid.
			indeksHapus_1001 = zs.nextInt();
			zs.nextLine(); // consume newline untuk membersihkan buffer scanner.
		} else {
			zs.nextLine();
			System.out.println("Input Angka Indeks Tidak Valid");
			return;
		}
		
		if (indeksHapus_1001 >= 1 && indeksHapus_1001 <= list.size()) { // Validasi batas indeks agar tidak menyebabkan error.
			 Musik_2511531001 laguDihapus = list.remove(indeksHapus_1001 - 1); // remove menghapus elemen pada indeks dan mengembalikannya.
		        System.out.println("Lagu dengan judul \"" + laguDihapus.judul_1001 + "\" berhasil dihapus!\n");
		    } else {
		        System.out.println("Maaf, nomor " + indeksHapus_1001 + " tidak valid. Silakan pilih antara 1-" + list.size() + "\n");
		}
		
	}
	
	public static void main(String[] args) { // Method main adalah titik entry eksekusi program Java.
		ArrayList<Musik_2511531001> PlayList = new ArrayList<>	(); // Inisialisasi objek ArrayList dengan tipe data generik Musik.
		Scanner scanner = new Scanner (System.in); // Inisialisasi objek Scanner untuk membaca input dari console.
		int choice; // Deklarasi variabel integer untuk menyimpan pilihan menu pengguna.
		
		do { // Loop do-while memastikan blok kode dijalankan minimal satu kali sebelum pengecekan kondisi.
			tampilkanMenu_2511531001();
			System.out.print("\nSilakan Pilih Menu :) : ");
			choice = scanner.nextInt(); // nextInt membaca nilai integer dari input pengguna.
			scanner.nextLine(); //consume newline untuk membersihkan buffer setelah pembacaan integer.
			
			switch (choice) { // Switch-case memilih blok kode yang akan dieksekusi berdasarkan nilai variabel choice.
			case 1 :
			tambahLagu_2511531001(PlayList, scanner);
			break; // break menghentikan fall-through agar case lain tidak ikut dieksekusi.
			case 2:
			lihatPlayList_2511531001(PlayList);
			break;
			case 3:
			hapusLagu_2511531001(PlayList, scanner);
			break;
			case 4:
			System.out.println("\nKamu Keluar dari Program");
			System.out.println("Terima kasih sudah menggunakan program ini :D ");
			break;
			default: // default menangani nilai input yang tidak cocok dengan case manapun.
			System.out.print("Maaf, Pilihan Menu ini tidak tersedia :(");;
			}
		} while (choice !=4); // Kondisi while menentukan apakah loop akan diulang atau dihentikan.
		scanner.close(); // close menutup resource Scanner untuk mencegah kebocoran memori.

	}
}