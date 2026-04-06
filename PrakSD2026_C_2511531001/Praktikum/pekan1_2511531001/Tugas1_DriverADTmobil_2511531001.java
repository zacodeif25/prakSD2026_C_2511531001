package pekan1_2511531001;

public class Tugas1_DriverADTmobil_2511531001 {
	public static void main (String [] args) {
		Tugas1_ADTmobil_2511531001 mobil1 = new Tugas1_ADTmobil_2511531001("Avanza", "Toyota",2020, 1300,150000000);
		System.out.println("Menambahkan Mobil ke-1 dengan konstruktor default");
		mobil1.tampilkanInfo();
		
		Tugas1_ADTmobil_2511531001 mobil2 = new Tugas1_ADTmobil_2511531001();
		mobil2.tambahMobil("Civic","Honda",2021,1500,250000000);
		System.out.println("Menambah Mobil Ke-2 dengan method tambahMobil");
		mobil2.tampilkanInfo();
		
		System.out.println("\nMengubah data mobil ke-2 dengan setter:");
        mobil2.setTahun(2022);
        mobil2.setHarga(260000000);
        mobil2.tampilkanInfo();
        
        System.out.println("\nMengakses data menggunakan getter:");
        System.out.println("Nama Mobil: " + mobil2.getNama());
        System.out.println("Merk: " + mobil2.getMerk());
        System.out.println("Tahun: " + mobil2.getTahun());
        
        System.out.println("\nMenghapus mobil ke-1:");
        mobil1.hapusMobil();
        mobil1.tampilkanInfo();
	}
}
