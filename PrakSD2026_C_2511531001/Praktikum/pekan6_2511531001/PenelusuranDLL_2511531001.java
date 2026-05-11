package pekan6_2511531001;

public class PenelusuranDLL_2511531001 {
	static void forwardTraversal_1001 (NodeDLL_2511531001 head_1001) {
		//memulai penulusuran dari head
		NodeDLL_2511531001 curr_1001 = head_1001;
		//lanjutkan sampai akhir
		while (curr_1001 != null) {
			//print data
			System.out.print(curr_1001.data_1001 + " <-> ");
			//pindah ke node berikutnya
			curr_1001 = curr_1001.next_1001;
		}
		//print spasi 
		System.out.println();
	}
	//fungsi penulusuran mundur
	static void backwardTraversal_1001 (NodeDLL_2511531001 tail_1001) {
		//mulai dari akhir
		NodeDLL_2511531001 curr_1001 = tail_1001;
		//lanjut sampai head
		while (curr_1001 != null) {
			//cetak data
			System.out.print(curr_1001.data_1001 + " <-> ");
			//pindah ke node sebelumnya
			curr_1001 = curr_1001.prev_1001;
		}
		//cetak spasi
		System.out.println();
	}
	
	public static void main (String [] args) {
		//cetak DLL
		NodeDLL_2511531001 head_1001 = new NodeDLL_2511531001 (1);
		NodeDLL_2511531001 second_1001 = new NodeDLL_2511531001 (2);
		NodeDLL_2511531001 third_1001  = new NodeDLL_2511531001 (3);
		
		head_1001.next_1001 = second_1001;
		second_1001.prev_1001 = head_1001;
		second_1001.next_1001 = third_1001;
		third_1001.prev_1001 = second_1001;
		
		System.out.println("Penelusuran maju :");
		forwardTraversal_1001(head_1001);
		
		System.out.println("Penelusuran mundur :");
		backwardTraversal_1001(third_1001);
	
	}

}
