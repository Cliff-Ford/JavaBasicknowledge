class Array{
	public static void printArray(int[] arr){
		System.out.println("输出一个一维数组");
		//输出一个整型数组
		for(int t : arr)
			System.out.print(t + " ");
		System.out.println();
	}
	//可对输出函数进行重载
	public static void printArray(int[][] arr){
		System.out.println("输出一个二维数组");
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
public class Main{
	public static void main(String[] args){
		//声明一维数组的两种方法
		int a[];
		int[] b;
		//声明二维数组的两种方法同理
		double c[][];
		double[][] d;
		//注意：java中声明数组时，不可以说明有几个元素，需要用关键字new创建相应元素
		a = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		Array.printArray(a);
		//数组的声明和创建一起
		int[][] e = new int[2][2];
		e[0][0] = 4;
		e[0][1] = 5;
		e[1][0] = 6;
		e[1][1] = 7;
		Array.printArray(e);
		//可以创建不整齐的数组
		int f[][] = new int[2][];
		f[0] = new int[1];
		f[1] = new int[2];
		f[0][0] = 8;
		f[1][0] = 9;
		f[1][1] = 10;
		Array.printArray(f);
	}
}
