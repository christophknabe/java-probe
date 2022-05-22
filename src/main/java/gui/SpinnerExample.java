package gui;
//SpinnerExample.java:

//1998-12-22  Knabe  abgeleitet aus Sun-Quelle:
//ExampleApplet.java 1.2 97/01/14 Jeff Dinkins

/**
 * SpinnerExample: Application that demonstrates the
 * Spinner component.
 *
 * The application creates a window that has a pretty 
 * background picture in it, and throws some lightweight
 * Spinner components in. Notice how the lightweight
 * Spinner component has "transparent" areas that let you see
 * the image behind it! Cool!
 */
public class SpinnerExample extends java.awt.Frame {

  public static void main(final String[] i_args){
    new SpinnerExample();
  }

  public SpinnerExample() {
    setSize(400,300);
    setLayout(new java.awt.GridBagLayout());

    // ************* Create Spinners with different colors
    final Spinner spinner1  
    = new Spinner(java.awt.Color.yellow, java.awt.Color.red);

    final Spinner spinner2 
    = new Spinner(java.awt.Color.green, java.awt.Color.blue);

    // ************* add components

    final java.awt.GridBagConstraints c = newGridBagConstraints();

    c.gridx = 0;     c.gridy = 0;
    add(spinner1,c);

    // add spinner2
    c.gridx = 1;     c.gridy = 1;
    add(spinner2,c);

    setVisible(true);
    spinner1.startSpinning();
    spinner2.startSpinning();
  }

  public java.awt.GridBagConstraints newGridBagConstraints() {
    final java.awt.GridBagConstraints c = new java.awt.GridBagConstraints();
    c.gridwidth = 1; c.gridheight = 1;
    c.weightx   = 1; c.weighty    = 1;
    c.fill  = java.awt.GridBagConstraints.BOTH;
    c.anchor= java.awt.GridBagConstraints.NORTHWEST;
    return c;
  }
  
  /** override update to *not* erase the background before painting
  */
  public void update(final java.awt.Graphics g) {
    paint(g);
  }
 
  /**paint the background picture, then call super.paint which
  ** will paint all contained components 
  */
  public void paint(final java.awt.Graphics g) {
    g.drawImage(orb, 0, 0, getSize().width, getSize().height, 
    getBackground(), this);
    super.paint(g);
  }

  private final java.awt.Image orb 
  = java.awt.Toolkit.getDefaultToolkit().getImage("orb.gif");

}

