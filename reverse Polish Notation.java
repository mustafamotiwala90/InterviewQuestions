 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6   
  
  
  public int evalRPN(String[] tokens) {
  
  int returnValue = 0;
  String operators = "+-*/";
  
  Stack<String> value = new Stack<String>();
  for(String token : tokens){
    if(operators.contains(token){
      int index = operators.indexOf(token);
      int a = Integer.valueOf(value.pop());
      int b = Integer.valueOf(value.pop());
      switch(index) {
      case 0:
        value.push(String.valueOf(a+b));
        break;
      case 1:
        value.push(String.valueOf(b-a));
        break;
      case 2:
        value.push(String.valueOf(a*b));
        break;
      case 3:
        value.push(String.valueOf(b/a));
        break;
      default:
        break;
      }
    }
    else
      value.push(token);
  
  }
  returnValue = Integer.valueOf(value.pop());
  return returnValue;
  }
