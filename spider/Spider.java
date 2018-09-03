import java.io.*;
import java.net.URL;

class WebPage {
    //������Ҫ��������ҳ��ַ
    private String pageUrl;
    //������Ҫ��������ҳ����
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
        * StringBuffer �̰߳�ȫ
        * StringBuilder ���̰߳�ȫ
        *
        * */
        StringBuilder stringBuffer = new StringBuilder();
        int i = 0;
        try{
            //����һ��url����
            URL url = new URL(pageUrl);
            //ʹ��openStream�õ�һ�����������ɴ˹���һ��BufferReader����
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),pageEncode));
            String line;
            //���浽һ���ļ�����
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
        System.out.println("��������������");
        System.out.println(i);
        return stringBuffer.toString();
    }





}



public class Spider {
    public static void main(String args[]){
        System.out.println("д����������");
        WebPage webPage = new WebPage("https://m.jb51.net/article/124593.htm","gb2312");
        System.out.println("����ȡ����ַ�ǣ�" + webPage.getPageUrl());
        System.out.println("��ҳ��Դ�����£�");
        System.out.println(webPage.getPageSource());
        System.out.println("���������н��");
    }
}