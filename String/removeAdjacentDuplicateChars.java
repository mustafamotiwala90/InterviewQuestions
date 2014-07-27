//Remove adjacent duplicate chars 


public static String removeDuplicate(String s) {
    StringBuilder builder = new StringBuilder();
    char lastchar = '\0';
    
    for (int i = 0; i < s.length(); i++) {
        String str = builder.toString();
        if (!str.equals("") && (str.charAt(str.length() - 1) == s.charAt(i))) {
            builder.deleteCharAt(str.length() - 1);
        } else if (s.charAt(i) != lastchar)
            builder.append(s.charAt(i));
    
        lastchar = s.charAt(i);
    }
    return builder.toString();
}
