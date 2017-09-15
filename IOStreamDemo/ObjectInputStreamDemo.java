package study;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//�����л���������
//		ObjectInputStream obj = new ObjectInputStream(new FileInputStream("F:/Hello.txt"));
//		Person p = (Person) obj.readObject();
//		obj.close();
//		System.out.println(p);
		
		//�����л��������
		ObjectInputStream obj = new ObjectInputStream(new FileInputStream("F:/Hello.txt"));
		List<Person> ps = (List<Person>) obj.readObject();
		System.out.println(ps);
		obj.close();
	}
}
