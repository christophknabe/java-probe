//StdIn.java: Formatted Standard Input (usually from keyboard)
//1998-03-24  Knabe  Erstellung

class StdIn {

public static java.io.BufferedReader in 
  = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

/** getInt()
Effekt: liest von der Standardeingabe eine Zeile, interpretiert diese als
        Ganzzahlliteral und liefert dessen Wert.
        */
public static int getInt() throws java.io.IOException
{
  return Integer.parseInt( in.readLine() );
}

};