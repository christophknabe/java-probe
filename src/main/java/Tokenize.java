//Tokenize.java: Zerlegung der Standardeingabe in Wörter
//1998-10-08  Knabe  Erstellung

class Tokenize {

  public static java.io.BufferedReader in 
    = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

  public static void main(final String[] i_args) throws java.io.IOException
  {
    for(;;){
      final String lineString = in.readLine();
      if(lineString==null){break;}
      final java.util.StringTokenizer st 
      = new java.util.StringTokenizer(lineString," \t\r\n{}[]().,;:+-*/=\"?");
      while (st.hasMoreTokens()) {
        System.out.println(st.nextToken());
      }//while token
    }//for line
  }//main

}//class Tokenize