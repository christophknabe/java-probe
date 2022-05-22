//Tilgung.java
//2005-09-15  Knabe  Monatlicher Tilgungsbetrag, Rechnung, Typ double
//2000-09-20  Knabe  Erstellung

/**Berechnet und protokolliert eine Kredittilgung*/
class Tilgung {


/**Berechnet und protokolliert eine Kredittilgung.
  i_args[0]:  Kreditbetrag in Währungseinheit
  i_args[1]:  Zinssatz per annum in Prozent
  i_args[2]:  Rückzahlung pro Monat in Währungseinheit
*/
public static void main(final String[] i_args) //throws java.io.IOException
{
    final String className = Tilgung.class.getName();
    if(i_args.length<3){
        System.err.println("Benutzung: java " + className + " Kreditbetrag %-JahresZinssatz MonatsRueckzahlungsbetrag");
        System.exit(1);
        return;
    }
    final double kredit = Double.parseDouble(i_args[0]);
    final double zinsProzentPA = Double.parseDouble(i_args[1]);
    final double rückzahlungPM = Double.parseDouble(i_args[2]);
    rückzahlungDrucken(kredit, zinsProzentPA, rückzahlungPM);
}

/**Berechnet und protokolliert eine Kredittilgung.
    @param i_kredit  Kreditbetrag in Währungseinheit
    @param i_zinsProzentPA  Zinssatz per annum in Prozent
    @param i_rückzahlungPM  Rückzahlung pro Monat in Währungseinheit
*/
static void rückzahlungDrucken(
    final double i_kredit, final double i_zinsProzentPA, final double i_rückzahlungPM
)
//throws java.io.IOException
{
  System.out.println("Kredit:\t " + i_kredit);
  System.out.println("Zins:\t " + i_zinsProzentPA + "% p.A.");
  System.out.println("Rueckzahlung:\t " + i_rückzahlungPM + " pro Monat");
  System.out.println("Jahr-Monat\t Zins\t Restschuld");
  final int monateProJahr = 12;
  final double monatsZinsFaktor = i_zinsProzentPA/100/monateProJahr;
  double restschuld = i_kredit;
  for(int lfdMonat=0; restschuld>0; lfdMonat++){
      final double zins = restschuld*monatsZinsFaktor;
      restschuld += zins;
      restschuld -= i_rückzahlungPM;
      final int jahr = lfdMonat/monateProJahr + 1;
      final int monat = lfdMonat%monateProJahr + 1;
      System.out.println(jahr+"-"+monat+"\t " + zins + "\t " + restschuld);
  }
}


}//Tilgung