interface ShowMessage{
	void showIcon(String s);
}

class TV implements ShowMessage{
	public void showIcon(String s){
		System.out.println(s);
	}
}

class PC implements ShowMessage{
	public void showIcon(String s){
		System.out.println(s);
	}
}

class Phone implements ShowMessage{
	public void showIcon(String s){
		System.out.println(s);
	}
}

public class Main{
	/*
	如果一个方法的参数是接口类型，用户就可以将 任何 实现该接口的类 的实例 的引用传递给该接口参数，那么
	接口参数就可以回调类实现的接口方法
	*/
	public static void example(ShowMessage sm){
		sm.showIcon("iPhone X 我有十几台");
	}
	public static void main(String[] args){
		/*
		接口回调是指，可以把实现某一接口的类 创建的对象 的引用 赋值给该接口声明的接口变量，那么该
		接口变量就可以调用被类实现的接口中的方法。实际上，当接口变量调用被类实现的接口中的方法时，就是
		通知相应的对象调用接口的方法
		*/
		ShowMessage sm;
		sm = new TV();
		sm.showIcon("长城牌电视机");
		sm = new PC();
		sm.showIcon("联想奔月5008PC机");
		sm = new Phone();
		example(sm);
	}
}