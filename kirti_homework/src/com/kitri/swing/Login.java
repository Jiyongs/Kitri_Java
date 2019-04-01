package com.kitri.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Login extends JFrame {
	private JTextField ipTF;
	private JTextField nameTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Login!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 184);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("I     P  :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 9, 69, 38);
		getContentPane().add(lblNewLabel);
		
		ipTF = new JTextField();
		ipTF.setBounds(87, 10, 186, 38);
		getContentPane().add(ipTF);
		ipTF.setColumns(10);
		
		JLabel label = new JLabel("대화명  :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 60, 69, 38);
		getContentPane().add(label);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(87, 61, 186, 38);
		getContentPane().add(nameTF);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 108, 262, 33);
		getContentPane().add(panel);
		
		JButton ok = new JButton("확인");
		panel.add(ok);
		
		JButton cancel = new JButton("취소");
		panel.add(cancel);
	}
}
