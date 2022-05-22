package collections;

import static org.junit.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ConstantArrayListTest {

	@Test
	public void test() {
		final String sentence = "when I went to Germany I learned to live with rain";
		final String[] words = sentence.split(" ");
		final List<String> list = new ConstantArrayList<>(words);
		final StringBuilder out = new StringBuilder();
		final var it = list.iterator();
		while(it.hasNext()) {
			out.append(it.next());
			out.append(" ");
		}
		assertEquals(false, it.hasNext());
		assertEquals(sentence + " ", out.toString());
		try {
			it.next();
			fail("NoSuchElementException expected");
		}catch(NoSuchElementException expected) {}
	}

}
