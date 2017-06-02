package test.generic;

import java.util.Iterator;

public interface Enumable<E> extends Codeable, Nameable {

	public Iterator<E> iterator();
}
