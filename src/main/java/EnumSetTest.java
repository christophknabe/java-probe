/**Probiert, eine Menge über einem enum-Typ zu definieren.
 * @author knabe 2008-06-13
*/
public class EnumSetTest {
    
    public static void main(final String[] i_args){
        new EnumSetTest().execute();
    }

    private void execute() {
        final Wochentag[] values = Wochentag.values();
        for(final Wochentag wochentag: values){
            System.out.println(wochentag);
        }
        final DiskreteMenge<Wochentag> arbeitsTage = new DiskreteMenge(Wochentag.class); //Type safety warning, although safe
        
        final DiskreteMenge<Wochentag> freieTage   = DiskreteMenge.create(Wochentag.class); //type safe
    }

}

enum Wochentag {Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag, Sonntag}

class DiskreteMenge<E extends Enum<E>> {
    
    private final Enum[] containedValues;
    
    public DiskreteMenge(final Class<E> myClass){
        final int valuesLength = myClass.getEnumConstants().length;
        containedValues = new Enum[valuesLength];
    }
    
    /**Type safe wrapper for the constructor in order to avoid warning*/
    public static <E extends Enum<E>> DiskreteMenge<E> create(final Class<E> myClass){
        return new DiskreteMenge<E>(myClass);
    }
} 
