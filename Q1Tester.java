package lab5;
class TestThread implements Runnable
{
	@Override
	public void run() {
		for(int i=0;i<=100;i++) {
			System.out.println("Thread: " + Thread.currentThread().getName() + " " + i);
		}
	}
}
public class Q1Tester{
	public static void main(String[] args) {
		TestThread testThread=new TestThread();
		Thread t1=new Thread(testThread,"Thread1");
		Thread t2=new Thread(testThread,"Thread2");
		Thread t3=new Thread(testThread,"Thread3");
		t1.start();
		t2.start();
		t3.start();
	}
}
