public class Main{
	public static int test(){
		int i = 0;
		try{
			
			return i;            //将i复制一份寄存起来，finally执行完之后再返回
		}
		finally{
			i++;
			return i;          //因为修改了将要返回的i,这里返回新的i
		}
	}
	
	public static int test2(){
		int i = 0;
		try{
			
			return i;            
		}
		finally{
			
			return 2;          // finally的返回覆盖了try的返回
		}
	}
	
	public static int test3(){
		int i = 0;
		try{
			
			return i;            
		}
		finally{
			i++;              //这里虽然修改了i的值，但是没有将它更新到需要返回到的那个复制变量出
			
		}
	}
	public static void main(String args[]){
		int j = test();
		System.out.println(j);       //  j = 1
		
		j = test2();
		System.out.println(j);       //  j = 2
		
		j = test3();
		System.out.println(j);       //  j = 0
	}
}