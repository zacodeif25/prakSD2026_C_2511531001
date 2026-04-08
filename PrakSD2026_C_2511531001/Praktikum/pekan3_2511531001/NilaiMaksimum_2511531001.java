package pekan3_2511531001;
import java.util.Stack;
public class NilaiMaksimum_2511531001 {
	public static int max (Stack <Integer> s_1001) {
		Stack<Integer> backup_1001 = new Stack <Integer>();
		int maxValue_1001 = s_1001.pop ();
		backup_1001.push((maxValue_1001));
		while (!s_1001.isEmpty()) {
			int next_1001 = s_1001.pop();
			backup_1001.push (next_1001);
			maxValue_1001 = Math.max(maxValue_1001,  next_1001);
		}
		while(backup_1001.isEmpty()) {
			s_1001.push(backup_1001.pop());
		} return maxValue_1001;
	}
	
	public static void main (String [] args) {
		Stack <Integer> s_1001 = new Stack <Integer> ();
		s_1001.push(70);
		s_1001.push(12);
		s_1001.push(20);
		System.out.println("isi stack " + s_1001);
		System.out.println("Stack Teratas " + s_1001.peek());
		System.out.println("Nilai Maksimum " + max(s_1001));
	}

}
