//ZeichMul.java: Zeichenmultiplikation
//1999-12-14  Knabe  erstellt


class ZeichMul {


  /**Result: String der Länge i_länge, der nur aus Zeichen i_zeichen besteht
  */
  public static String multi(final char i_zeichen, final int i_länge){
    final char inhalt[] = new char[i_länge];
    for(int i=0; i<i_länge; i++){
      inhalt[i] = i_zeichen;
    }
    return new String(inhalt);
  }

  public static void main(final String[] i_args)
  {
    final char zeichen = i_args[0].charAt(0);
    final int  länge   = Integer.parseInt(i_args[1]);
    final String ergebnis = multi(zeichen,länge);
    System.out.println("zeichen = '" + zeichen + "', länge = " + länge + ":");
    System.out.println('"' + ergebnis + '"');
  }//main


} //ZeichMul
