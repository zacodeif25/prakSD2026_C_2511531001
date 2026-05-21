package pekan7_2511531001;
public class Mahasiswa_2511531001 {
	private String nama_1001;
	private String nim_1001;
	private String prodi_1001;
	
	//konstruktor
	public Mahasiswa_2511531001 (String n_1001, String nim_1001, String p_1001) {
		this.nama_1001 = n_1001;
		this.nim_1001 = nim_1001;
		this.prodi_1001 = p_1001;
	}
	
	//getter
	public String getNama_1001() {return nama_1001;}
	public String getNim_1001() {return nim_1001;}
	public String getProdi_1001() {return prodi_1001;}
	
	//setter
	public void setNama_1001 (String nama_1001) {this.nama_1001 = nama_1001;}
	public void setNim_1001 (String nim_1001) {this.nim_1001 = nim_1001;}
	public void setProdi_1001 (String prodi_1001) {this.prodi_1001 = prodi_1001;}
	
	//tampilan data
	public String toString () {
		return nama_1001 + " " + nim_1001 + " " + prodi_1001;
	}
}
