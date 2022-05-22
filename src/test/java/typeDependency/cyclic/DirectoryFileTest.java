package typeDependency.cyclic;

import static org.junit.Assert.*;
import org.junit.Test;

public class DirectoryFileTest {

	@Test
	public void test() {
		final Directory usr = new Directory("usr");
		final Directory local = usr.createDirectory("local");
		final Directory bin = local.createDirectory("bin");
		final String content1 = "This is the list directory program.";
		final File file1 = bin.createFile("ls", content1);
		assertEquals(content1.length(), file1.size());
		final String content2 = "my notice";
		local.createFile("notice.txt", content2);
		assertEquals(content1.length() + content2.length(), local.size());
		assertEquals(content1.length() + content2.length(), usr.size());
		assertEquals("/usr/local/bin/ls", file1.getPath());
	}

}
