package pekan3_2511531001;

public class stackArray_2511531001 {
	static final int MAX_1001 = 1000;
	int top_1001;
	int[] a_1001 = new int [MAX_1001]; //array
	boolean isEmpty_1001() {
		return (top_1001 <0);
	}
	stackArray_2511531001(){
		top_1001=-1;
	}
	boolean push_1001(int x_1001) {
		if (top_1001 >=(MAX_1001 -1)) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			a_1001[++top_1001] = x_1001;
			System.out.println( x_1001 +" dimasukkan dalam stack");
			return true;
		}
	}
	int pop_1001 () {
		if (top_1001 <0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x_1001 = a_1001 [top_1001--];
			return x_1001;
		}
	}
	int peek_1001 () {
		if (top_1001<0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int x_1001= a_1001 [top_1001];
			return x_1001;
		}
	}
	void print_1001 () {
		for (int i_1001 = top_1001; i_1001 >-1; i_1001 --) {
			System.out.print(" "+ a_1001 [i_1001]);
		}
	}
}
