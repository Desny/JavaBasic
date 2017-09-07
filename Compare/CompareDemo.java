package com.dfbz.test.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CompareDemo {
	public static void main(String[] args) {
		Employee em1 = new Employee(1, "С��", "��ͨԱ��", 200);
		Employee em2 = new Employee(2, "��÷÷", "��Ŀ����", 800);
		Employee em3 = new Employee(3, "����", "�ܼ�", 1000.50);
		
		Set<Employee> em = new HashSet<>();		//Set�洢
		em.add(em1);
		em.add(em2);
		em.add(em3);
		
//		Employee employee = new Employee();		//��Comparator�Ƚ����������С
//		System.out.println(employee.compare(em1, em2));
		
//		Iterator<Employee> it = em.iterator();		//����������
//		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
//		for (Employee employee : em) {		//for-each����
//			System.out.println(employee);
//		}
		
		
		List<Employee> list = new ArrayList<>();		//List�洢
		list.add(em1);
		list.add(em3);
		list.add(em2);
		
//		System.out.println(em1.compareTo(em2));		//Comparable�Ƚ���������Ĵ�С
		
//		Collections.sort(list);		//Comparable����
//	
//		Collections.sort(list, new Employee());//Comparator���򷽷�1

//		Collections.sort(list,new Comparator<Employee>() {		//Comparator���򷽷�2
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return o1.getId()-o2.getId();
//			}
//			
//		} );
//		

//		Collections.sort(list, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				return (int)(o2.getSalary()-o1.getSalary());		//ע�⺯�����ص���intֵ������Ҫ��������ת��
//			}
//		});
	
		
	}
}
