package concurrency;

public class CS601BlockingQueue<T> {

	private T[] items;
	private int start;
	private int end;
	private int size;

	public CS601BlockingQueue(int size) {
		this.items = (T[]) new Object[size];
		this.start = 0;
		this.end = -1;
		this.size = 0;
	}

	public synchronized void put(T item) {
		
		//busy-wait solution
		
		//if...wait solution
		
		int next = (end+1)%items.length;
		items[next] = item;
		end = next;		
		size++;
	}


	public synchronized T take() {
		
		T item = items[start];
		start = (start+1)%items.length;
		size--;
		if(size == items.length-1) {
			this.notifyAll();
		}
		return item;
	}


	public synchronized boolean isEmpty() {
		return size == 0;
	}
}
