1
11
21
1211
111221
312211
13112221
1113213211
31131211131221
13211311123113112211



String lookAndSay(String number) {
  
  StringBuilder builder = new StringBuilder();
  String repeat = number.charAt(0);  
  number = number.substring(1) + " ";
  int times = 1;
  
  for(char actual:number.toCharArrray()) {
  if(repeat!=actual) {
    builder.append(times + " " + repeat);
    times=1;
    repeat = actual;
  }else
    times +=1;

  }
  return builder.toString();
}


void main()

String num = "1";
for(int i =0;i<10;i++){
  System.out.println(num);
  num = lookAndSay(num);
}
