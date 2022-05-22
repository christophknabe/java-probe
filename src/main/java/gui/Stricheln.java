package gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Stricheln.java: Test Maus-Listener: ähnlich Scribble
//2009-05-29  Knabe  Umgestellt auf Swing mit _Canvas als durchscheinende JComponent
//1999-12-23  Knabe  Absichern gegen Zusammenfassung mehrerer update()-Aufrufe durch ein repaint()
//1999-12-21  Knabe  erstellt

/*Aufgabe: Schreiben Sie ein Java-Programm, mit welchem man durch Mausbewegung
  bei gedrückter Maustaste zeichnen kann.
 */
/**Ermöglicht Zeichnen bei gedrückter Maustaste.
  Vereinfachung gegenüber dem klassischen Scribble, indem die Zeichnung nicht
  gespeichert wird, sondern durch Redefinition von JComponent.paintComponent(Graphics)
  bei Einstellung der Property opaque auf true immer nur der letzte Strich in die
  bestehende Zeichnung hineingezeichnet wird. Dadurch geht jedoch bei Größenänderung
  oder Refresh des Fensters der bisher gezeichnete Inhalt verloren.
 */

public class Stricheln extends java.awt.event.MouseAdapter
implements java.awt.event.MouseMotionListener, Runnable {


	private class _Canvas extends javax.swing.JComponent {

		@Override public void paintComponent(final java.awt.Graphics io_graphics){
			//Für durchscheinende Komponenten: Unterdrückt erneutes Ausfüllen mit Hintergrundfarbe:
			//Wird hier benutzt, um nicht den ganzen Linienzug speichern zu müssen:
			setOpaque(true);

			io_graphics.drawLine(_lastX, _lastY, _newX, _newY);
			_lastX = _newX;   _lastY = _newY;
		}

	}

	private int _lastX, _lastY, _newX, _newY;

	@Override public void mousePressed(final java.awt.event.MouseEvent i_ev){
		_lastX = i_ev.getX();   _lastY = i_ev.getY();
		System.out.println("mousePressed(" + _lastX + ',' + _lastY + ')');
	}

	@Override public void mouseDragged(final java.awt.event.MouseEvent i_ev){
		_newX = i_ev.getX();   _newY = i_ev.getY();
		System.out.println("mouseDragged(" + _newX + ',' + _newY + ')');
		_canvas.repaint();
	}

	@Override public void mouseMoved(final java.awt.event.MouseEvent i_ev){}

	private final javax.swing.JFrame  _frame  = new javax.swing.JFrame("Stricheln");
	private final javax.swing.JComponent _canvas = new _Canvas();

	public void run(){
		_frame.getContentPane().add(_canvas);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_canvas.addMouseListener(this);
		_canvas.addMouseMotionListener(this);
		_frame.setSize(300,200);
		_frame.setVisible(true);
	}

	public static void main(final String[] i_args){
		SwingUtilities.invokeLater(new Stricheln());
	}


}//Stricheln
