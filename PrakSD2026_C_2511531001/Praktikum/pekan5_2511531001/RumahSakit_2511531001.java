package pekan5_2511531001;

import java.util.Scanner;

public class RumahSakit_2511531001 {
    
    // Counter global untuk nomor antrian auto-increment
    static int counterAntrian_1001 = 0;

    // Insert at Tail: menambahkan node pasien baru di akhir linked list dengan prinsip FIFO
    public static Pasien_2511531001 insertAtTail_1001(Pasien_2511531001 head_1001, String nama_1001, String penyakit_1001) {
        counterAntrian_1001++;
        Pasien_2511531001 newNode_1001 = new Pasien_2511531001(nama_1001, penyakit_1001, counterAntrian_1001);
        
        if (head_1001 == null) {
            return newNode_1001;
        }
        
        Pasien_2511531001 last_1001 = head_1001;
        while (last_1001.getNext() != null) {
            last_1001 = last_1001.getNext();
        }
        
        last_1001.setNext_1001(newNode_1001);
        return head_1001;
    }

    // Delete Head: menghapus dan menampilkan data pasien terdepan lalu menggeser head ke node berikutnya
    public static Pasien_2511531001 deleteHead_1001(Pasien_2511531001 head_1001) {
        if (head_1001 == null) {
            System.out.println("Antrian kosong! Tidak ada pasien untuk dipanggil");
            return null;
        }
        
        Pasien_2511531001 pasienDipanggil_1001 = head_1001;
        System.out.println("\n=== Pasien Dipanggil ===");
        System.out.println("Nama        : " + pasienDipanggil_1001.getNama_1001());
        System.out.println("Penyakit    : " + pasienDipanggil_1001.getPenyakit_1001());
        System.out.println("Nomor Antrian: " + pasienDipanggil_1001.getNomor_1001());
        
        return head_1001.getNext();
    }

    // Display List: menelusuri linked list dari head hingga null dan menampilkan semua data pasien
    public static void printList_1001(Pasien_2511531001 head_1001) {
        if (head_1001 == null) {
            System.out.println("Antrian kosong. Belum ada pasien terdaftar");
            return;
        }
        
        System.out.println("\n=== Daftar Antrian ===");
        Pasien_2511531001 curr_1001 = head_1001;
        
        while (curr_1001.getNext() != null) {
            System.out.println("[" + curr_1001.getNomor_1001() + "] " + 
                               curr_1001.getNama_1001() + " - " + 
                               curr_1001.getPenyakit_1001() + " -->");
            curr_1001 = curr_1001.getNext();
        }
        if (curr_1001 != null) {
            System.out.println("[" + curr_1001.getNomor_1001() + "] " + 
                               curr_1001.getNama_1001() + " - " + 
                               curr_1001.getPenyakit_1001());
        }
    }

    // Search Case-Insensitive: mencari pasien berdasarkan nama tanpa membedakan huruf besar atau kecil
    public static void searchPatient_1001(Pasien_2511531001 head_1001, String namaCari_1001) {
        if (head_1001 == null) {
            System.out.println("Antrian kosong");
            return;
        }
        
        Pasien_2511531001 curr_1001 = head_1001;
        boolean ditemukan_1001 = false;
        
        while (curr_1001 != null) {
            if (curr_1001.getNama_1001().equalsIgnoreCase(namaCari_1001)) {
                System.out.println("\n=== Pasien Ditemukan ===");
                System.out.println("Nama        : " + curr_1001.getNama_1001());
                System.out.println("Penyakit    : " + curr_1001.getPenyakit_1001());
                System.out.println("Nomor Antrian: " + curr_1001.getNomor_1001());
                ditemukan_1001 = true;
                break;
            }
            curr_1001 = curr_1001.getNext();
        }
        
        if (!ditemukan_1001) {
            System.out.println("Pasien dengan nama '" + namaCari_1001 + "' tidak ditemukan");
        }
    }

    // Cek Status Antrian: menghitung total pasien dan menampilkan informasi pasien terdepan
    public static void checkStatus_1001(Pasien_2511531001 head_1001) {
        if (head_1001 == null) {
            System.out.println("Status Antrian: KOSONG. Tidak ada pasien");
            return;
        }
        
        int total_1001 = 0;
        Pasien_2511531001 curr_1001 = head_1001;
        while (curr_1001 != null) {
            total_1001++;
            curr_1001 = curr_1001.getNext();
        }
        
        System.out.println("\n=== Status Antrian ===");
        System.out.println("Total Pasien    : " + total_1001);
        System.out.println("Pasien Terdepan : " + head_1001.getNama_1001() + 
                           " (No. " + head_1001.getNomor_1001() + ")");
    }

    // Menu utama: menangani input pengguna dan memanggil method operasi linked list yang sesuai
    public static void main(String[] args) {
        Scanner input_1001 = new Scanner(System.in);
        Pasien_2511531001 head_1001 = null;
        int pilihan_1001 = 0;

        do {
            System.out.println("\n=== Antrian Rumah Sakit NIM: 2511531001 ===");
            System.out.println("1. Daftarkan Pasien (Insert at Tail)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");

            if (input_1001.hasNextInt()) {
                pilihan_1001 = input_1001.nextInt();
                input_1001.nextLine();
            } else {
                System.out.println("Input tidak valid. Silakan masukkan angka 1-6");
                input_1001.nextLine();
                continue;
            }

            switch (pilihan_1001) {
                case 1:
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama_1001 = input_1001.nextLine();
                    System.out.print("Masukkan Penyakit   : ");
                    String penyakit_1001 = input_1001.nextLine();
                    head_1001 = insertAtTail_1001(head_1001, nama_1001, penyakit_1001);
                    System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counterAntrian_1001);
                    break;
                case 2:
                    head_1001 = deleteHead_1001(head_1001);
                    break;
                case 3:
                    printList_1001(head_1001);
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cari_1001 = input_1001.nextLine();
                    searchPatient_1001(head_1001, cari_1001);
                    break;
                case 5:
                    checkStatus_1001(head_1001);
                    break;
                case 6:
                    System.out.println("Program selesai. Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-6");
            }
        } while (pilihan_1001 != 6);

        input_1001.close();
    }
}