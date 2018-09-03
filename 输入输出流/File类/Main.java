import java.io.*;

class FileAccept implements FilenameFilter{
	String str = null;
	FileAccept(String s){
		str = "." + s;
	}
	public boolean accept(File dir, String name){
		return name.endsWith(str);
	}
}

public class Main{
	public static void main(String args[]){
		/*
		File对象主要用来获取文件本身的一些信息，如文件所在的目录、文件的长度和文件读写权限等，不涉及对文件的读写操作
		创建一个File对象有三个构造方法
		File(String filename);   文件默认与当前应用程序在同一目录下
		File(String directoryPath, String filename);
		File(File f, String filename);
		其中filename是文件名称，directoryPath是文件的路劲，f是指定一个目录的文件
		
		
		文件的属性
		public String getName() 获取文件的名字
		public boolean canRead()
		public boolean canWrite()
		public boolean exits() 判断文件是否存在
		public long length() 获取文件的长度  单位是字节
		public String getAbsolutePath() 绝对路径
		public String getParent()  获取文件的父目录
		public boolean isFile() 判断文件是否是一个正常文件，而不是目录
		public boolean isDirectory()  判断文件是否是已存在的一个目录
		public Boolean isHidden() 
		public long lastModified() 获取文件最后修改的时间，单位是毫秒数
		
		*/
		
		File f1 = new File("D:\\onedrive\\Java基础教程\\输入输出流\\File类","Main.java");
		File f2 = new File("D:\\onedrive\\Java基础教程\\输入输出流\\File类");
		System.out.println(f1.getName() + "是可读的吗？" + f1.canRead());
		System.out.println(f1.getName() + "的长度:" + f1.length());
		System.out.println(f1.getName() + "的绝对路径：" + f1.getAbsolutePath());
		System.out.println(f2.getName() + "是目录吗？" + f2.isDirectory());
		
		/*
		使用File对象调用方法public boolean mkdir()可创建一个目录，如果创建成功返回true，否则返回false,如果该目录已经存在将返回false
		如果File对象是一个目录，那么该对象可以调用下述方法覅用下属方法列出该目录下的文件和子目录
		public String[] list()  用字符串形式返回目录下的全部文件
		public File[] listFiles() 用File对象形式返回目录下的全部文件
		
		有时需要列出目录下指定类型的文件，如以.java .txt等扩展名的文件，可以使用File类的两个方法，列出指定类型的文件，方法如下
		public String[] list(FilenameFilter obj)  字符串形式返回
		public String[] listFiles(FilenameFilter obj)  File对象形式返回
		上述两个方法的参数FilenameFilter obj是一个接口，该接口有一个方法，此方法如下
		public  boolean accept(File dir, String name)
		使用list方法时，需向该方法传递一个实现FilenameFilter接口的对象，list方法执行时参数不断回调接口方法accept，accept中的参数name是实例化目录中的一个文件名
		参数dir为调用list的当前目录，当接口方法返回true时，list方法就将目录dir中的文件存放到返回的数组中
		*/
		
		File dir = new File(".");  // File dir = new File(".\\")  也可以
		FileAccept acceptCondition = new FileAccept("java");
		String fileName[] = dir.list(acceptCondition);
		for(int i = 0; i < fileName.length; i++){
			System.out.println(fileName[i]);
		}
		
		/*
		使用File类创建一个文件对象，如
		File f = new File("c:\\myletter","letter.txt");
		如果c:\myletter目录中没有名字为letter.txt文件，文件对象f调用如下方法：
		public boolean createNewFile()
		文件对象调用如下方法 public Boolean delete()可以删除当前文件
		*/
		
		/*
		当要执行一个本地机上的可执行文件时，可以使用java.lang 包中的Runtime类
		创建对象后可以使用静态方法getRuntime
		exec(String command)方法打开本地机的可执行文件或执行一个操作
		*/
		try{
			Runtime ce = Runtime.getRuntime();
			ce.exec("javac OtherMain.java");   //仿佛没用
			ce.exec("java OtherMain");          //仿佛没用
			File file = new File("D:\\notepadd++\\Notepad++","notepad++.exe");
			ce.exec(file.getAbsolutePath());        //仿佛没用
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}