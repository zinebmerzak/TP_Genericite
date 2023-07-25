package ma.enset;

import java.util.List;

public interface IMetier<T>{
	
	public void add(T o);
	
	public List<T> getAll();
	
	public void saveAll();
	
	public T findById(long id);
	
	public void delete(long id);
	
}
