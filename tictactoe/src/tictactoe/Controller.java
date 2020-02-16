package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Controller {
	Gui gui;
	JLabel label;
	JButton[] jButton;
	ButtonListener listener;
	JDialog winDialog = new JDialog();
	JLabel winLabel = new JLabel();
	Logger logger;

	TicTacToeBean bean;
	int turn = 1;

	public Controller() {
		gui = new Gui();
		
		bean = new TicTacToeBean();
		bean.initLogger();
		logger = bean.getLogger();

		jButton = gui.getjButton();

		listener = gui.getListener();
		listener.setJButton(jButton);
		listener.setController(this);

		winDialog.setTitle("Mein JDialog Beispiel");
		winDialog.setSize(200, 200);
		winDialog.setModal(true);

		label = gui.getLabel();
		label.setText((bean.initBoard()));

	}

	public boolean startRound(int field) {
		try {
			if (bean.getGameBoard() == null)
			throw new Exception();
		} catch (Exception e) {
			// Another try for initBoard
			logger.severe("Board init failed.");
			bean.initBoard();
		}

		if (!bean.playRound(field)) {
			label.setText("Occupied field! Select another one!");
			return false;
		}

		int player = bean.getPlayer();
		if (player == 1) {
			jButton[field].setText("O");
		} else {
			jButton[field].setText("X");
		}
		if (bean.winCheck()) {
			label.setText("We have a winner!");
			winLabel.setText("Player " + player + " won!");
			winDialog.add(winLabel);
			winDialog.setVisible(true);
			bean.resetBoard();
			gui.resetView();
			logger.info("Player"+player+"won!");
		}

		if (bean.getFieldCounter() == 9 && !bean.winCheck()) {
			label.setText("There is no winner!");
			winLabel.setText("Draw!");
			winDialog.add(winLabel);
			winDialog.setVisible(true);
			bean.resetBoard();
			gui.resetView();
			logger.info("Draw!");

		}

		label.setText("Player " + player + "'s turn!");
		if (player == 1) {
			player++;
			bean.setPlayer(player);
		} else {
			player--;
			bean.setPlayer(player);
		}
		return true;
	}

	public Logger getLogger() {
		return logger;
	}

}

class ButtonListener implements ActionListener {
	JButton jButton[];
	Controller con;
	Logger logger;
	public void actionPerformed(ActionEvent e) {
		logger = con.getLogger();
		for (int i = 1; i < 10; i++) {
			if (e.getSource() == jButton[i]) {
				logger.config("Field was chosen:" + i);
				con.startRound(i);
			}
		}

	}

	public void setController(Controller c) {
		con = c;
	}

	public void setJButton(JButton[] button) {
		jButton = button;
	}
}
