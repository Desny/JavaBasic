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
			System.out.print("锅包肉----->");
		}else{
			System.out.print("酱肘子----->");
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
			System.out.println("香甜可口");
		}else{
			System.out.println("肥而不腻");
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



