package gui;
//Spinner.java
//1998-12-22  Knabe  erstellt aus Vorlage von Sun
//Spinner.java 1.2 97/01/14 Jeff Dinkins

/**
 * Spinner - a class that creates a lightweight component that
 * shows a spinning wheel.
 *
 * Lightweight components can have "transparent" areas, meaning that
 * you can see the background of the container behind these areas.
 *
 */
public class Spinner extends java.awt.Component {

  private final int totalAngle   = -360;
  private       int currentAngle =    0;
  
  private SpinnerThread spinnerThread;
  
  /**
   * Constructs a Spinner
   */
  public Spinner(
    final java.awt.Color i_background, final java.awt.Color i_foreground
  ){
    setBackground(i_background);
    setForeground(i_foreground);
  }
  
  /**
   * paints the Spinner
   */
  public void paint(final java.awt.Graphics g) {
    //System.err.println("aSpinner.paint(Graphics)");
    final int w = getSize().width-8, h = getSize().height-8;

    g.setColor(getForeground());
    g.fillArc(3, 3, w, h, 90, currentAngle);

    g.setColor(getBackground());
    g.fillArc(3, 3, w, h, 90+currentAngle, totalAngle-currentAngle);

    g.setColor(java.awt.Color.black);
    g.drawOval(3, 3, w, h);
  }

  public void next() {
    currentAngle -= 6;
    currentAngle %= totalAngle;
    // Repaint might flicker a bit. To avoid this, you can use
    // double buffering (see the Gauge example).
    repaint();
  }

  public void startSpinning() {
    spinnerThread = new SpinnerThread(this);
    spinnerThread.start();
  }

  public void stopSpinning() {
    spinnerThread.stop();
    spinnerThread = null;
  }
}



/**
 * SpinnerThread: spins the wheel
 */
class SpinnerThread extends Thread {

  private Spinner spinner;

  public SpinnerThread(Spinner spinner) {
    super("Spinner Thread");
    this.spinner = spinner;
  }

  public void run () {
    for(;;){
      spinner.next();
      try{ sleep(100); }
        catch (java.lang.InterruptedException e) {}
      //end try
    }
  }
}
 
