package mockito;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ListMockTest {

	@Test
	public void test() {
		// mock creation
		final List<String> mockedList = mock(List.class);

		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();

		// selective, explicit, highly readable verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}

}
