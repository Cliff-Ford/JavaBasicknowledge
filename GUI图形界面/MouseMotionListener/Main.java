import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;
import javax.swing.border.*;

class LP extends JLayeredPane implements MouseListener, MouseMotionListener{
	JButton button;
	JCheckBox box;
	int x,y,a,b,x0,y0;
	LP(){
		button = new JButton("拖动我");
		box = new JCheckBox("拖动我");
		button.addMouseMotionListener(this);
		button.addMouseListener(this);
		box.addMouseListener(this);
		box.addMouseMotionListener(this);
		setLayout(new FlowLayout());
		add(box, JLayeredPane.DEFAULT_LAYER);
		add(button, JLayeredPane.DEFAULT_LAYER);
		setBounds(10,10,350,300);
		setVisible(true);
		validate();
	}
	public void mousePressed(MouseEvent e){
		JComponent com = null;
		com = (JComponent) e.getSource();
		setLayer(com,JLayeredPane.DRAG_LAYER);
		a = com.getBounds().x;
		b = com.getBounds().y;
		x0 = e.getX();           //获取鼠标指针在事件源中的位置坐标
		y0 = e.getY();
	}
	public void mouseReleased(MouseEvent e){
		JComponent com = null;
		com = (JComponent)e.getSource();
		setLayer(com, JLayeredPane.DEFAULT_LAYER);
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	public void mouseDragged(MouseEvent e){
		Component com = null;
		if(e.getSource() instanceof Component){
			com = (Component) e.getSource();
			a = com.getBounds().x;
			b = com.getBounds().y;
			x = e.getX();
			y = e.getY();
			a = a + x;
			b = b + y;
			com.setLocation(a - x0,b - y0);
		}
	}
}

public class Main{
	public static void main(String []args){
		/*
		使用MouseMotionListener接口可以处理一下两种操作触发的鼠标事件
		addMouseMotionListener(监视器)
		mouseDragged(MouseEvent) 负责处理拖动时触发的鼠标事件
		mouseMoved(MouseEvent) 负责处理移动鼠标指针所触发的鼠标事件
		*/
		JFrame fr = new JFrame();
		fr.add(new LP(),BorderLayout.CENTER);
		fr.setVisible(true);
		fr.setBounds(12,12,300,300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.validate();
	}
}