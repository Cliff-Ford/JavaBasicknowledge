/*
假如student.txt是一个学生名单，每个姓名占一行，如果想读取名字，那么每次必须读取一行，使用FileReader流很难完成这样的任务，因为并不清楚一行有多少个字符
FileReader类没有提供读取一行的方法

此时需要用更高级的类BufferedReader BufferedWriter
构造方法如下
BufferedReader(Reader in);
BufferedWriter(Writer out)
通过向BufferedReader传递一个Reader子类的对象，来创建一个BufferedReader对象，如下
FileReader inOne = new FileReader("Student.txt");
BufferedReader inTwo = new BufferedReader(inOne);


BufferedReader和BufferedWriter称作上层流，把他们指向的字符流称作底层流。java采用缓存技术将上层流和底层流链接
底层字符输入流首先将数据读入缓存，BufferedReader流在从缓存流读取数据
BuffererWriter流将数据写入缓存，底层字符输出流会不断的将缓存中的数据写入到目的地

当BufferWriter流调用flush()方法刷新缓存或调用close方法关闭时，即使缓存还没有溢满，底层流也会立刻将缓存的内容写入目的地
*/

import java.io.*;
public class Main{
	public static void main(String args[]){
		File file = new File("Weather.txt");
		String content[] = {"天气预报：","北京晴","上海多云小雨","大连多云"};
		try{
			FileWriter outOne = new FileWriter(file);
			BufferedWriter outTwo = new BufferedWriter(outOne);
			for(String str : content){
				outTwo.write(str);
				outTwo.newLine();
			}
			outTwo.close();
			outOne.close();
			FileReader inOne = new FileReader(file);
			BufferedReader inTwo = new BufferedReader(inOne);
			String s = null;
			int i = 0;
			while((s = inTwo.readLine()) != null){
				System.out.println(s);
			}
			inTwo.close();
			inOne.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}