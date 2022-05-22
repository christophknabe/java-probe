
public class CloserProbe {
	
    /** Kopiert Datei args[0] binär nach Datei args[1].*/
    public static void main(final String[] args) throws java.io.IOException
    {
        new CloserProbe().kopierenEinfach(args[0], args[1]);
    }

    /** Kopiert Datei namens inFileName binär nach Datei outFileName.*/
    void kopierenEinfach(final String inFileName, final String outFileName)
    throws java.io.IOException
    {
        final java.io.FileInputStream in = new java.io.FileInputStream(inFileName);
        final java.io.FileOutputStream out = new java.io.FileOutputStream(outFileName);
        final byte[] buf = new byte[512];

        for(;;){
            final int len = in.read(buf);
            if(len<=0){break;}
            out.write(buf,0,len);
        }
        in.close();
        out.close();
    }

	
}
