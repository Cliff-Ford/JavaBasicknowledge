/*
IP��ַ��ʶInternet�ϵļ�������˿ںű�ʶ���ڼ���������еĽ���
�˿ںź�IP��ַ��ϳ�һ�������׽��֣��˿ںű��涨Ϊһ��16λ������ 0 - 65535
���� 0 - 1023 ��Ԥ����ķ���ͨ��ռ�ã���teInetռ�ö˿�23 httpռ�ö˿�80 ��

������������Ҫͨ��ʱ�����ǿ���ͨ��ʹ��socket�ཨ���׽��ֶ���������һ��

Socket(String host, int port)  host�Ƿ�������ip��ַ port�Ƕ˿ں�
�����׽������ӿ��ܷ���IOException�쳣 ���Ҫ���������������׽�������Ӧʹ�����´���
try{
	Socket mysocket = new Socket("http://192.168.0.78", 1880);
}
catch(IOException e){
	
}
���׽�������mysocket�󣬿�������һ��ͨ����·�Ѿ�����������
����ʹ��getInputStream()���һ����������Ȼ���������������ȡ���������뵽��·����Ϣ
�����ܶ�ȡ�Լ�������·����Ϣ�������绰ʱ��ֻ�������Է�������·���������

getOutputStream()��ȡһ���������Ȼ����������������Ϣд����·

ʵ�ʱ���ϣ�����getInputStream��õ����������ӵ���һ���������ϣ�Ȼ��Ϳ��Դ������������ȡ����������Ϣ
֮��������������Ϊ����DataInputStream���и��õĴ����ж�ȡ����������Ϣ

ͬ��������getOutputStream�õ�����Ҳ��󶨵���һ��DataOutputStream����ȥ

*/

import java.io.*;
import java.net.*;
public class Main{
	public static void main(String args[]){
		Socket socket;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try{
			socket = new Socket("127.0.0.1", 4331);
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			char c = 'a';
			while(true){
				if(c > 'z'){
					c = 'a';
				}
				dataOutputStream.writeChar(c);
				char s = dataInputStream.readChar();       //in��ȡ��Ϣʱ������״̬
				System.out.println("�ͻ����յ���" + s);
				c++;
				Thread.sleep(500);
			}
		}
		catch(InterruptedException ee){
			System.out.println(ee);
		}
		catch(IOException e){
			System.out.println("�������ѶϿ�" + e);
		}
	}
}