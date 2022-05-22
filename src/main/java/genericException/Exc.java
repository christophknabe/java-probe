package genericException;

import java.io.File;

public class Exc extends Exception {
    /*package*/ Object[] params;
    public Exc(){}
    public <E> E init1(final Object... params){
        this.params = params;
        return (E)this;
    }
    public static <E extends Exc> E init2(final E e, final Object... params){
        e.params = params;
        return e;
    }
    public static <E extends Exc> E create(final Object... params) throws RuntimeException {
        //final E e = new E();  //Cannot instantiate the type E!!!
        //final Class c = E.class;  //Illegal class literal for the type parameter E!!!
        return null;
    }
    /**
     * @param <E>
     * @param c
     * @param params
     * @return
     * @throws RuntimeException
     */
    public static <E extends Exc> E create(final Class<E> c, final Object... params) throws RuntimeException {
        final E e;
        String className = null;
        try {
            className = c.getName();
            e = c.newInstance();
            e.params = params;
        } catch (Exception cause) {
            throw new RuntimeException("Cannot throw " + className, cause);
        }
        return e;
    }
    /**
     * @param <E>
     * @param c
     * @param params
     * @return
     * @throws RuntimeException
     */
    public static <E extends Exc> E create(final Class<E> c, final Throwable cause, final Object... params) throws RuntimeException {
        final E e;
        String className = null;
        try {
            className = c.getName();
            e = c.newInstance();
            e.params = params;
            e.initCause(cause);
        } catch (Exception creationException) {
            throw new RuntimeException("Cannot throw " + className, creationException);
        }
        return e;
    }
    public static <E extends Exc> void throwNew3(final Object... params){
        //final E e = new E(); //Cannot instantiate the type E!!!
    }
    public static <E extends Exc> void throwNew4(final Class<E> c, final Object... params) throws E {
        final E e = create(c, params);
        throw e;
    }
    public static <E extends Exc> void throwMe(final Object... params) throws E {
        Class c = null;
        final E e;
        try {
            final Class[] callingClasses = securityManager.getCallingClasses();
            //final List<Class> callingClassesList = Arrays.asList(callingClasses);
            //System.out.println("Calling classes: " + callingClassesList);
            c = callingClasses[2];
            e = (E)c.newInstance();
            e.params = params;
        } catch (Exception cause) {
            throw new RuntimeException("Cannot throw " + c, cause);
        }
        throw e;
    }
    /**Purpose: Enabling access to a protected method of java.lang.SecurityManager.*/
    private static final class MySecurityManager extends SecurityManager {
        public Class[] getCallingClasses(){
            return getClassContext();
        }
    }
    private static final MySecurityManager securityManager = new MySecurityManager();
}
