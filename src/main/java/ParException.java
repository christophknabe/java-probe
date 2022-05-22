//ParException.java: Parameterized Exception

//1999-01-12  Knabe  ???verworfen, da geerbtes m_set() nicht Objekt der erbenden
//                   Klasse liefern kann!
//1999-01-11  Knabe  erstellt
/** 

The usual Java exceptions are
heavy to parameterize, as you have to declare for each parameterized
exception a parameterized constructor, which in turn invokes the 
parameterized constructor of its superclass. e.g.:
  class Overflow extends Exception {
    Overflow(String i_string){super(i_string);}
  }

As it is not possible
to inherit a constructor, we are using a normal, inheritable method in
order to set the message parameters of a ParException. The programmer
inheriting ParException should use m_par in order to do this.
*/

public class ParException extends Exception {
  private StringBuffer parameters;

  /** Adds a message parameter for this exception.
  * You should use it as follows e.g.:
  *   class Overflow extends lib.ParException {}
  *   ...
  *   void machen()throws Overflow {
  *     final int actSize  = ...;
  *     final int maxSize  = ...;
  *     if(actSize>=maxSize){
  *       throw new Overflow().m_par("actSize",actSize).m_par("maxSize",maxSize);
  *     }
  *     ...
  *   }
  */
  public ParException m_par(final String i_name, final int i_value){
    if(parameters==null){parameters = new StringBuffer();}
    parameters.append(i_name + "={" + Integer.toString(i_value) + "}  ");
    return this;
  }

  public String getMessage(){return parameters.toString();}

  public String toString(){
    final String exceptionName = getClass().getName();
    final String message = getMessage();
    return exceptionName + (message==null ? "" : ": " + message);
  }

}

class WertFehler extends ParException {}

class ParExceptionTest {
  public void main(final String[] i_args)throws WertFehler{
    final int actSize = Integer.parseInt(i_args[0]);
    final int maxSize = Integer.parseInt(i_args[1]);
    if(actSize>=maxSize){
      final WertFehler wertFehler = new WertFehler();
      wertFehler.m_par("actSize",actSize).m_par("maxSize",maxSize);
      throw wertFehler;
    }
  }
}
