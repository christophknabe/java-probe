import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Dieses Programm demonstriert die N�tzlichkeit von final und die Sch�dlichkeit von unn�tig globalen Variablen.
 * Es ben�tigt MulTEx 8 und hsqldb-1.7.3.3.jar
 * @author knabe 2007-10-04
 *
 */
public class JdbcTest {

    public static void main(final String[] args) throws ClassNotFoundException, SQLException {
        new JdbcTest().execute();
    }

    //Das Schl�sselwort final bei den Deklarationen w�rde die genau einmalige Initialisierung
    //der Variablen erzwingen. Diese muss im Konstruktor erfolgen.
    //Deklarationen:
    Connection con;
    Statement stmt;
    ResultSet rs;
    String name;

    private void execute() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        //Ohne final-Deklarationen werden Vertauschungen oder Vergessen der Zuweisungen nicht vom Compiler bemerkt,
        //sondern f�hren erst zur Laufzeit zu einer NullPointerException!
        //Zuweisungen:
        con = DriverManager.getConnection("jdbc:hsqldb:mem:coffeeshop", "sa", "");
        stmt = con.createStatement();
        rs = stmt.executeQuery(
            "select NAME from COFFEE"
        );
        rs.next();
        name = rs.getString("NAME");
        System.out.println("The coffee is " + name);
    }


}
