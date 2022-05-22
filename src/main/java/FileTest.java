import java.io.File;

//FileTest.java: Test Klasse File
//1998-10-08  Knabe  erstellt

public class FileTest {

  /** Testet die Directory-Listing-Zugriffe. */

  public static void main(final String[] i_args)
  throws java.io.IOException
  {
    final java.io.File directory = new java.io.File(".");
    System.out.println( "Directory " + directory.getCanonicalPath() );
    final String[] list = directory.list();
    final java.util.Vector vector = new java.util.Vector(list.length);
    for(int i=0; i<list.length; i++){
      vector.addElement(list[i]); //verallgemeinert String -> Object
    }
    for(
      final java.util.Enumeration enumeration = vector.elements();
      enumeration.hasMoreElements();
    ){
      System.out.println( "  " + enumeration.nextElement() );
    }
  }


}; //class FileTest
