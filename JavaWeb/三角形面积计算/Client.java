/*
我们已经知道，使用套接字时，可能在另一端数据发送出来之前，就已经开始试着读取了，这时就会堵塞本线程，直到该读取方法读取到信息
本线程才继续执行后续的操作
因此，服务器接受到一个客户的套接字后，应该启动一个专门为该客户服务的线程

*/

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ComputerClient extends JFrame implements Runnable,ActionListener{
	JButton connection, send;
	JTextField inputText;
	JTextArea showResult;
	Socket socket = null;
	DataInputStream in = null;
	DataOutputStream out = null;
	Thread thread;
	ComputerClient(){
		socket = new Socket();
		connection = new JButton("连接服务器");
		send = new JButton("发送");
		send.setEnabled(false);              //什么意思？ 按钮不可点击
		send.addActionListener(this);
		inputText = new JTextField(6);
		showResult = new JTextArea();
		add(connection,BorderLayout.NORTH);
		JPanel pSouth = new JPanel();
		pSouth.add(new JLabel("输入三角形三边的长度，用逗号或空格分隔："));
		pSouth.add(inputText);
		pSouth.add(send);
		add(new JScrollPane(showResult),BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);
		connection.addActionListener(this);
		thread = new Thread(this);
		setBounds(100,30,460,400);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == connection){
			try{
				if(socket.isConnected()){
					
				}
				else{
					InetAddress address = InetAddress.getByName("127.0.0.1");
					InetSocketAddress socketAddress = new InetSocketAddress(address,4331);
					socket.connect(socketAddress);
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
					send.setEnabled(true);
					if(!(thread.isAlive())){
						thread = new Thread(this);
						thread.start();
					}
				}
			}
			catch(IOException ee){
				System.out.println(ee);
				socket = new Socket();               //什么？
			}
		}
		else if(e.getSource() == send){
			String s = inputText.getText();
			if(s != null){
				try{
					
					out.writeUTF(s);
					System.out.println("已发送" + s);
				}
				catch(IOException e1){
					System.out.println(e1);
				}
			}
		}
	}
	public void run(){
		String s = null;
		double result = 0;
		while(true){
			try{
				s = in.readUTF();
				result = in.readDouble();
				showResult.append(s + result + "\n");
			}
			catch(IOException e){
				showResult.setText("与服务器已断开" + e);
				socket = new Socket();
				break;
			}
		}
	}
}

public class Client{
	public static void main(String args[]){
		new ComputerClient();
	}
}