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
		Employee em1 = new Employee(1, "小明", "普通员工", 200);
		Employee em2 = new Employee(2, "韩梅梅", "项目主管", 800);
		Employee em3 = new Employee(3, "李明", "总监", 1000.50);
		
		Set<Employee> em = new HashSet<>();		//Set存储
		em.add(em1);
		em.add(em2);
		em.add(em3);
		
//		Employee employee = new Employee();		//用Comparator比较两个对象大小
//		System.out.println(employee.compare(em1, em2));
		
//		Iterator<Employee> it = em.iterator();		//迭代器遍历
//		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
//		for (Employee employee : em) {		//for-each遍历
//			System.out.println(employee);
//		}
		
		
		List<Employee> list = new ArrayList<>();		//List存储
		list.add(em1);
		list.add(em3);
		list.add(em2);
		
//		System.out.println(em1.compareTo(em2));		//Comparable比较两个对象的大小
		
//		Collections.sort(list);		//Comparable排序
//	
//		Collections.sort(list, new Employee());//Comparator排序方法1

//		Collections.sort(list,new Comparator<Employee>() {		//Comparator排序方法2
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
//				return (int)(o2.getSalary()-o1.getSalary());		//注意函数返回的是int值，所以要进行类型转换
//			}
//		});
	
		
	}
}
