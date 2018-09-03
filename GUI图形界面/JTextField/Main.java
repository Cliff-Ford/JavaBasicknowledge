import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class MyJText extends JFrame implements ActionListener{
	JTextField text1, text2;
	MyJText(String s){
		super(s);
		
		setBounds(100,100,150,150);
		setLayout(new FlowLayout());
		text1 = new JTextField("不可编辑",10);
		System.out.println(text1.getText());
		text1.setEditable(false);
		text1.setHorizontalAlignment(JTextField.CENTER);   //对齐方式
		text2 = new JTextField(10);
		text2.addActionListener(this);
		add(text1);
		add(text2);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == text2){
			int n = 0, m = 0;
			try{
				n = Integer.parseInt(text2.getText());
				m = n * n;
				text1.setText(m + "");
			}
			catch(Exception ee){
				text1.setText("请输入数字");
				text2.setText(null);
			}
		}
	}
}

public class Main{
	public static void main(String []args){
		/*
		JTextField() 创建文本框，文本框的长度为一个机器字符长，可以输入若干个字符
		JTextField(int x)           x个机器字符长
		JTextField(String s)  初始字符为s
		public void setText(String s);
		public String getText()
		public void setEditable(boolean b)
		setHorizontalAlignment(int alignment) 文本对齐方式 JTextField.LEFT | RIGHT | CENTER
		public void addActionListener(ActionListener)
		public void removeActionListener(ActionListener)
		
		*/
		MyJText demo = new MyJText("JTextField");
	}
}