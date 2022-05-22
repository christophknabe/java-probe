//Ck.java:
//2001-02-28  Knabe  erstellt


class ListFontFamilies {

/** Listet die Fonts
*/
static public void main(final String[] i_args)
{
  final java.awt.GraphicsEnvironment ge
  = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
  final String[] names = ge.getAvailableFontFamilyNames();
  System.out.println("AvailableFontFamilyNames:");
  for(final var fontFamily: names){
    System.out.println(fontFamily);
  }
}


} //class Ck
