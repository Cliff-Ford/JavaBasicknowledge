import java.io.*;
import java.net.URL;

class WebPage {
    //定义需要操作的网页地址
    private String pageUrl;
    //定义需要操作的网页编码
    private String pageEncode;

    WebPage(String url,String encode){
        this.pageUrl = url;
        this.pageEncode = encode;
    }
    public String getPageUrl(){
        return pageUrl;
    }
    public void setPageUrl(String url){
        this.pageUrl = url;
    }
    public String getPageEncode(){
        return pageEncode;
    }
    public void setPageEncode(String encode){
        this.pageEncode = encode;
    }
    public String getPageSource(){
        //https://blog.csdn.net/rmn190/article/details/1492013
        /*
        * StringBuffer 线程安全
        * StringBuilder 非线程安全
        *
        * */
        StringBuilder stringBuffer = new StringBuilder();
        int i = 0;
        try{
            //构建一个url对象
            URL url = new URL(pageUrl);
            //使用openStream得到一个输入流并由此构建一个BufferReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),pageEncode));
            String line;
            //另存到一个文件里面
			String filename =  "result.txt";

			File file = new File(filename);
            FileWriter out = new FileWriter(file);
			
            System.out.println(filename);
            while((line = in.readLine()) != null){
                i++;
                stringBuffer.append(line + "\n");
				out.write(line);
            }
            in.close();
            out.close();
        }
        catch (Exception e){
            System.err.println();
        }
        System.out.println("函数即将结束了");
        System.out.println(i);
        return stringBuffer.toString();
    }





}



public class Spider {
    public static void main(String args[]){
        System.out.println("写个爬虫玩玩");
        WebPage webPage = new WebPage("https://m.jb51.net/article/124593.htm","gb2312");
        System.out.println("待爬取的网址是：" + webPage.getPageUrl());
        System.out.println("网页的源码如下：");
        System.out.println(webPage.getPageSource());
        System.out.println("理论上面有结果");
    }
}
