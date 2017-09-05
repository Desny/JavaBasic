package com.dfbz.demo.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	
	static int i = 0;
	public static void main(String[] args) {
		Timer tm = new Timer();
		tm.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(i<10) {
					
					System.out.println("我执行"+i+"次啦");
					i++;
				}else{
					tm.cancel();
				}
			}
		}, 500, 1000);		//第二个参数是最开始执行操作的延迟时间(在本例中是500ms)，仅使用一次；第三个参数是操作之间的间隔时间(在本例中是1s)
	}
	
}
