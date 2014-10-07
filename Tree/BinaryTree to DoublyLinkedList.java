// Convert a binary tree to a doubly linked list.

Solution : The trick is to do inorder traversal while keeping track of the previous node. 



void BinaryTreeToDLL(Node root,Node head){

  if(root==null)
    return;
    
  Node prev = null;
  BinaryTreeToDLL(root.left,head);
  
  if(prev==null)
    head = root;
  else{
    root.left=prev;
    prev.right=root;
  }
  prev = root;

  if(root.right!=null)
    BinaryTreeToDLL(root.right,head);
}
