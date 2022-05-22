package socketComm;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.*;
public class JavaServer1{
    public static void main(String[] args) throws IOException{

        final ServerSocket serverSocket = new ServerSocket(8080);
        while(true){
            System.out.println("Server lauscht..." );
            final Socket socket = serverSocket.accept(); //blockierender Aufruf
            System.out.println("Client hat sich verbunden." );
            //Empfang des Datenstroms vom Client
            final InputStreamReader portLeser = new InputStreamReader(socket.getInputStream());
            //Aus binärem Format in Zeilengegliedertes Zeichenformat umwandeln
            final BufferedReader eingabe = new BufferedReader(portLeser);
            //Lesen, was vom Client über den Socket kommt
            final String str = eingabe.readLine();
            System.out.println("Client sagt: " + str);
            socket.close();
        }
    }
}
