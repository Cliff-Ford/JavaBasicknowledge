import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;

class WindowMouse extends JFrame implements MouseListener{
	JTextField text;
	JButton button;
	JTextArea textArea;
	WindowMouse(String s){
		super(s);
		setLayout(new FlowLayout());
		text = new JTextField(10);
		text.addMouseListener(this);
		button = new JButton("按钮");
		button.addMouseListener(this);
		textArea = new JTextArea(6,16);
		add(button);
		add(text);
		add(new JScrollPane(textArea));
		setBounds(100,100,220,120);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	public void mousePressed(MouseEvent e){
		textArea.append("按住鼠标键，位置：" + "(" + e.getX() + "," + e.getY() + ")\n");
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		
			textArea.append("连续单击，位置：" + "(" + e.getX() + "," + e.getY() + ")\n");
		
	}
}

public class Main{
	public static void main(String []args){
		/*
		getX()
		getY()
		getModifieres() 获取鼠标的左键或者右键 BUTTON1.MASK BUTTON3.MASK 
		getClickCount() 获取单击的次数
		getSource()  获取鼠标事件的事件源
		mousePressed(MouseEvent) 负责处理在组件上按住鼠标键触发的鼠标事件
		mouseReleased(MouseEvent) 负责处理在组件上释放....
		mouseEntered(MouseEvent) 鼠标指针进入组件触发的鼠标事件
		mouseExited(MouseEvent)       离开...
		mouseClicked(MouseEvent)  单击....
		*/
		WindowMouse win = new WindowMouse("鼠标事件");
	}
}