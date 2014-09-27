int longest(int[] arr) {
  
  int lis[] = new int[];
  lis[0] = 1;
  
  for(i=1;i<arr.length;i++)
    lis[i] = 1 + maximum(lis,i);

}

int maximum(int[] lis,int end){
  
  for(int i=0;i<end;i++)
  {
    if(arr[i]<arr[end] && lis[i]>lis[end])
      lis[end]=lis[i];
  }

  return lis[end];
}
