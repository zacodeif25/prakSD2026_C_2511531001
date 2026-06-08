package Pekan9_2511531001;
public class BTree_2511531001 {
	private Node_2511531001 root_1001;
	private Node_2511531001 currentNode_1001;
	public BTree_2511531001 () {
		root_1001 = null;
	}
	
	public boolean search_1001 (int data_1001) {
		return search_1001 (root_1001, data_1001);
	}
	
	private boolean search_1001 (Node_2511531001 node_1001 , int data_1001) {
		if (node_1001.getData_1001() == data_1001)
			return true;
		if(node_1001.getLeft_1001() != null)
			if (search_1001(node_1001.getLeft_1001(),data_1001))
				return true;
		if(node_1001.getRight_1001() != null)
			if (search_1001(node_1001.getRight_1001(),data_1001))
				return true;
		return false;
	}
	
	public void printInorder_1001 () {
		root_1001.printInorder_1001(root_1001);
	}
	
	public void printPreorder_1001 () {
		root_1001.printPreorder_1001(root_1001);
	}
	
	public void printPostorder_1001 () {
		root_1001.printPostorder_1001(root_1001);
	}
	
	public Node_2511531001 getRoot_1001 () {
		return root_1001;
	}
	
	public boolean isEmpty_1001 () {
		return root_1001 == null;
	}
	
	public int countNodes_1001 () {
		return countNodes_1001 (root_1001);
	}
	
	private int countNodes_1001 (Node_2511531001 node_1001) {
		int count_1001 = 1;
		if (node_1001 == null){
			return 0;
		} else {
			count_1001 += countNodes_1001 (node_1001.getLeft_1001());
			count_1001 += countNodes_1001 (node_1001.getRight_1001());
			return count_1001;
		}
	}
	
	public void print_1001 () {
		root_1001.print_1001();
	}
	
	public Node_2511531001 getCurrent_1001 () {
		return currentNode_1001;
	}
	
	public Node_2511531001 setCurrent_1001 (Node_2511531001 node_1001) {
		return currentNode_1001 = node_1001;
	}
	
	public void setRoot_1001 (Node_2511531001 root_1001) {
		this.root_1001 = root_1001;
	}
}
