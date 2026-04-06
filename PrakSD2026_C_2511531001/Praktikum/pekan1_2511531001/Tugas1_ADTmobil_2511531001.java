package pekan1_2511531001;
public final class Tugas1_ADTmobil_2511531001 {
	private String nama;
	private String merk;
	private int tahun;
	private int cc;
	private long harga;
	
	public Tugas1_ADTmobil_2511531001 (String n, String m, int t, int cc, int h){
		this.nama = n; this.merk = m; this.tahun = t; this.cc =cc; this.harga= h;
	}
	
	public Tugas1_ADTmobil_2511531001() {
		 this.nama = "";
	        this.tahun = 0;
	        this.cc = 0;
	        this.harga = 0;
	        this.merk = "";
	}

	public String getNama() {return nama;}
	public String getMerk() {return merk;}
	public int getTahun () {return tahun;}
	public int getCC () {return cc;}
	public long getHarga () {return harga;}
	
	public void setNama (String n) {this.nama=n;}
	public void setMerk (String m) {this.merk=m;}
	public void setTahun (int t) {this.tahun=t;}
	public void setCC (int cc) {this.cc=cc;}
	public void setHarga (long h) {this.harga=h;}
	
	public void tambahMobil (String n, String m, int t, int cc, long h) {
		this.nama = n; this.merk = m; this.tahun = t; this.cc =cc; this.harga= h;
	}
	public void hapusMobil() {
		this.nama = ""; this.tahun = 0; this.cc=0; this.harga=0; this.merk="";
	}
	public void tampilkanInfo() {
		 System.out.println("=== Informasi Mobil ===");
	        System.out.println("Nama  : " + nama);
	        System.out.println("Tahun : " + tahun);
	        System.out.println("CC    : " + cc);
	        System.out.println("Harga : Rp " + String.format("%,d", harga));
	        System.out.println("Merk  : " + merk);
	        System.out.println("=======================");
	}
}
