public class Test1 {
	//�����⣺���߳�ѭ��5�Σ����߳�ѭ��6�Σ�Ȼ���ֻص���ѭ��5�Σ�����ֻص����߳�6�Σ����ѭ��5�Ρ�
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
	
	boolean sub = true;
	
	public synchronized void sub(int i) {
		if(!sub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j=0; j<5; j++) {
			System.out.println("sub: No."+j+" of loop "+i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		sub = false;
		this.notify();
	}
	
	public synchronized void main(int i) {
		
		if(sub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j=0; j<6; j++) {
			System.out.println("main: No."+j+" of loop "+i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		sub = true;
		this.notify();
		
	}
	
}