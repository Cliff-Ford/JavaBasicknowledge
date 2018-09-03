/*
客户负责建立客户到服务器的套接字连接，即客户负责呼叫
因此服务器必须建立一个等待接受客户的套接字的ServerSocket对象

构造方法 ServerSocket(int port)

当建立ServerSocket对象时，可能发生IOException异常，例如端口号被占用
try{
	ServerSocket serverSocket = new ServerSocket(1880);
}
catch(IOException e){
	
}

当服务器ServerSocket对象建立后，就可以使用方法accept()接受客户的套接字连接呼叫
但接收的客户套接字也可能发生异常，因此
try{
	Socket sc = serverSocket.accept();
}
catch(IOException e){
	
}
所谓的“接收”客户的套接字连接就是accept()会返回一个和客户端Socket对象相连接的Socket对象
服务器的这个Socket对象sc使用getOutputStream()方法获得的输出流将指向客户端Socket对象mySocket使用getInputStream获得的输入流

同样，服务器这个socket对象sc使用getInputStream获得的输入流将指向客户端Socket对象mysocket使用getOutputStream获得的输出流

需要注意的是，从套接字连接中读取数据与从文件中读取数据有着很大的不同，尽管二者都是输入流
从文件中读取数据时，所有的数据都已经在文件中
而使用套接字连接时，可能在另一端数据发送出来之前，就已经开始试着读取了，这时就会堵塞本线程，知道该读取方法成功读取到信息
本线程才继续执行后续的操作

另外，accept方法也会堵塞本线程的继续执行，知道接受到客户的呼叫
try{
	Socket sc = serverSocket.accept();
	System.out.println("ok");  //如果客户没有呼叫，这句话就不会输出
}
catch(IOException e){}


serverSocket对象可以调用setSoTimeOut(int timeout)方法设置超时值，timeout是一个正值
当serverSocket对象调用accept方法堵塞的时间一旦超过timeout时，将触发SocketTimeoutException事件

*/

import java.io.*;
import java.net.*;
public class Main{
	public static void main(String args[]){
		ServerSocket serverSocket = null;
		Socket sc = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		try{
			serverSocket = new ServerSocket(4331);
		}
		catch(IOException e){            //端口可能被占用
			System.out.println(e);
		}
		try{
			System.out.println("等待客户呼叫");
			sc = serverSocket.accept();      //堵塞状态，除非客户呼叫
			dataOutputStream = new DataOutputStream(sc.getOutputStream());
			dataInputStream = new DataInputStream(sc.getInputStream());
			while(true){
				char c = dataInputStream.readChar();   //读取信息，堵塞状态
				System.out.println("服务器收到" + c);
				dataOutputStream.writeChar((char)(c - 32));
				Thread.sleep(500);
			}
		}
		catch(Exception e){
			System.out.println("客户断开了连接" + e);
		}
	}
}

























