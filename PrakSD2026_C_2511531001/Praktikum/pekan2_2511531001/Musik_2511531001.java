package pekan2_2511531001; // Mendeklarasikan paket tempat kelas ini disimpan untuk organisasi kode.

public class Musik_2511531001 {
	// Deklarasi variabel instance dengan akses default untuk menyimpan judul lagu.
	String judul_1001;
	// Deklarasi variabel instance dengan akses default untuk menyimpan nama penyanyi.
	String penyanyi_1001;
	// Deklarasi variabel instance dengan akses default untuk menyimpan durasi lagu dalam detik.
	int durasi_1001;
	
	// Constructor untuk menginisialisasi objek Musik dengan nilai parameter yang diberikan.
	Musik_2511531001 (String j_1001, String p_1001, int d_1001){
		this.judul_1001 = j_1001; // Keyword 'this' merujuk pada variabel instance kelas saat ini.
		this.penyanyi_1001 = p_1001;
		this.durasi_1001 = d_1001;
	}
	
	// Getter method untuk mengakses nilai privat/protected dari variabel judul_1001.
	public String getJudul () {return judul_1001;}
	// Getter method untuk mengakses nilai privat/protected dari variabel penyanyi_1001.
	public String getPenyanyi () {return penyanyi_1001;}
	// Getter method untuk mengakses nilai privat/protected dari variabel durasi_1001.
	public int getDurasi () {return durasi_1001;}
	
	// Setter method untuk memperbarui nilai variabel judul_1001 setelah objek dibuat.
	public void setJudul (String j_1001) {this.judul_1001 = j_1001;}
	// Setter method untuk memperbarui nilai variabel penyanyi_1001 setelah objek dibuat.
	public void setPenyanyi (String p_1001) {this.penyanyi_1001 = p_1001;}
	// Setter method untuk memperbarui nilai variabel durasi_1001 setelah objek dibuat.
	public void setDurasi (int d_1001) {this.durasi_1001 = d_1001;}

	// Override annotation menandakan method ini menggantikan implementasi toString() dari kelas induk Object.
	@Override
	public String toString() {
		// Method ini mengembalikan representasi string dari objek untuk keperluan pencetakan.
		return "Judul Lagu: " + judul_1001 + "\n" + "  Nama Penyanyi: " + penyanyi_1001 +  "\n"+ "  Durasi: " + durasi_1001 + " detik\n";
	}
}