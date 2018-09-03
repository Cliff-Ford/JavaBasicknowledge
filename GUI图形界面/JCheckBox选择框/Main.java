import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;

class WindowBox extends JFrame implements ItemListener{
	JCheckBox box[];
	JTextArea text;
	JPanel pNorth;
	WindowBox(String s){
		super(s);
		String name[] = {"苹果","海棠","草莓","香蕉","西瓜"};
		box = new JCheckBox[name.length];
		pNorth = new JPanel();
		for(int i = 0; i < box.length; i++){
			box[i] = new JCheckBox(name[i]);
			pNorth.add(box[i]);
			box[i].addItemListener(this);
		}
		add(pNorth,NORTH);
		text = new JTextArea();
		add(new JScrollPane(text),CENTER);
		setBounds(100,100,400,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	public void itemStateChanged(ItemEvent e){
		text.setText(null);
		for(int i = 0; i < box.length; i++){
			if(box[i].isSelected()){
				text.append(box[i].getText() + "\n");
			}
		}
	}
}


public class Main{
	public static void main(String []args){
		/*
		public JCheckBox()   创建没有名称的选择框，初始状态是未选中
		public JCheckBox(String name)   
		public JCheckBox(Icon icon)   带图标
		public JCheckBox(String name, Icon icon)
		public setIcon(Icon defaultIcon)
		public setSelectedIcon(Icon selectedIcon) 设置选择框选中状态下的图标
		public boolean isSelected()
		public String getText()
		public void setText(String name)
		
		*/
		WindowBox w = new WindowBox("JCheckBox");
	}
}