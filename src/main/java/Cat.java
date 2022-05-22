//Cat.java
//1998-03-10  Knabe  Erstellung
class Cat {
  public static void main(final String[] i_args) throws NrOfLinesException
  //Effekt: Gibt die Konkatenation der als Kommandoargumente abgegebenen 
  //        Dateien aus.
  {
    for(int i=0; i<i_args.length; i++){
      System.out.print(i_args[i] + "   ");
      System.out.println(nrOfLines(i_args[i]));
    }
  }

  static class NrOfLinesException extends Exception{}

  static int nrOfLines(final String i_fileName) 
  throws NrOfLinesException 
  //Result: Number of text lines in the file named i_fileName
  { 
    try{
      final java.io.FileReader inFile = new java.io.FileReader( i_fileName );
      final java.io.BufferedReader
        in = new java.io.BufferedReader( inFile )
      ;
      for(int i=0; ; i++){
        final String zeile = in.readLine();
        if(zeile==null){return i;}
      }
    }catch(java.io.IOException e){
      e.printStackTrace();
      System.err.print("rethrown as: ");
      throw new NrOfLinesException();
    }
  }
}