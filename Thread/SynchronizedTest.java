package com.dfbz.demo.thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {
	
	public static void main(String[] args) {
		MyRunnable88 mr = new MyRunnable88();
		Thread th1 = new Thread(mr);
		Thread th2 = new Thread(mr);
		Thread th3 = new Thread(mr);
		Thread th4 = new Thread(mr);
		Thread th5 = new Thread(mr);
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}
}

class MyRunnable88 implements Runnable {
	
	Lock lock = new ReentrantLock();
	private int tickets = 20;
	
	@Override
	public void run() {
		//用三种方式实现的同步：1.锁  2.对函数进行synchoronized修饰  3.使用synchoronized代码块
		
		for(int i=0; i<100; i++) {
			
//			saleTicketsLock();
//			System.out.println(Thread.currentThread().getName());	//如果有这句话，那么有这一句话或是两句话一起都能正常运行
			
//			saleTicketsSychronized();
			
			synchronized(this) {
				if(tickets>0) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					tickets--;
					System.out.println("还剩"+tickets+"张票");
				}
			}
			
			
		}
	}
	
	public void saleTicketsLock() {		//用锁的方式实现同步
		lock.lock();
		
		if(tickets>0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tickets--;
			System.out.println("还剩"+tickets+"张票");
//			System.out.println(Thread.currentThread().getName());		//如果单放这句话，只会显示Thread-0，这可能说明在run方法中能获取到线程的属性，在其他地方只能获得线程的默认值比如，Name为thread-0
		}
		
		lock.unlock();
	}
	
	public synchronized void saleTicketsSychronized() {
		if(tickets>0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tickets--;
			System.out.println("还剩"+tickets+"张票");
		}
	}
	
	
	
	
	
}