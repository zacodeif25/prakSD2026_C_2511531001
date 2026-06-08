package Pekan9_2511531001;
public class Node_2511531001 {
	int data_1001;// bisa diganti dengan string 
	Node_2511531001 left_1001;
	Node_2511531001 right_1001;
	
	public Node_2511531001 (int data_1001) {
		this.data_1001= data_1001;
		left_1001 = null;
		right_1001 = null;
		}
	public void setLeft_1001 (Node_2511531001 node_1001) {
		if (left_1001 == null)
			left_1001 = node_1001;
	}
	public void setRight_1001 (Node_2511531001 node_1001) {
		if (right_1001 == null)
			right_1001 = node_1001;
	}
	public Node_2511531001 getLeft_1001 () {
		return left_1001;
	}
	public Node_2511531001 getRight_1001 () {
		return right_1001;
	}
	public int getData_1001 () { 
		return data_1001;
	}
	public void setData_1001 (int data_1001) {
		this.data_1001 = data_1001;
	}
	
	void printPreorder_1001 (Node_2511531001 node_1001) {
		if (node_1001 ==null)
		return ;
		System.out.print(node_1001.data_1001 + " ");
		printPreorder_1001 (node_1001.left_1001);
		printPreorder_1001 (node_1001.right_1001);
	}
	
	void printPostorder_1001 (Node_2511531001 node_1001) {
		if (node_1001 ==null)
		return ;
		printPostorder_1001 (node_1001.left_1001);
		printPostorder_1001 (node_1001.right_1001);
		System.out.print(node_1001.data_1001 + " ");
	}
	
	void printInorder_1001 (Node_2511531001 node_1001) {
		if (node_1001 ==null)
		return ;
		printInorder_1001 (node_1001.left_1001);
		System.out.print(node_1001.data_1001 + " ");
		printInorder_1001 (node_1001.right_1001);
	}
	
	public String print_1001() {
		return this.print_1001("",true,"");
	}
	
	public String print_1001(String prefix_1001, boolean isTail_1001, String sb_1001) {
		if (right_1001 !=null) {
			right_1001.print_1001(prefix_1001 + (isTail_1001 ? "|   " : "   "), false,sb_1001);
		}
		System.out.println(prefix_1001 + (isTail_1001 ? "\\--" : "/--") + data_1001);
		if (left_1001 !=null) {
			left_1001.print_1001(prefix_1001 + (isTail_1001 ? "   " : "|   "), true, sb_1001);
		}
		return sb_1001;
	}
}
