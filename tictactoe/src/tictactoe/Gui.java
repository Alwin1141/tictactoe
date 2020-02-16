package tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frm = new JFrame();
	private JPanel jPanel = new JPanel();
	private JButton[] jButton = new JButton[10];
	private JPanel jPanelSouth = new JPanel();
	private JLabel label = new JLabel("", JLabel.CENTER);
	private ButtonListener bl = new ButtonListener();

	public Gui() {
		frm.setTitle("TicTacToe");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(new BorderLayout());
		frm.setPreferredSize(new Dimension(800, 800));
		frm.add(jPanel, BorderLayout.CENTER);

		jPanel.setLayout(new GridLayout(3, 3));

		jPanelSouth.setPreferredSize(new Dimension(200, 100));
		jPanelSouth.add(label);

		frm.add(jPanelSouth, BorderLayout.SOUTH);

		label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalTextPosition(JLabel.LEFT);

		for (int i = 1; i < 10; i++) {
			jButton[i] = new JButton("");
			jButton[i].addActionListener(bl);
			jPanel.add(jButton[i]);
		}
		frm.pack();
		frm.setVisible(true);
	}

	public void resetView() {
		for (int i = 1; i < 10; i++) {
			jButton[i].setText("");
		}
	}

	public JButton[] getjButton() {
		return jButton;
	}

	public void setjButton(JButton[] jButton) {
		this.jButton = jButton;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ButtonListener getListener() {
		return bl;
	}

	public void setListener(ButtonListener bl) {
		this.bl = bl;
	}

}
