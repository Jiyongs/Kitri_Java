package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;
//Address already in use: JVM_Bind ���� : �����Ϸ��� ��Ʈ�� �̹� ������̶�� ������


// �� ����
// server >> client(����)
public class ChatServer implements Runnable {    //*������ extends�� �����̹Ƿ�, ������ ó���� ���� Runnable�� implements

	// * ���� ���� �� ���� ����
	ServerSocket ss = null;
	
	// *������� Ŭ���̾�Ʈ�� ������ vector ����
	Vector<ChatClient> list = new Vector<ChatClient>();

	// [������]
	public ChatServer() {
	
		try {
			ss = new ServerSocket(ChatConstance.PORT);
			System.out.println("Ŭ���̾�Ʈ ���� �����............");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// *Ŭ���̾�Ʈ ���� ó��
	@Override
	public void run() {
		while(true) {
			try {
				Socket socket = ss.accept();
				System.out.println("Ŭ���̾�Ʈ ���� ���� :: " + socket);  //socket�� socket�� ���� toString() ȣ�� : �ּҰ� ����� ����
				
				new ChatClient(socket).start(); //**
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// [���� ���� �޼ҵ�]
	public static void main(String[] args) {
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);     //*�������� Ÿ�� Runnable ��ü�ν�, Runnable�� implements�� ChatServer��ü�� ����
//		t.start();
		
		new Thread(new ChatServer()).start(); //t�δ� start()�ۿ� �� ���� �����Ƿ�, �͸�ü�� �ع�����.
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// �� â
	// server >> clients(����)  
	// [inner class] : Ŭ���̾�Ʈ ����� / �ٱ� ������ ����� ��� ������
	class ChatClient extends Thread {

		String name;           //�� ��ȭ��
		BufferedReader in;
		OutputStream out;
		
		Socket socket;
		
		public ChatClient(Socket socket) { //**
			try {
				this.socket = socket;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				// ���� �޼��� �ְ� ���� �� �ִ�
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// *Ŭ���̾�Ʈ �޼��� ó��
		@Override
		public void run() {
			boolean flag = true;
			while(flag) {
				try {					
					String msg = in.readLine();
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + msg); //��������|�޼�������...
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					
					switch(protocol) {
						case ChatConstance.CS_CONNECT : {
							// 100|������
							// *�� ��ȭ�� ������
							name = st.nextToken(); // name = "������"
							// *���� ������ ��� ���(Vector)���� ��ȭ�� �����ϱ�   //��Ƽĳ��Ʈ
							multicast(ChatConstance.SC_CONNECT + "|" + name);
							// *Vector�� ���� ���Խ�Ŵ
							list.add(this);
							
							// *������ ���ӵ� ��ȭ����� �˷��ֱ�                       //����ĳ��Ʈ
							for(ChatClient cc : list) {
								unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
							}
							
						} break;
						
						case ChatConstance.CS_ALL : {
							// 200|�ȳ��ϼ���.
							String tmp = st.nextToken();
							multicast(ChatConstance.SC_MESSAGE+ "|[" + name +"] " + tmp); //��Ƽĳ��Ʈ
						} break;
						
						case ChatConstance.CS_TO : {
							// 250|ȫ�浿|�ȳ��ϼ���.
							String to = st.nextToken();     //ȫ�浿
							String tmp = st.nextToken();   //�ȳ��ϼ���.
							for(ChatClient cc : list) {
								if(cc.name.equals(to)) {
									cc.unicast(ChatConstance.SC_MESSAGE + "|��" + name + "��" + tmp);  // �߽��� + ���� �ӼӸ�
									break;
								}
							}
						} break;
						///////////////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
						case ChatConstance.CS_PAPER : {
							// 300|ȫ�浿|ȫ�浿�� ���� �����ϴ�.
							String to = st.nextToken();   //ȫ�浿
							String tmp = st.nextToken(); //ȫ�浿�� ���� �����ϴ�.
							for(ChatClient cc : list) {
								if(cc.name.equals(to)) {
									cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + tmp);  // �߽��� + ���� ����
								}
							}
						} break;
						
						case ChatConstance.CS_RENAME : {
							//400|����ȭ��
							String newname = st.nextToken(); //����ȭ��
							multicast(ChatConstance.SC_RENAME + "|" + name + "|" + newname);
							name = newname; //�������� ��ȭ�� �ٲ� ��ȭ������ ����!
						} break;
						
						case ChatConstance.CS_DISCONNECT : {
							// 900|
							multicast(ChatConstance.SC_DISCONNECT + "|" + name);  // �� Vector�� ���� ���� �ֱ⋚����, �����׵� �� �޼����� ��
							list.remove(this);                                                    // �� Vector���� ���� �M
							flag = false;                                                         // �� �����带 �����Ѵٰ� ���
							in.close();                                                            // �� �����, ������ ����         //if(in, out, socket==null)���ϴ� ������ null�̾��� �Ϸ� ������ ���߱� ����. �� �ص� ��!
							out.close();
							socket.close();
						} break;
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// <��Ƽĳ��Ʈ> �޼ҵ�                  // ��� ������� �޼��� ����
		private void multicast(String msg) {
			// *���� ������ ��� ���(Vector)���� ���� �� ��ȭ�� �˷��ֱ�
//			int size = list.size();
//			for(int i = 0; i<size; i++) {
//				ChatClient cc = list.get(i);
//			}	
			// => ���� for�� ���
//			for(ChatClient cc : list) {
//				cc.out.write((msg + "\n").getBytes());
//			}
			// => unicast() ȣ��
			for(ChatClient cc : list) {
				cc.unicast(msg);
			}
		}
		
		// <����ĳ��Ʈ> �޼ҵ�                // �� ������� �޼��� ����
		private void unicast(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	} //ChatClient ��
	

	
} // ChatServer ��

