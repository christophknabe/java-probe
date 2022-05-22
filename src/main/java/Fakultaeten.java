public class Fakultaeten {

  public static void main( String arg[] ) throws Throwable {
    System.out.println("n   fak[n]");
    long fak = 1;
    for(int n=1;;n++){
           System.out.print(n + " ");
           fak *= n;
           System.out.println(fak);
    }
  }
}
