Counting minimum number of changes required to convert one string to another
For example, the edit distance between "a" and "b" is 1, the edit distance between "abc" and "def" is 3.

For better understanding go here at : http://www.programcreek.com/2013/12/edit-distance-in-java/

public static int minDistanceBetweenStrings(String word1,String word2) {
  
  int[][] dp = new int[word1.length()][word2.length()];
  
  for(int i =0;i<word1.length();i++)
    dp[i][0] = i;

  for(int j=0;j<word2.length();j++)
    dp[0][j] = j;

  for(int i = 0;i<word1.length();i++) {
    char c1 = word1.charAt(i);
    
    for(int j = 0;j<word2.length();j++) {
      char c2 = word2.charAt(j);
      if(c1==c2)
        dp[i+1][j+1] = dp[i][j];
      else {
        int replace = dp[i][j] + 1;
        int insert = dp[i+1][j] + 1;
        int delete dp[i][j+1] + 1;
        int min = replace > insert ? insert : replace;
        dp[i+1][j+1] = min > delete ? delete : min;
        
      }
    
    }
    return dp[word1.length()][word2.length()];
  }

}
