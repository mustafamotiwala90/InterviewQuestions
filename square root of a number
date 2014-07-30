// calculate the square root of a number

// Square root of a number will always lie between 0 and N/2
// we use binary search. we check if square of N/4 is equal to N. if it is return N/4
// if not then check if it is less than or greater than N/4 and approach ahead

int sqrt(int N)
{

if(n<=0)
  return;
  
if (n ==1)
  return 1;
  
low = 0;
high = n/2;
mid = n/4;

while(low + 1 <=high)
{
  int square = mid * mid;
  if(square == n)
    return mid;
  else if (square < num)
    low = mid + 1;
  else
    high = mid;
}

return low;
}
