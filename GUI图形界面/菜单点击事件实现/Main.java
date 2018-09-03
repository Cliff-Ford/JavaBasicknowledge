import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class WindowExit extends JFrame implements ActionListener{
	JMenuBar menuBar;
	JMenu menu ;
	JMenuItem exit;
	WindowExit(String s){
		super(s);
	
		setBounds(100,100,500,200);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("文件");
		menuBar.add(menu);
		
		exit = new JMenuItem("退出");
		menu.add(exit);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		exit.addActionListener(this);
		
		
		
		
		
		
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public  void actionPerformed(ActionEvent e){
		System.exit(0);
	}
}

public class Main{
	public static void main(String []args){
		new WindowExit("菜单点击事件实现");
	}
	
	
}