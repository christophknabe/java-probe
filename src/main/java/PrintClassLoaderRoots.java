import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/** @since 2024-03-24 */
public class PrintClassLoaderRoots {

    /**Prints all URL-based roots of ClassLoaders this class is using. */
    public static void main(String... main){
        new PrintClassLoaderRoots().execute();
    }

    private void execute(){
        final List<String> roots = new ArrayList<>();
        //Traverse all ClassLoaders up the getParent() chain:
        for(ClassLoader cl = getClass().getClassLoader(); cl != null; cl = cl.getParent()) {
            System.out.println("Classloader: " + cl);
            if(cl instanceof URLClassLoader) {
                final URLClassLoader urlClassLoader = (URLClassLoader) cl;
                final URL[] urls = urlClassLoader.getURLs();
                for(final URL url : urls) {
                    roots.add(url.getPath());
                }
            }
        }
        //Now print all collected roots in default order.
        roots.stream().sorted().forEach(x -> System.out.println(x));
    }

}
