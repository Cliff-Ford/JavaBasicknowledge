/*
TreeSet要求存放的对象所属的类必须实现Comparable接口，该接口提供比较元素的compareTo()方法
当插入元素时会回调该方法比较元素的大小

TreeMap要求存放的键值对映射的键必须实现Comparable接口从而根据键对元素进行排序

Collections工具类的sort方法有两种重载的形式，第一种要求传入的待排序容器中存放的对象比较实现Comparable接口以实现比较

第二种不强制性的要求容器中的元素必须可比较，但是要求传入第二个参数，参数是Comparator接口的子类型（需要重写compare方法实现元素的比较），相当于临时定义的排序规则，其实就是通过接口注入比较元素大小的算法，也是对回调模式的应用


*/

import java.util.*;

class Student implements Comparable<Student>{
	private String name;
	private int age;
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString(){
		return "Student [name = " + name + ",age = " + age + "]";
	}
	@Override
	public int compareTo(Student o){
		return this.age - o.age;      //年龄升序
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}

public class Main{
	public static void main(String args[]){
		//TreeSet排序案例
		Set<Student> set = new TreeSet<>();
		set.add(new Student("Hao Luo",33));
		set.add(new Student("XJ WANG",32));
		set.add(new Student("BRUCE LEE",40));
		set.add(new Student("Bob Yang",22));
		for(Student stu : set){
			System.out.println(stu);
		}
		//Collections工具类的sort方法 
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("dsf",20));
		list.add(new Student("dsf",24));
		list.add(new Student("dsf",30));
		list.add(new Student("dsf",67));
		list.add(new Student("dsf",19));
		/*
		通过sort方法的第二个参数传入一个Comparator接口对象
		相当于是传入一个比较对象大小的算法到sort方法中
		由于java中没有函数指针，仿函数、委托这样的概念
		因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
		
		*/
		
		Collections.sort(list,new Comparator<Student>(){
			@Override
			public int compare(Student o1,Student o2){
				return o1.getAge() - o2.getAge();
			}
		});
		
		for(Student stu : list){
			System.out.println(stu);
		}
		
		
		
		
		
		
		
		
	}
}