package tictactoe;

import java.io.IOException;
import java.util.logging.*;

public class TicTacToeBean {
	private Logger logger = Logger.getLogger("MyLog");
	
	private BoardField[][] gameBoard = new BoardField[3][3];
	private int player = 1;
	private int fieldCounter = 0;
	
	public void initLogger() {
		logger = Logger.getLogger("MyTicTacToeLog");  
	    FileHandler fh;  

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:\\Users\\alwin\\Desktop\\TicTacToe.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
	        logger.info("Logger initialized");  
	        
	    } catch (SecurityException e) {  
	    	logger.severe("Logger init failed: " + e);
	    } catch (IOException e) {  
	    	logger.severe("Reading file failed: " + e);
	    }  
	}

	public String initBoard() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				gameBoard[x][y] = new BoardField();
			}
		}
		logger.info("Board initialized");
		return "Player 1 starts!";
	}

	public boolean playRound(int selectedField) {
		try {
			if (selectedField > 9 || selectedField < 1)
				return false;
			
			if (checkMove(selectedField)) {
				setMove(selectedField, player);
				return true;
			}
			return false;
		} catch (Exception e) {
			// send Text to View and return false. Not nessessary caused by the Gui variable limitation 
			return false;
		}
	}

	private boolean checkMove(int selectedField) {

		if (!(gameBoard[(selectedField - 1) / 3][(selectedField - 1) % 3].isOccupied())) {
			return true;
		}
		return false;
	}

	private void setMove(int fieldMove, int player) {
		gameBoard[(fieldMove - 1) / 3][(fieldMove - 1) % 3].setField(player);
		gameBoard[(fieldMove - 1) / 3][(fieldMove - 1) % 3].setOccupied(true);
		fieldCounter++;
	}

	public boolean winCheck() {
		boolean won = false;

		for (int i = 0; i < 3; i++) {
			if (gameBoard[i][0].getField() == gameBoard[i][1].getField()
					&& gameBoard[i][1].getField() == gameBoard[i][2].getField()) {
				if (gameBoard[i][2].isOccupied()) {
					won = true;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (gameBoard[0][i].getField() == gameBoard[1][i].getField()
					&& gameBoard[1][i].getField() == gameBoard[2][i].getField()) {
				if (gameBoard[2][i].isOccupied()) {
					won = true;
				}
			}
		}

		if (gameBoard[0][0].getField() == gameBoard[1][1].getField()
				&& gameBoard[1][1].getField() == gameBoard[2][2].getField()) {
			if (gameBoard[2][2].isOccupied()) {
				won = true;
			}
		}

		if (gameBoard[2][0].getField() == gameBoard[1][1].getField()
				&& gameBoard[0][2].getField() == gameBoard[1][1].getField()) {
			if (gameBoard[0][2].isOccupied()) {
				won = true;
			}
		}
		return won;
	}

	public void resetBoard() {

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				gameBoard[x][y].setField(0);
				gameBoard[x][y].setOccupied(false);
			}
		}
		fieldCounter = 0;
		logger.info("Board reseted.");
	}

	public int getFieldCounter() {
		return fieldCounter;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public BoardField[][] getGameBoard() {
		return gameBoard;
	}

	public Logger getLogger() {
		return logger;
	}
}
