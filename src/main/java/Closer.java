import java.io.Closeable;


public abstract class Closer<C extends Closeable> {
	
	protected final C closeable;
	
	public Closer(final C closeable)throws Exception{
		if(null==closeable){
			throw new IllegalArgumentException("Illegal null reference passed to argument closeable");
		}
		this.closeable = closeable;
		try{use();}
		finally{
			this.closeable.close();
		}
	}
	protected abstract void use() throws Exception;

}
