package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;


//Address already in use: JVM_Bind ���� : �����Ϸ��� ��Ʈ�� �̹� ������̶�� ������

// �� ����
// �� â

public class ChatServer implements Runnable {    //*������ extends�� �����̹Ƿ�, ������ ó���� ���� Runnable�� implements

	// *������� Ŭ���̾�Ʈ�� ������ vector ����
//	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>();
	Vector<ChatClient> list = new Vector<ChatClient>();
	
	// * �� ���� ���� �� ���� ����
	ServerSocket ss = null;

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
	
	// [inner class] : Ŭ���̾�Ʈ ����� / �ٱ� ������ ����� ��� ������
	class ChatClient extends Thread {

		String name;           //��ȭ��
		BufferedReader in;
		OutputStream out;
		
		public ChatClient(Socket socket) { //**
			try {
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
							// *���� ������ ��� ���(Vector)���� ���� �� ��ȭ�� �˷��ֱ�
//							int size = list.size();
//							for(int i = 0; i<size; i++) {
//								ChatClient cc = list.get(i);
//							}							
							// ���� for�� ���
							for(ChatClient cc : list) {
								cc.out.write((ChatConstance.SC_CONNECT + "|" + name +"\n").getBytes());
							}
							// *Vector�� ���� ���Խ�Ŵ
							list.add(this);
							
							// *���� ������ ��� ���(Vector)���� ������� ��ȭ���� �˷��ֱ�
							for(ChatClient cc : list) {
								this.out.write((ChatConstance.SC_CONNECT + "|" + cc.name +"\n").getBytes());
							}
							
						} break;
						
						case ChatConstance.CS_ALL : {
							String tmp = st.nextToken();
							for(ChatClient cc : list) {
								cc.out.write((ChatConstance.SC_MESSAGE+ "|[" + name +"] " + tmp + "\n").getBytes());
							}
						} break;
						
						case ChatConstance.CS_TO : {
							
						} break;
						
						case ChatConstance.CS_PAPER : {
							
						} break;
						
						case ChatConstance.CS_RENAME : {
							
						} break;
						
						case ChatConstance.CS_DISCONNECT : {
							
						} break;
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	// [���� ���� �޼ҵ�]
	public static void main(String[] args) {
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);     //*�������� Ÿ�� Runnable ��ü�ν�, Runnable�� implements�� ChatServer��ü�� ����
//		t.start();
		
		new Thread(new ChatServer()).start(); //t�δ� start()�ۿ� �� ���� �����Ƿ�, �͸�ü�� �ع�����.
		
	}
	
}

