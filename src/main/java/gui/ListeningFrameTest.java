package gui;
//ListeningFrameTest.java: Test Frame mit Abbruch-Listener
//1998-05-29  Knabe  erstellt

public class ListeningFrameTest {


public static void main(final String[] i_args)throws Exception{
  final java.awt.Frame frame 
    = new java.awt.Frame("Das ist ein Rahmen mit Listener für WindowClosing");

  frame.setSize(new java.awt.Dimension(300,200));
  //ohne setSize erscheint der Frame zunaechst in Minimalgroesze, 
  //ist aber durch Mausbewegung in der Groesze aenderbar.

  frame.setLocation(100,200);
  //ohne setLocation() erscheint der Frame in der linken oberen Bildschirmecke

  frame.addWindowListener(
    new java.awt.event.WindowAdapter(){
      public void windowClosing(final java.awt.event.WindowEvent e){
        System.exit(0); //beendet die gesamte Applikation
      }
      public void windowActivated(final java.awt.event.WindowEvent e){
        System.out.println("Frame activated.");
      }
    }
  );
  
  frame.show(); //ohne show() erscheint der Frame nicht!
}


}; //class 
