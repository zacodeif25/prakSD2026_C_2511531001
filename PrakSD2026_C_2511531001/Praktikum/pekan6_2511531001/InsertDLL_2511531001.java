package pekan6_2511531001;
public class InsertDLL_2511531001 {
	//menambahkan node di awal kiri
	static NodeDLL_2511531001 InsertBegin_1001 (NodeDLL_2511531001 head_1001, int data_1001) {
		//buat node baru
		NodeDLL_2511531001 new_node_1001 = new NodeDLL_2511531001 (data_1001);
		//jadikan pointer nextnya head
		new_node_1001.next_1001 = head_1001;
		// jadikan pointer prev head ke new_node
		if (head_1001 != null) {
			head_1001.prev_1001 = new_node_1001;
		}
		return new_node_1001;
	}
	
	//fungsi menambahkan node di akhir
	public static NodeDLL_2511531001 insertEnd_1001 (NodeDLL_2511531001 head_1001, int newData_1001) {
		//buat node baru
		NodeDLL_2511531001 newNode_1001 = new NodeDLL_2511531001 (newData_1001);
		//jika dll null jadikan head
		if(head_1001 == null) {
			head_1001 = newNode_1001;
		}
		else {
			NodeDLL_2511531001 curr_1001 = head_1001;
			while (curr_1001.next_1001 != null) {
				curr_1001 = curr_1001.next_1001;
			}
			curr_1001.next_1001 = newNode_1001;
			newNode_1001.prev_1001 = curr_1001;
		}
		return head_1001;
	}
	
	//fungsi menambahkan node  di posisi tertentu 
	public static NodeDLL_2511531001 insertAtPosition_1001 (NodeDLL_2511531001 head_1001, int pos_1001, int new_data_1001) {
		//buat node baru
		NodeDLL_2511531001 new_node_1001 = new NodeDLL_2511531001 (new_data_1001);
		if (pos_1001== 1) {
			new_node_1001.next_1001 = head_1001;
			if (head_1001 != null) {
				head_1001.prev_1001 = new_node_1001;}
			head_1001 = new_node_1001;
			return head_1001;
			}
		NodeDLL_2511531001 curr_1001 = head_1001;
		for ( int i = 1; i <pos_1001 -1 && curr_1001 != null; i++) {
			curr_1001 = curr_1001.next_1001;}
		if(curr_1001 == null) {
			System.out.println("Posisi tidak ada");
			return head_1001;
		}
		
		new_node_1001.prev_1001 = curr_1001;
		new_node_1001.next_1001 = curr_1001.next_1001;
		curr_1001.next_1001 = new_node_1001;
		if (new_node_1001.next_1001 != null) {
			new_node_1001.next_1001.prev_1001 = new_node_1001;
		}
		return head_1001;
		}
	
	public static void printList_1001 (NodeDLL_2511531001 head_1001) {
		NodeDLL_2511531001 curr_1001 = head_1001;
		while (curr_1001 != null) {
			System.out.print(curr_1001.data_1001 + " <-> ");
			curr_1001 = curr_1001.next_1001;	
		}
		System.out.println();
	}
	
	public static void main (String [] args) {
		//membuat dll 2 <-> 1 <-> 5
		NodeDLL_2511531001 head_1001 = new NodeDLL_2511531001(2);
		head_1001.next_1001 = new NodeDLL_2511531001(3);
		head_1001.next_1001.prev_1001 = head_1001;
		head_1001.next_1001.next_1001 = new NodeDLL_2511531001 (5);
		head_1001.next_1001.next_1001.prev_1001 = head_1001.next_1001;
		//cetak DLL awal
		System.out.print("DLL Awal : ");
		printList_1001 (head_1001);
		//tambah 1 di awal
		head_1001 = InsertBegin_1001 (head_1001,1);
		System.out.print("simpul 1 ditambah di awal: ");
		printList_1001(head_1001);
		//tambah 6 di akhir
		System.out.print("simpul 6 ditambah di akhir: ");
		int data_1001 = 6;
		head_1001 = insertEnd_1001 (head_1001, data_1001);
		printList_1001(head_1001);
		//menambah node 4 di posisi 4
		System.out.print("tambah node 4 di posisi 4: ");
		int data2_1001 = 4;
		int pos_1001 = 4;
		head_1001 = insertAtPosition_1001 (head_1001, pos_1001, data2_1001);
		printList_1001(head_1001);
		}
	
}

