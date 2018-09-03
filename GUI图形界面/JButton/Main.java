import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class WindowButton extends JFrame implements ActionListener{
	int number;
	JTextField tip, input;
	JButton getNum, enter;
	WindowButton(String s){
		super(s);
		setLayout(new FlowLayout());
		getNum = new JButton("得到一个随机数");
		add(getNum);
		tip = new JTextField("输入你的猜测",10);
		tip.setEditable(false);
		add(tip);
		input = new JTextField("",10);
		add(input);
		enter = new JButton("确定");
		add(enter);
		enter.addActionListener(this);
		getNum.addActionListener(this);
		setBounds(100,100,400,200);
		
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == getNum){
			number = (int)(Math.random()*100) + 1;
			tip.setText("输入您的猜测");
		}else if(e.getSource() == enter){
			int guess = 0;
			try{
				guess = Integer.parseInt(input.getText());
				if(guess == number){
					tip.setText(guess + ": 猜对了");
				}else if(guess > number){
					tip.setText(guess + ": 猜da了");
					input.setText(null);
				}else if(guess < number){
					tip.setText(guess + ": 猜小了");
					input.setText(null);
				}
			}
			catch(NumberFormatException event){
				tip.setText("请输入数字");
			}
		}
	}
}


public class Main{
	public static void main(String []args){
		/*
		JButton(String text);       创建名字为text的按钮
		public JButton(Icon icon) 创建图标为icon的按钮
		public JButton(String text, Icon icon)
		public void setText(String text);
		public String getText()
		public setIcon(Icon icon)
		public getIcon();
		public void setHorizontalTextPosition(int textPosition)  设置按钮名字相对按钮图标的水平位置 AbstractButton.LEFT | CENTER | RIGHT
		public void setVerticalTextPosition(int textPosition)  设置           垂直位置 AbstractButton.TOP | CENTER | BOTTOM
		public void setMnermonic(char mnemonic) 按钮对象调用该方法设置按钮的键盘激活方式 有效值是a-z 激活方法是 ALT + 字母
		public voidaddActionListener(ActionListener)
		
		*/
		
		WindowButton win = new WindowButton("猜数字");
	}
}