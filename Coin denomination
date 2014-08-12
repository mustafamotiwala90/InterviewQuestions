// Problem Statement: You are given n types of coin denominations of values d1 < d2 < ... < dn (all integers).
// Give an algorithm which makes change for an amount of money C with as few coins as possible.

int arr[] = {1, 2, 3};
coins(arr, 6);

int coins(int arr[],int sum)
{
  int min[] = new int[1000];
  min[0]=0;
  
  for(int i=0;i<sum;i++)
    min[i] = 9999;
    
  for(int j=0;j<arr.length;j++)
    min[arr[j]]=1;

  for(int k=0;k<sum;k++)
  {
    for(int m = 0;m<arr.length;m++)
    {
      
      int index = k - arr[m];
      
      if(index<0) {
        continue;
      }
      
      if(min[index]+1<min[k]) {
        min[k] = min[index]+1;
      }
       
    }
  }
  
  return min[sum];
  
}
