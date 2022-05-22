package threadExc; //FileThread.java

/**Demonstrates the usage of redefining method
  ThreadGroup.uncaughtException()
  in order to report all uncaught exceptions in the user
  ThreadGroup in a user specific manner.
  @author Christoph Knabe 2003-01-16
*/

class FileThread extends Thread {

  public static void main(final String[] i_args){
    final ThreadGroup userThreadGroup = new ThreadGroup("User ThreadGroup"){
      public void uncaughtException(Thread t, Throwable e){
        System.err.println("" + t + " exited with exception:");
        multex.Msg.printReport(e);
      }
    };
    new FileThread(userThreadGroup).start();
  }

  public FileThread(final ThreadGroup i_threadGroup){
    super(i_threadGroup, "FileThread");
  }

  public void run(){
    final String root = "C:\\bin";
    final java.io.File file = new java.io.File(root);
    listFilesDeeply(file);
    throw new multex.Failure("Listing of file hierarchy {0} completed", null, root);
  }

  public void listFilesDeeply(final java.io.File i_file){
    System.out.println(i_file);
    final java.io.File[] files = i_file.listFiles();
    if(null==files){return;}
    for(int i=0; i<files.length; i++){
      listFilesDeeply(files[i]);
    }
  }

}//FileThread