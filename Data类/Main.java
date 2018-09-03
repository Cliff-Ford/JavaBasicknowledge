import java.util.*;
import java.text.SimpleDateFormat;
public class Main{
	public static void main(String []args){
		//Date对象表示时间的默认顺序是星期，月，日，小时，分，秒，年
		Date dateNow = new Date();
		System.out.println("现在的时间是:" + dateNow);
		
		//public SimpleDateFormat(String pattern);该方法可以用参数pattern指定的格式，创建一个对象
		//该对象可以调用public String format(Date date)格式化指定日期
		
		//其中pattern中可以含有如下的格式符
		//y,yy 用2位数字表示的“年"替换
		//yyyy 用4位......
		//M 或 MM : 2位 ....月替换
		//MMM ： 汉字   月替换
		//d或dd : 2位   日替换
		//h或hh : 2位   时替换
		//m或mm : 2位   分替换
		//s或ss : 2位   秒替换
		//E     : 星期替换
		
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy年yy年MM月MMMdd日E hh时m分s秒");
		System.out.println(matter1.format(dateNow));
	}
}