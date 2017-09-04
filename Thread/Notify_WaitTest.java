package com.dfbz.demo.thread;

public class Notify_WaitTest {
	//面试题：子线程循环10次，主线程循环15次，然后又回到子循环10次，最后又回到主线程15次，如此循环5次。
	
	public static void main(String[] args) {
		ChangeThread ct = new ChangeThread();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<5; i++) {
					ct.sub(i);
				}
			}
		}).start();
		
		for(int i=0; i<5; i++) {
			ct.main(i);
		}
	}
	
	
}

class ChangeThread {
	private boolean sub = true;		//为true代表此时应该打印sub(子线程)  false代表应该打印main线程
	
	public synchronized void sub(int i) {
		while(!sub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j=0; j<10; j++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("sub: No."+j+"of loop"+i);
		}
		sub = false;
		this.notify();		//这里应该是唤醒在ChangeThread对象上等待的线程
	}
	
	public synchronized void main(int i) {
		while(sub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j=0; j<15; j++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("main: No."+j+"of loop"+i);
		}
		sub = true;
		this.notify();
	}
	
}