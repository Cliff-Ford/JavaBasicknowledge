import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main{
	public static void main(String []args){
		/*
		public JLabel()  创建没有名字的标签
		public JLabel(String s)
		public JLabel(String s, int aligment)  aligment值决定了标签中的文字在水平方向上的对齐方式 JLabel.CENTER | LEFT | RIGHT
		public JLabel(Icon icon) 标签有图标
		String getText()  获取标签名字
		void setText()
		Icon getIcon()
		void setIcon(Icon icon)
		void setHorizontalTextPosition(int a)  参数a确定名字相对于标签上的图标的位置 JLabel.LEFT | RIGHT
		void setVerticalTextPosition(int a) 参数a确定名字相对于                  JLabel.BOTTOM | TOP
		*/
		JFrame frame = new JFrame("JLabel属性测试");
		frame.setBounds(100,100,400,400);
		frame.setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel("默认图标");
		label1.setIcon(new ImageIcon("./computer.png"));
		frame.add(label1);
		
		JLabel label2 = new JLabel("文字在图标左边");
		label2.setIcon(new ImageIcon("./computer.png"));
		label2.setHorizontalTextPosition(JLabel.LEFT);
		frame.add(label2);
		
		JLabel label3 = new JLabel("文字在图标上边");
		label3.setIcon(new ImageIcon("./computer.png"));
		label3.setVerticalTextPosition(JLabel.TOP);
		frame.add(label3);
		
		JLabel label4 = new JLabel("文字在图标下边");
		label4.setIcon(new ImageIcon("./computer.png"));
		label4.setVerticalTextPosition(JLabel.BOTTOM);
		frame.add(label4);
		
		frame.setVisible(true);
		frame.validate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}