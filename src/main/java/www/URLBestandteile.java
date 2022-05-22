package www;

import java.net.URL;
public class URLBestandteile
{
    public static void main(String[] args) throws Exception {
        URL url = new URL(
                "http://www.goethe-oberschule-berlin.de/" +
                        "286-0-Informatik+AG.html"
        );
        System.out.println("Bestandteile meiner URL:");
        System.out.println("Protokoll = " + url.getProtocol());
    }
}
