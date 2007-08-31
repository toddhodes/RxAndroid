package lsn.persist;

public class PersistException extends Exception {
	public static final long serialVersionUID = 0x010101;
	
	protected PersistException(String m) {
		super(m);
	}
}
