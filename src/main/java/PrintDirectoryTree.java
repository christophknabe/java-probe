public class PrintDirectoryTree {
  
    private void printDirectoryTree(final File file, final int level){
        final String printName = level<=0 ? file.getAbsolutePath() : file.getName();
        printIndentation(level);
        System.out.println(printName);
        if(file.isDirectory()){
            final File[] subfiles = file.listFiles();
            for(final File subfile: subfiles){
                printDirectoryTree(subfile, level+1);
            }
        }
    }

    private void printIndentation(final int level){
        for(int i=0; i<level; i++){
            System.out.print("+--");
        }
    }
}
