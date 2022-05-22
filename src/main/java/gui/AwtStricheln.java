package gui;
//Stricheln.java: Test Maus-Listener: ähnlich Scribble
//1999-12-23  Knabe  Absichern gegen Zusammenfassung mehrerer update()-
//                   -Aufrufe durch ein repaint()
//1999-12-21  Knabe  erstellt

/*Aufgabe: Schreiben Sie ein Java-Programm, mit welchem man durch Mausbewegung
  bei gedrückter Maustaste zeichnen kann.
*/
/**Ermöglicht Zeichnen bei gedrückter Maustaste.
  Vereinfachung gegenüber dem klassischen Scribble, indem die Zeichnung nicht
  gespeichert wird, sondern durch Redefinition von Canvas.update(Graphics)
  immer nur der letzte Strich in die bestehende Zeichnung hineingezeichnet
  wird. Dadurch geht jedoch bei Größenänderung oder Refresh des Fensters
  der bisher gezeichnete Inhalt verloren.
*/

public class AwtStricheln extends java.awt.event.MouseAdapter
implements java.awt.event.MouseMotionListener {


  private class _MyCanvas extends java.awt.Canvas {
    public void update(final java.awt.Graphics io_graphics){
      io_graphics.drawLine(_lastX, _lastY, _newX, _newY);
      _lastX = _newX;   _lastY = _newY;
    }
  }

  private int _lastX, _lastY, _newX, _newY;

  public void mousePressed(final java.awt.event.MouseEvent i_ev){
    _lastX = i_ev.getX();   _lastY = i_ev.getY();
  }

  public void mouseDragged(final java.awt.event.MouseEvent i_ev){
    _newX = i_ev.getX();   _newY = i_ev.getY();
    _canvas.repaint();
  }

  public void mouseMoved(final java.awt.event.MouseEvent i_ev){}

  private final java.awt.Frame  _frame  = new java.awt.Frame("AwtStricheln");
  private final java.awt.Canvas _canvas = new _MyCanvas();

  public AwtStricheln(){
    _frame.add(_canvas);
    _canvas.addMouseListener(this);
    _canvas.addMouseMotionListener(this);
    _frame.setSize(300,200);
    _frame.setVisible(true);
  }

  public static void main(final String[] i_args){
    new AwtStricheln();
  }


}//Stricheln
