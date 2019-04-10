package com.kitri.chat.client;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kitri.chat.util.ChatConstance;

// ���� �α����ϴ� ����� â
// �� Ŭ���̾�Ʈ�� ������� â
public class Login extends JFrame implements ActionListener, ListSelectionListener, Runnable  {
	
	// [�ʵ�]
	Socket socket;
	
	String myid;          // ��ȭ��
	BufferedReader in;
	OutputStream out;
	
	JLabel ip;
	JLabel name;
	JTextField ipTf;
	JTextField nameTf; // event source 1
	JButton cancel;     // event source 2
	JButton ok;          // event source 3
	 
	Chat chat;
	Paper paper;
	Rename rename;

	// [������]
	public Login() {
		super("Login!!");
		initGUI();
		
		chat = new Chat();
		paper = new Paper();
		rename = new Rename();
		
		// loginâ event ���
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		// Chatâ event ���
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);
		chat.list.addListSelectionListener(this);
		
		// â �ݱ� �̺�Ʈ
		chat.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeProcess();
			}
		});
		
		// Paperâ event ���
		
		// Renameâ event ���
		
	}
	
	// [�޼ҵ�]
	// <������ ����> �޼ҵ�
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(244,243,242));
			{
				ip = new JLabel();
				getContentPane().add(ip);
				ip.setText("\uc544\uc774\ud53c");
				ip.setBounds(12, 12, 60, 30);
				ip.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				ip.setFocusable(false);
				ip.setRequestFocusEnabled(false);
				ip.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setText("\ub300\ud654\uba85");
				name.setBounds(12, 47, 60, 30);
				name.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				name.setFocusable(false);
				name.setRequestFocusEnabled(false);
				name.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				ipTf = new JTextField();
				getContentPane().add(ipTf);
				ipTf.setBounds(78, 12, 209, 30);
			}
			{
				nameTf = new JTextField();
				getContentPane().add(nameTf);
				nameTf.setBounds(78, 47, 209, 30);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\ub85c\uadf8\uc778");
				ok.setBounds(83, 83, 61, 32);
				ok.setBackground(new java.awt.Color(237,236,233));
				ok.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				cancel = new JButton();
				getContentPane().add(cancel);
				cancel.setText("\ucde8 \uc18c");
				cancel.setBounds(153, 83, 59, 32);
				cancel.setBackground(new java.awt.Color(237,236,233));
				cancel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			pack();
			this.setSize(303, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// [���� �޼ҵ�]
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setResizable(false);
				inst.setVisible(true);
			}
		});
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// [ActionListener override]
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if( ob == nameTf || ob == ok) {  //�ʵ忡�� ���� + ok��ư : �α���(���� �̺�Ʈ)
			connectProcess();
		} else if(ob == cancel) {
			System.exit(0);
		} else if(ob == chat.globalsend) {
			globalsendProcess();
		} else if(ob == chat.whomsend) {
			whomsendProcess();
		} else if(ob == chat.paper) {
			// ****************Paperâ ����
		} else if(ob == chat.rename) {

		} else if(ob == chat.exit) {
			closeProcess();
		}
	}

	// [ListSelectionListener override]
	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selName = chat.list.getSelectedValue();
		chat.whom.setText(selName);
	}
	
	//***************************************************************************************************************
	// 1. ���� ������ �޼ҵ�
	
	// 2. ��ȭ�� ���� �޼ҵ�
	
	//***************************************************************************************************************
	
	
	// <�α���> �޼ҵ�
	// 1) ip, ��ȭ�� get(��ȿ���˻�);   // ip�� �ڵ忡 �����Ŵϱ� �����ϰ�, ��ȭ���� 3���� �̻� ó����
	// 2) 1�� ip�� Socket ����          // Socket�� ���� = ������ ������ �Ǿ��ٴ� ��
	// 3) IO(BufferedReader, OutputStream) ����
	// 4) loginâ �ݰ�, chatâ ����
	// 5) server�� �޼��� ����           // ������ ���� �������ݴ�� �� ��ȭ��, �޼��� ���� (������ '��'�� �������� �˸�)
	// 6) Thread ����                     // �ٸ� ������� ��ȭ�� �غ� �� �����̹Ƿ�, ������ ����
	private void connectProcess() {
		
		String ip = ipTf.getText().trim();
		myid = nameTf.getText().trim();
		
		if(myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "��ȭ���� 3�� �̻��Դϴ�.", "��ȭ�� ����", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		try {
			// 2)
			socket = new Socket(ip, ChatConstance.PORT);
			
			// 3)
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			
			// 4)
			this.setVisible(false);
			chat.setVisible(true);
			
			// 5)
			sendMessage(ChatConstance.CS_CONNECT + "|" + myid);
			
			// 6)
			new Thread(this).start(); //**
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// <����� �޼��� ����> �޼ҵ�
	// 1) �޼��� get (��ȿ���˻�)
	// 2) server�� �޼��� ����
	private void globalsendProcess() {
		// 1)
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if(msg.isEmpty()) {
			return;
		}
		
		// 2)
		sendMessage(ChatConstance.CS_ALL + "|" + msg);
	}
	
	// <�ӼӸ�> �޼ҵ�
	// 1) �޼���, ���� ��� get (��ȿ���˻�)  - ����� ���ÿ���, �ڱ� �ڽſ��� �ӼӸ� X
	// 2) server�� �޼��� ����
	private void whomsendProcess() {
		// 1)
		String msg = chat.whomsend.getText().trim();
		chat.whomsend.setText("");
		if(msg.isEmpty()) {
			return;
		}
		
		String to = chat.whom.getText();
		
		if(to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "����ڸ� �����ϼ���.", "����� ����", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(to.equals(myid)){
			JOptionPane.showMessageDialog(chat, "�ڽſ��� �ӼӸ���...?", "����� ����", JOptionPane.INFORMATION_MESSAGE);
			return;	
		}
		
		// 2)
		sendMessage(ChatConstance.CS_TO + "|" + to + "|" + msg);
		viewMessage("��" + to + "��" + msg);   // ���� �ӼӸ�       //////////////////////////////////////////////////////###�����׵� ������ ��### (����)
	}
	
	// <����> �޼ҵ�
	// 1) �������� �����ٰ� �˸�
	private void closeProcess() {
		sendMessage(ChatConstance.CS_DISCONNECT + "|");   // 900|
	}
	
	// <������ �޼��� ����> �޼ҵ�
	private void sendMessage(String msg) {
		try {
			out.write((msg + "\n").getBytes()); // byte[]�� �����ϴµ�, server���� �̸� BufferedReader�� ����. ���� �������� "\n"�� ������, ���۰� �Է��� �ν��� �� ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// <Chatâ�� ��ȭâ�� �޼��� ����) �޼ҵ�
	private void viewMessage(String msg) {
		chat.area.append(msg + "\n");
		chat.area.setCaretPosition(chat.area.getDocument().getLength());  // TextArea�� ��Ŀ���� �� ������ �� (���ο� ä���� ������ ��, ��Ŀ���� ����)
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//���� ������ ������ â
	// Runnable Interface override //**
	@Override
	public void run() {
		boolean flag = true;
		while(flag) {
			try {
				String msg = in.readLine();
				System.out.println("������ ���� �޼��� : " + msg); //��������|�޼�������...
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				
				switch(protocol) {
					case ChatConstance.SC_CONNECT : {
						//100|�����ڴ�ȭ��
						String tmp = st.nextToken();   // myip�� ������, ��� ����� ��ȭ���� ��� �����ɷ� �ٲ�����. �ӽ� tmp�� ����
						viewMessage("[�˸�] " + tmp + "���� �����ϼ̽��ϴ�.");
						chat.listData.add(tmp);                //Chat Ŭ������ Vector��ü�� 'listData'�� ��ȭ���� ����
						chat.list.setListData(chat.listData);   //Chat Ŭ������ List��ü�� 'list'�� ��ȭ���� ����Ǿ� �ִ� Vector��ü�� 'listData'�� ������
					} break;
					
					case ChatConstance.SC_MESSAGE : {
						//200|[�����ڴ�ȭ��] �ȳ��ϼ���..
						String tmp = st.nextToken();  //[�����ڴ�ȭ��] �ȳ��ϼ���..
						viewMessage(tmp);
					} break;
					
					case ChatConstance.SC_PAPER : {
						
					} break;
					
					case ChatConstance.SC_RENAME : {
						
					} break;
					
					case ChatConstance.SC_DISCONNECT : {
						//900|�����»��
						String tmp = st.nextToken(); //�����»��
						if(!tmp.equals(myid)) {      // ������ ����� ���� �ƴ϶��
							viewMessage("[�˸�] " + tmp + "���� ������ �����Ͽ����ϴ�.");  // �� ���� �������� �˸���
							chat.listData.remove(tmp);                                                // �� ����Ʈ�� ���� ���� Vector���� ���� ��� ����
							chat.list.setListData(chat.listData);                                        // �� ����� Vector�� ����Ʈ�� ������
						}else {                          // ������ ����� �����
							flag = false;                                                         // �� �����带 �����Ѵٰ� ���
							in.close();                                                             // �� �����, ������ ����         //if(in, out, socket==null)���ϴ� ������ null�̾��� �Ϸ� ������ ���߱� ����. �� �ص� ��!
							out.close();
							socket.close();
//							chat.setVisible(false);                                              // �� â�� �� ���̰� ��
							System.exit(0);                                                      // �� ���α׷� ������
						}
					} break;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}



