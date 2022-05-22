//VectorTest.java: Test Klasse java.util.Vector
//1998-10-08  Knabe  erstellt

public class VectorTest {
  private static void print(final java.util.Vector i_vector){
    for(int i=0; i<i_vector.size(); i++){
      System.out.println( "Vector["+i+"] = " + i_vector.elementAt(i) );
    }
  }

  /** Testet die Vector-Zugriffe. */

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
    print(vector);
    System.out.println("vector.toString()=" + vector.toString());
    vector.removeElementAt(10);
    print(vector);
  }


}; //class VectorTest
