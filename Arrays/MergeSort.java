

void doMergeSort(int low,int high) {
  
  if(low < high)
  {
      int middle = low + (high-low)/2;
      
      doMergeSort(low,middle);
      
      doMergeSort(middle+1,high);
      
      merge(low,middle,high);
  }

}

void merge(int lowerIndex, int middle, int highIndex)
{
  for(int i = lowerIndex;i <= highIndex; i++)
    tempArray[i] = arr[i];

    int i = lowerIndex;
    int j = middle + 1;
    int k = lowerIndex;

    while(i<=middle && j<=highIndex)
    {
      if(tempArray[i] <= tempArray[j]) {
        array[k] = tempArray[i];
        i++;
      }
      else {
        array[k] = tempArray[j];
        j++;
      }
      k++;
    }
    
    while(i<=middle) {
      array[k] = tempArray[i];
      i++;
      k++;
    }
}
