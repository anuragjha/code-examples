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
		int next = (end+1)%items.length;
		items[next] = item;
		end = next;		
		size++;
	}


	public synchronized T take() {
		T item = items[start];
		start = (start+1)%items.length;
		size--;
		return item;
	}


	public synchronized boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {

		final CS601BlockingQueue<String> q = new CS601BlockingQueue<String>(4);

		Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 200; i++) {
					q.put("Value " + i);
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(q.take());
				}
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(q.take());
				}
			}
		};

		long start = System.currentTimeMillis();
		t2.start();
		t3.start();
		t1.start();		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start));

	}



}
