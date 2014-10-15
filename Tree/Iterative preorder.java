// Iterative preorder traversal java

void preOrderTraversal(Node root)
{
  if(root == null)
    return;
  Stack<Node> nodes = new Stack<Node>();
  nodes.push(root);
  
  while(true) {
    Node node = nodes.pop();
    if(node==null)
      break;
    System.out.println("Node visited : "+node.value);
    if(node.left!=null)
      nodes.push(node.left);
      
    if(node.right!=null)
      nodes.push(node.right);
  }
}

void inOrderTraversal(Node root) {
  
  if(root==null)
    return;
  
  Stack<Node> inorderNodes = new Stack<Node>();
 
  current = root;
  while(!inorderNodes.empty() || current){
    if(current){
     inorderNodes.push(current);
     current = current.left;
    }else{
      current = inorderNodes.pop();
      System.out.println(current.data);
      current = current.right;
    }
  }
  
}
