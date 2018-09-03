/*
本例子将介绍java中基于UDP(用户数据报协议)协议的网络信息传输方式。
基于UDP的通信和基于TCP的通信不同，基于UDP的信息传递更快，但不提供可靠保证

也就是说，用户无法知道数据能否正确到达目的主机，也不能确定数据到达目的地的顺序是否和发送顺序相同

基于UDP通信的基本模式如下

1 将数据打包，称为数据包（好比将信件装入信封一样），然后将数据包发往目的地

2 接受别人发来的数据包（好比接收信封一样），然后查看数据包中的内容

发送数据包步骤如下

1 首先用DatagramPacket类将数据打包，即用DatagramPacket类创建一个对象，称为数据包
用DatagramPacket类的以下两个构造方法创建待发送的数据包
DatagramPacket(byte data[],int length,InetAddress address,int port);
DatagramPacket(byte data[],int offset,int length,InetAddress address,int port);

例子
byte data[] = "近来好吗？".getByte();
InteAddress address = InetAddress.getName("www.sian.com.cn");
DatagramPack data_pack = new DatagramPack(data, data.length, address, 980);

用上述方法创建的数据包 data_pack 调用方法  public int getPort()
                                           public InetAddress getAddress()
										   public byte[] getData()
										   
2 然后用DatagramSocket类的不带参数的构造方法DatagramSocket()创建一个对象，该对象负责发送数据包
DatagramSocket mail_out = new DatagramSocket();
mail_out.send(data_pack);


接收数据包步骤如下

首先用DatagramSocket类的另一个构造方法DatagramSocket(int port)创建一个对象，其中的参数必须和待接收的数据包的端口号相同
DatagramSocket mail_in = new DatagramSocket(5666);
然后对象mail_in使用方法receive(DatagramPacket pack)接收数据包，该方法有一个参数pack，方法receive把收到的数据包传递给该参数
因此必须预备一个数据包以便收取数据包
这时需要使用DatagramPack(byte data[],int length)创建一个数据包，用于接收数据包
byte data[] = new byte[100];
int length = 90;
DatagramPacket pack = new DatagramPacket(data, length);
mail_in.receive(pack);

receive方法会堵塞，直到收到数据包

*/

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Beijing{
	public static void main(String args[]){
		Beijing_Frame beijing_win = new Beijing_Frame("我是北京");
	}
}

class Beijing_Frame extends JFrame implements Runnable, ActionListener{
	JTextField out_message = new JTextField(20);
	JTextArea in_message = new JTextArea();
	JButton send = new JButton("发送");
	Beijing_Frame(String s){
		super(s);
		setSize(400,200);
		setVisible(true);
		send.addActionListener(this);
		JPanel pSouth = new JPanel();
		pSouth.add(out_message);
		pSouth.add(send);
		add(pSouth,"South"); //  add(pSouth, BorderLayout.SOUTH);
		add(new JScrollPane(in_message),"Center");
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread thread = new Thread(this);
		thread.start();        //线程负责接收数据包
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == send){
			byte buffer[] = out_message.getText().trim().getBytes();
			try{
				InetAddress address = InetAddress.getByName("127.0.0.1");
				DatagramPacket data_pack = new DatagramPacket(buffer,buffer.length,address,1234); //自己从1234端口发出数据包，对方必须从1234端口才能接收
				DatagramSocket mail_data = new DatagramSocket();
				mail_data.send(data_pack);
			}
			catch(Exception ee){
				System.out.println(ee);
			}
		}
	}
	public void run(){ //接收数据包
		DatagramPacket pack = null;
		DatagramSocket mail_data = null;
		byte data[] = new byte[8192];    //不可超过8192字节
		try{
			pack = new DatagramPacket(data,data.length);
			mail_data = new DatagramSocket(4321);       //对方从4321端口发送数据包
		}
		catch(Exception e){
			System.out.println(e);
		}
		while(true){
			if(mail_data == null) break;
			else{
				try{
					mail_data.receive(pack);
					String message = new String(pack.getData(),0,pack.getLength());
					in_message.append("收到数据：" + message + "\n");
				}
				catch(Exception e){
					System.out.println(e);
					
				}
			}
		}
	}
}

























