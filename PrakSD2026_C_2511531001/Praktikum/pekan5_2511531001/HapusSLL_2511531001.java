package pekan5_2511531001;
public class HapusSLL_2511531001 {
	//fungsi untuk menghapus head
	public static NodeSLL_2511531001 deleteHead_1001 (NodeSLL_2511531001 head_1001) {
		//jika SLL Kosong
	if (head_1001 == null)
		return null;
	//pindahkan ke node berikutnya
	head_1001 = head_1001.next_1001;
	//return head baru
	return head_1001;
	}
	
	// fungsi menghapus node terakhir SLL 
	public static NodeSLL_2511531001 removeLastNode_1001 (NodeSLL_2511531001 head_1001) {
		//jika list kosong, return null
		if (head_1001 == null) {
			return null;
		}
		
		//jika list satu node, hapus node akan return null
		if (head_1001.next_1001 == null) {
			return null;
		}
		//temukan node terakhir ke dua
		NodeSLL_2511531001 secondLast_1001 = head_1001;
		while (secondLast_1001.next_1001.next_1001 != null) {
			secondLast_1001 = secondLast_1001.next_1001;
		}
		//hapus node terakhir
		secondLast_1001.next_1001 = null;
		return head_1001;
	}
	
	public static NodeSLL_2511531001 deleteNode_1001 (NodeSLL_2511531001 head_1001, int position_1001) {
		NodeSLL_2511531001 temp_1001 = head_1001;
		NodeSLL_2511531001 prev_1001 = null;
		//jika linked list null
		if (temp_1001 == null)
			return head_1001;
		//kasus 1 : head dihapus
		if (position_1001 == 1) {
			head_1001 = temp_1001.next_1001;
			return head_1001;
		}
		
		//kasus 2 : menghapus node di tengah
		//telusuri ke node yang dihapus
		
		for (int i = 1; temp_1001 != null && i < position_1001; i++) {
			prev_1001 = temp_1001;
			temp_1001 = temp_1001.next_1001;
		}
		//jika ditemukan, hapus node
		if (temp_1001 != null) {
			prev_1001.next_1001 = temp_1001.next_1001;
		}else {
			System.out.println("Data tidak ada");
		}
		return head_1001;
	}
	
	//fungsi mencetak SLL
	public static void printList_1001 (NodeSLL_2511531001 head_1001) {
		NodeSLL_2511531001 curr_1001 = head_1001;
		while (curr_1001.next_1001 != null) {
			System.out.print(curr_1001.data_1001+"-->");
			curr_1001 = curr_1001.next_1001;
		}
		if (curr_1001.next_1001 == null) {
			System.out.print(curr_1001.data_1001);
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		//buat SLL 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
		NodeSLL_2511531001 head_1001 = new NodeSLL_2511531001 (1);
		head_1001.next_1001 = new NodeSLL_2511531001 (2);
		head_1001.next_1001.next_1001 = new NodeSLL_2511531001 (3);
		head_1001.next_1001.next_1001.next_1001 = new NodeSLL_2511531001 (4);
		head_1001.next_1001.next_1001.next_1001.next_1001 = new NodeSLL_2511531001 (5);
		head_1001.next_1001.next_1001.next_1001.next_1001.next_1001= new NodeSLL_2511531001 (6);
		
		//cetak list awal
		System.out.println("list awal : ");
		printList_1001(head_1001);
		
		//hapus head
		head_1001 = deleteHead_1001 (head_1001);
		System.out.println("List setelah head di hapus : ");
		printList_1001(head_1001);
		
		//hapus node terakhir
		head_1001 = removeLastNode_1001 (head_1001);
		System.out.println("List setelah simpul terakhir di hapus : ");
		printList_1001(head_1001);
		
		//deleting node position 2
		int position_1001 = 2;
		head_1001 = deleteNode_1001(head_1001,position_1001);
		
		//print list after deletion
		System.out.println("List setelah posisi 2 dihapus: ");
		printList_1001(head_1001);
	}
}
