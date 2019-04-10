package com.kitri.chat.util;

	// client(��) >> server >> client(����)

public class ChatConstance {
	
	// ip ����
	public static final int PORT = 9876;

	// �������� ����
	// client(��) >> server                                                   //[Login.java]
	// �� ����								100|��ȭ��  
	// �� ����� �޼���					200|�޼���
	// �� Ư����� �޼��� (�ӼӸ�)		250|�����|�޼���
	// �� ���� ������						300|�����|�޼���
	// �� ��ȭ�� ����						400|�����Ҵ�ȭ��
	// �� ���� ����							900|
	
	public static final int CS_CONNECT = 100;
	public static final int CS_ALL = 200;
	public static final int CS_TO = 250;
	public static final int CS_PAPER = 300;
	public static final int CS_RENAME = 400;
	public static final int CS_DISCONNECT = 900;
	
	// server >> client(����)                                              //[ChatServer.java]
	// �� ����								100|�����ڴ�ȭ��
	// �� �޼���	(��ü)						200|[���������ȭ��] �޼���         //�޼��� ��� ���·� ��������
	// �� �޼���  (Ư��)						200|�ٺ��������ȭ��� �޼���
	// �� ���� ������						300|���������ȭ��|�޼���
	// �� ��ȭ�� ����						400|��������ȭ��|�����Ҵ�ȭ��      //�������� �ĸ� ������ �ϴϱ�
	// �� ���� ����							900|�����ڴ�ȭ��                       //���� �������� ������ �ϴϱ�
	
	public static final int SC_CONNECT = 100;
	public static final int SC_MESSAGE = 200;
	public static final int SC_PAPER = 300;
	public static final int SC_RENAME = 400;
	public static final int SC_DISCONNECT = 900;
	
}
