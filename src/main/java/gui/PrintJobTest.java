package gui; //PrintJobTest.java: Test Grafik mit Java 1.1 AWT
//1999-07-01  Knabe  erweitert um Ausdrucken des Gesichts
//1999-06-16  Knabe  erweitert um Ellipse: Gesicht, Nase
//1999-02-26  Knabe  mit Praefix _ für gekapselte Daten
//1998-06-19  Knabe  umgestellt auf Kopf mit Augen und Mund
//1998-05-22  Knabe  erstellt

//Plan: Umstellen auf umgebende Rechtecke als Ort+Masz,
//      Ellipse nehmen und Kopfform anpassen (stauchen, spreizen)!

//Achtung:
//Mehrere Klassen in einer .java-Datei nur fuer nichtoeffentliche moeglich!

abstract class Figur {
  protected final int _x, _y;  //x,y-Koordinaten des Verankerungspunktes

  /**Initialisiert fuer eine Figur den Verankerungspunkt (i_x, i_y) */
  Figur(final int i_x, final int i_y)
  {
    _x = i_x;   _y = i_y;
  }
  final int x(){return _x;}
  final int y(){return _y;}
  abstract void zeichnen(final java.awt.Graphics io_graphics);
}//Figur

class Ellipse extends Figur {
  private final int _rX, _rY;   //Radien in X,Y-Richtung

  /**Erzeugt Ellipse mit Mittelpunkt (i_x,i_y) und Radien i_rX, i_rY */
  Ellipse(final int i_x, final int i_y, final int i_rX, final int i_rY)
  {
    super(i_x, i_y);
    _rX = i_rX;   _rY = i_rY;
  }

  final int rX(){return _rX;}
  final int rY(){return _rY;}
  void zeichnen(final java.awt.Graphics io_graphics){
    io_graphics.drawOval(_x-_rX, _y-_rY, 2*_rX, 2*_rY);
  }
}//Ellipse

class Kreis extends Figur {
  private final int _r;   //Radius

  /**Erzeugt Kreis mit Mittelpunkt (i_x,i_y) und Radius i_r */
  Kreis(final int i_x, final int i_y, final int i_r)
  {
    super(i_x, i_y);
    _r = i_r;
  }

  final int r(){return _r;}
  void zeichnen(final java.awt.Graphics io_graphics){
    io_graphics.drawOval(_x-_r, _y-_r, 2*_r, 2*_r);
  }
}//Kreis

class Rechteck extends Figur {
  private final int _b, _h; //Breite, Hoehe

  /**Erzeugt Rechteck der Breite i_b und der Hoehe i_h 
  * mit (i_x,i_y) als linke obere Ecke 
  */
  Rechteck(final int i_x, final int i_y, final int i_b, final int i_h)
  {
    super(i_x, i_y);
    _b = i_b; _h = i_h;
  }

  /**Effekt: Zeichnet das Objekt vollstaendig auf 'io_graphics' */
  void zeichnen(final java.awt.Graphics io_graphics)
  {
    io_graphics.drawRect(_x, _y, _b, _h);
  }

}//Rechteck

class MyCanvas extends java.awt.Canvas {
  public void paint(final java.awt.Graphics io_graphics){

    final java.awt.Rectangle rectangle = getBounds();
    final int breite = rectangle.width  - 1;
    final int hoehe  = rectangle.height - 1;

    final Ellipse kopf = new Ellipse(
      breite/2,
      hoehe/2,
      breite*2/5,
      hoehe *2/5
    );
    final int augenR = Math.min(kopf.rX(),kopf.rY()) / 4;
    final Kreis linkesAuge = new Kreis(
      kopf.x()-kopf.rX()/3,
      kopf.y()-kopf.rY()/2,
      augenR
    );
    final Kreis rechtesAuge = new Kreis(
      kopf.x()+kopf.rX()/3,
      kopf.y()-kopf.rY()/2,
      augenR
    );
    final Rechteck mund = new Rechteck(
      kopf.x() - kopf.rX()/2,
      kopf.y() + kopf.rY()/4,
      kopf.rX(),
      kopf.rY()/4
    );
    final Ellipse nase = new Ellipse(
      kopf.x(),
      kopf.y(),
      kopf.rX()/10,
      kopf.rY()/5
    );
                           //============Polymorphie============
    final Figur[] figuren
    = {kopf, linkesAuge, rechtesAuge, mund, nase};
    for(int i=0; i<figuren.length; i++){
      figuren[i].zeichnen(io_graphics); //Dynamisches Binden
    }
  }//paint
}//MyCanvas

public class PrintJobTest {

  public static void main(final String[] i_args) throws Exception {
    final java.awt.Frame frame 
    = new java.awt.Frame("Ein dehnbares Gesicht");
    frame.setSize(300,200);
    final MyCanvas myCanvas = new MyCanvas();
    frame.add(myCanvas);
    frame.setVisible(true);
    
    //Ausdrucken des Geischts
    final java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
    final java.awt.PrintJob printJob 
    = toolkit.getPrintJob(frame, "PrintJobTest", null);
    final java.awt.Graphics graphics = printJob.getGraphics();
    //myCanvas.paint(graphics);
    frame.printAll(graphics);
    graphics.dispose();
    printJob.end();
  }

}//PrintJobTest
