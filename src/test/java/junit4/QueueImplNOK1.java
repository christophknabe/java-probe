package junit4;
//Queue.java
//Im SS 13 in Pr1: Aufgabe 9, in WS 08 in IN3: Aufgabe 6
//1999-06-03  Knabe  javadoc-Kommentare
//1998-06-18  Knabe  Absicherung durch Ausnahmen
//1998-06-04  Knabe  Erstellung

/**
 * Zweck: Verwaltet eine Warteschlange nach dem FIFO-Prinzip. Elementetyp ist
 * String.
 */
class QueueImplNOK1 implements Queue {

	/**
	 * Das Feld, in welchem die Elemente abgelegt werden. Das älteste hat immer
	 * den Index 0.
	 */
	protected final String _inhalt[];

	/** Anzahl eingetragener Elemente */
	protected int _anzahl = 0;

	/** Erzeugt eine neue Queue mit Platz fuer maximal size Elemente */
	public QueueImplNOK1(final int size) {
		_inhalt = new String[size-1];
	}

	/* (non-Javadoc)
	 * @see junit.Queue#insert(java.lang.String)
	 */
	@Override
	public void insert(final String element) throws Queue.Overflow {
		if (_anzahl >= _inhalt.length) {
			throw new Queue.Overflow(_anzahl);
		}
		_inhalt[_anzahl] = element;
		_anzahl++;
	}

	/* (non-Javadoc)
	 * @see junit.Queue#read()
	 */
	@Override
	public String read() throws Queue.Underflow {
		_checkUnderflow();
		return _inhalt[0];
	}

	/* (non-Javadoc)
	 * @see junit.Queue#delete()
	 */
	@Override
	public void delete() throws Queue.Underflow {
		_checkUnderflow();
		for (int i = 1; i < _anzahl; i++) {
			_inhalt[i - 1] = _inhalt[i];
		}
		_anzahl--;
		_inhalt[_anzahl] = null;
	}
	
	public String toString(){
		final StringBuilder result = new StringBuilder("Queue(");
		for (int i = 0; i < _anzahl; i++) {
			if(i > 0){result.append(", ");}
			result.append(_inhalt[i]);
		}
		result.append(")");
		return result.toString();
	}

	protected void _checkUnderflow() throws Queue.Underflow {
		if (_anzahl <= 0) {
			throw new Queue.Underflow();
		}
	}

}// Queue
