public class Main{
	public static void main(String[] args){
		String s = new String("we are students");
		//也可以用已创建的字符串创建一个新的字符串
		String a = new String(s);
		System.out.println(s);
		System.out.println(a);
		//可以用一个字符数组来创建一个字符串
		char[] b = {'b','o','y'};
		String c = new String(b);
		//或者  String(char a[], int startIndex, int count);
		String d = new String(b,1,2);
		System.out.println(c);
		System.out.println(d);
		//public int length()获取字符串长度
		System.out.println(d.length());
		//public boolean equals(String s) 比较当前字符串对象的实体是否与参数s指定的字符串的实体相同
		System.out.println("boy".equals(d));  //boy  oy
		
		//public boolean startsWith(String s)
		//public boolean endWith(String s)  判断字符串是否以s为前缀或者后缀
		System.out.println("2202143".startsWith("220"));
		
		//public boolean regionMatches(int firstStart, String other, int otherStart, int length);
		//字符串调用该方法，从大年字符串参数firstStart指定的位置开始处，取长度为length的子串，并
		//将这个子串和参数other指定的一个子串进行比较，其中，other指定的子串是从参数otherStart指定
		//的位置开始，取长度为length的一个子串。如果两个子串相等，返回true，否则返回false
		String e = "studentstudentstudent";
		int num = 0;
		for(int k = 0; k < e.length(); k++){
			//判断有几个st
			if(e.regionMatches(k,"stu",0,2)){
				num++;
			}
		}
		System.out.println(num);  // num = 3
		
		//public int compareTo(String s)按照字典序与参数比较大小，如果字符串相同，返回0，当前字符串大则返回正数
		//否则，返回负数
		System.out.println("aabcde".compareTo("aacoy"));    // -1
		System.out.println("aaabcde".compareTo("aaaba"));    // 2
		System.out.println("abcde".compareTo("abcde"));  // 0
		
		//public int indexOf(String s)
		//public int lastIndexOf(String s)
		System.out.println("abcbc".indexOf("bc"));  // 1
		System.out.println("abcbc".lastIndexOf("bc"));  // 3
		
		//public String substring(int startpoint);
		//public String substring(int start, int end);
		//第一个方法时从开始位置到最后，第二方法是从开始位置到end位置，但不包括end位置,即[start，end)
		System.out.println("XiaoNIZiYo".substring(4));
		System.out.println("XiaoNIZiYo".substring(4,8));
		
		//public String replaceAll(String oldString, String newString)
		//public String replaceFirst(String oldString, String newString)
		System.out.println("MeiXi".replaceAll("i","abc"));
		
		//public String trim()调用该方法，得到一个去掉调用对象前后空格的字符串,中间的空格保留
		System.out.println(" I am  a Student ".trim());
		
		//字符串与基本数据的相互转化
		int x = Integer.parseInt("1234");
		System.out.println(x);
		System.out.println(Float.parseFloat("12.0f"));
		System.out.println(Double.parseDouble("12.09"));
		System.out.println(Long.parseLong("1212131312121"));
		//System.out.println(Integer.parseInt("1212131312121")); 报错，因为范围问题
		//其他数据类型转换为string类型
		System.out.println(String.valueOf(123));
		
		//public void getChars(int start, int end, char c[], int offset)
		//字符串调用该方法，将当前字符串中的一部分复制到c的字符数组里面，[start,end),offset是c数组的偏移
		
		//public byte[] getBytes()将当前字符串转化为一个字节数组，一个汉字算一个字符，但一个汉字算连个字节
		byte k[] = "abc你我他".getBytes();
		for(byte t : k){
			System.out.println(t);
		}
		
		
	}
}