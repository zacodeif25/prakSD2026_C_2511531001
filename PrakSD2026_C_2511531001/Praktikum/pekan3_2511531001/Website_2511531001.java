package pekan3_2511531001; // Mendeklarasikan paket tempat kelas ini disimpan untuk organisasi kode.

public class Website_2511531001 {
	// Deklarasi variabel instance dengan akses default untuk menyimpan judul website.
	String judulweb_1001;
	// Deklarasi variabel instance dengan akses default untuk menyimpan URL website.
	String urlweb_1001;
	
	// Constructor untuk menginisialisasi objek Website dengan nilai parameter yang diberikan.
	Website_2511531001 (String jw_1001, String urlw_1001){
		this.judulweb_1001= jw_1001; // Keyword 'this' merujuk pada variabel instance kelas saat ini.
		this.urlweb_1001 = urlw_1001;
	}
	
	// Getter method untuk mengakses nilai variabel judulweb_1001 dari luar kelas.
	public String getJudul () {return judulweb_1001;}
	// Getter method untuk mengakses nilai variabel urlweb_1001 dari luar kelas.
	public String getURL () {return urlweb_1001;}
	
	// Setter method untuk memperbarui nilai variabel judulweb_1001 setelah objek dibuat.
	public void setJudul (String jw_1001) {this.judulweb_1001= jw_1001;}
	// Setter method untuk memperbarui nilai variabel urlweb_1001 setelah objek dibuat.
	public void setURL (String urlw_1001) {this.urlweb_1001 = urlw_1001;}
}