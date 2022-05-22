package collections;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** An immutable java.util.List based on an array of elements. */
public class ConstantArrayList<E> extends AbstractList<E> {

	private final E[] elements;
	
	public ConstantArrayList(E[] elements) {
		this.elements = elements;
	}

	@Override
	public E get(int index) {
		return elements[index];
	}

	@Override
	public int size() {
		return elements.length;
	}

    public Iterator<E> iterator() {
        return new MyIterator();
    }
	
	private final class MyIterator implements Iterator<E> {
		
		private int nextIndex = 0;

		@Override
		public boolean hasNext() {
			return nextIndex < elements.length;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException("There is no element at index=" + nextIndex + ", as lenth=" + elements.length);
			}
			final E result = elements[nextIndex];
			nextIndex++;
			return result;
		}
	}
	
}
