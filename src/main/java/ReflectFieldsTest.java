//ReflectFieldsTest.java

//2000-06-22  Knabe  Erstellung

class ReflectFieldsTest {


public static void main(final String[] i_args) throws IllegalAccessException {
  final Class longClass = long.class;
  System.out.println("longClass = " + longClass);
  final ArgumentExc argumentExc = new ArgumentExc("Dauer",99);
  System.out.println(toString(argumentExc));
}

public static String toString(final Object i_object) throws IllegalAccessException {
  final Class theClass = i_object.getClass();
  final String className = theClass.getName();
  final java.lang.reflect.Field[] fields = theClass.getFields();
  final StringBuffer result = new StringBuffer();
  result.append(className + "{");
  for(int i=0; i<fields.length; i++){
    final java.lang.reflect.Field field = fields[i];
    final Object fieldValue = field.get(i_object);
    if(i>0){result.append(", ");}
    result.append(field.getName() + "=" + fieldValue);
  }
  result.append("}");
  return result.toString();
}

static class ArgumentExc extends multex.Exc {
  public ArgumentExc(final String i_name, final int i_wert){
    super("Argument {0} has illegal value {1}");
    name = i_name;   wert = i_wert;
  }
  public final String name;
  public final int    wert;
}//ArgumentExc


}//ReflectFieldsTest.java