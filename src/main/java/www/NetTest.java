package www;
//NetTest.java

//1999-11-29  Knabe  Erstellung

/**Lädt die als Kommandoargument angegebene URL*/
class NetTest {
  public static void main(final String[] i_args) throws Exception {
    final String urlString = i_args[0];
    System.err.println("urlString = " + urlString);
    final java.net.URL url = new java.net.URL(urlString);
    System.err.println("url = " + url);
    final java.net.URLConnection conn = url.openConnection();
    final java.io.InputStream inputStream = conn.getInputStream();
    final java.io.BufferedReader in
    = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
    for(;;){
      final String zeile = in.readLine();
      if(zeile==null){break;}
      System.out.println(zeile);
    }
  }
}