package pekan3_2511531001;

import java.util.Scanner; // Mengimpor kelas Scanner untuk menangani input dari pengguna.
import java.util.Stack; // Mengimpor kelas Stack untuk menggunakan struktur data tumpukan.

public class Browser_2511531001 {
	// Method statis untuk menampilkan pilihan menu browser kepada pengguna.
	public static void tampilkanMenu_2511531001() {
		System.out.println("\n\n======= Menu BROWSER  NIM : 2511531001 ======");
		System.out.println("1. Kunjungi Website (push) ");
		System.out.println("2. Tombol Back (Pop)");
		System.out.println("3. Lihat Halaman Aktif 1(Peek)");
		System.out.println("4. Keluar");
	}
	
	// Method untuk menambahkan objek Website baru ke dalam Stack menggunakan operasi push.
	public static void tambahBrowser_2511531001(Stack<Website_2511531001>list, Scanner zs) {
		System.out.print("Masukkan Judul Website: ");
		String judulweb_1001 = zs.nextLine(); // Membaca input string satu baris penuh dari pengguna.
		System.out.print("Masukkan URL Website: ");
		String urlweb_1001 = zs.nextLine();
		list.push(new Website_2511531001 (judulweb_1001,urlweb_1001)); // Push menambahkan elemen ke puncak stack.
		System.out.print("\n Berhasil mengunjungi halaman website! :D");
	}
	
	// Method untuk menghapus halaman terakhir dari history menggunakan operasi pop.
	public static void tombolBack_2511531001(Stack<Website_2511531001> list) {
		if (!list.isEmpty()) { // Kondisi ini memeriksa apakah stack tidak kosong sebelum diakses.
			Website_2511531001 halamanKembali = list.pop(); // Pop menghapus dan mengembalikan elemen teratas stack.
			System.out.println("\nKembali ke halaman sebelumnya...");
			System.out.println("Halaman \"" + halamanKembali.getJudul() + "\" telah dihapus dari history :-]");
		} else {
			System.out.println("\nMaaf, belum ada halaman yang kamu kunjungi :( (Stack kosong)");
		}
	}
	
	// Method untuk melihat elemen teratas stack tanpa menghapusnya menggunakan operasi peek.
	public static void lihatHalaman_2511531001(Stack<Website_2511531001> list) {
		System.out.println("\n========================== STATUS BROWSER =========================");
		System.out.println("Total Halaman yang sudah dikunjungi = " + list.size()); // Size mengembalikan jumlah elemen dalam stack.
		
		if (list.isEmpty()) {
			System.out.println("Belum ada halaman aktif yang dikunjungi ;)");
			System.out.println("Silakan pilih menu \"1\" untuk mengunjungi website terlebih dahulu");
			
		}else {
			Website_2511531001 halamanAktif= list.peek(); // Peek mengembalikan elemen teratas tanpa menghapusnya.
			System.out.println("\nHalaman yang sedang aktif :");
			System.out.println("Judul : " + halamanAktif.getJudul());
			System.out.println("URL : " + halamanAktif.getURL());
		}
		System.out.println("\n===================================================================");
	}
	
	public static void main(String[] args) { // Method main adalah titik entry eksekusi program Java.
			Stack<Website_2511531001> historyBrowser = new Stack<>(); // Inisialisasi objek Stack dengan tipe data generik Website.
			Scanner scanner = new Scanner(System.in); // Inisialisasi objek Scanner untuk membaca input dari console.
			int choice = 0; // Deklarasi variabel integer untuk menyimpan pilihan menu pengguna.
			
			do { // Loop do-while memastikan blok kode dijalankan minimal satu kali sebelum pengecekan kondisi.
				tampilkanMenu_2511531001();
				System.out.print("\nSilakan Pilih Menu :) : ");
				
				// Validasi input menu untuk memastikan pengguna hanya memasukkan tipe data integer.
				if (scanner.hasNextInt()) { // hasNextInt memeriksa apakah token input berikutnya adalah integer valid.
					choice = scanner.nextInt(); // nextInt membaca nilai integer dari input pengguna.
					scanner.nextLine(); // consume newline untuk membersihkan buffer setelah pembacaan integer.
				} else {
					scanner.nextLine(); // consume input invalid untuk menghapus input non-integer dari buffer.
					System.out.println("Input tidak valid! Harap masukkan angka 1-4.");
					continue; // Continue menghentikan iterasi saat ini dan langsung kembali ke awal loop.
				}
				
				switch (choice) { // Switch-case memilih blok kode yang akan dieksekusi berdasarkan nilai variabel choice.
					case 1:
						tambahBrowser_2511531001(historyBrowser, scanner);
						break; // Break menghentikan fall-through agar case lain tidak ikut dieksekusi.
					case 2:
						tombolBack_2511531001(historyBrowser);
						break;
					case 3:
						lihatHalaman_2511531001(historyBrowser);
						break;
					case 4:
						System.out.println("\nKamu Keluar dari Program Browser");
						System.out.println("Terima kasih sudah menggunakan program ini :D ");
						break;
					default: // Default menangani nilai input yang tidak cocok dengan case manapun.
						System.out.println("Maaf, Pilihan Menu ini tidak tersedia :(");
				}
			} while (choice != 4); // Kondisi while menentukan apakah loop akan diulang atau dihentikan.
			scanner.close(); // Close menutup resource Scanner untuk mencegah kebocoran memori.
	}
}