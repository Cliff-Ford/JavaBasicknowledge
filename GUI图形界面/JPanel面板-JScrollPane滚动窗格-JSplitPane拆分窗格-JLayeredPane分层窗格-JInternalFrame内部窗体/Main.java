import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;

class MyWindow extends JFrame implements ActionListener{
	JButton buttonOpen;
	JLabel labelOne, labelTwo;
	JTextArea text;
	JScrollPane scroll;
	JInternalFrame interframe;
	JSplitPane splitOne, splitTwo;
	MyWindow(String s){
		super(s);
		setBounds(100,100,300,300);
		JPanel panel = new JPanel();
		buttonOpen = new JButton("打开内部窗体");
		panel.add(buttonOpen);
		add(panel,BorderLayout.NORTH);
		
		interframe = new JInternalFrame("内部窗体",true,true,true,true);
		interframe.setSize(100,100);
		interframe.setLayout(new GridLayout(1,1));
		labelOne = new JLabel(new ImageIcon("./computer.png"));
		labelTwo = new JLabel(new ImageIcon("./computer.png"));
		splitOne = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,labelOne,labelTwo);
		text = new JTextArea(6,12);
		text.setLayout(new FlowLayout());
		text.add(new JTextField("我是文本区中的组件"));
		scroll = new JScrollPane(text);
		splitTwo = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitOne,scroll);
		interframe.add(splitTwo);
		interframe.setVisible(true);
		interframe.validate();
		add(interframe,BorderLayout.CENTER);
		buttonOpen.addActionListener(this);
		
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		add(interframe,BorderLayout.CENTER);
		interframe.setVisible(true);
		interframe.validate();
	}
}

public class Main{
	public static void main(String []args){
		/*
		JPanel 是一个面板 默认布局是 FlowLayout
		JScrollPane 只可以添加一个组件 然后可以通过操控滚动条观察组件 比如JTextArea不带滚动条，添加到JScrollPane后会有滚动条
		JSplitPane 分为水平拆分和垂直拆分 拆分窗格只有两个组件
		
		JLayeredPane分层窗格有五层 DEFAULT_LAYER PALETTE_LAYER MODAL_LAYER POPUP_LAYER DRAG_LAYER
		DEFAULT_LAYER是最底层 添加到该层的组件如果和其它层组件发生重叠时，将被其他组件遮挡
		DRAG_LAYER 是最顶层
		添加到同一层上的组件，如果发生重叠，后添加的会遮挡先添加的组件
		
		JInternalFrame 内部窗体相当于一个新的窗体
		
		*/
		MyWindow win = new MyWindow("容器运用");
		
	}
}