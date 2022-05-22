/**Gibt eine Potenzreihe aus.*/
public class PotenzReihe {

  public static void main( String arg[] ) throws Throwable {
    new PotenzReihe().execute();
  }

  public void execute() throws Exception {
		int sum = 0;
        if (sum==0) throw new Exception("My Exception");
		for(int n=1;;){
           n = 2*n + 1;
           System.out.print( String.valueOf(n) + "  " );
    		System.out.flush();
    	}
  }

}
