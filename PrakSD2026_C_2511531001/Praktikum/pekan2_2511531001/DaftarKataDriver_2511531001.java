package pekan2_2511531001;

public class DaftarKataDriver_2511531001 {
	public static void main (String [] args) {
		DaftarKata_2511531001 al = new DaftarKata_2511531001();
		
		//Menambah elemen (akhir)
		al.tambah_2511531001("Kami");
		al.tambah_2511531001("Informatika");
		
		//Menyisipkan elemen pada indeks 1
		al.tambahPada_2511531001(1, "Mahasiswa");
		
		//cetak isi awal
		System.out.println("Awal   : " + al);
		
		//Mengubah elemen (index 1)
		al.ubahElemen_2511531001(1, "Departmen");
		System.out.println("Setelah Ubah: " + al);
		
		//Menghapus elemen (hapus index 0)
		String terhapus = al.hapusElemen_2511531001(0);
		System.out.println("Terhapus : " + terhapus);
		System.out.println("Setelah Dihapus : " + al);
		
		//Iterasi pada ArrayList (cetak setiap elemen)
		System.out.print("Iterasi ");
		al.iterasiCetak_2511531001();
		System.out.println();
	}
}
