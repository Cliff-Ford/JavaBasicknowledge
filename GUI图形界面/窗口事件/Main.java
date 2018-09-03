import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;

class Win extends JFrame implements WindowListener{
	JTextArea text;
	Win(String s){
		super(s);
		addWindowListener(this);
		text = new JTextArea();
		text.setLineWrap(true);
		add(new JScrollPane(text),BorderLayout.CENTER);
		setEnabled(false);
		setEnabled(true);
		setVisible(true);
		setBounds(100,100,300,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void windowActivated(WindowEvent e){     
		text.append("窗口从非激活状态到激活状态触发windowActivated事件"+"\n");
	}
	public void windowDeactivated(WindowEvent e){
		text.append("窗口从激活状态到非激活状态触发windowDeactivated事件"+"\n");
	}
	public void windowClosing(WindowEvent e){
		System.out.println("窗口正在被关闭时触发windowClosing事件"+"\n");
		text.append("窗口正在被关闭时触发windowClosing事件"+"\n");
	}
	public void windowClosed(WindowEvent e){
		text.append("窗口关闭时触发windowClosed"+"\n");
	}
	public void windowIconified(WindowEvent e){
		text.append("窗口图标化时触发windowIconified"+"\n");
	}
	public void windowDeiconified(WindowEvent e){
		text.append("窗口撤销图标化的时候触发windowDeiconified"+"\n");
	}
	public void windowOpened(WindowEvent e){
		text.append("窗口打开时触发windowOpened"+"\n");
	}
}

public class Main{
	public static void main(String []args){
		/*
		当一个JFrame窗口被激活或撤销激活、打开或关闭、图标化或撤销图标化时，就触发了窗口事件
		即windowEvent创建一个窗口事件对象 
		windowEvent创建的事件对象调用getWindow()方法可以获取发生窗口事件的窗口
		窗口使用addWindowlistener()方法获得监视器
		创建监视器的类必须实现WindowListener接口，共七个方法
		*/
		Win win = new Win("WindowEvent事件");
	}
}