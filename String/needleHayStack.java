// Implementation of the StrStr() function or the Needle in a haystack problem

public String needleHayStack(String needle,String haystack) {

  int needleLength = needle.length();
  int haystackLength = haystack.length();
  
  if(needleLength==haystackLength && needleLength==0)
    return "";
  
  if(needleLength==0)
    return haystack;
    
  for(int i =0;i<haystackLengh;i++){
  
    if(needleLengh > haystackLength - i + 1)
      return null;
  
    int j = 0;
    int k = i;
    
    while(j<needleLength && k <haystackLength && needle.charAt(j)==haystack.charAt(k)){
      j++;
      k++;
      if(j==needleLength)
        return haystack.substring(i);
    }
  
  }

return null;
}
