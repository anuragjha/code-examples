
public class Lock {

	private volatile boolean isHeld;
	
	public Lock() {
		isHeld = false;
	}	
	
	public  void setIsHeld(boolean newValue) {
		isHeld = newValue;
	}
	
	
	public synchronized void lock() {
		//if lock is held
		while(isHeld) {
			try {
				//block/go to "sleep" until lock is unlocked
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isHeld = true;		
	}
	
	public synchronized void unlock() {
		if(!isHeld) {
			//ack...shouldn't happen! throw exception			
		}
		isHeld = false;
		this.notifyAll();
	}
	
	public static void main(String[] args) {
		
		
		
		
//		System.out.println("Main: " + Thread.currentThread().getId());
//		Thread t = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("Thread: " + Thread.currentThread().getId());
//				
//			}			
//		}
//		);
//		
//		t.start();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("Main: " + Thread.currentThread().getId());

	}
	
}
