/*
FileReader 和 FileWriter 分别是 Reader 和 Writer 的子类，其构造方法如下
FileReader(String filename);   FileReader(File filename);
FileWriter(String filename);   FileWriter(File filename);

常用方法
int read() 字符输入流调用该方法从源中读取一个字符，该方法返回一个整数(0 - 65535) 如果没有读出字符就返回 -1
int read(char b[])             ...从源中试图读取b.length个字符到字符数组b中，返回实际读取到的字符数目，如果到达源的末尾，则返回-1
int read(char b[], int off, int len)         读取len个字符放在b中，首个字符放在off处  返回实际读取到的字符数目，如果到达源的末尾，则返回-1
void write()
void write(byte b[])
void write(byte b[], int off, int len)

*/

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	public static void main(String args[]){
		char a[] = "四月20日10点发起总攻".toCharArray();
		int n = 0, m = 0;
		try{
			File f = new File("secret.txt");
			for(int i = 0; i < a.length; i++){
				a[i] = (char)(a[i] ^ 'R');
			}
			FileWriter fileWriter = new FileWriter(f);
			fileWriter.write(a,0,a.length);
			fileWriter.close();
			FileReader fileReader = new FileReader(f);
			char tom[] = new char[10];
			System.out.print("密文：");
			while((n = fileReader.read(tom, 0, 10)) != -1){
				String s = new String(tom, 0, n);
				System.out.println(s);
			}
			fileReader.close();
			fileReader = new FileReader(f);
			System.out.println("开始解密：");
			System.out.println("明文：");
			while((n = fileReader.read(tom, 0, 10)) != -1){
				for(int i = 0; i < n; i++){
					tom[i] = (char)(tom[i] ^ 'R');
				}
				String s = new String(tom, 0, n);
				System.out.print(s);
			}
			fileReader.close();
		}
		catch(IOException e){
			System.out.println("File read Error");
		}
	}
}