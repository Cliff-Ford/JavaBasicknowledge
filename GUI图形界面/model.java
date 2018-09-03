import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;

class Win extends JFrame implements ActionListener, DocumentListener, ItemListener, TreeSelectionListener, WindowListener, FocusListener{
	//这里定义变量
	
	
	//构造函数
	Win(String s){
		super(s);
		
		
		setBounds(60,60,300,300);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//实现ActionListener接口
	public void actionPerformed(ActionEvent e){}
	//实现DocumentListener接口
	public void changedUpdate(DocumentEvent e){}
	public void removeUpdate(DocumentEvent e){}
	public void insertUpdate(DocumentEvent e){}
	//实现ItemListener接口
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			
		}
	}
	//实现TreeSelectionListener
	public void valueChanged(TreeSelectionEvent e){}
	//实现WindowListener
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowClosing(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	//实现FocusListener
	public void focusGained(FocusEvent e){}
	public void focusLost(FocusEvent e){}
	//实现KeyListener
	public void keyPressed(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	
}

public class Main{
	public static void main(String []args){
		
		Win win = new Win("待确定的窗口名字");
	}
}