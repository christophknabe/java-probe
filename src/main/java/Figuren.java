//Figuren.java

//2000-07-16  Knabe  Anpassung an neueren Programmierstil, Java 1.1
//1998-05-28  Knabe  Erstellung

//Zweck: Verwaltung geometrischer Figuren, wie JOBST p.73
abstract class Figur {
  private final String _name;

  String i_name(){return _name;}
  Figur(final String i_name){_name = i_name;}
  abstract void paint(final java.awt.Graphics io_graphics);
  abstract boolean contains(final int i_x, final int i_y);
}//Figur

class Kreis extends Figur {
  private final int _r;   //Radius
  private final int _mx, _my;  //x,y-Koordinaten des Mittelpunktes

  Kreis(final int i_r, final int i_mx, final int i_my){
    super("Kreis");
    _r = i_r; _mx = i_mx; _my = i_my;
  }

  void paint(final java.awt.Graphics io_graphics){
    io_graphics.drawArc(_mx-_r, _my-_r, 2*_r, 2*_r, 0, 360);
  }

  boolean contains(final int i_x, final int i_y){
    final long dx = _mx-i_x, dy = _my-i_y;
    return dx*dx + dy*dy <= _r * _r;
  }
}//Kreis

class RechtEck extends Figur {
  private final int _x, _y, _b, _h; //x,y-Koordinaten der li.ob.Ecke, Breite, Hoehe

  RechtEck(final int i_x, final int i_y, final int i_b, final int i_h){
    super("RechtEck");
    _x = i_x; _y = i_y; _b = i_b; _h = i_h;
  }

  void paint(final java.awt.Graphics io_graphics){
    io_graphics.drawRect(_x, _y, _b, _h);
  }

  boolean contains(final int i_x, final int i_y){
    return _x<=i_x && i_x<=_x+_b
        && _y<=i_y && i_y<=_y+_h;
  }

}//RechtEck

public class Figuren extends java.applet.Applet {
  private final Figur[] _figurArray = new Figur[5];

  public void init(){
    _figurArray[0] = new Kreis(30,50,70);
    for(int i=1; i<_figurArray.length; i++){
      _figurArray[i] = new RechtEck(20+i*10, 10+i*10, 100, 15);
    }
    addMouseListener(new MausLauscher());
  }

  public void paint(final java.awt.Graphics io_graphics){
    for(int i=0; i<_figurArray.length; i++){
      _figurArray[i].paint(io_graphics);
    }
  }

  private class MausLauscher extends java.awt.event.MouseAdapter {
    public void mousePressed(final java.awt.event.MouseEvent i_ev){
      final int  mausX = i_ev.getX(),  mausY = i_ev.getY();
      final StringBuffer treffer = new StringBuffer("click: x=" + mausX + "  y=" + mausY);
      for(int i=0; i<_figurArray.length; i++){
        if(_figurArray[i].contains(mausX,mausY)){
          treffer.append( " " + _figurArray[i].i_name() );
        }
      }
      final String meldung = treffer.toString();
      showStatus(meldung);
      System.out.println(treffer.toString());
      if(mausX*mausY<100){
        //System.out.println("this Applet:");
        //_printParents(Figuren.this);
//        new lib.Msg(
//          Figuren.this,
//          new Exception("Links Oben getroffen")
//        );
    	  multex.Awt.report(Figuren.this, new Exception("Links Oben getroffen"));
      }
    }//mousePressed

    private void _printParents(final java.awt.Component i_component){
      for(java.awt.Component c=i_component; c!=null; c=c.getParent()){
        System.out.println(c);
      }
    }//_print

    private java.awt.Frame _getParentFrame(final java.awt.Component i_component){
      for(java.awt.Component c=i_component; c!=null; c=c.getParent()){
        System.out.println(c);
        if(c instanceof java.awt.Frame){return (java.awt.Frame)c;}
      }
      return null;
    }//_print

  }//MausLauscher

}//Figuren