/*
如果用户的文件读取需求比较简单，那么用户可以使用FileInputStream类，该类是从InputStream中派生出来的简单输入类，该类的实例方法都是从InputStream类继承的
FileInputStream(String name)     使用给定的文件名name创建一个FileInputStream对象
FileInputStream(File file)       使用File对象创建FileInputStream对象

输入流用int read()方法从输入流中读出数据，输入流调用read()方法顺序地读取源中的单个字节数据，该方法返回字节值（0-255）,如果到达源的末尾，就返回-1

int read(byte b[])  将试图读取b.length个字节，并将读取的字节存放在数组b中
int read(byte b[], int off, int len) 试图读取len个字节，并将读取的字节存放在数组b中，off是首个字节在数组中的存放位置
这两个read()方法都返回实际读取的字节个数，如果到达源的末尾，方法返回-1

read()方法顺序地读取文件，只要不关闭流，每次调用read()方法就顺序地读取源中的其余的内容，知道源的末尾或流被关闭

关闭流
虽然java在程序结束时自动关闭所有打开的流，但是当使用完流后，显式地关闭任何打开的流仍是一个良好的习惯，一个被打开的流可能会用尽系统资源
这取决于平台和实现。如果没有关闭那些被打开的流，那么就可能不允许领一个程序操作利用这些流所用的资源
关闭输出流的另一个原因是把该流缓冲区中的内容冲洗掉（通常冲洗到磁盘文件上）
正如将要学到的内容，在操作系统把程序缩写到输出流上的那些字节保存到磁盘上，有时被存放在内存缓冲区中，通过调用close()方法
可以保证操作系统把流缓冲区的内容写到它的目的地
*/

import java.io.*;
public class Main{
	public static void main(String args[]){
		int b;
		byte tom[] = new byte[1024];
		try{
			File file = new File("Main.java");
			FileInputStream fileInputStream = new FileInputStream(file);
			while((b = fileInputStream.read(tom,0,1024)) != -1){
				String s = new String(tom, 0, b);
				System.out.println(s);
			}
			fileInputStream.close();
		}
		catch(IOException e){
			System.out.println("File read Error " + e);
		}
	}
}