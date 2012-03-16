package solved;
public class Node {

	int data;
	Node prev, next, rev; // linked listing
	Node left, right; // Btree
	Node parent;
	boolean visited; // BFS/DFS

	public Node(int val) {
		data = val;
	}
}
