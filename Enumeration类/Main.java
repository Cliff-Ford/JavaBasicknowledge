/*
Enumeration接口中定义了一些方法，通过这些方法可以枚举（一次一个）对象集合中的元素
这种传统接口一杯迭代器取代，虽然Enumeration还未被遗弃，但在现代代码中已经被很少使用了。
尽管如此，它还是使用在诸如Vector和Properties这些传统类所定义的方法中
除此之外，还用在一些API类，并且在应用程序中也广泛被使用


http://www.runoob.com/java/java-enumeration-interface.html
*/

import java.util.*;

public class Main{
	public static void main(String args[]){
		Enumeration<String> days;
		Vector<String> dayNames = new Vector<String>();
		dayNames.add("Sunday");
		dayNames.add("Monday");
		dayNames.add("Tuesday");
		dayNames.add("Wednesday");
		dayNames.add("Thursday");
		dayNames.add("Friday");
		dayNames.add("Saturday");
		days = dayNames.elements();
		while(days.hasMoreElements()){
			System.out.println(days.nextElement());
		}
	}
}