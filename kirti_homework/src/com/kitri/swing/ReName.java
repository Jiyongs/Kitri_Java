package com.kitri.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReName extends JFrame {

	private JPanel contentPane;
	private JTextField newname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReName frame = new ReName();
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
	public ReName() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 203);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(12, 10, 302, 154);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Name :");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 10, 108, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewName = new JLabel("New Name :");
		lblNewName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewName.setBounds(12, 59, 97, 39);
		panel.add(lblNewName);
		
		JLabel oldname = new JLabel("");
		oldname.setBounds(109, 10, 171, 39);
		panel.add(oldname);
		
		newname = new JTextField();
		newname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		newname.setBounds(109, 67, 181, 28);
		panel.add(newname);
		newname.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(143, 188, 143));
		panel_1.setBounds(81, 111, 141, 33);
		panel.add(panel_1);
		
		JButton ok = new JButton("변경");
		panel_1.add(ok);
		
		JButton cancel = new JButton("취소");
		panel_1.add(cancel);
	}

}
