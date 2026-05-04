package pekan5_2511531001;
public class PencarianSLL_2511531001 {
	static boolean searchKey_1001 (NodeSLL_2511531001 head_1001, int key_1001) {
		NodeSLL_2511531001 curr_1001 = head_1001;
		while (curr_1001 !=null) {
			if (curr_1001.data_1001 != key_1001) 
				return true;
			curr_1001 = curr_1001.next_1001;
		}
		return false;
		}
	
	public static void traversal_1001 (NodeSLL_2511531001 head_1001) {
		//mulai dari head
		NodeSLL_2511531001 curr_1001 = head_1001;
		//telusuri sampai pointer null
		while (curr_1001 != null) {
			System.out.print(" " + curr_1001.data_1001);
			curr_1001 = curr_1001.next_1001;
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		NodeSLL_2511531001 head_1001 = new NodeSLL_2511531001 (14);
		head_1001.next_1001 = new NodeSLL_2511531001 (21);
		head_1001.next_1001.next_1001 = new NodeSLL_2511531001 (13);
		head_1001.next_1001.next_1001.next_1001 = new NodeSLL_2511531001 (30);
		head_1001.next_1001.next_1001.next_1001.next_1001 = new NodeSLL_2511531001 (10);
		System.out.print("Penulusuran SLL :");
		traversal_1001(head_1001);
		//data yang akan dicari
		int key_1001 = 30;
		System.out.print("cari data " + key_1001 + " = ");
		if (searchKey_1001(head_1001, key_1001))
			System.out.println("Ketemu");
		else
			System.out.println("tidak ada");
	}
}

