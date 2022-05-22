import java.util.ArrayList;
import java.util.List;

public class ParameterizedTypeTest {

    public static void main(String[] args) {
        final ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character('A'));
        characters.add(new Character('B'));
        characters.add(new Character('C'));
        System.out.println("characters: " + characters);
        final List<Character> cl = characters;
        //final List<Boolean> bl = cl;  //type mismatch
    }

}
