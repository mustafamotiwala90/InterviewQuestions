Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


public int wordLadder(String start, String end,HashSet<String> dict) {

  LinkedList<String> wordQueue = new LinkedList<String>();
  LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
  
  wordQueue.add(start);
  distanceQueue.add(1);
  
  while(!wordQueue.isEmpty()) {
  
    String curWord = wordQueue.pop();
    int currentDistance = distanceQueue.pop();
    
    for(int i =0;i<curWord.length;i++) {
      Char[] curWordArr = curWord.toCharArray();
      
      for(char c ='a';c<'z';c++) {
          
        curWordArr[i] = c;
        String temp = new String(curWordArr);
        
        if(dict.contains(temp)) {
          wordQueue.add(temp);
          distanceQueue.add(currentDistance+1);
          dict.remove(curWord);
        }
      
      }
      
    }
    
  
  
  
  }

return distanceQueue.pop();
}
