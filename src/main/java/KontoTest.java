//KontoTest.java
//1999-06-17  Knabe  Erstellung

/**Zweck: Verwaltung eines Feldes von Konten.
* Demonstriert die Benutzung von static-Komponenten für die objektübergreifende
* Verwaltung.
*/
class Konto {
  //-----klassenbezogene (static) Komponenten von Konto:

  private static int _letzteKontoNr = 0;

  /**Alle Konten: Index diene als Kontonummer, 0 soll frei bleiben*/
  public static Konto[] konten = new Konto[100];

  public static void printAll(){
    System.out.println("KontoNr   Guthaben[Pf]");
    for(int i=1; i<=_letzteKontoNr; i++){
      System.out.println(i + "         " + konten[i]._guthabenPf);
    }
  }

  //-----objektbezogene (ohne static) Komponenten von Konto:

  private int _guthabenPf = 0; //Pfennige

  public Konto(){
    konten[++_letzteKontoNr] = this; //Selbstregistrierung
  }
  public void überweisen(final int i_betragPf, final int i_aufKontoNr){
    _guthabenPf -= i_betragPf;
    konten[i_aufKontoNr]._guthabenPf += i_betragPf;
  }
  public int guthabenPf(){return _guthabenPf;}
}//Konto

class KontoTest {
  public static void main(final String[] i_args)throws Exception{
    new Konto(); //1
    new Konto(); //2
    new Konto(); //3
    Konto.konten[1].überweisen(19800,2);
    Konto.konten[1].überweisen(14998,3);
    Konto.printAll();
    System.in.read();
  }
}//KontoTest

/* gibt aus:
KontoNr   Guthaben[Pf]
1         -34798
2         19800
3         14998
*/
