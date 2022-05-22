//ErrorInInitializerTest.java
//2005-08-19  Knabe  Erstellung

public class Initializer2StaticFail {

	public static void main(final String[] i_args )
	{
		try{
			//Ausnahmen der static-Initialisierer einer Klasse werden bei
			//ihrem Laden geworfen:
			final Class dummy = Abgeleitet.class;
		}catch(final ExceptionInInitializerError ex){
			System.err.println("Fehler beim Hochfahren des Systems:");
			ex.printStackTrace();
			System.exit(-1);
		}
	}//main

}//Initializer2StaticFail

class Initializer2Base {
  static {
    System.out.println("className="+ Initializer2Base.class.getName());
  }
}

class Abgeleitet extends Initializer2Base {
    static { //Muster zur Formulierung eines statischen init-Blocks:
        //Ausnahmen immer propagieren, nie abfangen!
	    try{
			final String className = Abgeleitet.class.getName();
			System.out.println("className="+className);
			final Integer dummy = new Integer(className);
        }catch(Exception ex){
			throw new RuntimeException("Cannot initialize class Abgeleitet", ex);
        };
    }
}

/*Ausführung ergibt folgende Ausgabe:

className=Initializer1Base
className=Abgeleitet
Fehler beim Hochfahren des Systems:
java.lang.ExceptionInInitializerError
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Class.java:141)
        at Initializer2StaticFail.class$(Initializer2StaticFail.java:11)
        at Initializer2StaticFail.main(Initializer2StaticFail.java:11)
Caused by: java.lang.RuntimeException: Cannot initialize class
        at Abgeleitet.<clinit>(Initializer2StaticFail.java:35)
        ... 4 more
Caused by: java.lang.NumberFormatException: For input string: "Abgeleitet"
        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:48)
        at java.lang.Integer.parseInt(Integer.java:468)
        at java.lang.Integer.<init>(Integer.java:609)
        at Abgeleitet.<clinit>(Initializer2StaticFail.java:33)
        ... 4 more
*/
