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
		//�����ַ�ʽʵ�ֵ�ͬ����1.��  2.�Ժ�������synchoronized����  3.ʹ��synchoronized�����
		
		for(int i=0; i<100; i++) {
			
//			saleTicketsLock();
//			System.out.println(Thread.currentThread().getName());	//�������仰����ô����һ�仰�������仰һ������������
			
//			saleTicketsSychronized();
			
			synchronized(this) {
				if(tickets>0) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					tickets--;
					System.out.println("��ʣ"+tickets+"��Ʊ");
				}
			}
			
			
		}
	}
	
	public void saleTicketsLock() {		//�����ķ�ʽʵ��ͬ��
		lock.lock();
		
		if(tickets>0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tickets--;
			System.out.println("��ʣ"+tickets+"��Ʊ");
//			System.out.println(Thread.currentThread().getName());		//���������仰��ֻ����ʾThread-0�������˵����run�������ܻ�ȡ���̵߳����ԣ��������ط�ֻ�ܻ���̵߳�Ĭ��ֵ���磬NameΪthread-0
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
			System.out.println("��ʣ"+tickets+"��Ʊ");
		}
	}
	
	
	
	
	
}