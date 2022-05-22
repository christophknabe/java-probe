package bintrees.classic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/** A Table is an Abstract Data Type which can (similar to a database table) 
 * store a set of rows. Each row has a unique key field. 
 * The key values must be comparable in a linear order. */
public class Table<KEY extends Comparable<KEY>, ROW> {
	
	private final Tree<ROW> tree;
	private final Function<ROW, KEY> getKey;

	/**Creates a Table from the rows which is efficiently searchable by the row KEY.
	 * @param rows an array of rows
	 * @param getKey a function to extract the key out of a row*/
	public Table(final ROW[] rows, final Function<ROW, KEY> getKey){
		class RowComparator implements Comparator<ROW> {
			@Override
			public int compare(ROW a, ROW b) {
				return getKey.apply(a).compareTo(getKey.apply(b));
			}
		}
		final int len = rows.length;
		final ROW[] unsortedRows = rows.clone();
		Arrays.sort(unsortedRows, new RowComparator());
		final ROW[] sortedRows = unsortedRows;
		this.tree = createTree(sortedRows, 0, len);
		this.getKey = getKey;
	}

	/** Returns the row with the given key.
	 * @return the row with the key, or null if not found. */
	public ROW findByKey(final KEY key) {
		return _findByKey(tree, key);
	}

	/** Returns the row with the given key if it is contained in the given node or its successors. 
	 * @return the row with the key, or null if not found. */
	private ROW _findByKey(final Tree<ROW> tree, final KEY searchedKey) {		
		if(tree==null) {
			return null;
		}
		final ROW middleRow = tree.getContent();
		final KEY middleKey = getKey.apply(middleRow);
		final int comparison = searchedKey.compareTo(middleKey);
		if(comparison==0) {
			return middleRow;		
		}
		final Tree<ROW> subTree = comparison < 0 ? tree.getLeft() : tree.getRight();
		return _findByKey(subTree, searchedKey);
	}
	
	/** Makes a sorted binary tree from a slice of the sorted array of records.
	 * @param sortedRows the sorted array of records
	 * @param left the index of the first element of the slice
	 * @param right the index after the last element of the slice
	 * @return the root node of the sorted binary tree containing the elements of the slice, or null, if the slice is empty. */
	private static <ROW> Tree<ROW> createTree(final ROW[] sortedRows, int left, int right){
		if(right<=left) { //slice empty
			return null;
		}
		final int mid = (left+right) / 2;
		return new Tree<ROW>(createTree(sortedRows, left, mid), sortedRows[mid], createTree(sortedRows, mid+1, right));
	}

	/** Demonstrates the class Table by creating a table of Kunde objects and by repeatedly searching them by their Kunde.nummer. */
	public static void main(String[] args) {
		final Kunde[] kunden = {
				new Kunde(17, "Hans"),
				new Kunde(7, "Franz"),
				new Kunde(1, "Fritz"),
				new Kunde(11, "Sigmar"),
				new Kunde(6, "Nina"),
				new Kunde(2, "Lisa"),
				new Kunde(14, "Maria"),
				new Kunde(8, "Rosa")
		};
		final Table<Integer, Kunde> table = new Table<>(kunden, kunde -> kunde.getNummer());
		for(int i=1; i<20; i++) {
			final Kunde kunde = table.findByKey(i);
			System.out.print(i + " ");
			final String fundErgebnis = kunde==null ? "nicht gefunden" : "-> " + kunde.getName();
			System.out.println(fundErgebnis);
		}
	}
	
	private static class Kunde {
		private final int nummer;
		private final String name;
		public Kunde(final int nummer, final String name) {
			this.nummer = nummer;
			this.name = name;
		}
		public int getNummer() {
			return nummer;
		}
		public String getName() {
			return name;
		}		
	}

}
