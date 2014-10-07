// Print Binary tree in vertical order

void main(){
  HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
  getVerticalNode(root,0,map);
  
  for(Integer value:map.keySet()){
    ArrayList<Integer> verticalList = map.get(value);
    for(Integer val: verticalList)
      System.out.print(val + " ");
    System.out.println();
    
  }

}


void getVerticalNode(Node root,int distance,HashMap<Integer,ArrayList<Integer>> treeMap){
  
  if(root==null)
    return;

  ArrayList<Integer> lst = treeMap.get(distance);
  lst.add(root.value);
  treeMap.put(distance,lst);
  
  getVerticalNode(root.left,distance-1,treeMap);
  getVerticalNode(root.right,distance+1,treeMap);

}
