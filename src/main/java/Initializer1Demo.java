//InitializerTest.java
//2000-06-27  Knabe  Erstellung

public class Initializer1Demo {

    public static void main(final String[] i_args )
    {
    }//main
    
    private class _Abgeleitet extends Initializer1Base {}

}//Initializer1Demo

class Initializer1Base {
    {
        final String className = getClass().getName();
        System.out.println("className="+className);
    }
}
