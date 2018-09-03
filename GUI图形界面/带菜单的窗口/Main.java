import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

class FirstWindow extends JFrame{
	JMenuBar menubar;  //菜单条
	JMenu menu, subMenu, menuRight;  //菜单
	JMenuItem item1, item2;  //菜单项
	FirstWindow(String s){
		super(s);
		setVisible(true);           //设置可见
		setSize(500,160);         //设置宽高		
		setLocation(120,200);       //设置窗口出现位置
		//setResizable(false);         //false代表窗口不可调整大小，true代表可调
		menubar = new JMenuBar();          //一个窗口只能有一个菜单条
		setJMenuBar(menubar);          //设置菜单条
		menu = new JMenu("菜单");
		menubar.add(menu);            //把菜单添加到菜单条里面
		item1 = new JMenuItem("菜单项1");
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));  //设置快捷键
		item2 = new JMenuItem("菜单项2");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		menu.add(item1);
		menu.addSeparator();         //设置分割线
		menu.add(item2);
		subMenu = new JMenu("菜单里面的菜单");
		menu.add(subMenu);
		subMenu.add(new JMenuItem("1"));
		menuRight = new JMenu("另一个菜单");
		menubar.add(menuRight);
		validate();                    //确保组件有有效的布局
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //设置点击x后的操作
		
		
		/*
		窗口属性必须设置可见，一个窗口只有一个菜单条，一个菜单条拥有多个菜单，点击菜单展开菜单项，菜单项也可以是一个菜单
		窗口要设置大小，位置，是否可扩展，点击关闭时的操作
		*/
	}
}


public class Main{
	public static void main(String []args){
		FirstWindow win = new FirstWindow("带菜单的窗口1");
	}
}