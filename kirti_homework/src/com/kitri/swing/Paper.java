package com.kitri.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import java.awt.GridLayout;

public class Paper extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paper frame = new Paper();
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
	public Paper() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(216, 191, 216));
		panel.setBounds(12, 10, 301, 303);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel from = new JLabel("");
		from.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		from.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		from.setBackground(new Color(128, 128, 128));
		from.setBounds(64, 10, 81, 40);
		panel.add(from);
		
		JLabel lblNewLabel = new JLabel("From :");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 51, 40);
		panel.add(lblNewLabel);
		
		JLabel lblTO = new JLabel("T o :");
		lblTO.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblTO.setHorizontalAlignment(SwingConstants.CENTER);
		lblTO.setBounds(157, 10, 51, 40);
		panel.add(lblTO);
		
		JTextArea letter = new JTextArea();
		letter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		letter.setBounds(12, 60, 277, 188);
		panel.add(letter);
		
		JLabel to = new JLabel("");
		to.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		to.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		to.setBackground(Color.LIGHT_GRAY);
		to.setBounds(208, 10, 81, 40);
		panel.add(to);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 191, 216));
		panel_1.setBounds(64, 258, 175, 35);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 5, 0));
		
		JButton send = new JButton("보내기");
		panel_1.add(send);
		send.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		JButton cancle = new JButton("취소");
		panel_1.add(cancle);
		cancle.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	}

}
