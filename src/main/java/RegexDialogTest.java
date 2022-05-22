import java.io.*;
import java.util.regex.*;

public final class RegexDialogTest {

    private static String REGEX;
    private static String INPUT;
    private static BufferedReader br;

    public static void main(String[] argv) throws IOException {
        initResources();
        processTest();
        closeResources();
    }

    private static void initResources() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("RegEx? ");
        REGEX = br.readLine();
        System.out.print("Input? ");
        INPUT = br.readLine();

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);
    }

    private static void processTest() {
        final Pattern pattern = Pattern.compile(REGEX);
        final Matcher matcher = pattern.matcher(INPUT);
        boolean found = false;
        while(matcher.find()) {
            System.out.println(
                "I found the text \"" + matcher.group() +
                "\" starting at index " + matcher.start() +
                " and ending at index " + matcher.end() + "."
            );
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }
    }

    private static void closeResources() throws IOException {
        br.close();
    }
    
    
}

