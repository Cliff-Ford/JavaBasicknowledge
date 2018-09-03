
public class Main{
	public static void main(String[] args){
		//String创建的对象一旦创建，实体就不可以再发生变化
		//StringBuffer创建的对象的实体是可以随意变化的
		StringBuffer s = new StringBuffer("abcde");
		System.out.println(s);
		
		System.out.println("当前s的容量是" + s.capacity());
		System.out.println("当前s的长度是" + s.length());
		
		//StringBuffer() StringBuffer(int size) StringBuffer(String s)
		//StringBuffer有三个构造函数，使用第一个无参数构造方法创建一个StringBuffer对象，那么分配
		//给该对象的实体的初始容量是16个字符，当该对象实体存放的字符序列长度大于16时，实体的容量
		//自动增加
		//对象可以通过length()获取实体的长度，capacity()获取实体的实际容量
		s.append("fghijk");
		System.out.println(s);
		s.append(1);
		System.out.println(s);
		//同理，append()方法的参数不仅可以是int String Object ，还可以是boolean float double等
		s.setCharAt(0,'c');
		System.out.println("将s的第一个字符修改为c " + s);
		
		//StringBuffer insert(int index, String str) 将参数str指定的字符串插入到参数index指定的位置，
		//返回当前对象的引用
		System.out.println(s.insert(0,"我"));
		
		System.out.println("字符串翻转 " + s.reverse());
		
		//StringBuffer delete(int startIndex, int endIndex) StringBuffer delete(int startIndex)  闭区间[startIndex,endIndex)
		System.out.println("删除s中的第3,4个字符" + s.delete(3,5));
		
		//StringBuffer replace(int startIndex, int endIndex, String str)
		System.out.println("替换s中的第4,5个字符 " + s.replace(4,6,"嗯嗯"));
		
	}
}