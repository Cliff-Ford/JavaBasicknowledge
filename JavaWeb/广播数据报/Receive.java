import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Receive extends JFrame implements Runnable, ActionListener{
	int port;       //组播端口
	InetAddress group = null;        //组播组地址
	MulticastSocket socket = null;     //多点广播套接字
	JButton start, stop;
	JTextArea receiving,received;
	int i = 1;
	Thread thread;        //负责接收信息的进程
	boolean end = false;
	public Receive(){
		super("定时接收信息");
		thread = new Thread(this);
		start = new JButton("开始接收");
		stop = new JButton("停止接收");
		start.addActionListener(this);
		stop.addActionListener(this);
		receiving = new JTextArea(10,10);
		received = new JTextArea(10,10);
		JPanel north = new JPanel();
		north.add(start);
		north.add(stop);
		add(north,"North");
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,2));
		center.add(new JScrollPane(receiving));
		center.add(new JScrollPane(received));
		add(center,"Center");
		validate();
		port = 5858;
		try{
			group = InetAddress.getByName("239.255.8.0");
			socket = new MulticastSocket(port);
			socket.joinGroup(group);
		}
		catch(Exception e){
			System.out.println(e);
		}
		setBounds(100,50,360,380);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == start){
			if(! (thread.isAlive())){
				thread = new Thread(this);
			}
			try{
				thread.start();
				end = false;
			}
			catch(Exception ee){
				System.out.println(ee);
			}
		}
		else if(e.getSource() == stop){
			end = true;
		}
	}
	public void run(){
		while(true){
			byte data[] = new byte[8912];
			DatagramPacket packet = null;
			packet = new DatagramPacket(data, data.length, group, port);
			try{
				socket.receive(packet);
				String message = new String(packet.getData(),0,packet.getLength());
				receiving.setText("正在接收 ：" + message + "\n");
				received.append(i + " " + message + "\n");
				i++;
			}
			catch(Exception e){
				System.out.println(e);
			}
			if(end == true){
				i = 1;
				received.setText(null);
				break;
			}
		}
	}
	public static void main(String args[]){
		new Receive();
	}
}

