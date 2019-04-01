package com.kitri.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField whomsend;
	private JTextField globalsend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chat() {
		setResizable(false);
		setTitle("즐거운 채팅.. ^^*");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea area = new JTextArea();
		area.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		area.setBounds(23, 22, 400, 355);
		contentPane.add(area);
		
		whomsend = new JTextField();
		whomsend.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		whomsend.setBounds(81, 431, 342, 34);
		contentPane.add(whomsend);
		whomsend.setColumns(10);
		
		globalsend = new JTextField();
		globalsend.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		globalsend.setColumns(10);
		globalsend.setBounds(23, 387, 400, 34);
		contentPane.add(globalsend);
		
		JLabel whom = new JLabel("귓속말");
		whom.setHorizontalAlignment(SwingConstants.LEFT);
		whom.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		whom.setForeground(new Color(255, 255, 255));
		whom.setBounds(22, 431, 84, 34);
		contentPane.add(whom);
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(435, 22, 162, 309);
		contentPane.add(list);
		
		JButton rename = new JButton("대화명변경");
		rename.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rename.setBounds(435, 341, 162, 34);
		contentPane.add(rename);
		
		JButton paper = new JButton("쪽지보내기");
		paper.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		paper.setBounds(435, 387, 162, 34);
		contentPane.add(paper);
		
		JButton close = new JButton("나가기");
		close.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		close.setBounds(435, 431, 162, 34);
		contentPane.add(close);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(12, 10, 598, 462);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}
