import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
	public static void main(String[] args) {
		//多线程池
//		MyRunnable1 mr1 = new MyRunnable1();
//		MyRunnable1 mr11 = new MyRunnable1();
//		MyRunnable2 mr2 = new MyRunnable2();
//		MyRunnable2 mr22 = new MyRunnable2();
//		
//		ExecutorService es = Executors.newFixedThreadPool(3);
//		es.execute(mr1);
//		es.execute(mr11);
//		es.execute(mr2);
//		es.execute(mr22);
		
		//单线程池
		MyRunnable1 mr = new MyRunnable1();
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(mr);
		es.execute(mr);
	}
}

class MyRunnable1 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName()+"我是1号run"+i);
		}
		
	}
}

class MyRunnable2 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName()+"我是2号run"+i);
		}
		
	}
}