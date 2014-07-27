// Find the smallest number E such that E > N 


Psuedocode :

  123456784987654321
  
- Start with a number 
- Start from right to left . Find the first digit where the digit on the left is smaller than the right one.
  12345678 4 987654321 
- Find the smallest higher digit than the number we found 
  12345678 4 987654321
                 ^
- Put that digit before the middle digit we found earlier
  123456785 4 98764321
- Arrange all the numbers after 5 in the ascending order.
 123456785 12346789
- Join the two numbers and you have your E.
  12345678512346789
  
  
  for(int i=arr.length-1;i>0;i--)
    {
      if(arr[i] < arr[i+1])
        digit-left = arr[i];
        index = i;
        break;
    }
    int minToLeft = arr[index+1];
  for(int i = index+1;i<arr.length;i++)
    {
      if(arr[i] < min)
        minToLeft = arr[i];
        minToLeftIndex = i;
    }
  int temp = arr[index];
  arr[index] = minToLeft;
  arr[minToLeftIndex] = temp;
  
  //Sort array after index - arr.length
  
