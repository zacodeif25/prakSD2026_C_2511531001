package pekan3_2511531001;
import java.util.*;
class Siswa_1001 {
	String nama_1001;
	int nim_1001;
	
	public Siswa_1001 (String nama_1001, int nim_1001) {
		this.nama_1001 = nama_1001;
		this.nim_1001 = nim_1001;
	}
	@Override
	public String toString () {
		return "NIM : "+ nim_1001 + ", Nama : " + nama_1001; 
	}
}
public class SiswaStack_2511531001 {
	private ArrayList <Siswa_1001> stack_1001;
	
	public SiswaStack_2511531001() {
		stack_1001 = new ArrayList<>();
	}
	
	public void push_1001 (Siswa_1001 mhs_1001) {
		stack_1001.add(mhs_1001);
	}
	
	public Siswa_1001 pop_1001() {
		if (!isEmpty_1001()) {
			return stack_1001.remove (stack_1001.size() - 1);
		}
		return null;
	}
	
	public Siswa_1001 peek_1001 () {
		if (!isEmpty_1001()) {
			return stack_1001.get(stack_1001.size() -1);
		}
		return null;
	}
	
	public boolean isEmpty_1001() {
		return stack_1001.isEmpty();
	}
	
	public void tampilkanSiswa_1001() {
		for ( int i_1001 = stack_1001.size () -1 ; i_1001 >=0; i_1001 --) {
			System.out.println(stack_1001.get(i_1001));
		}}

	public static void main (String [] args) {
		SiswaStack_2511531001 studentStack_1001 = new SiswaStack_2511531001 ();
		
		Siswa_1001 mhs1_1001 = new Siswa_1001 ("Ali" , 1);
		Siswa_1001 mhs2_1001 = new Siswa_1001 ("Bobby" , 2);
		Siswa_1001 mhs3_1001 = new Siswa_1001 ("Charles" , 3);
		
		studentStack_1001.push_1001((mhs1_1001));
		studentStack_1001.push_1001((mhs2_1001));
		studentStack_1001.push_1001((mhs3_1001));
		
		System.out.println("Siswa di dalam stack :");
		studentStack_1001.tampilkanSiswa_1001();
		
		System.out.println("Siswa teratas " + studentStack_1001.peek_1001());
		System.out.println("mengeluarkan siswa teratas " + studentStack_1001.pop_1001());
		System.out.println("Daftar siswa setelah di pop: ");
		studentStack_1001.tampilkanSiswa_1001();
	}
}
