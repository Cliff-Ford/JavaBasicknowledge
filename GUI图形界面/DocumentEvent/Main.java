import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/*
文本区可以出发DocumentEvent事件，用户在文本区中进行文本编辑操作，使得文本区中的文本发生变化
这将导致文本区所维护的文档模型中的数据发生变化，从而导致DocummentEvent事件的发生，
需要使用addDocumentListener(监视器)向文本区维护的文档创建监视器
DocumentListener接口的实现需要实现三个方法
public void changedUpdate(DocumentEvent e)
public void removeUpdate(DocumentEvent e)
public void insertUpdate(DocumentEvent e)
这不同于ActionLinster只需要实现actionPerformed(ActionEvent e)
*/


class WindowTextArea extends JFrame implements DocumentListener{
	JTextArea text1, text2;
	WindowTextArea(String s){
		super(s);
		setBounds(100,100,400,400);
		setLayout(new FlowLayout());
		text1 = new JTextArea(6,15);
		text2 = new JTextArea(6,15);
		add(new JScrollPane(text1));
		add(new JScrollPane(text2));
		text1.setLineWrap(true);
		text2.setLineWrap(true);
		text2.setEditable(false);
		
		(text1.getDocument()).addDocumentListener(this);  //想文档注册监听事件
		
		
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//接口方法
	public void changedUpdate(DocumentEvent e){
		if(e.getDocument() == text1.getDocument()){
			String s = text1.getText();
			StringTokenizer analysic = new StringTokenizer(s," ,'\n'");
			int n = analysic.countTokens();
			String result[] = new String[n];
			for(int i = 0; i < n; i++){
				result[i] = analysic.nextToken();
			}
			Arrays.sort(result);
			text2.setText(null);
			for(int i = 0; i < n; i++){
				text2.append(result[i] + "\n");
			}
		}
	}
		//接口方法

	public void removeUpdate(DocumentEvent e){
		changedUpdate(e);
	}
		//接口方法

	public void insertUpdate(DocumentEvent e){
		changedUpdate(e);
	}
}

public class Main{
	public static void main(String []args){
		WindowTextArea win = new WindowTextArea("DocumentEvent事件");
		
	}
}