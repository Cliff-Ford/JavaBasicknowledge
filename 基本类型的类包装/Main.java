
import java.lang.*;

public class Main{
	public static void main(String[] args){
		//java的基本数据类型包括byte short char int long float double
		//对应的包装类是        Byte Short Character Integer Long Float Double
		//jdk1.5之后允许基本类型数据和相应的对象之间互相自动转换功能，称作基本数据类型的自动装箱与拆箱
		Integer x = 100, y = 12;  //装箱：Integer x = new Integer(100), y = new Integer(12);
		Integer m = x + y; //先拆箱再装箱： Integer m = new Integer(x.intValue() + y.intValue());
		System.out.println(m);
		//装箱时必须保证类型的一致性，否则会报错
		//Float c = 12; 错误操作
		Float c = 12.0f;
		System.out.println(c);
		
	}
}