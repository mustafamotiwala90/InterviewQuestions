package solved;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	static Node root = null;

	public static void main(String[] args) {
		root = insert(root, 2);
		root = insert(root, 4);
		root = insert(root, 3);
		root = insert(root, -8);
		root = insert(root, 1);
		root = insert(root, -1);
		root = insert(root, -9);
		root = insert(root, 9);

		//print(root);
		//root = revTree(root);
		
		//print(root);
		
		//printLevelWise();
		
		//System.out.println(getLCA(-9,-1).data);
	}

	public static Node insert(Node n, int val) {
		if (n == null) {
			n = new Node(val);
		} else if (n.data > val) {
			n.left = insert(n.left, val);
		} else {
			n.right = insert(n.right, val);
		}
		return n;

	}

	public static void print(Node n) {
		if (n == null)
			return;
		print(n.left);
		System.out.println(n.data);
		print(n.right);
	}

	public static Node revTree(Node n) {
		if (n != null) {
			Node t = n.left;
			n.left = n.right;
			n.right = t;

			n.left = revTree(n.left);
			n.right = revTree(n.right);
		}
		return n;
	}
	
	public static int getMaxDepth(Node n){
		if(n == null)
			return 0;
		else
			return 1+ Math.max(getMaxDepth(n.left), getMaxDepth(n.right));
	}
	
	public static int getMinDepth(Node n){
		if(n == null)
			return 0;
		else
			return 1+ Math.min(getMaxDepth(n.left), getMaxDepth(n.right));
	}
	
	public static boolean isBalanced(){
		return (getMaxDepth(root) - getMinDepth(root) <= 1);
	}
	
	public static void printLevelWise(){
		if(root == null) return;
		
		Queue<Node> q = new LinkedList<Node>();
		int currentLevel=1,nextLevel = 0;
		Node temp;
		q.add(root);
		
		while(!q.isEmpty()){
			temp = q.remove();
			currentLevel--;
			
			System.out.print(temp.data);
			
			if(temp.left != null){
				q.add(temp.left);
				nextLevel++;
			}
			
			if(temp.right != null){
				q.add(temp.right);
				nextLevel++;
			}
			
			if(currentLevel == 0){
				currentLevel = nextLevel;
				nextLevel = 0;
				System.out.println();
			}
		}
	}
	
	public static Node getLCAinBST(int a, int b){
		//ASSUMED that both exist and need not be checked
		//ASSUMED that a < b and need not be checked
		Node n = root;
		while(n!= null){
			if(a < n.data && n.data < b)	return n;
			else if(n.data < a)				n = n.right;
			else 							n = n.left;
		}
		return null;
	}
	
	public static boolean isToLeft(Node n,int val){
		Node temp = n.left;
		if(temp == null) 		return false;
		if(temp.data == val)	return true;
		else 					return (isToLeft(temp, val) || isToRight(temp, val));
	}
	
	public static boolean isToRight(Node n,int val){
		Node temp = n.right;
		if(temp == null) 		return false;
		if(temp.data == val)	return true;
		else 					return (isToLeft(temp, val) || isToRight(temp, val));
	}
	
	public static Node getLCA(int a,int b){
		Node n = root;
		while(n!= null){
			
			boolean a2left = isToLeft(n, a); 
			boolean b2right = isToRight(n, b);
			
			if((a2left && b2right) || (!a2left && !b2right)) 	return n;
			else if(a2left && !b2right) 						n = n.left;
			else 												n = n.right;
		}	//O(N log N)
		return null;
	}
}
