package lab5;
import java.io.*;
import java.util.*;
class SumMethod implements Runnable {
	private int sum;
	public SumMethod(int sum) {
		this.sum = sum;
	}	
	public int getSum() {
		return sum;
	}
	@Override
	public void run() {
		getSum(sum);
	}
	public int getSum(int sum) {
		Random random = new Random();
		int val = random.nextInt(10)+1;
		System.out.println("Random no: " + val);
		synchronized (this) {
			this.sum=this.sum+val;
		}
		return this.sum;
	}
}
public class Q2Tester {
	public static void main(String[] args) {
		int baseSum = 0;
		SumMethod sumMethod = new SumMethod(baseSum);
		Thread t1 = new Thread(sumMethod);
		Thread t2 = new Thread(sumMethod);
		Thread t3 = new Thread(sumMethod);
		Thread t4 = new Thread(sumMethod);
		Thread t5 = new Thread(sumMethod);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		//for uninterrupted execution
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Sum: " + sumMethod.getSum());
		System.out.println("Main ends....!");
	}
}
