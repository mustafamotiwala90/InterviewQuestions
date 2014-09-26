// Prune a Binary Search Tree such that all nodes less than min or greater than max are deleted from the tree.

Node pruneTrees(Node root,int min,int max) {

  if(root==null)
    return;
    
  Node root.left = pruneTrees(root.left,min,max);
  Node root.right = pruneTrees(root.right,min,max);
  
  if(root.value < min) {
    Node right_tree = root.right;  
    free(root);
    return right_tree;
  
  }
  else if (root.value > max) {
    Node left_tree = root.left;  
    free(root);
    return left_tree;
  }
  else 
    return root;

}
