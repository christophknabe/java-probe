//ZeichMul.java: Zeichenmultiplikation
//1999-12-14  Knabe  erstellt


class ZeichMul {


  /**Result: String der L�nge i_l�nge, der nur aus Zeichen i_zeichen besteht
  */
  public static String multi(final char i_zeichen, final int i_l�nge){
    final char inhalt[] = new char[i_l�nge];
    for(int i=0; i<i_l�nge; i++){
      inhalt[i] = i_zeichen;
    }
    return new String(inhalt);
  }

  public static void main(final String[] i_args)
  {
    final char zeichen = i_args[0].charAt(0);
    final int  l�nge   = Integer.parseInt(i_args[1]);
    final String ergebnis = multi(zeichen,l�nge);
    System.out.println("zeichen = '" + zeichen + "', l�nge = " + l�nge + ":");
    System.out.println('"' + ergebnis + '"');
  }//main


} //ZeichMul
