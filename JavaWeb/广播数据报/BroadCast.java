/*
广播数据包涉及到地址和端口
Internet的地址是a.b.c.d的形式，该地址的一部分代表用户自己的主机，而另一部分代表用户所在的网络
ABC三类地址的划分不做详细描述
224.0.0.0 - 224.255.255.255是保留地址，称作D类地址

广播数据报是一种教新的技术，要广播或接收广播的主机都必须加入同一个D类地址
一个D类地址也称作一个组播地址，D类地址并不代表某个特定主机的位置
一个具有A、B或C类地址的主机要广播数据或接收广播，都必须加入同一个D类地址

*/

import java.net.*;
public class BroadCast extends Thread{
	String s = "天气预报，最高32度，最低25度";
	int port = 5858;        //组播端口
	InetAddress group = null;      //组播组地址
	MulticastSocket socket = null;    //多点广播套接字
	BroadCast(){
		try{
			group = InetAddress.getByName("239.255.8.0");    //设置广播地址为239.255.8.0
			socket = new MulticastSocket(port);            //多点广播套接字将在port端口广播
			socket.setTimeToLive(1);          //多点广播套接字发送数据报范围为本地网络
			socket.joinGroup(group);      //加入group后，socket发送的数据报被group中的成员接收到
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void run(){
		while(true){
			try{
				DatagramPacket packet = null;       //待广播的数据包
				byte data[] = s.getBytes();
				packet = new DatagramPacket(data, data.length, group, port);
				System.out.println(new String(data));
				socket.send(packet);     //广播数据包
				sleep(2000);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	public static void main(String args[]){
		new BroadCast().start();
	}
}

