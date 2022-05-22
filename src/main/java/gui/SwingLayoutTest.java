package gui;
//SwingLayoutTest.java

//2009-05-29  Knabe  Umstellung von AWT nach Swing
//1999-11-30  Knabe  Erstellung

class GridLayoutTest {

	public static void main(final String[] i_args){
		final javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setSize(300,100);
		final java.awt.Container cp = frame.getContentPane();
		cp.setLayout(new java.awt.GridLayout(3,2)); //zeilen,spalten
		cp.add(new java.awt.Label("Name:"));
		cp.add(new java.awt.TextField("Müller"));
		cp.add(new java.awt.Label("Vorname:"));
		cp.add(new java.awt.TextField("Manfred"));
		cp.add(new java.awt.Label("Geburtsdatum:"));
		cp.add(new java.awt.TextField("14.12.1963"));
		frame.setVisible(true);
	}

}//GridLayoutTest


class MixedLayoutTest {

	public static void main(final String[] i_args){
		final javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.setSize(300,140);
		final java.awt.Container cp = frame.getContentPane();
		//cp hat BorderLayout
		
		final javax.swing.JPanel dataPanel = new javax.swing.JPanel();
		dataPanel.setLayout(new java.awt.GridLayout(3,2)); //zeilen,spalten
		
		dataPanel.add(new java.awt.Label("Name:"));
		dataPanel.add(new java.awt.TextField("Müller"));
		dataPanel.add(new java.awt.Label("Vorname:"));
		dataPanel.add(new java.awt.TextField("Manfred"));
		dataPanel.add(new java.awt.Label("Geburtsdatum:"));
		dataPanel.add(new java.awt.TextField("14.12.1963"));

		cp.add(dataPanel, java.awt.BorderLayout.CENTER);

		final javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		//buttonPanel hat FlowLayout
		buttonPanel.add(new java.awt.Button("Eintragen"));
		buttonPanel.add(new java.awt.Button("Ändern"));
		buttonPanel.add(new java.awt.Button("Löschen"));

		cp.add(buttonPanel, java.awt.BorderLayout.PAGE_END);

		frame.setVisible(true);
	}

}//MixedLayoutTest