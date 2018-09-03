/*
在程序中经常可能出现几个线程来处理同一个文件，如更新或读取文件，应对这样的问题作出处理，否则可能混乱
尽管可以使用多线程的同步来处理这个问题，但将增加问题的复杂性

FileLock FileChannel类分别在java.nio 和java.nio.channels包中
文件锁定且未被释放时，只允许一个流对它作出操作
*/

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
public class Main{
	public static void main(String args[]){
		int b;
		byte tom[] = new byte[12];
		try{
			RandomAccessFile input = new RandomAccessFile("Main.java","rw");
			FileChannel channel = input.getChannel();              //获取通道
			while((b = input.read(tom, 0, 10)) != -1){
				FileLock lock = channel.tryLock();               //上锁
				String s = new String(tom,0,b);
				System.out.print(s);
				try{
					Thread.sleep(1000);
					lock.release();
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			input.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}