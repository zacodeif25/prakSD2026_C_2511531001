package pekan4_2511531001;

import java.util.Scanner;

public class AntrianLoketDriver_2511531001 {
	public static void main(String[] args) {
		Scanner sc_1001 = new Scanner(System.in);
		// Inisialisasi objek antrian dengan kapasitas default 100
		AntrianLoket_2511531001 antrian_1001 = new AntrianLoket_2511531001(100);
		int pilihan_1001 = 0;

		do {
			System.out.println("\n=== PROGRAM ANTRIAN LOKET");
			System.out.println("1. Tambah Antrian");
			System.out.println("2. Hapus Antrian");
			System.out.println("3. Tampilkan Antrian");
			System.out.println("4. Reverse");
			System.out.println("5. Keluar");
			System.out.print("Pilih menu: ");

			// Validasi input menu
			if (sc_1001.hasNextInt()) {
				pilihan_1001 = sc_1001.nextInt();
				sc_1001.nextLine(); // Bersihkan karakter newline
			} else {
				System.out.println("Input tidak valid. Silakan masukkan angka.");
				sc_1001.next();
				continue;
			}

			// Routing menu ke method yang sesuai
			switch (pilihan_1001) {
				case 1:
					System.out.print("Masukkan nama pelanggan: ");
					String nama_1001 = sc_1001.nextLine();
					antrian_1001.enqueue_1001(nama_1001);
					break;
				case 2:
					antrian_1001.dequeue_1001();
					break;
				case 3:
					antrian_1001.display_1001();
					break;
				case 4:
					antrian_1001.reverse_1001();
					antrian_1001.display_1001(); // Tampilkan hasil reverse sesuai contoh output
					break;
				case 5:
					System.out.println("Program selesai");
					break;
				default:
					System.out.println("Pilihan tidak tersedia.");
			}
		} while (pilihan_1001 != 5);
		
		sc_1001.close();
	}
}
