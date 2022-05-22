package socketComm;

import java.io.*;
import java.net.*;


public class JavaClient{
    public static void main(final String[] args) throws IOException, UnknownHostException{

        final Socket clientSocket =  new Socket("localhost", 8080); //blockierend?
        System.out.println("Client hat sich mit Server verbunden.");
        //OutputStream - Klasse, die Möglichkeit bietet etwas auszugeben
        final OutputStream outputStream = clientSocket.getOutputStream();
        //PrintWriter - Klasse, die Daten ausgibt
        final PrintWriter ausgabe = new PrintWriter(outputStream, true);
        ausgabe.println("Guten Tag und viel Spass!");
        outputStream.close();
        clientSocket.close();
    }
}
