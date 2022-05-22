//CharLoop.java: Ausgeben eines Schachbrettmusters
//1999-11-12  Knabe  erstellt


class CharLoop {

/** Gibt ein Schachbrett mit den Namen seiner Felder aus
*/
static public void main(final String[] i_args) //throws java.io.IOException
{
  for(char zeile='A'; zeile<='H'; zeile++){
    for(int spalte=1; spalte<=8; spalte++){
      System.out.print(" "+zeile+spalte);
    }
    System.out.println();
  }
}//main


} //CharLoop
