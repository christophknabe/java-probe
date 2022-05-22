import java.util.NoSuchElementException;
import java.util.Scanner;

//IntSort.java: Demo Sortieren der Eingabezahlen bis EoF
//1998-03-24  Knabe  Erstellung

public class IntSort {

  public static void tauschen(int[] io_tabelle, final int i_i, final int i_j){
    final int hilf = io_tabelle[i_i];
    io_tabelle[i_i] = io_tabelle[i_j];
    io_tabelle[i_j] = hilf;
  }

  public static void main( String[] i_args ) throws Exception
  {
    final int[] tabelle = new int[10];
    int fuellstand = 0;
    final Scanner scanner = new Scanner(System.in);

    //Einlesen:
    for(fuellstand=0; ; fuellstand++){
      final int zahl;
      try{zahl = scanner.nextInt();}
      catch(NoSuchElementException e){break;}
      tabelle[fuellstand] = zahl;
    }

    //Sortieren: 
    for(int i=0; i<fuellstand-1; i++){
      for(int j=i+1; j<fuellstand; j++){
        if(tabelle[i]>tabelle[j]){ //tauschen
          tauschen(tabelle, i, j);
        }
      }
    }

    //Ausgeben:
    for(int i=0; i<fuellstand; i++){
      System.out.println(tabelle[i]);
    }
  }

}
