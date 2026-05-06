package pekan5_2511531001; // Deklarasi package untuk mengorganisir kelas

public class Pasien_2511531001 { // Kelas ADT yang merepresentasikan node dalam Single Linked List
    // Deklarasi atribut data pasien dan pointer next dengan suffix NIM
    String nama_1001;
    String penyakit_1001;
    int no_1001;
    Pasien_2511531001 next_1001;
    
    // Constructor untuk menginisialisasi atribut saat objek node dibuat
    public Pasien_2511531001 (String nama_1001, String penyakit_1001, int no_1001) {
        this.nama_1001 = nama_1001;
        this.penyakit_1001 = penyakit_1001;
        this.no_1001 = no_1001;
        this.next_1001 = null;
    }
    
    // Method getter untuk mengakses nilai atribut privat
    public String getNama_1001() {return nama_1001;}
    public String getPenyakit_1001() {return penyakit_1001;}
    public int getNomor_1001() { return no_1001;}
    public Pasien_2511531001 getNext() {return next_1001;}
    
    // Method setter untuk mengubah nilai atribut dan menghubungkan pointer next
    public void setNama_1001 (String nama_1001) {this.nama_1001 = nama_1001;}
    public void setPenyakit_1001 (String penyakit_1001) {this.penyakit_1001 = penyakit_1001;}
    public void setNomor_1001 (int no_1001) {this.no_1001 = no_1001;}
    public void setNext_1001 (Pasien_2511531001 next_1001) {this.next_1001 = next_1001;}
}