import java.util.*;
import java.text.*;
public class Main{
	public static void main(String []args){
		double a = -4;
		double b = 2.890;
		System.out.println("输出绝对值" + Math.abs(a));
		System.out.println("输出最大值" + Math.max(a,b));
		System.out.println("输出最小值" + Math.min(a,b));
		System.out.println("输出随机数" + Math.random());
		System.out.println("输出a的b次幂" + Math.pow(a,2));
		System.out.println("输出b的平方根" + Math.sqrt(b));
		System.out.println("输出b的对数" + Math.log(b));
		System.out.println("输出正弦值" + Math.sin(a));
		System.out.println("输出余弦值" + Math.cos(a));
		System.out.println("输出反正弦值" + Math.asin(b));
		
		
		//格式化
		NumberFormat f = NumberFormat.getInstance();
		f.setMaximumFractionDigits(7); //小数点及后面的数字，最多7位
		f.setMinimumIntegerDigits(3);//小数点前面最少3位
		String s = f.format(b);
		System.out.println(s);
		
		f.setMinimumFractionDigits(7); //小数点及后面的数字，最少7位
		f.setMaximumIntegerDigits(1);//小数点前面最多3位
		s = f.format(b);
		System.out.println(s);
		
	}
}