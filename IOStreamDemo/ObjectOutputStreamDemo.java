package study;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamDemo {
	//���л�

	public static void main(String[] args) throws IOException {
		//���л���������
//		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("F:/Hello.txt")) ;
//		Person p = new Person();
//		p.setAge(18);
//		p.setName("С��");
//		obj.writeObject(p);
//		obj.close();
		
		//���л��������
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:/Hello.txt"));
		Person person1 = new Person("С��", 22);
		Person person2 = new Person("С��", 20);
//		Person[] ps = {person1, person2};
		List<Person> ps = new ArrayList<>();
		ps.add(person1);
		ps.add(person2);
		oos.writeObject(ps);		//�����ǿ��Դ洢�����;�����л���������Ĳ�����Ψһ��֮ͬ�������ڴ�
		oos.close();
	}
}
