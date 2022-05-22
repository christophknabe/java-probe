//JavaVersionTest.java

//2002-04-20  Knabe  Test, ob Throwable.getCause() aufrufbar
//2000-06-22  Knabe  Erstellung als ReflectFieldsTest

class JavaVersionTest {


public static void main(final String[] i_args) throws NoSuchMethodException {
    final String version = System.getProperty("java.version");
    System.out.println("Our Java Runtime Environment version is:" + version);
    final boolean from1_4 = version.compareTo("1.4") >= 0;
    System.out.println("It is " + (from1_4?"from":"before") + " JDK 1.4");
}


}//JavaVersionTest.java