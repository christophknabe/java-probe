//MemberClassesTest.java

//2006-04-28  Knabe  Erstellung

class MemberClassesTest {


public static void main(final String[] i_args) throws IllegalAccessException {
  System.out.println(Menu.Service.SaveToUsbKey.class.getName()); //MemberClassesTest$Menu$Service$SaveToUsbKey
}


static class Menu {

    static class Service {

        static class PrintParametersKey {}
        static class SaveToUsbKey {}

    }

}//Menu


}//MemberClassesTest.java