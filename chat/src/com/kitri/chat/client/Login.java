package com.kitri.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.kitri.chat.util.ChatConstance;

// 지금 로그인하는 사람의 창
// 각 클라이언트에 띄워지는 창

public class Login extends JFrame implements ActionListener, Runnable {
	
	String myid;          // 대화명
	BufferedReader in;
	OutputStream out;
	
	JLabel ip;
	JLabel name;
	JTextField ipTf;
	JTextField nameTf; // event source
	JButton cancel;     // es
	JButton ok;          // es
	 
	Chat chat;
	Paper paper;
	Rename rename;

	public Login() {
		super("Login!!");
		initGUI();
		
		chat = new Chat();
		paper = new Paper();
		rename = new Rename();
		
		// login창 event 등록
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		// Chat창 event 등록
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);
		
		// Paper창 event 등록
		
		// Rename창 event 등록
		
	}
	
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

	
	
	// [ActionListener override]
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if( ob == nameTf || ob == ok) {  //필드에서 엔터 + ok버튼 : 로그인(같은 이벤트)
			connectProcess();
		} else if(ob == cancel) {
			System.exit(0);
		} else if(ob == chat.globalsend) {
			globalsendProcess();
		} else if(ob == chat.whomsend) {

		} else if(ob == chat.paper) {

		} else if(ob == chat.rename) {

		} else if(ob == chat.exit) {

		}
	}
	
	
	// [메소드]
	// <모든사람 메세지 전송> 메소드
	// 1) 메세지 get (유효성검사)
	// 2) server로 메세지 전송
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


	// <로그인> 메소드
	// 1) ip, 대화명 get(유효성검사);   // ip는 코드에 박을거니까 제외하고, 대화명은 3글자 이상만 처리함
	// 2) 1의 ip로 Socket 생성          // Socket이 생성 = 서버와 연결이 되었다는 뜻
	// 3) IO(BufferedReader, OutputStream) 생성
	// 4) login창 닫고, chat창 열기
	// 5) server로 메세지 전송           // 정의해 놓은 프로토콜대로 내 대화명, 메세지 전송 (서버에 '내'가 들어왔음을 알림)
	// 6) Thread 실행                     // 다른 사람과의 대화가 준비가 된 시점이므로, 스레드 실행
	private void connectProcess() {
		
		String ip = ipTf.getText().trim();
		myid = nameTf.getText().trim();
		
		if(myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "대화명은 3자 이상입니다.", "대화명 오류", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		try {
			// 2)
			Socket socket = new Socket(ip, ChatConstance.PORT);
			
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
	
	// <서버에 메세지 전송> 메소드
	private void sendMessage(String msg) {
		try {
			out.write((msg + "\n").getBytes()); // byte[]로 전송하는데, server에선 이를 BufferedReader로 받음. 따라서 마지막에 "\n"을 보내야, 버퍼가 입력을 인식할 수 있음
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Runnable Interface override //**
	@Override
	public void run() {
		boolean flag = true;
		while(flag) {
			try {
				String msg = in.readLine();
				System.out.println("서버가 보낸 메세지 : " + msg); //프로토콜|메세지형식...
				StringTokenizer st = new StringTokenizer(msg, "|");
				int protocol = Integer.parseInt(st.nextToken());
				
				switch(protocol) {
					case ChatConstance.SC_CONNECT : {
						//100|접속자대화명
						String tmp = st.nextToken();   // myip에 받으면, 모든 사람의 대화명이 방금 받은걸로 바뀌어버림. 임시 tmp에 받자
						chat.area.append("[알림] " + tmp + "님이 접속하셨습니다.\n");
						chat.listData.add(tmp);                //Chat 클래스의 Vector객체인 'listData'에 대화명을 저장
						chat.list.setListData(chat.listData);   //Chat 클래스의 List객체인 'list'에 대화명이 저장되어 있는 Vector객체인 'listData'를 세팅함
						chat.area.setCaretPosition(chat.area.getDocument().getLength());
					} break;
					
					case ChatConstance.SC_MESSAGE : {
						//200|[접속자대화명] 안녕하세요..
						String tmp = st.nextToken();  //[접속자대화명] 안녕하세요..
						chat.area.append(tmp + "\n");
						chat.area.setCaretPosition(chat.area.getDocument().getLength());  // TextArea의 포커스를 맨 밑으로 둠 (새로운 채팅이 생겼을 때, 포커스를 맞춤)
					} break;
					
					case ChatConstance.SC_PAPER : {
						
					} break;
					
					case ChatConstance.SC_RENAME : {
						
					} break;
					
					case ChatConstance.SC_DISCONNECT : {
						
					} break;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
}



