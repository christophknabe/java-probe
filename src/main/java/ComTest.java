//ComTest.java
//1998-08-24  Knabe  Erstellung

class ComTest {

  public static void main(final String[] i_args)
  throws java.io.IOException
  {
    final java.io.File file = new java.io.File("com2:");
    System.out.println("canRead: " + file.canRead());
    System.out.println("canWrite: " + file.canWrite());
    System.out.println("exists: " + file.exists());
    final java.io.FileOutputStream comOut = new java.io.FileOutputStream(file);
    final java.io.FileDescriptor comFD = comOut.getFD();
    comOut.write("ATH1\r".getBytes()); //klappt
    final java.io.FileInputStream comIn = new java.io.FileInputStream(comFD);
    for(;;){
      System.out.println(comIn.read()); //java.io.IOException: read error
    }
  }


}