import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import multex.Failure;
import static multex.MultexUtil.create;

//CopyFiles.java
//2007-09-17  Knabe  Hervorgegangen aus FileTest.java
//1998-10-08  Knabe  erstellt

public class CopyFiles {

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
  
    /**Copies all files from directory sourceDir to directory destDir.*/
    public static void copyFiles1(final File sourceDir, final File destDir){
        try {
            final File[] files = sourceDir.listFiles();
            for(final File file: files){
                copyOneFile(file, destDir);
            }
        } catch (Exception e) {
            throw create(CopyFilesFailure1.class, sourceDir, destDir);
        }
    }
    
    /**Failure copying files from directory {0} to directory {1}*/
    public static final class CopyFilesFailure1 extends Failure {}
    

    
    /**Copies all files from directory sourceDir to directory destDir.*/
    public static void copyFiles2(final File sourceDir, final File destDir){
        final Collection<Object> parameters = new ArrayList<Object>();
        parameters.add(sourceDir);
        parameters.add(destDir);
        final File[] files = sourceDir.listFiles();
        for(final File file: files){
            try {
                copyOneFile(file, destDir);
            } catch (Exception e) {
                parameters.add(e);
            }
        }
        if (parameters.size()>=2) {
            throw new CopyFilesFailure2(parameters);
        }        
    }
    
    /**Failure copying files from directory {0} to directory {1}*/
    public static final class CopyFilesFailure2 extends Failure {
        public CopyFilesFailure2(Collection i_parameters) {
            super((String)null, i_parameters);
        }
    }

    private static void copyOneFile(File file, File destDir) throws IOException {
    }


}; //class FileTest
