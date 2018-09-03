import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;

class Win extends JFrame implements ItemListener{
	JComboBox list;
	JTextArea text;
	Win(String s){
		super(s);
		list = new JComboBox();
		list.setForeground(Color.blue);
		list.setBackground(new Color(12,250,34));
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = ge.getAvailableFontFamilyNames();
		for(int i = 0; i < fontName.length; i++){
			list.addItem(fontName[i]);
		}
		add(list,BorderLayout.NORTH);
		list.addItemListener(this);
		text = new JTextArea();
		
		text.setFont(new Font("",Font.BOLD,32));  //Font找不到字体时，选中默认字体
		
		add(new JScrollPane(text),BorderLayout.CENTER);
		text.append("2008北京奥运会");
		setVisible(true);
		setBounds(100,100,300,300);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			String name = (String)list.getSelectedItem();
			Font f = new Font(name,Font.BOLD,32);
			text.setFont(f);
			text.append("\n"+"2008北京奥运会");
		}
	}
}

public class Main{
	public static void main(String []args){
		/*
		颜色
		public void setBackground(Color c)   设置组件的背景色
		public void setForeground(Color c)   设置组件的前景色
		public Color getBackground()
		public Color getForeground()
		
		字体
		public void setFont(Font f)
		public Font getFont(Font f)
		public Font(String name, int style, int size);  name是字体名称 可以使用GraphicsEnvironment对象调用方法
		String[] getAvailableFontFamilyNames()查看
		但因为GraphicsEnvironment类是抽象类，不能用构造方法创建对象，但是java运行环境已经准备好了这个对象，只需要让
		GraphicsEnvironment类调用它的类方法 代码如下
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = ge.getAvailableFontFamilyNames();
		
		大小与位置
		public void setSize(int width, int height)
		public void setLocation(int x,int y)
		public Dimension getSize() Dimension.width Dimension.height
		public Point getLocation()  Point.x Ponit.y
		public void setBounds(int x,int y,int width,int height)
		
		组件的激活性和可见性
		public void setEnabled(boolean b)
		public void setVisible(boolean b)
		*/
		Win win = new Win("Component常用方法");
	}
}