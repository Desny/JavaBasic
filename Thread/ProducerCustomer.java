package com.dfbz.demo.thread;
public class ProducerCustomer {
	
	public static void main(String[] args) {
		
		Food food = new Food();
		Producer producer = new Producer(food);
		Customer customer = new Customer(food);
		new Thread(producer).start();
		new Thread(customer).start();
	}
}

class Producer implements Runnable {
	Food food;
	
	public Producer(Food food) {
		this.food = food;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			
			food.produceFood(i);
		}
		
	}
}

class Customer implements Runnable {
	Food food;
	
	public Customer(Food food) {
		this.food = food;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			
			food.buyFood(i);
		}
		
	}
}

class Food {
	public Food() {}
	boolean produce = true;
	
	public synchronized void produceFood(int i) {
		if(!produce) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(i%2==0) {
			System.out.print("������----->");
		}else{
			System.out.print("������----->");
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		produce = false;
		this.notify();
	}
	
	public synchronized void buyFood(int i) {
		if(produce) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(i%2==0) {
			System.out.println("����ɿ�");
		}else{
			System.out.println("�ʶ�����");
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		produce = true;
		this.notify();
	}
}



