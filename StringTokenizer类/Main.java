import java.util.*;
public class Main{
	public static void main(String []args){
		
		/*
		StringTokenizer(String s)为字符串s构造出一个分析器，默认分隔符集合是空格符(若跟个连续空格符视为一个空格符)
		换行符，回车符，tab符，进纸符
		StringTokenizer(String s, String delim)参数delim作为s的分隔符
		*/
		String s1 = "we are s	t             u,dents";
		StringTokenizer analysis = new StringTokenizer(s1);
		
		System.out.println(s1 + "划分出来的单词数量：" + analysis.countTokens());
		
		while(analysis.hasMoreTokens()){
			String s = analysis.nextToken();
			System.out.println(s + "取出单词后，还有" + analysis.countTokens() + "个单词");
		}
		
		String s2 = "asf,sdf,sadf,sadf,";
		analysis = new StringTokenizer(s2,",");
		
		System.out.println(s2 + "划分出来的单词数量：" + analysis.countTokens());
		
		while(analysis.hasMoreTokens()){
			String s = analysis.nextToken();
			System.out.println(s + "取出单词后，还有" + analysis.countTokens() + "个单词");
		}
		System.out.println("hello");
	}
}
