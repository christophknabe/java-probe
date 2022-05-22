//ThrowableTest.java:
//2000-07-09  Knabe  erstellt


class PrintFile {

/** Zeigt den Inhalt der als Kommandoargument 0 angegebenen Textdatei an.
*/
static public void main(final String[] i_args) throws java.io.IOException
{
  final java.io.BufferedReader in
    = new java.io.BufferedReader(new java.io.FileReader(i_args[0]));
  for(;;){
    final String zeile = in.readLine();
    if(zeile==null){break;}
    System.out.println(zeile);
  }
}


}//PrintFile