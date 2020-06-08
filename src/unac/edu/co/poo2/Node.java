package unac.edu.co.poo2;

public class Node {

	protected Object date;
	protected Node left;
	protected Node right;

	public Node(Object value) {
		date = value;
		left = right = null;
	}

	public Node(Node branchL, Object value, Node branchR) {
		date = value;
		left = branchL;
		right = branchR;
	}

	public Object valueNode() {
		return date;
	}

	public Node subTreeL() {
		return left ;
	}

	public Node subTreeR() {
		return right;
	}

	public void newValue(Object d) {
		date = d;
	}

	public void branchL(Node n) {
		left = n;
	}

	public void branchR(Node n) {
		right = n;
	}
	
	public void visited() {
		System.out.print(" " + date + " ");
	}
}
