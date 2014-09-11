[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

Find minimum path from top element to the bottom most one .
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Solution : Use dynamic programming to go from bottom to up to find the minimum path


public int minimumSum(ArrayList<ArrayList<Integer>> triangle) {
  
  int l = triangle.size()-1;
  int[] total = new int[triangle.get(l).size()]
    
  for(int i=0;i<triangle.get(l).size()-1;i++)
    total[i] = triangle.get(l).get(i);
    
  
  for(i=l-1;i>0;i--) {
    for(j = 0;j<triangle.get(i+1).size()-1;j++) {
      total[j] = triangle.get(i).get(j) + Math.min(total[j],total[j+1]);
    }
  }

  return total[0];

}
