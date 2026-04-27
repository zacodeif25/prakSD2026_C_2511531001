package pekan4_2511531001;
import java.util.*;
public class IterasiQueue_2511531001 {
	public static void main (String [] args) {
		Queue<String> q_1001 = new LinkedList <>();
		
		q_1001.add("Praktikum");
		q_1001.add("Struktur");
		q_1001.add("Data");
		q_1001.add("Dan");
		q_1001.add("Algoritma");
		
		Iterator<String> iterator_1001 = q_1001.iterator();
		while (iterator_1001.hasNext()) {
			System.out.print(iterator_1001.next() + " ");
		}
	}
}
