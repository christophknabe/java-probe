//ThreadTest.java
//1999-01-11  Knabe  Erstellung als Vereinfachung von p. 130 aus Jobst: Programmieren in Java, 2. Auflage

class ZaehlerThread extends Thread {
    public void run(){
        for(int i=0; i<10; i++){
            try{
                sleep( Math.round(2000*Math.random()) );
            }catch(InterruptedException ex){
                //ex.printStackTrace();
                throw new multex.Failure("ZaehlerThread {0} interrupted", ex, this);
            }
            System.out.println(toString() + "  " + i);
        }
    }
}

public class ThreadTest {

  /** startet zwei ZaehlerThread-s */
    public static void main(final String[] i_args){
        new ZaehlerThread().start();
        new ZaehlerThread().start();
    }

}