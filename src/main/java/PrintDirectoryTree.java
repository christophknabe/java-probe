import java.io.File;

/** Prints the tree of the current working directory. Similar to <code>ls -R</code>
 * @author Christoph Knabe
 * @since 2022-09-15
 */
public class PrintDirectoryTree {

    public static void main(final String... args){
        new PrintDirectoryTree().execute();
    }

    private void execute(){
        printDirectoryTree(new File(".").getAbsoluteFile(), 0);
    }
  
    private void printDirectoryTree(final File file, final int level){
        final String printName = level<=0 ? file.getAbsolutePath() : file.getName();
        printIndentation(level);
        System.out.println(printName);
        final File[] subfiles = file.listFiles();
        if(subfiles==null){ //no directory => break recursion here
            return;
        }
        for(final File subfile: subfiles){
            printDirectoryTree(subfile, level+1);
        }
    }

    private void printIndentation(final int level){
        for(int i=0; i<level; i++){
            System.out.print("+--");
        }
    }
}
