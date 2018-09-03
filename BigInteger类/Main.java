import java.math.*;
public class Main{
	public static void main(String []args){
		System.out.println("hello");
		//public BigInteger add(BigInteger val)    返回当前大整数对象与参数的和
		//public BigInteger subtract(BigInteger val) 返回差值
		//public BigInteger multiply(BigInteger val) 返回积
		//public BigInteger divide(BigInteger val) 返回商
		//public BigInteger remainder(BigInteger val) 返回余
		//public int compareTo(BigInteger val) 返回-1 0 1
		//public BigInteger abs(int a)
		//public BigInteger pow()
		//public String toString(int p) 返回当前大整数对象p进制的字符串表示

		
		// 求 1 + 2！+ 3！+ ... + 200！
		BigInteger sum = new BigInteger("0"),
					one = new BigInteger("1"),
					i = one,
					item = one,
					m = new BigInteger("200");
		while(i.compareTo(m) <= 0){
			sum = sum.add(item);
			i = i.add(one);
			item = item.multiply(i);
		}
		System.out.println("sum = " + sum);
	}
}