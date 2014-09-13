Given a binary tree, determine if it is a valid binary search tree (BST).

Initial call : isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

class Node {
	int val;
	Node left;
	Node right;
 
	Node(int x) {
		val = x;
	}
}


boolean isValidBST(Node root,int min,int max) {
  
  if(root==null)
    return true;
  
  if(root<=min || root=>max)
    return false;
  
  return isValidBST(root.left,min,root.val) || isValidBST(root.right,root.val,max);
}
