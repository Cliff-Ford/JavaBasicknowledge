import java.io.*;
import java.net.*;
import java.util.*;

class Server_thread extends Thread{
	Socket socket;
	DataOutputStream out = null;
	DataInputStream in = null;
	String s = null;
	boolean quesion = false;
	Server_thread(Socket t){
		socket = t;
		try{
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
		}
		catch(IOException e){
			
		}
	}
	public void run(){
		while(true){
			double a[] = new double[3];
			int i = 0;
			try{
				s = in.readUTF();          //堵塞状态，除非读到信息
				System.out.println(s);
				quesion = false;
				StringTokenizer fenxi = new StringTokenizer(s," ,");
				while(fenxi.hasMoreTokens()){
					String temp = fenxi.nextToken();
					try{
						a[i] = Double.valueOf(temp).doubleValue();
						i++;
					}
					catch(NumberFormatException e){
						out.writeUTF("请输入数字字符");
						out.writeDouble(-100);
						quesion = true;
					}
				}
				if(quesion == false){
					double p = (a[0] + a[1] + a[2]) / 2.0;
					out.writeUTF("三边是：" + a[0] + "," + a[1] + "," + a[2] + "的三角形的面积");
					out.writeDouble(Math.sqrt(p * (p - a[0]) * (p - a[1]) * (p - a[2])));
				}
			}
			catch(IOException e){
				System.out.println("客户离开");
				return;
			}
		}
	}
}

public class Server{
	public static void main(String args[]){
		ServerSocket serverSocket = null;
		Socket sc = null;
		try{
			serverSocket = new ServerSocket(4331);
		}
		catch(IOException e){
			System.out.println(e);
		}
		

		while(true){
			try{
				System.out.println("等待客户呼叫");
				sc = serverSocket.accept();
				System.out.println("客户地址：" + sc.getInetAddress());
			}
			catch(IOException e){
				System.out.println("正在监听");      //ServerSocket对象不能重复创建
				
			}
			if(sc != null){
				new Server_thread(sc).start();       //为每个客户启动一个专门的线程
			}
		}
	}
}