import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shanghai{
	public static void main(String args[]){
		Shanghai_Frame beijing_win = new Shanghai_Frame("我是上海");
	}
}

class Shanghai_Frame extends JFrame implements Runnable, ActionListener{
	JTextField out_message = new JTextField(20);
	JTextArea in_message = new JTextArea();
	JButton send = new JButton("发送");
	Shanghai_Frame(String s){
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
				DatagramPacket data_pack = new DatagramPacket(buffer,buffer.length,address,4321); //自己从4321端口发出数据包，对方必须从4321端口才能接收
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
			mail_data = new DatagramSocket(1234);       //对方从1234端口发送数据包
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