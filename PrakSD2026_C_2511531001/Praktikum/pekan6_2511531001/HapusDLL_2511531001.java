package pekan6_2511531001;
public class HapusDLL_2511531001 {
	//fungsi menghapus node awal
	public static NodeDLL_2511531001 delHead_1001 (NodeDLL_2511531001 head_1001) {
		if (head_1001 == null) {
			return null;
		}
		NodeDLL_2511531001 temp_1001 = head_1001;
		head_1001 = head_1001.next_1001;
		if (head_1001 != null) {
			head_1001.prev_1001 = null;
		}
		return head_1001;
	}
	//fungsi menghapus di akhir 
	public static NodeDLL_2511531001 delLast_1001 (NodeDLL_2511531001 head_1001) {
		if (head_1001 == null) {
			return null;
		}
		if (head_1001.next_1001 == null ) {
			return null;
		}
		NodeDLL_2511531001 curr_1001 = head_1001;
		while (curr_1001.next_1001 != null) {
			curr_1001 = curr_1001.next_1001;
		}
		//update pointer previous node
		if (curr_1001.prev_1001 != null) {
			curr_1001.prev_1001.next_1001 = null;
		}
		return head_1001;
	}
	
	//fungsi menghapus node posisi tertentu
	public static NodeDLL_2511531001 delPos_1001 (NodeDLL_2511531001 head_1001, int pos_1001) {
		//jika DLL kosong
		if(head_1001 == null) {
			return head_1001;
		}
		NodeDLL_2511531001 curr_1001 = head_1001;
		//telusuri sampai ke node yang akan dihapus
		for (int i =1; curr_1001 != null && i<pos_1001; i++) {
			curr_1001 = curr_1001.next_1001;
		}
		//jika posisi tidak ditemukan
		if (curr_1001 == null) {
			return head_1001;
		}
		//update pointer
		if (curr_1001.prev_1001 != null) {
			curr_1001.prev_1001.next_1001 = curr_1001.next_1001;
		}
		if (curr_1001.next_1001 != null) {
			curr_1001.next_1001.prev_1001 = curr_1001.prev_1001;
		}
		//jika yang dihapus head
		if (head_1001 == curr_1001) {
			head_1001 = curr_1001.next_1001;
		}
		return head_1001;
	}
	//fungsi mencetak DLL
	public static void printList_1001(NodeDLL_2511531001 head_1001) {
		NodeDLL_2511531001 curr_1001 = head_1001;
		while (curr_1001 != null) {
			System.out.print(curr_1001.data_1001 + " ");
			curr_1001 = curr_1001.next_1001;
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		//buat sebuah DLL
		NodeDLL_2511531001 head_1001 = new NodeDLL_2511531001 (1);
		head_1001.next_1001 = new NodeDLL_2511531001(2);
		head_1001.next_1001.prev_1001 = head_1001;
		head_1001.next_1001.next_1001 = new NodeDLL_2511531001 (3);
		head_1001.next_1001.next_1001.prev_1001 = head_1001.next_1001;
		head_1001.next_1001.next_1001.next_1001 = new NodeDLL_2511531001 (4);
		head_1001.next_1001.next_1001.next_1001.prev_1001 = head_1001.next_1001.next_1001;
		head_1001.next_1001.next_1001.next_1001.next_1001 = new NodeDLL_2511531001 (5);
		head_1001.next_1001.next_1001.next_1001.next_1001.prev_1001 = head_1001.next_1001.next_1001.next_1001;
		
		System.out.print("DLL awal :" );
		printList_1001(head_1001);
		
		System.out.print("Setelah head dihapus :" );
		head_1001 = delHead_1001(head_1001);
		printList_1001(head_1001);
		
		System.out.print("Setelah node terakhir dihapus :" );
		head_1001 = delLast_1001(head_1001);
		printList_1001(head_1001);
		
		System.out.print("menghapus node ke 2 :" );
		head_1001 = delPos_1001(head_1001,2);
		printList_1001(head_1001);
	}
	
}
