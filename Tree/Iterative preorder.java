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
