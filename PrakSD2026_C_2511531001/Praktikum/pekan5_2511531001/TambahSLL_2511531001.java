package pekan5_2511531001;


public class TambahSLL_2511531001 {
	public static NodeSLL_2511531001 insertAtFront_1001 (NodeSLL_2511531001 head_1001, int value_1001) {
		NodeSLL_2511531001 new_node_1001 = new NodeSLL_2511531001 (value_1001);
		new_node_1001.next_1001 = head_1001;
		return new_node_1001;
	}
	
	// fungsi menambahkan node di akhir SLL
	public static NodeSLL_2511531001 insertAtEnd_1001 (NodeSLL_2511531001 head_1001, int value_1001) {
		// buat sebuah node dengan sebuah nilai
		NodeSLL_2511531001 newNode_1001 = new NodeSLL_2511531001 (value_1001);
		
		// jika list kosong maka node jadi head
		if(head_1001 == null) {
			return newNode_1001;
			}
		// simpan head ke variabel semenetara
		NodeSLL_2511531001 last_1001 = head_1001;
		
		//telusuri ke node akhir
		while (last_1001.next_1001 != null) {
			last_1001 = last_1001.next_1001;
			}
		
		//ubah pointer 
		last_1001.next_1001 = newNode_1001;
		return head_1001;
		}
	
	static NodeSLL_2511531001 GetNode_1001 (int data_1001) {
		return new NodeSLL_2511531001 (data_1001);
	}
	
	static NodeSLL_2511531001 insertPos_1001 (NodeSLL_2511531001 headNode_1001, int position_1001, int value_1001) {
		NodeSLL_2511531001 head_1001 = headNode_1001;
		if (position_1001 < 1)
			System.out.println("Invalid Position");
		if (position_1001 == 1) {
			NodeSLL_2511531001 new_node_1001 = new NodeSLL_2511531001 (value_1001);
			new_node_1001.next_1001 = head_1001;
			return new_node_1001;
			} else {
			while (position_1001-- !=0) {
				if (position_1001 ==1) {
					NodeSLL_2511531001 newNode_1001 = GetNode_1001 (value_1001);
					newNode_1001.next_1001 = headNode_1001.next_1001;
					headNode_1001.next_1001 = newNode_1001;
					break;
				}
				headNode_1001 = headNode_1001.next_1001;
			}
		if (position_1001 != 1)
		System.out.println("Posisi di luar jangkauan");}
		return head_1001;}
	
	public static void printList_1001 (NodeSLL_2511531001 head_1001) {
		NodeSLL_2511531001 curr_1001 = head_1001;
			while (curr_1001.next_1001 != null) {
				System.out.print(curr_1001.data_1001 + "-->");
				curr_1001 = curr_1001.next_1001;
			}
			if (curr_1001.next_1001 == null) {
				System.out.print(curr_1001.data_1001);
			}
			System.out.println();
	}
	
	public static void main (String [] args) {
		//buat linked list 2->3->5->6
		NodeSLL_2511531001 head_1001 = new NodeSLL_2511531001(2);
		head_1001.next_1001 = new NodeSLL_2511531001(3);
		head_1001.next_1001.next_1001 = new NodeSLL_2511531001 (5);
		head_1001.next_1001.next_1001.next_1001 = new NodeSLL_2511531001(6);
		
		//cetak list asli 
		System.out.print("Senarai berantai awal: ");
		printList_1001(head_1001);
		//tambah node baru di depan
		System.out.print("tambah 1 simpul di depan: ");
		int data_1001 = 1;
		head_1001 = insertAtFront_1001(head_1001, data_1001);
		//cetak update list
		printList_1001(head_1001);
		
		//tambahkan node abru di belakang
		System.out.print("tambah 1 simpul di belakang : ");
		int data2_1001 = 7;
		head_1001 = insertAtEnd_1001 (head_1001, data2_1001);
		//cetak update list
		printList_1001 (head_1001);
		
		System.out.print("tambah 1 simpul ke data 4: ");
		int data3_1001 = 4;
		int pos_1001 = 4;
		head_1001 = insertPos_1001 (head_1001,pos_1001,data3_1001);
		// cetak update list
		printList_1001 (head_1001);
	}
}
