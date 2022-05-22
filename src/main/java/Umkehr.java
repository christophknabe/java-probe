//Umnkehr.java
//1999-10-05  Knabe  Erstellung
/**Zweck: Umgekehrte Ausgabe der Kommandozeilenargumente, Demo für das Java
Collections Framework.
*/
class Umkehr {
  public static void main(final String[] i_args)
  //Kommandoargumente umgekehrt ausgeben
  {
    final java.util.List list = java.util.Arrays.asList(i_args);
    System.out.println(list);
    java.util.Collections.reverse(list);
    System.out.println(list);
  }
}