import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	public static void main(String args[]){
		byte b[] = new byte[30];
		JTextArea text = new JTextArea(20,20);
		JFrame jframe = new JFrame();
		jframe.setSize(280,300);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(new JScrollPane(text),BorderLayout.CENTER);
		jframe.validate();
		try{
			FileInputStream input = new FileInputStream("Main.java");
			//ProgressMonitorInputStream(Conmponent c, String s, InputStream in);
			ProgressMonitorInputStream input_progress = new ProgressMonitorInputStream(null, "读取java文件", input);
			ProgressMonitor p = input_progress.getProgressMonitor(); //获得进度条
			while(input_progress.read(b) != -1){
				String s = new String(b);
				text.append(s);
				Thread.sleep(200);  //为了看清进度条，可以缓慢0.2秒
			}
		}
		catch(Exception e){}
	}
}