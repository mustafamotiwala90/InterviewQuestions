// Printing a tree level by level order

public void levelOrder(Node root) {

if(root==null)
  return;

  Queue<Node> nodes = new Queue<Node>();
  nodes.add(root);
  int currentLevel = 1;
  int nextLevel = 0;
  while(!nodes.isEmpty()){
    
    Node node = nodes.deQueue();
    currentLevel--;
    if(node.left!=null) {
      nodes.add(node.left);
      nextLevel++;
    }
    
    if(node.right!=null) {
      nodes.add(node.right);
      nextLevel++;
    }  
    System.out.print(node.data);
    if(currentLevel==0){
      System.out.println();
      currentLevel = nextLevel;
      nextlevel = 0;
    }

  }


}
