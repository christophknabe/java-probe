//Tilgung.java
//2005-09-15  Knabe  Monatlicher Tilgungsbetrag, Rechnung, Typ double
//2000-09-20  Knabe  Erstellung

/**Berechnet und protokolliert eine Kredittilgung*/
class Tilgung {


/**Berechnet und protokolliert eine Kredittilgung.
  i_args[0]:  Kreditbetrag in W�hrungseinheit
  i_args[1]:  Zinssatz per annum in Prozent
  i_args[2]:  R�ckzahlung pro Monat in W�hrungseinheit
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
    final double r�ckzahlungPM = Double.parseDouble(i_args[2]);
    r�ckzahlungDrucken(kredit, zinsProzentPA, r�ckzahlungPM);
}

/**Berechnet und protokolliert eine Kredittilgung.
    @param i_kredit  Kreditbetrag in W�hrungseinheit
    @param i_zinsProzentPA  Zinssatz per annum in Prozent
    @param i_r�ckzahlungPM  R�ckzahlung pro Monat in W�hrungseinheit
*/
static void r�ckzahlungDrucken(
    final double i_kredit, final double i_zinsProzentPA, final double i_r�ckzahlungPM
)
//throws java.io.IOException
{
  System.out.println("Kredit:\t " + i_kredit);
  System.out.println("Zins:\t " + i_zinsProzentPA + "% p.A.");
  System.out.println("Rueckzahlung:\t " + i_r�ckzahlungPM + " pro Monat");
  System.out.println("Jahr-Monat\t Zins\t Restschuld");
  final int monateProJahr = 12;
  final double monatsZinsFaktor = i_zinsProzentPA/100/monateProJahr;
  double restschuld = i_kredit;
  for(int lfdMonat=0; restschuld>0; lfdMonat++){
      final double zins = restschuld*monatsZinsFaktor;
      restschuld += zins;
      restschuld -= i_r�ckzahlungPM;
      final int jahr = lfdMonat/monateProJahr + 1;
      final int monat = lfdMonat%monateProJahr + 1;
      System.out.println(jahr+"-"+monat+"\t " + zins + "\t " + restschuld);
  }
}


}//Tilgung