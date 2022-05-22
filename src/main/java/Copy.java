//Copy.java
//1998-12-14  Knabe  Umbau zu binaer Kopieren
//1998-03-10  Knabe  Erstellung als Cat
class Copy {
  public static void main(final String[] i_args) throws java.io.IOException
  //Effekt: Kopiert Datei i_args[0] binär nach Datei i_args[1].
  {
    kopieren(i_args[0], i_args[1]);
  }

  static void kopieren(final String i_inFileName, final String i_outFileName) 
  throws java.io.IOException 
  //Effekt: Kopiert Datei namens i_inFileName binär nach Datei i_outFileName.
  { 
    final java.io.FileInputStream inStream 
    = new java.io.FileInputStream(i_inFileName);
    final java.io.FileOutputStream outStream 
    = new java.io.FileOutputStream(i_outFileName);
    final byte[] buf = new byte[512];
    
    for(;;){
      final int len = inStream.read(buf);
      if(len<=0){break;}
      outStream.write(buf,0,len);
    }
    inStream.close();
    outStream.close();
  }
}