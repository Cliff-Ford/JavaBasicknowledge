import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Main{
	public static void main(String args[]){
		FWindow f = new FWindow();
	}
}

class FWindow extends JFrame implements ActionListener{
	JFileChooser fileDialog;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem itemSave, itemOpen;
	JTextArea text;
	BufferedReader in;
	FileReader fileReader;
	BufferedWriter out;
	FileWriter fileWriter;
	FWindow(){
		setSize(300,400);
		text = new JTextArea(10,10);
		text.setLineWrap(true);
		add(new JScrollPane(text), BorderLayout.CENTER);
		menubar = new JMenuBar();
		menu = new JMenu("文件");
		itemOpen = new JMenuItem("打开文件");
		itemSave = new JMenuItem("保存文件");
		itemSave.addActionListener(this);
		itemOpen.addActionListener(this);
		menu.add(itemOpen);
		menu.add(itemSave);
		menubar.add(menu);
		setJMenuBar(menubar);
		fileDialog = new JFileChooser();
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == itemSave){
			int state = fileDialog.showSaveDialog(this);
			if(state == JFileChooser.APPROVE_OPTION){
				try{
					File file = new File(fileDialog.getCurrentDirectory(),fileDialog.getSelectedFile().getName());
					fileWriter = new FileWriter(file);
					out = new BufferedWriter(fileWriter);
					out.write(text.getText(),0,(text.getText()).length());
					out.close();
					fileWriter.close();
					
				}
				catch(IOException ee){
					System.out.println(ee);
				}
			}
		}
		else if(e.getSource() == itemOpen){
			int state = fileDialog.showOpenDialog(this);
			if(state == JFileChooser.APPROVE_OPTION){
				text.setText(null);
				try{
					File file = new File(fileDialog.getCurrentDirectory(),fileDialog.getSelectedFile().getName());
					fileReader = new FileReader(file);
					in = new BufferedReader(fileReader);
					String s = null;
					while((s = in.readLine()) != null){
						text.append(s + "\n");
					}
					in.close();
					fileReader.close();
				}
				catch(IOException ee){
					System.out.println(ee);
				}
			}
		}
	}
}