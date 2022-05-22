package gui;
//FrameTest.java: Test stummer Frame
//2009-05-29  Knabe  umgestellt nach Swing
//1998-05-29  Knabe  erstellt

public class FrameTest {


	public static void main(final String[] args)throws Exception{
		final javax.swing.JFrame frame 
		= new javax.swing.JFrame("Das ist ein Rahmen ohne Listener");
		//Dieser Rahmen kann nur im Kommandofenster durch <Ctrl/C> beendet werden.

		//ohne setSize erscheint der Frame zunaechst in Minimalgroesze, 
		//ist aber durch Mausbewegung in der Groesze aenderbar:
		frame.setSize(new java.awt.Dimension(300,200));

		//ohne setLocation() erscheint der Frame in der linken oberen Bildschirmecke:
		frame.setLocation(100,200);
		 
		//ohne setVisible(true) erscheint der Frame nicht!
		frame.setVisible(true);
	}


}; //class 
