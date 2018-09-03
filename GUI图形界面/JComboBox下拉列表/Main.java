import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class WindowChoice extends JFrame implements ItemListener, ActionListener{
	JComboBox choice;
	JTextField text;
	JTextArea area;
	JButton add, del;
	WindowChoice(String s){
		super(s);
		setBounds(100,100,400,200);
		setLayout(new FlowLayout());
		choice = new JComboBox();		
		choice.addItem("音乐天地");
		choice.addItem("武术");
		choice.addItem("C++");
		choice.addItemListener(this);
		add(choice);
		
		del = new JButton("删除");
		del.addActionListener(this);
		add(del);
		
		text = new JTextField(8);
		text.addActionListener(this);
		add(text);
		
		add = new JButton("添加");
		add.addActionListener(this);
		add(add);
		
		area = new JTextArea(8,18);
		area.setLineWrap(true);
		add(new JScrollPane(area));
		
		
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			//String name = choice.getSelectedItem().toString();
			area.append("选中：" + choice.getSelectedItem() + "\n"); 
			// https://blog.csdn.net/LucasXu01/article/details/72026838 重复触发itemStateChanged的原因
		}
		                 
	}
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == add || e.getSource() == text){
			String name = text.getText();
			if(name.length() > 0){
				choice.addItem(name);
				area.append("列表添加:" + name + "\n");
			}
		}
		else if(e.getSource() == del){
			
			area.append("列表删除：" + choice.getSelectedItem() + "\n");
			choice.removeItemAt(choice.getSelectedIndex());
		}
	}
}

public class Main{
	public static void main(String []args){
		/*
		public JComboBox()  使用该方法创建一个没有选项的下拉列表
		public void addItem(Object anObject)  添加选项
		public int getSelectedIndex 返回被选中的项  索引起始值是0
		public Object getSelectedItem()
		public void removeItemAt(int anlndex)  异常时，报告ArrayIndexOutOfboundsException
		public void removeAllItems()
		public void addItemListener(ItemListener)
		*/
		new WindowChoice("JComboBox");
	}
}