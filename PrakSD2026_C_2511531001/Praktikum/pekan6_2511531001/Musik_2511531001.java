package pekan6_2511531001;

import java.util.Scanner;

public class Musik_2511531001 {
    static Scanner scanner_1001 = new Scanner(System.in); // scanner untuk input pengguna
    
    public static Lagu_2511531001 tambahLagu_1001(Lagu_2511531001 head_1001, String judul_1001, String penyanyi_1001) {
        Lagu_2511531001 laguBaru_1001 = new Lagu_2511531001(judul_1001, penyanyi_1001); // buat node lagu baru
        if (head_1001 == null) { 
        	head_1001 = laguBaru_1001; 
        	} // jika kosong, jadi head
        else { 
        	Lagu_2511531001 curr_1001 = head_1001; 
        while (curr_1001.next_1001 != null) { 
        	curr_1001 = curr_1001.next_1001; 
        	} 
        curr_1001.next_1001 = laguBaru_1001; 
        laguBaru_1001.prev_1001 = curr_1001; 
        } // cari tail, hubungkan ke node baru
        return head_1001; // kembalikan head yang sudah diupdate
    }
    
    public static Lagu_2511531001 hapusLaguAwal_1001(Lagu_2511531001 head_1001) {
        if (head_1001 == null) { 
        	System.out.println("Playlist kosong!"); 
        	return null; 
        	} // cek jika kosong
        System.out.println("Lagu \"" + head_1001.judul_1001 + "\" dihapus!"); // tampilkan info hapus
        if (head_1001.next_1001 != null) { 
        	head_1001 = head_1001.next_1001; 
        	head_1001.prev_1001 = null; 
        	} // jika ada node berikutnya, pindah head dan putus prev
        else { 
        	head_1001 = null; 
        	} // jika cuma 1 node, jadi null
        return head_1001; // kembalikan head baru
    }
    
    public static void tampilMaju_1001(Lagu_2511531001 head_1001) {
        if (head_1001 == null) { 
        	System.out.println("Playlist kosong!"); 
        	return; 
        	} // cek kosong
        System.out.println("\n=== Playlist (Maju) ==="); // header tampilan
        Lagu_2511531001 curr_1001 = head_1001; int nomor_1001 = 1; // inisialisasi traversal
        while (curr_1001 != null) { 
        	System.out.println(nomor_1001 + ". " + curr_1001.judul_1001 + " - " + curr_1001.penyanyi_1001); 
        	curr_1001 = curr_1001.next_1001;
        	nomor_1001++; 
        	} // loop pakai next_1001
        System.out.println("======================="); // footer
    }
    
    public static void tampilMundur_1001(Lagu_2511531001 head_1001) {
        if (head_1001 == null) { 
        	System.out.println("Playlist kosong!"); 
        	return; 
        	} // cek kosong
        Lagu_2511531001 curr_1001 = head_1001; 
        while (curr_1001.next_1001 != null) { 
        	curr_1001 = curr_1001.next_1001; 
        	} // cari tail dulu
        System.out.println("\n=== Playlist (Mundur) ==="); // header tampilan
        int nomor_1001 = 1; 
        while (curr_1001 != null) { 
        	System.out.println(nomor_1001 + ". " + curr_1001.judul_1001 + " - " + curr_1001.penyanyi_1001); 
        	curr_1001 = curr_1001.prev_1001; nomor_1001++; 
        	} // loop mundur pakai prev_1001 (wajib DLL!)
        System.out.println("========================"); // footer
    }
    
    public static void cariLagu_1001(Lagu_2511531001 head_1001, String judul_1001) {
        if (head_1001 == null) {
        	System.out.println("Playlist kosong!"); 
        	return; 
        	} // cek kosong
        Lagu_2511531001 curr_1001 = head_1001; 
        boolean ditemukan_1001 = false; // inisialisasi flag
        while (curr_1001 != null) { 
        	if (curr_1001.judul_1001.equalsIgnoreCase(judul_1001)) { 
        		System.out.println("Ditemukan: " + curr_1001.judul_1001 + " - " + curr_1001.penyanyi_1001); 
        		ditemukan_1001 = true; 
        		break; } curr_1001 = curr_1001.next_1001; } // cari linear case-insensitive
        if (!ditemukan_1001) { 
        	System.out.println("Lagu \"" + judul_1001 + "\" tidak ditemukan."); 
        	} // jika tidak ketemu
    }
    
    public static void tampilkanMenu_1001() {
        Lagu_2511531001 head_1001 = null; int pilihan_1001; // inisialisasi playlist kosong dan variabel pilihan
        do {
            System.out.print("\n=== Playlist Musik NIM: 2511531001 ===\n1. Tambah Lagu\n2. Hapus Lagu Pertama\n3. Lihat Playlist (Maju)\n4. Lihat Playlist (Mundur)\n5. Cari Lagu\n6. Keluar\nPilihan: "); // tampilkan menu
            pilihan_1001 = scanner_1001.nextInt(); scanner_1001.nextLine(); // baca input dan konsumsi newline
            switch (pilihan_1001) {
                case 1:
                	System.out.print("Judul: "); 
                	String judul_1001 = scanner_1001.nextLine(); 
                	System.out.print("Penyanyi: "); 
                	String penyanyi_1001 = scanner_1001.nextLine(); 
                	head_1001 = tambahLagu_1001(head_1001, judul_1001, penyanyi_1001); 
                	System.out.println("Lagu berhasil ditambahkan!"); 
                break; // kasus tambah lagu
                case 2: 
                	head_1001 = hapusLaguAwal_1001(head_1001); 
                break; // kasus hapus lagu pertama
                case 3: 
                	tampilMaju_1001(head_1001); 
                break; // kasus tampil maju
                case 4: 
                	tampilMundur_1001(head_1001); 
                break; // kasus tampil mundur (fitur DLL)
                case 5: 
                	System.out.print("Cari judul: "); 
                	String cari_1001 = scanner_1001.nextLine(); 
                	cariLagu_1001(head_1001, cari_1001); 
                break; // kasus cari lagu
                case 6: 
                	System.out.println("Terima kasih!"); 
                break; // keluar
                default: System.out.println("Pilihan tidak valid!"); // input salah
            }
        } while (pilihan_1001 != 6); // loop sampai pilih keluar
        scanner_1001.close(); // tutup scanner
    }
    
    public static void main(String[] args) { tampilkanMenu_1001(); } // entry point program
}