import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EditWindow extends JFrame implements ActionListener{
	JMenuBar menuBar;
	JMenu menu;
	JSplitPane splitPane;
	JMenuItem itemCopy, itemCut, itemPaste;
	JTextArea text;
	EditWindow(String s){
		super(s);
		setBounds(100,100,400,200);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenu("编辑");
		menuBar.add(menu);
		itemCopy = new JMenuItem("复制");
		itemCut = new JMenuItem("剪切");
		itemPaste = new JMenuItem("粘贴");
		menu.add(itemCopy);
		menu.add(itemCut);
		menu.add(itemPaste);
		text = new JTextArea();
		text.setLineWrap(true);
		text.setText("默认文本");
		add(new JScrollPane(text), BorderLayout.CENTER); //因为JTextArea没有滚动条，所以将它放进一个滚动窗格中JScrollPane
		itemCopy.addActionListener(this);
		itemCut.addActionListener(this);
		itemPaste.addActionListener(this);
		
		
		
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == itemCopy){
			text.copy();
		}else if(e.getSource() == itemCut){
			text.cut();
		}else if(e.getSource() == itemPaste){
			text.paste();
		}
	}
}

public class Main{
	public static void main(String []args){
		/*
		JTextArea()  文本区可见行数列数为默认值
		JTextArea(String s)  初始字符为s
		JTextArea(int x, int y)   可见行数x 列数 y
		public void setText(String s)
		public String getText(String s)
		public void insert(String s, int x) x是指从文本区开始到当前位置所含有的字符个数，x不能大于文本区中字符的个数
		public void replaceRange(String s, int start, int end);
		public void append(String s) 文本区末端追加文本
		int getCaretPosition()  获取光标的位置
		public void setCaretPosition(int position) 设置光标的位置
		public void selectAll()  选中全部文本
		public void setLineWrap(boolean b) 决定输入的文本是否在文本区的右边界自动换行
		public void copy() 复制选中文本
		public void cut() 
		public void paste()
		
		*/
		EditWindow win = new EditWindow("JTextArea");
	}
}