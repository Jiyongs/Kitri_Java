package test_today;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Font;

public class View2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public View2() {
		setLayout(new GridLayout(1, 2, 10, 0));
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("\uD1A0\uAE00 \uBC84\uD2BC");
		tglbtnNewToggleButton.setFont(new Font("고양일산 L", Font.PLAIN, 19));
		add(tglbtnNewToggleButton);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(216, 191, 216));
		add(editorPane);

	}

}
