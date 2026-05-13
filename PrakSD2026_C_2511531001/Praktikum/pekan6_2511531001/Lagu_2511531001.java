package pekan6_2511531001;


public class Lagu_2511531001 {
		//mendefinisikan kelas node
		String judul_1001; // judul lagu
		String penyanyi_1001; // nama penyanyi
		Lagu_2511531001 next_1001; // pointer ke next mode
		Lagu_2511531001 prev_1001; // pointer ke previous node
		
		//konstruktor
		public Lagu_2511531001 (String judul_1001, String penyanyi_1001) {
			this.judul_1001= judul_1001;
			this.penyanyi_1001 = penyanyi_1001;
			this.next_1001 = null;
			this.prev_1001 = null;			
	}
		 public String getJudul_1001() {return judul_1001;}
		    public String getPenyanyi_1001() {return penyanyi_1001;}
		    public Lagu_2511531001 getPrev () {return prev_1001;}
		    public Lagu_2511531001 getNext() {return next_1001;}
		    
		    public void setJudul_1001 (String judul_1001) {this.judul_1001 = judul_1001;}
		    public void setPenyanyi_1001 (String penyanyi_1001) {this.penyanyi_1001 = penyanyi_1001;}
		    public void setPrev_1001 (Lagu_2511531001 prev_1001) {this.prev_1001 = prev_1001;}
		    public void setNext_1001 (Lagu_2511531001 next_1001) {this.next_1001 = next_1001;}
}
