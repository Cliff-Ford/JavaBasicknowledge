import java.util.*;
import static java.util.Calendar.*;
public class Main{
	public static void myCalendarPrint(Calendar c){
		System.out.println(c);//反正看不懂
		System.out.println("输出年：" + String.valueOf(c.get(YEAR)));
		System.out.println("输出月：" + String.valueOf(c.get(MONTH) + 1));//一月用0表示，所以要逻辑转换加一
		System.out.println("输出日：" + String.valueOf(c.get(DAY_OF_MONTH)));
		System.out.println("输出星期几：" + String.valueOf(c.get(DAY_OF_WEEK) - 1));//星期天是0
		System.out.println("输出时：" + String.valueOf(c.get(HOUR_OF_DAY)));
		System.out.println("输出分：" + String.valueOf(c.get(MINUTE)));
		System.out.println("输出秒：" + String.valueOf(c.get(SECOND)));
	}
	public static void main(String []args){
		Calendar calendar = Calendar.getInstance();//静态方法初始化
		myCalendarPrint(calendar);
		
		
		calendar.setTime(new Date());       //同上面的静态方法等效
		myCalendarPrint(calendar);
	}
}