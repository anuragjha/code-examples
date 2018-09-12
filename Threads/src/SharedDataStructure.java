import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class SharedDataStructure {

	private HashMap<Integer, String> values;
	private ReentrantReadWriteLock rwl;

	public SharedDataStructure() {
		this.values = new HashMap<>();
		this.rwl = new ReentrantReadWriteLock();
	}	
	
	//write method
	public void addValue(int number, String string) {
		this.rwl.writeLock().lock();
		this.values.put(number, string);
		this.rwl.writeLock().unlock();	
	}	

	//read method
	public int size() {
		this.rwl.readLock().lock();
		int copy = this.values.size();
		this.rwl.readLock().unlock();
		return copy;		
	}	
}