package pekan4_2511531001;
import java.util.*;
public class QueueLinkedList_2511531001 {
	public static void main (String [] args) {
		Queue <Integer> q_1001 = new LinkedList <> ();
		//tambah elemen {0, 1, 2, 3, 4, 5} ke antrian
		for (int i = 0; i < 6; i++) {
			q_1001.add((i));
		}
		//Menampilkan isi antrian
		System.out.println("Elemen Antrian " + q_1001);
		//untuk menghapus kepala antrian.
		int hapus_1001 = q_1001.remove();
		System.out.println("Hapus Elemen = " + hapus_1001);
		System.out.println(q_1001);
		//untuk melihat antrian terdepan 
		int depan_1001 = q_1001.peek();
		System.out.println("Kepala Antrian = " + depan_1001);
		
		int banyak_1001 = q_1001.size();
		System.out.println("Size Antrian = " + banyak_1001);
		}
	}

