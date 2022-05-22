package schmied;

class Tabelle {	
    public void eintragen(int zeile, int spalte, String text) {System.out.println(zeile + "," + spalte + ": " + text);}
    public String lesen(int zeile, int spalte) {return zeile + "," + spalte;}
    public void loeschen (int zeile, int spalte){System.out.println(zeile + "," + spalte);}
}
class Spezialtabelle extends Tabelle {  
    public void eintragen(int zeile, int spalte, String text) {System.out.println("Spezial: " + zeile + "," + spalte + ": " + text);}
	public void eintragen(int a, int b, Object c) {System.out.println(a + "," + b + ": " + c);}
}

public class TabelleMain {

	public static void main(String[] args) {
		final Spezialtabelle spezialtabelle = new Spezialtabelle();
        final Tabelle tabelle = spezialtabelle;
        tabelle.eintragen(1,2, "String");
        spezialtabelle.eintragen(3,4, new StringBuilder("StringBuilder"));
	}

}
