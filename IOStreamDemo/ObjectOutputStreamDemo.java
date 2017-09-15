package study;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamDemo {
	//序列化

	public static void main(String[] args) throws IOException {
		//序列化单个对象
//		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("F:/Hello.txt")) ;
//		Person p = new Person();
//		p.setAge(18);
//		p.setName("小李");
//		obj.writeObject(p);
//		obj.close();
		
		//序列化多个对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:/Hello.txt"));
		Person person1 = new Person("小王", 22);
		Person person2 = new Person("小张", 20);
//		Person[] ps = {person1, person2};
		List<Person> ps = new ArrayList<>();
		ps.add(person1);
		ps.add(person2);
		oos.writeObject(ps);		//这里是可以存储数组的;和序列化单个对象的操作的唯一不同之处就在于此
		oos.close();
	}
}
