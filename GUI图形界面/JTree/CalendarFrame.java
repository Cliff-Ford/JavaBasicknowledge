import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;
import javax.swing.tree.*;

public class CalendarFrame extends JFrame implements ItemListener, TreeSelectionListener{
	JTable table;
	JTree tree = null;    //树组件
	DefaultMutableTreeNode root;
	Object name[] = {"星期天","星期一","星期二","星期三","星期四","星期五","星期六"};
	JComboBox yearList;
	int year, month;
	CalendarBean calendar;
	String rili[][];
	String item[] = {"2006","2007","2008","2009","2010"};
	JScrollPane scrollTable, scrollTree;
	JSplitPane split;
	CalendarFrame(String s){
		super(s);
		calendar = new CalendarBean();
		yearList = new JComboBox();
		for(int k = 0; k < item.length; k++){
			yearList.addItem(item[k]);
		}
		yearList.addItemListener(this);
		root = new DefaultMutableTreeNode(item[0]);    //创建根节点
		year = Integer.parseInt(item[0]);
		month = 1;
		DefaultMutableTreeNode 月[] = new DefaultMutableTreeNode[13];
		for(int i=1; i <= 12; i++){
			月[i] = new DefaultMutableTreeNode("" + i);
			root.add(月[i]);
		}
		tree = new JTree(root);
		add(new JScrollPane(tree),BorderLayout.WEST);
		tree.addTreeSelectionListener(this);               //监听树节点事件
		calendar.setYear(year);
		calendar.setMonth(month);
		rili = calendar.getCalendar();
		table = new JTable(rili, name);
		scrollTree = new JScrollPane(tree);
		scrollTable = new JScrollPane(table);
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,scrollTree,scrollTable);
		split.setDividerLocation(0.5);
		add(yearList,BorderLayout.NORTH);
		add(split,BorderLayout.CENTER);
		setSize(580,200);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void itemStateChanged(ItemEvent e){
		String 年 = yearList.getSelectedItem().toString().trim();
		year = Integer.parseInt(年);
		calendar.setYear(year);
		root = new DefaultMutableTreeNode(年);
		DefaultMutableTreeNode 月[] = new DefaultMutableTreeNode[13];
		for(int i=1; i <= 12; i++){
			月[i] = new DefaultMutableTreeNode("" + i);
			root.add(月[i]);
		}
		split.remove(scrollTree);
		tree = new JTree(root);
		tree.addTreeSelectionListener(this);
		scrollTree = new JScrollPane(tree);
		split.add(scrollTree, JSplitPane.LEFT);
		validate();
	}
	public void valueChanged(TreeSelectionEvent e){
		DefaultMutableTreeNode monthNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(monthNode.isLeaf()){
			month = Integer.parseInt(monthNode.toString().trim());
			calendar.setMonth(month);
			rili = calendar.getCalendar();
			split.remove(scrollTable);
			table = new JTable(rili,name);
			scrollTable = new JScrollPane(table);
			split.add(scrollTable, JSplitPane.RIGHT);
			validate();
		}
	}
}