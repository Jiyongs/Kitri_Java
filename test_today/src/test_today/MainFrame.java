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
	
	// 패널이벤트 지정하기 위해, 전역으로 생성
	JPanel panel = new JPanel();
	
	// 패널에 붙일 다른 클래스의 패널 2개 생성
	View1 v1 = new View1();
	View2 v2 = new View2();	
	
	// 카드레이아웃의 화면 전환 메소드를 다른 클래스에서 쓰기 위해, 전역으로 생성
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
		
		// 패널의 레이아웃을 카드레이아웃으로 설정하기
		panel.setLayout(card);
		// 패널에 v1, v2를 붙이면서 각자에 이름 지정
		panel.add("view1", v1);
		panel.add("view2", v2);
		
		// 패널에 처음 보여줄 패널 지정해보기 (지정한 이름 사용)
		card.show(panel, "view2");
		
		panel.setBounds(12, 43, 481, 434);
		contentPane.add(panel);
		
		b1 = new JButton("\uD654\uBA741");
		b1.setBounds(12, 10, 80, 23);
		contentPane.add(b1);
		
		b2 = new JButton("\uD654\uBA742");
		b2.setBounds(104, 10, 80, 23);
		contentPane.add(b2);
		
		//버튼1,2의 이벤트 등록
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	// *ActionLinstener 메소드 override
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
