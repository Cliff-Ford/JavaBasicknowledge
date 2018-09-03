/*
public void write(byte b[]) 写b.length个字节到输出流
public void write(byte b[], int off, int len) 从给定字节数组中始于偏移量off处写len个字节到输出流

FileOutputStream流顺序地写文件，只要不关闭流，每次调用writer()方法就顺序地向输出流写入内容，知道流被关闭

*/

import java.io.*;
public class Main{
	public static void main(String args[]){
		int b;
		byte buffer[] = new byte[100];
		try{
			System.out.println("输入一行文本，并保存到磁盘");
			b = System.in.read(buffer);   //把从键盘敲入的字符读入buffer
			FileOutputStream fileOutputStream = new FileOutputStream("line.txt");
			fileOutputStream.write(buffer, 0, b);       //流把buffer写入到文件line.txt
			fileOutputStream.close();
		}
		catch(IOException e){
			System.out.println("Error " + e);
		}
		
	}
}