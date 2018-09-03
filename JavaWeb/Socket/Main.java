/*
IP地址标识Internet上的计算机，端口号标识正在计算机上运行的进程
端口号和IP地址组合出一个网络套接字，端口号被规定为一个16位的整数 0 - 65535
其中 0 - 1023 被预定义的服务通信占用（如teInet占用端口23 http占用端口80 ）

当两个程序需要通信时，他们可以通过使用socket类建立套接字对象并连接在一起

Socket(String host, int port)  host是服务器的ip地址 port是端口号
建立套接字连接可能发生IOException异常 因此要建立到服务器的套接字连接应使用如下代码
try{
	Socket mysocket = new Socket("http://192.168.0.78", 1880);
}
catch(IOException e){
	
}
当套接字连接mysocket后，可以想象一条通信线路已经建立起来，
可以使用getInputStream()获得一个输入流，然后用这个输入流读取服务器放入到线路的信息
但不能读取自己放入线路的信息，就像打电话时，只能听到对方放入线路里面的声音

getOutputStream()获取一个输出流，然后用这个输出流将信息写入线路

实际编程上，常把getInputStream获得的输入流连接到另一个数据流上，然后就可以从这个数据流读取服务器的信息
之所以这样做是因为后面DataInputStream流有更好的从流中读取服务器的信息

同样道理，getOutputStream得到的流也会绑定到另一个DataOutputStream流上去

*/

import java.io.*;
import java.net.*;
public class Main{
	public static void main(String args[]){
		Socket socket;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try{
			socket = new Socket("127.0.0.1", 4331);
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			char c = 'a';
			while(true){
				if(c > 'z'){
					c = 'a';
				}
				dataOutputStream.writeChar(c);
				char s = dataInputStream.readChar();       //in读取信息时，堵塞状态
				System.out.println("客户端收到：" + s);
				c++;
				Thread.sleep(500);
			}
		}
		catch(InterruptedException ee){
			System.out.println(ee);
		}
		catch(IOException e){
			System.out.println("服务器已断开" + e);
		}
	}
}