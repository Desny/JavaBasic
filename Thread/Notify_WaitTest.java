package com.dfbz.demo.thread;

public class Notify_WaitTest {
	//�����⣺���߳�ѭ��10�Σ����߳�ѭ��15�Σ�Ȼ���ֻص���ѭ��10�Σ�����ֻص����߳�15�Σ����ѭ��5�Ρ�
	
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
	private boolean sub = true;		//Ϊtrue�����ʱӦ�ô�ӡsub(���߳�)  false����Ӧ�ô�ӡmain�߳�
	
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
		this.notify();		//����Ӧ���ǻ�����ChangeThread�����ϵȴ����߳�
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