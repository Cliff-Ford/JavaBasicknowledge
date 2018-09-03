import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;

class WindowFocusEvent extends JFrame implements FocusListener{
	JButton button1,button2;
	WindowFocusEvent(String s){
		super(s);
		button1 = new JButton("1点击获得焦点");
		button2 = new JButton("2点击获得焦点");
		setLayout(new FlowLayout());
		button1.addFocusListener(this);
		button2.addFocusListener(this);
		add(button1);
		add(button2);
		
		setBounds(100,100,300,300);		
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void focusGained(FocusEvent e){
		if(e.getSource() == button1){
			System.out.println("button1获得焦点，同时button2失去焦点");
		}
		else if(e.getSource() == button2){
			System.out.println("button2获得焦点，同时button1失去焦点");
		}
	}
	public void focusLost(FocusEvent e){
		
	}
}

public class Main{
	public static void main(String []args){
		/*
		addFocusListener(FocusListener listener)  
		组件获得焦点监视器之后，必须实现两个方法
		public void focusGained(FocusEvent e)
		public void foucsLost(FocusEvent e)
		用户通过单击组件可以使得该组件获得输入焦点，同时其他组件失去焦点
		一个组件也可以调用public boolean requestFocusInWindow() 获得焦点
		*/
		WindowFocusEvent win = new WindowFocusEvent("焦点事件");
	}
}