/*
DataInputStream 和 DataOutputStream 类创建的对象分别被陈伟数据输入流和数据输出流，他们允许程序按照与机器无关的风格读取java原始数据
也就是说，当读取一个数值时，不必再关心这个数值应当是多少个字节

DataInputStream(InputStream in) 
DataOutputStream(OutputStream out)
*/

import java.io.*;
public class Main{
	public static void main(String args[]){
		try{
			FileOutputStream fos = new FileOutputStream("jerry.dat");
			DataOutputStream outData = new DataOutputStream(fos);
			outData.writeInt(100);
			outData.writeLong(12345678);
			outData.writeFloat(3.1415926f);
			outData.writeChars("i am ookk");
		}
		catch(IOException e){
			System.out.println(e);
		}
		try{
			FileInputStream fis = new FileInputStream("jerry.dat");
			DataInputStream inData = new DataInputStream(fis);
			System.out.println(inData.readInt());
			System.out.print
			ln(inData.readLong());
						System.out.println(inData.readFloat());
			char c;
			while((c = inData.readChar()) != '\0'){
				System.out.print(c);
				
			}
			
		}
		catch(IOException e){
			//System.out.println(e);  读文件的时候，如果读到文件末尾，会抛出EOFException ，所以一般不处理
		}
		finally{
			System.out.println();
		}
	}
}

