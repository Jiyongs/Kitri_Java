package test_today;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public View1() {
		setLayout(new GridLayout(3, 2, 0, 0));
		
		JButton btn1 = new JButton("\uC785\uB825");
		add(btn1);
		
		JButton btn2 = new JButton("\uCDE8\uC18C");
		add(btn2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC120\uD0DD\uC0AC\uD56D1");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uC120\uD0DD\uC0AC\uD56D2");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnNewRadioButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		textField = new JTextField();
		textField.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1);
		
		textField_1 = new JTextField();
		textField_1.setText("\uB0B4\uC6A9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		scrollPane_1.setViewportView(textField_1);
		textField_1.setColumns(10);

	}

}
