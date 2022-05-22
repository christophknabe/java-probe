package www;

import java.io.File;
import java.io.FileReader;

/**
 * Alt
 */
public class LineNumberReader {

    private static FileReader _fileReader;

    public LineNumberReader(final File file) throws Exception {
        _fileReader = new FileReader(file);
    }

}
