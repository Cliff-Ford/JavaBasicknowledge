import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;

class Win extends JFrame implements KeyListener{
	JButton b;
	Win(String s){
		super(s);
		setLayout(new FlowLayout());
		b = new JButton("Ctrl + X 或 Shift + X");
		b.addKeyListener(this);
		add(b);
		setBounds(10,10,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	public void keyPressed(KeyEvent e){
		JButton button = (JButton)e.getSource();
		int x = 0, y = 0, w = 0, h = 0;
		x = button.getBounds().x;
		y = button.getBounds().y;
		w = button.getBounds().width;
		h = button.getBounds().height;
		//键盘事件KeyEvent对象调用getModifiers()方法可以返回ALT_MASK CTRL_MASK SHIFT_MASK这些数值 //并且都是InputEvent的类常量
		if(e.getModifiers() == InputEvent.ALT_MASK && e.getKeyCode() == KeyEvent.VK_X){
			button.setLocation(y,x);
		}else if(e.getModifiers() == InputEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_X){
			button.setSize(h,w);
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
}

public class Main{
	public static void main(String []args){
		/*
		事件源使用addKeyListener()方法获得监视器 
		接口KeyListener必须实现以下三个方法
		public void keyPressed(KeyEvent e)
		public void keyTyped(KeyEvent e)
		public void keyReleased(KeyEvent e)
		*/
		Win win = new Win("键盘事件");
	}
}