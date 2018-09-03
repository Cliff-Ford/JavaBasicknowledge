/*
java.net包中的url类是对统一资源定位符的抽象，使用url创建对象的应用程序称作客户端程序
一个url对象存放着一个具体的资源的引用

一个url对象通常包含最基本的三部分信息：协议 、地址、资源
协议必须是url对象所在的java虚拟机支持的协议，例如Http Ftp File协议
地址必须是能连接的有效IP地址或域名
资源可以使主机上的任何一个文件

构造方法
public URL(String spec) throws MalformedURLException
使用方法如下
try{
	URL url = new URL("http://www.tup.tsinghua.edu.cn");
}
catch(MalformedURLException e){
	System.out.println("Bad URL:" + url);
}

读入资源
url对象调用InputStream openStream() 方法可以返回一个输入流，该输入流指向url对象所包含的资源
通过该输入流可以将服务器上的资源信息读入到客户端

*/

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main{
	public static void main(String args[]){
		Win win = new Win("使用url读取资源");
	}
}

class Win extends JFrame implements ActionListener, Runnable{
	JButton button;
	URL url;
	JTextField text;
	JEditorPane editPane;        //和JTextArea textArea 有点像
	JTextArea textArea;
	byte b[] = new byte[128];
	Thread thread;
	Win(String s){
		super(s);
		text = new JTextField(20);
		editPane = new JEditorPane();
		editPane.setEditable(false);    //设置这个是为了使得页面犹如真正的页面一样，可以点击跳转，然而好像没有用
		button = new JButton("确定");
		button.addActionListener(this);
		thread = new Thread(this);
		JPanel p = new JPanel();
		p.add(new JLabel("输入网址："));
		p.add(text);
		p.add(button);
		JScrollPane scroll = new JScrollPane(editPane);
		add(scroll,BorderLayout.CENTER);
		add(p,BorderLayout.NORTH);
		textArea = new JTextArea(20,20);
		textArea.setEditable(false);
		add(new JScrollPane(textArea),BorderLayout.SOUTH);
		setBounds(160,60,420,300);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editPane.addHyperlinkListener(new HyperlinkListener(){   //实现HyperlinkListener接口
			public void hyperlinkUpdate(HyperlinkEvent e){
				if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
					try{
						
						text.setText("" + e.getURL());
						editPane.setPage(e.getURL());
						textArea.setText(null);
						url = new URL(("" + e.getURL()).trim());
						InputStream in =  url.openStream();
						int n = -1;
						while((n = in.read(b))!= -1){
							String s = new String(b,0,n);
							textArea.append(s);
						}
						
					}
					catch(IOException e1){
						editPane.setText("" + e1);
					}
				}
			}
		});
		
	}
	public void actionPerformed(ActionEvent e){
		if(!thread.isAlive()){
			thread = new Thread(this);
		}
		try{
			url = new URL(text.getText().trim());  //trim()去掉前后的空格
			thread.start();
		}
		catch(Exception e1){
			text.setText("我正在读取" + url);
		}
	}
	public void run(){
		try{
			int n = -1;
			editPane.setText(null);
			editPane.setPage(url);  //JEditorPane容器可以解释执行html文件
			InputStream in =  url.openStream();
			while((n = in.read(b))!= -1){
				String s = new String(b,0,n);
				textArea.append(s);
			}
		}
		catch(MalformedURLException e1){
			text.setText("" + e1);
			return;
		}
		catch(Exception e){
			text.setText("" + e);
			return;
		}
	}
}

