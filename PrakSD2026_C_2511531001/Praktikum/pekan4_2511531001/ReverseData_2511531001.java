package pekan4_2511531001;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReverseData_2511531001 {
	public static void main (String [] args) {
		Queue <Integer> q_1001 = new LinkedList<Integer>();
		q_1001.add(1);
		q_1001.add(2);
		q_1001.add(3); // [1,2,3]
		System.out.println("sebelum reverse = " + q_1001);
		Stack <Integer> s_1001 = new Stack <Integer> ();
		while (!q_1001.isEmpty()) { // Q -> S
			s_1001.push(q_1001.remove());
			}
		while (!s_1001.isEmpty()) { // S -> Q
			q_1001.add(s_1001.pop());
			}
		
		System.out.println("sesudah reverse = " + q_1001); // [3,2,1]
		}
	}


