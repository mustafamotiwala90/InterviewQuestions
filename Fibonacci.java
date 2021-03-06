// Fibonacci Series with Recursion

int fib(int n)
{
  if(n<=1)
    return n;
  else
    return fib(n-1) + fib(n-2);
}

// Non-Recursive Backtracking implementation

int fib(int n) {

  if(n<=1)
    return n;
  
  int fibo = 1;
  int fiboPrev = 1;
  for(int i = 2;i < n;i++)
  {
    int temp = fibo;
    fibo = fibo + fiboPrev;
    fiboPrev = temp;
  }
return fibo;
}
