
public class ThreadTest {

	public static void main(String[] args) {

		Thread t1 = new Thread(new InfinitePrinter());
		t1.start();
		
		Thread t2 = new Thread(new InfinitePrinter());
		t2.start();

	}
	
}
