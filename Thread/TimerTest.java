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
					
					System.out.println("��ִ��"+i+"����");
					i++;
				}else{
					tm.cancel();
				}
			}
		}, 500, 1000);		//�ڶ����������ʼִ�в������ӳ�ʱ��(�ڱ�������500ms)����ʹ��һ�Σ������������ǲ���֮��ļ��ʱ��(�ڱ�������1s)
	}
	
}
