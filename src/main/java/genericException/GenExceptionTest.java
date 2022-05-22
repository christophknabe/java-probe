package genericException;

import java.io.File;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;
//import static genericException.Exc.create;
//import static genericException.Exc.throwNew4;
import static genericException.Exc.*;

class GenExceptionTest {
    
    final static String username = "sampleUser";
    final static java.io.File file = null;
    
    public static void main(final String[] args){
    }

    void doAccess11() throws FileAccessRightExc {
        final FileAccessRightExc fileAccessRightExc = new FileAccessRightExc();
        fileAccessRightExc.init1(username, file);
        throw fileAccessRightExc;
    }

    void doAccess12() throws FileAccessRightExc {
        throw new FileAccessRightExc().<FileAccessRightExc>init1(username, file);
    }

    void doAccess2() throws FileAccessRightExc {
        throw Exc.init2(new FileAccessRightExc(), username, file);
    }
    void doAccess31() throws FileAccessRightExc {
        throw Exc.<FileAccessRightExc>create(username, file);
    }
    void doAccess32() throws FileAccessRightExc {
        throw Exc.create(FileAccessRightExc.class, username, file);
    }
    void doAccess33() throws FileAccessRightExc {
        throw create(FileAccessRightExc.class, username, file);
    }
    void doAccess41() throws FileAccessRightExc {
        Exc.throwNew4(FileAccessRightExc.class, username, file);
    }

    void doAccess42() throws FileAccessRightExc {
        throwNew4(FileAccessRightExc.class, username, file);
    }
    
    void doAccess43() throws FileAccessRightExc {
        if (!fileAccessAllowed(username, file)) {
            throwNew4(FileAccessRightExc.class, username, file);
        }        
    }
    
    void checkUsername() throws EmptyStringExc {
        if(username==null || username.length()==0){
            throw create(EmptyStringExc.class, "username");
        }
    }
    
    /**Dummy implementation*/
    private boolean fileAccessAllowed(final String username, final File file) {
        return false;
    }

    /**Tests handling an expected exception individually.*/
    void callDoAccess42(){
        try{doAccess42();
            fail("FileAccessRightExc expected");
        } catch ( FileAccessRightExc expected ){ //expected
        }
    }

    void fail(final String message){
        throw new RuntimeException(message);
    }
    void doLoad(final Exception cause) throws LoadObjectExc, RuntimeException{
        throw create(LoadObjectExc.class, cause, username, file);
    }
    
}

/**User {0} does not have the right to access file {1}.*/
class FileAccessRightExc extends Exc {}

/**String reference {0} is null or has length zero.*/
class EmptyStringExc extends Exc {
    
    public static void check1(final String string, final String name) throws EmptyStringExc
    {
        if(string==null || string.length()==0){
            throwNew4(EmptyStringExc.class, name);
        }
    }

    public static void check2(final String string, final String name) throws EmptyStringExc
    {
        if(string==null || string.length()==0){
            // /*Exc.<EmptyStringExc>*/throwMe(name);  //Does not work without parameterization or casting to the specific exception type!
        }
    }
    
}

/**Failure loading object of class {0} with id {1}.*/
class LoadObjectExc extends Exc {}  