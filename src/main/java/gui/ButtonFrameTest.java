package gui;
//ButtonFrameTest.java
//2009-05-29  Knabe  umgestellt auf Swing
//1999-03-22  Knabe  erstellt

public class ButtonFrameTest {

	/**Effekt: Erstellt einen Swing-Frame mit einem Button in absoluter Position */
	public static void main(final String[] i_args){
		new ButtonFrameTest();
	}

	private ButtonFrameTest(){
		//Aufbau:

		final javax.swing.JFrame frame = new javax.swing.JFrame("Frame mit sensitivem Button");
		//ohne setSize erscheint der Frame zunaechst in Minimalgroesze, 
		//ist aber durch Mausbewegung in der Groesze aenderbar:
		frame.setSize(300,200);

		//ohne setLocation() erscheint der Frame in der linken oberen Bildschirmecke
		frame.setLocation(100,200);
		
		final java.awt.Container cp = frame.getContentPane();
		cp.setLayout(null);

		final javax.swing.JButton button = new javax.swing.JButton("Button");
		button.setBounds(100,50,60,30);
		//                x, y, b, h

		cp.add(button);

		//Verhalten:

		button.addActionListener( new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent ev){
				System.out.println("Button pressed");
			}
		});

		frame.addWindowListener( new java.awt.event.WindowAdapter(){
			@Override public void windowClosing(final java.awt.event.WindowEvent ev){
				System.exit(0);
			}
		});
		frame.setVisible(true);

	}//constructor

}//ButtonFrameTest