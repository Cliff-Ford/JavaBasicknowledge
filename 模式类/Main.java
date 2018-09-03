import java.util.regex.*;
public class Main{
	public static void main(String []args){
		/*
		元字符	在正则式中的写法	意义
		.	    "." 				代表任何一个字符
		\d		"\\d"				代表0到9的任何一个数字
		\D 		"\\D"				代表任何一个非数字字符
		\s		"\\s"				代表空格类字符：'\t' '\n' '\x0B' '\f' '\r'
		\S 		"\\S"				代表非空格类字符
		\w		"\\w"				代表可用于标识符的字符(不包括美元符号)
		\W 		"\\W"				代表不能用于标识符的字符
		\p{Lower}	\\p{Lower}		小写字母a-z
		\p{Upper}	\\p{Upper}		大写字母A-Z
		\p{ASCII}	\\p{ASCII}		ASCII字符
		\p{Alpha}	\\p{Alpha}		字母
		\p{Digit}	\\p{Digit}		数字字符
		\p{Alnum}	\\p{Alnum}		字母或数字
		\p{Punct}	\\p{Punct}		标点符号：！"#$%&'+-,./:;<=>?@[\]^_`{|}~
		\p{Graph}	\\p{Graph}		可视字符：\p{Alnum}\p{Punct}
		\p{Print}	\\p{Print}		可打印字符：\p{Graph}
		\p{Blank}	\\p{Blank}		空格或制表符
		\p{Cntrl}	\\p{Cntrl}		控制字符：[\x00-\x1F\x7F]
		
		
		在正则表达式中，可以用方括号括起若干字符来表示一个元字符，该元字符代表方括号中任何一个字符
		[abc]	代表a、b、c任何一个
		[^abc]	代表除abc之外的字符
		[a-zA-Z]代表英文字母中任何一个
		
		交并差如下
		
		交 [a-z&&[def]] 代表def中的一个
		并 [a-d[m-p]]
		差 [a-f&&[^bc]] 代表adef
		
		
		在正则式里面可以使用限定修饰符
		x？		x出现0次或1次
		x*		x出现0次或多次
		x+		x出现1次或多次
		x{n}	x恰好出现n次
		x{n,}	x至少n次
		x{n,m} 	x出现n次至m次
		
		*/
		
		String regex = "[1-9][0-9]{5,}@qq[.]com";  //识别qq邮箱
		String mail1 = "12345@qq.com";       //数字位数不够
		String mail2 = "123456@qq.com";
		String mail3 = "123456@qq.com223456@qq.com323456@qq.com423456@qq.com";
		if(Pattern.matches(regex,mail1)){
			System.out.println("邮箱符合要求");
		}else{
			System.out.println("邮箱不符合要求");
		}
		if(Pattern.matches(regex,mail2)){
			System.out.println("邮箱符合要求");
		}else{
			System.out.println("邮箱不符合要求");
		}
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mail3);
		System.out.println(m);
		while(m.find()){
			String s = m.group();
			System.out.println(s);
		}
	}
}