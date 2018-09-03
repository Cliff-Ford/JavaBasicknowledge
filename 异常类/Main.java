/*
Java的异常通常出现在方法调用过程中，
即在方法调用过程中抛出异常对象，导致程序运行出现异常
并等待处理
异常对象可以调用以下方法输出有关异常的信息
public String getMessage();
public void printStackTrace();
public String toString();
*/

//现在自定义一个异常类
class IntegerException extends Exception{
	String message;
	IntegerException(int m){
		message = "年龄" + m + "不合理";
	}
	//重写toString方法
	public String toString(){
		return message;
	}
}

class People{
	private int age = 1;
	public void setAge(int age) throws IntegerException{
		if(age >= 160 || age <=0){
			throw new IntegerException(age);   //方法抛出异常，导致方法结束
		}else{
			this.age = age;
		}
	}
}


public class Main{
	public static void main(String[] args){
		int n = 0, m = 0, t = 555;
		try{
			m = Integer.parseInt("8888");
			n = Integer.parseInt("abc789");  //发生异常，转向catch部分，后面的语句并没有执行
			t = 9999;                      //并没有执行
		}
		catch(NumberFormatException e){
			System.out.println("用getMessage()处理异常：" + e.getMessage());
			System.out.print("printStackTrace()处理异常：");
			e.printStackTrace();
			System.out.println("toString()处理异常：" + e.toString());
		}
		System.out.println(m);          //执行了，并没有因为之前的try语句块中的错误而堵塞
		
		//测试自己定义的异常类
		People wang = new People();
		try{
			wang.setAge(189);
		}
		catch(IntegerException e){
			System.out.println(e.toString());
		}
		
	}
}