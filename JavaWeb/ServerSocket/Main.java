/*
�ͻ��������ͻ������������׽������ӣ����ͻ��������
��˷��������뽨��һ���ȴ����ܿͻ����׽��ֵ�ServerSocket����

���췽�� ServerSocket(int port)

������ServerSocket����ʱ�����ܷ���IOException�쳣������˿ںű�ռ��
try{
	ServerSocket serverSocket = new ServerSocket(1880);
}
catch(IOException e){
	
}

��������ServerSocket�������󣬾Ϳ���ʹ�÷���accept()���ܿͻ����׽������Ӻ���
�����յĿͻ��׽���Ҳ���ܷ����쳣�����
try{
	Socket sc = serverSocket.accept();
}
catch(IOException e){
	
}
��ν�ġ����ա��ͻ����׽������Ӿ���accept()�᷵��һ���Ϳͻ���Socket���������ӵ�Socket����
�����������Socket����scʹ��getOutputStream()������õ��������ָ��ͻ���Socket����mySocketʹ��getInputStream��õ�������

ͬ�������������socket����scʹ��getInputStream��õ���������ָ��ͻ���Socket����mysocketʹ��getOutputStream��õ������

��Ҫע����ǣ����׽��������ж�ȡ��������ļ��ж�ȡ�������źܴ�Ĳ�ͬ�����ܶ��߶���������
���ļ��ж�ȡ����ʱ�����е����ݶ��Ѿ����ļ���
��ʹ���׽�������ʱ����������һ�����ݷ��ͳ���֮ǰ�����Ѿ���ʼ���Ŷ�ȡ�ˣ���ʱ�ͻ�������̣߳�֪���ö�ȡ�����ɹ���ȡ����Ϣ
���̲߳ż���ִ�к����Ĳ���

���⣬accept����Ҳ��������̵߳ļ���ִ�У�֪�����ܵ��ͻ��ĺ���
try{
	Socket sc = serverSocket.accept();
	System.out.println("ok");  //����ͻ�û�к��У���仰�Ͳ������
}
catch(IOException e){}


serverSocket������Ե���setSoTimeOut(int timeout)�������ó�ʱֵ��timeout��һ����ֵ
��serverSocket�������accept����������ʱ��һ������timeoutʱ��������SocketTimeoutException�¼�

*/

import java.io.*;
import java.net.*;
public class Main{
	public static void main(String args[]){
		ServerSocket serverSocket = null;
		Socket sc = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		try{
			serverSocket = new ServerSocket(4331);
		}
		catch(IOException e){            //�˿ڿ��ܱ�ռ��
			System.out.println(e);
		}
		try{
			System.out.println("�ȴ��ͻ�����");
			sc = serverSocket.accept();      //����״̬�����ǿͻ�����
			dataOutputStream = new DataOutputStream(sc.getOutputStream());
			dataInputStream = new DataInputStream(sc.getInputStream());
			while(true){
				char c = dataInputStream.readChar();   //��ȡ��Ϣ������״̬
				System.out.println("�������յ�" + c);
				dataOutputStream.writeChar((char)(c - 32));
				Thread.sleep(500);
			}
		}
		catch(Exception e){
			System.out.println("�ͻ��Ͽ�������" + e);
		}
	}
}
























