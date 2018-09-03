/*
ObjectInputStream(InputStream in)
ObjectOutputStream(OutputStream out)
准备将一个对象写入到文件时，应该首先用这个

当使用对象流写入或读入对象时，要保证对象时序列化的，这是为了保证能把对象写入到文件，并能正确读回到程序中

一个类如果实现了Serializable接口，那么这个类创建的对象就是所谓序列化的对象

Serializable接口中没有方法

*/

import java.io.*;
class Student implements Serializable{
	String name = null;
	double height;
	Student(String name, double height){
		this.name = name;
		this.height = height;
	}
	public void setHeight(double c){
		this.height = c;
	}
}

public class Main{
	public static void main(String args[]){
		Student zhang = new Student("张三",165);
		try{
			FileOutputStream file_out = new FileOutputStream("student.txt");
			ObjectOutputStream object_out = new ObjectOutputStream(file_out);
			object_out.writeObject(zhang);
			FileInputStream file_in = new FileInputStream("student.txt");
			ObjectInputStream object_in = new ObjectInputStream(file_in);
			Student li = (Student)object_in.readObject();
			li.setHeight(175);
			System.out.println(li.name + "身高是： " + li.height);
		}
		catch(ClassNotFoundException e){
			System.out.println("不能读出对象");
		}
		catch(IOException e){
			System.out.println("can not read file" + e);
		}
	}
}