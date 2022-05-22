package threadExc; //ThreadExcTest.java

//Change history:
//2002-04-20  Knabe  Directory demo as subpackage of multex
//2001-04-20  Knabe  As multi-purpose utility ThreadExcTest: copy and move
//2001-04-15  Knabe  Comments translated into english
//2000-10-26  Knabe  Using new class Awt instead of Msg for reporting exception
//2000-05-23  Knabe  Portierung von AWT nach Swing
//1999-03-24  Knabe  Exc-Parameter als Object[]
//1999-03-18  Knabe  Als Demo fuer multex.Exc-Meldungsausgabe in AWT-Oberflaeche
//1999-01-15  Knabe  Als Demo fuer multex.Exc: Ausnahme mit History und Parameter
//1998-12-14  Knabe  Umbau zu binaer Kopieren
//1998-03-10  Knabe  Erstellung als Cat

/** Copies or moves a file, see methods {@link File#copy(String,String)}
* and {@link File#move(String,String)}.
* Serves as a demonstration for reporting an exception which comes from
* a lower tier in the Swing user interface. Look as first example the
* command line file handling {@link File}, and as second example the AWT
* interface for file handling {@link AwtFile}.
*
* Each exception occurring in an ActionListener of the user interface is
* reported by calling <PRE><CODE>
*    multex.Swing.report(ownerFrame, exception);
*</PRE></CODE>
* Further description of the contents of the appearing message dialog
* see class {@link AwtFile}.
* The complete exception reports looks like: <PRE><CODE>
*
*File input could not be copied to output
*CAUSE: java.io.FileNotFoundException: input (Das System kann die angegebene Datei nicht finden)
*
*----------Stack Trace follows:----------
*java.io.FileNotFoundException: input (Das System kann die angegebene Datei nicht finden)
*   at java.io.FileInputStream.open(Native Method)
*   at java.io.FileInputStream.<init>(Unknown Source)
*   at File.copy(File.java:94)
*WAS CAUSING:
*File$CopyFailure: File {0} could not be copied to {1}
*{0}=input  {1}=output
*   at File.copy(File.java:108)
*   at ThreadExcTest$1.actionPerformed(ThreadExcTest.java:71)
*   at javax.swing.AbstractButton.fireActionPerformed(Unknown Source)
*   at javax.swing.AbstractButton$ForwardActionEvents.actionPerformed(Unknown Source)
*   at javax.swing.DefaultButtonModel.fireActionPerformed(Unknown Source)
*   at javax.swing.DefaultButtonModel.setPressed(Unknown Source)
*   at javax.swing.plaf.basic.BasicButtonListener.mouseReleased(Unknown Source)
*   at java.awt.Component.processMouseEvent(Unknown Source)
*   at java.awt.Component.processEvent(Unknown Source)
*   at java.awt.Container.processEvent(Unknown Source)
*   at java.awt.Component.dispatchEventImpl(Unknown Source)
*   at java.awt.Container.dispatchEventImpl(Unknown Source)
*   at java.awt.Component.dispatchEvent(Unknown Source)
*   at java.awt.LightweightDispatcher.retargetMouseEvent(Unknown Source)
*   at java.awt.LightweightDispatcher.processMouseEvent(Unknown Source)
*   at java.awt.LightweightDispatcher.dispatchEvent(Unknown Source)
*   at java.awt.Container.dispatchEventImpl(Unknown Source)
*   at java.awt.Window.dispatchEventImpl(Unknown Source)
*   at java.awt.Component.dispatchEvent(Unknown Source)
*   at java.awt.EventQueue.dispatchEvent(Unknown Source)
*   at java.awt.EventDispatchThread.pumpOneEvent(Unknown Source)
*   at java.awt.EventDispatchThread.pumpEvents(Unknown Source)
*   at java.awt.EventDispatchThread.run(Unknown Source)
*</PRE></CODE>
*/

public class ThreadExcTest extends Thread implements java.awt.event.ActionListener {
  private final javax.swing.JFrame _frame = new javax.swing.JFrame("ThreadExcTest");
  private final int _width = 20;
  private final javax.swing.JTextField _fromTextField
  = new javax.swing.JTextField("", _width);
  private final javax.swing.JTextField _toTextField
  = new javax.swing.JTextField("", _width);
  private final javax.swing.JButton _countButton = new javax.swing.JButton("Count");
  private final javax.swing.JButton _listButton = new javax.swing.JButton("List");

  /**Effect: Creates a Swing user interface for copying a file*/
  public static void main(final String[] i_args){
    final ThreadGroup userThreadGroup = new ThreadGroup("User ThreadGroup"){
      public void uncaughtException(Thread t, Throwable e){
        System.err.println("" + t + " exited with exception:");
        multex.Msg.printReport(e);
      }
    };
    new ThreadExcTest(userThreadGroup).start();
  }//main


  /**Do not create objects of me!*/
  private ThreadExcTest(final ThreadGroup i_threadGroup){
    super(i_threadGroup, "UserMainThread");
    multex.MsgText.setInternationalization(true);
    final java.util.Calendar version = java.util.Calendar.getInstance();
    version.clear();
    version.set(2001, 03, 20);
    multex.Msg.printMessages(
      new StartedExc(getClass().getName(), version.getTime())
    );

    //Layout:

    final java.awt.Container container = _frame.getContentPane();
    container.setLayout(new java.awt.FlowLayout());
    container.add(new javax.swing.JLabel("From:"));
    container.add(_fromTextField);
    container.add(new javax.swing.JLabel("To:"));
    container.add(_toTextField);
    container.add(_countButton);
    container.add(_listButton);
    _frame.pack();

    //Behaviour:

    _countButton.addActionListener(this);
    _listButton.addActionListener(this);

    _frame.addWindowListener( new java.awt.event.WindowAdapter(){
      public void windowClosing(final java.awt.event.WindowEvent i_){
        System.exit(0);
      }
    });
    _frame.setVisible(true);

  }//ThreadExcTest()

  public void actionPerformed(final java.awt.event.ActionEvent i_event){
    final Object eventSource = i_event.getSource();
    try{
      final String from=_fromTextField.getText(), to=_toTextField.getText();
      if(eventSource==_countButton){
        new FileThread(Thread.currentThread().getThreadGroup()).run();
      }else if(eventSource==_listButton){
        System.out.println("List button pressed.");
        Thread.currentThread().getThreadGroup().list();
      }else{
        throw new multex.Failure("Wrong button", null, eventSource);
      }
    }
      catch(final Exception ex){
        //Common handler for all ActionEvents: report any Exception
        multex.Awt.report(_frame, ex);
        return;
      }
    //end try
  }//actionPerformed
  

  /**Indicates, that this test driver has been started. If your environment
    is set to language "de", then the message text from the german message
    text file MsgText_de.properties will be taken instead of this default
    message text defined here.*/
  public static class StartedExc extends multex.Exc {
    public StartedExc(final String i_driver, final java.util.Date i_date){
      super("File handling driver {0}, version of {1,date,full} was started",
        i_driver, i_date
      );
    }
  }

}//class ThreadExcTest