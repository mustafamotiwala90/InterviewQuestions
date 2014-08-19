// AirBnb Regex Parser

f(a*b, acb) => true 
f(abc*, abbc) => false 
f(**bc, bc) => true


boolean regexParser(String str1,String str2)
{
  int j;
    for(int i = 0;i<str1.length();i++)
    {
      for(int j = 0;j<str2.length();j++)
      {
          if(i+j >= str1.length())
            return false;
          if(str1[i+j] != str2[j] && str2[j]!='*')
            break;
      }
        if(j>=str2.length())
          return true;
    }
}
