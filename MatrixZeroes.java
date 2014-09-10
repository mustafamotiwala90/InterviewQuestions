Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

public class Solution(){
  
  public setZeroes(int [][]matrix) {
    boolean firstRow = false;
    boolean firstColumn = false;
    
    for(int i=0;i<matrix.length;i++)
    {
      if(matrix[i][0]==0)
        firstRow=true;
      break;
    }
    
    for(int i=0;i<matrix.length;i++)
    {
      if(matrix[0][i]==0)
        firstColumn=true;
      break;
    }
  
    for(i=1;i<matrix.length;i++) {
      for(j=1;j<matrix.length;j++) {
          if(matrix[i][j]==0) {
            matrix[i][0] = 0;
            matrix[j][0] = 0;
          }
      }
    }
    
    for(i=1;i<matrix.length;i++) {
      for(j=1;j<matrix.length;j++) {
        if(matrix[i][0]==0) || matrix[0][j]==0) {
          matrix[i][j]=0;
        }
      }
    }
    
    //set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
 
        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
  }

}
