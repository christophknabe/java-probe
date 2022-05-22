package junit4;

interface Queue {

	/** Die Queue ist schon leer. */
	public static class Underflow extends Exception {}

	/** Die Queue ist mit anzahl Elementen schon voll. */
	public static class Overflow extends Exception {
		public Overflow(final int anzahl) {
			super(Integer.toString(anzahl));
		}
	}

	/** Hängt element an die Warteschlange an (Mutator).
	 *  @throws Queue.Overflow kein Platz mehr in der Schlange
	 */
	public void insert(final String element) throws Queue.Overflow;

	/**
	 * Liefert das älteste, noch in der Warteschlange enthaltene Element (Informator).
	 *  @throws Queue.Underflow Schlange leer
	 */
	public String read() throws Queue.Underflow;

	/** Löscht das älteste Element aus der Warteschlange (Mutator)
	 *  @throws Queue.Underflow Schlange leer
	 */
	public void delete() throws Queue.Underflow;
	
	/**Liefert menschenlesbare Darstellung des Inhalts, Informator.*/
	public String toString();

}