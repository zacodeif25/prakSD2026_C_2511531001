package pekan3_2511531001;

public class stackArrayDriver_2511531001 {
	public static void main (String [] args) {
		stackArray_2511531001 s_1001 = new stackArray_2511531001 ();
		s_1001.push_1001(10);
		s_1001.push_1001(20);
		s_1001.push_1001(30);
		System.out.println(s_1001.pop_1001() + " dikerluarkan dari stack");
		System.out.println("Elemen teratas adalah :" +s_1001.peek_1001());
		System.out.print("Elemen pada stack:");
		s_1001.print_1001();
	}
}
