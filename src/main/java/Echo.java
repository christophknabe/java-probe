//Echo.java
//1998-03-10  Knabe  Erstellung
class Echo {
  public static void main(final String[] i_args)
  //Effekt: Gibt die uebergebenen Kommandoargumente durch Zwischenraum getrennt 
  //        aus.
  {
    for(int i=0; i<i_args.length; i++){
      System.out.print( (i==0?"":" ") + i_args[i] );
    }
  }
}