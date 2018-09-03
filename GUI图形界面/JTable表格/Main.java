import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static java.awt.BorderLayout.*;

class Win extends JFrame implements ActionListener{
	JTable table;
	Object a[][];
	Object name[] = {"姓名","英语","数学","总成绩"};
	JButton enter, cacu;
	JTextField setRows;
	int rows = 1;
	JPanel p;
	Win(String s){
		super(s);
		cacu = new JButton("总成绩");
		enter = new JButton("确定");
		setRows = new JTextField(10);
		enter.addActionListener(this);
		cacu.addActionListener(this);
		a = new Object[rows][4];
		table = new JTable(a,name);
		p = new JPanel();
		p.add(new JLabel("输入行数"));
		p.add(setRows);
		p.add(enter);
		p.add(cacu);
		add(p,BorderLayout.SOUTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
		setBounds(100,100,550,200);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == enter){
			rows = Integer.parseInt(setRows.getText());
			a = new Object[rows][4];
			table = new JTable(a,name);
			getContentPane().removeAll();
			add(new JScrollPane(table),BorderLayout.CENTER);
			add(p,BorderLayout.SOUTH);
			validate();
		}
		else if(e.getSource() == cacu){
			for(int i = 0; i < rows; i++){
				double sum = 0;
				boolean boo = true;
				for(int j = 1; j <= 2; j++){
					try{
						sum = sum + Double.parseDouble(a[i][j].toString());
					}
					catch(NumberFormatException ee){
						boo = false;
						System.out.println(ee.toString());
						table.repaint();
					}
					
				}
				if(boo == true){
						a[i][3] = "" + sum;
						table.repaint();
				}
			}
		}
	}
}

public class Main{
	public static void main(String []args){
		/*
		JTable(Object data[][], Object columnName[]) 此构造方法创建的表格维护的数据是data二维数组的值，表格的列名有columnName指定
		当表格需要重新刷新显示时用repaint()
		
		*/
		Win win = new Win("JTable");
	}
}