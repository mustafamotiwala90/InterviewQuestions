// Print all subsets of size K in java

public static void getSubsets(List<Integer> superSet,int k,int index,Set<Integer> current,List<Set<Integer>> solution){

  if(current.size()==k){
    solution.add(current);
    return;
  }
  if(index==k)
    return;
    
  Integer x = superSet.get(index);
  current.add(x);
  getSubsets(superSet,k,index+1,current,solution);
  current.remove(x);
  getSubsets(superSet,k,index+1,current,solution);

}
