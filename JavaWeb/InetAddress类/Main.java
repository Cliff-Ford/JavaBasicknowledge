/*
Internet上的主机有以下两种方式表示地址

1 域名 www.tsinghua.edu.cn
2 IP   202.108.35.210

java.net包中的InetAddress类对象含有一个Internet主机地址的域名和IP地址
如 www.sina.com.cn/202.108.35.210

此域名容易记忆，当在连接网络时输入一个主机的域名之后，域名服务器dns负责将域名转换为IP地址，这样才能和主机建立连接

https://blog.csdn.net/u012561176/article/details/48183181
*/
import java.net.*;
public class Main{
	public static void main(String args[]){
		try{
			InetAddress address_1 = InetAddress.getByName("www.sina.com.cn");    //静态方法获取对象
			System.out.println(address_1.toString());
			InetAddress address_2 = InetAddress.getByName("183.232.24.222");
			System.out.println(address_2.getHostName());     //获取主机名  不知道为什么结果是ip
			System.out.println(address_2.getCanonicalHostName());
			InetAddress address_3 = InetAddress.getByName("");
			System.out.println(address_3.getHostAddress());  //获取IP
		}
		catch(UnknownHostException e){
			System.out.println("无法找到");
		}
	}
}