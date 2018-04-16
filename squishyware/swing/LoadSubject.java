package squishyware.swing;

public interface LoadSubject<T> {
	
	public T doAction(Object... args)throws WrongArgumentException;
		
	}