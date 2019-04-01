package test_today;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton b1;
	private JButton b2;
	
	// �г��̺�Ʈ �����ϱ� ����, �������� ����
	JPanel panel = new JPanel();
	
	// �гο� ���� �ٸ� Ŭ������ �г� 2�� ����
	View1 v1 = new View1();
	View2 v2 = new View2();	
	
	// ī�巹�̾ƿ��� ȭ�� ��ȯ �޼ҵ带 �ٸ� Ŭ�������� ���� ����, �������� ����
	CardLayout card = new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// �г��� ���̾ƿ��� ī�巹�̾ƿ����� �����ϱ�
		panel.setLayout(card);
		// �гο� v1, v2�� ���̸鼭 ���ڿ� �̸� ����
		panel.add("view1", v1);
		panel.add("view2", v2);
		
		// �гο� ó�� ������ �г� �����غ��� (������ �̸� ���)
		card.show(panel, "view2");
		
		panel.setBounds(12, 43, 481, 434);
		contentPane.add(panel);
		
		b1 = new JButton("\uD654\uBA741");
		b1.setBounds(12, 10, 80, 23);
		contentPane.add(b1);
		
		b2 = new JButton("\uD654\uBA742");
		b2.setBounds(104, 10, 80, 23);
		contentPane.add(b2);
		
		//��ư1,2�� �̺�Ʈ ���
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	// *ActionLinstener �޼ҵ� override
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob== b1) {
			card.show(panel, "view1");
		} else if(ob == b2) {
			card.show(panel, "view2");
		}
	}

}
