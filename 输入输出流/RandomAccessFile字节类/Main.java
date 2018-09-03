/*
RandomAccessFile类是专门用来处理文件输入输出操作功能的类，该类既不是InputStream类的子类，也不是OutputStream类的子类
该类既可以向源中读取数据，也可以写入数据

RandomAccessFile(String name, String mode)  参数name用来确定一个文件名，给出创建的流的源，也是流的目的地，参数mode取r(只读)rw(可读写)
RandomAccessFile(File file, String mode)

seek(long a)用来定位RandomAccessFile流的读写位置，其中参数a确定读写位置距离文件楷体的字节个数

getFilePointer()获取当前的读写位置

length()
read()读一个字节的数据
readBoolean()
readByte()
readChar()
readDouble()
readFully(byte b[])
readInt()
readLine()
readLong()
readShort()
readUnsignedByte()
readUnsignedShort()
readUTF()
seek()
setLength(long newlength)  设置文件的长度
skipBytes(int v) 在文件中跳过给定数量的字节
writeBytes(String s)
writeByte(Byte b)
writeChar(char c)
writeDouble(double v)
writeFloat(float v)
...

*/

import java.io.*;
public class Main{
	public static void main(String args[]){
		RandomAccessFile in_and_out = null;
		int data[] = {1,2,3,4,5,6,7,8,9,10};
		try{
			in_and_out = new RandomAccessFile("tom.dat","rw");
		}
		catch(Exception e){
			System.out.println(e);
		}
		try{
			for(int i = 0; i < data.length; i++){
				in_and_out.writeInt(data[i]);
			}
			for(long i = data.length - 1; i >= 0; i--){
				in_and_out.seek(i * 4);           //文件的第36个字节读取最后一个整数
				System.out.print(in_and_out.readInt());
			}
			in_and_out.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
			
			
	}
}