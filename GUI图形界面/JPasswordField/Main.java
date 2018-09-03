import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class PasswordWindow extends JFrame implements ActionListener{
	JPasswordField inputPassword;
	TextField textShow;
	PasswordWindow(String s){
		super(s);
		setLayout(new FlowLayout());
		inputPassword = new JPasswordField(10);
		inputPassword.setEchoChar('$');  //重新设置密码框的回显字符  默认*
		textShow = new TextField(16);
		textShow.setEditable(false);
		add(inputPassword);
		add(textShow);
		inputPassword.addActionListener(this);
		setBounds(100,100,400,200);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		char []password = inputPassword.getPassword();
		String str = new String(password);
		textShow.setText("密码是:" + str);
		if(str.equals("123456")){
			textShow.setEditable(true);
		}else{
			textShow.setEditable(false);
		}
	}
}

public class Main{
	public static void main(String []args){
		new PasswordWindow("JPasswordField");
	}
}