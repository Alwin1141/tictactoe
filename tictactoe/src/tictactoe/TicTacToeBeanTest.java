package tictactoe;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeBeanTest {

	TicTacToeBean bean = new TicTacToeBean();
	Gui gui = new Gui();
	Controller con = new Controller();

	@Before
	public void initBoardForInitBoardMethod() {
		bean.initBoard();
	}

	// State tests

	@Test
	public void initBoardTest() {
		BoardField[][] gameBoard = bean.getGameBoard();

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				assertNotNull(gameBoard[x][y].getClass());
			}
		}
	}

	@Before
	public void initBoardforResetMethod() {
		bean.initBoard();
		bean.resetBoard();
	}

	@Test
	public void resetBoardTest() {
		BoardField[][] gameBoard = bean.getGameBoard();

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				assertTrue(gameBoard[x][y].getField() == 0);

				assertFalse(gameBoard[x][y].isOccupied());
			}
		}
		assertTrue(bean.getFieldCounter() == 0);
	}

	@Before
	public void initBoardforWinCheckMethod() {
		bean.initBoard();
		bean.resetBoard();
	}

	@Test
	public void winCheckBoardTest() {
		BoardField[][] gameBoard = bean.getGameBoard();

		// Init each possibility of winning and test method recognition

		gameBoard[0][0].setField(1);
		gameBoard[0][1].setField(1);
		gameBoard[0][2].setField(1);
		gameBoard[0][2].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		gameBoard[1][0].setField(1);
		gameBoard[1][1].setField(1);
		gameBoard[1][2].setField(1);
		gameBoard[1][2].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		gameBoard[2][0].setField(1);
		gameBoard[2][1].setField(1);
		gameBoard[2][2].setField(1);
		gameBoard[2][2].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		gameBoard[0][0].setField(1);
		gameBoard[1][0].setField(1);
		gameBoard[2][0].setField(1);
		gameBoard[2][0].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		gameBoard[0][1].setField(1);
		gameBoard[1][1].setField(1);
		gameBoard[2][1].setField(1);
		gameBoard[2][1].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		gameBoard[0][2].setField(1);
		gameBoard[1][2].setField(1);
		gameBoard[2][2].setField(1);
		gameBoard[2][2].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		gameBoard[0][0].setField(1);
		gameBoard[1][1].setField(1);
		gameBoard[2][2].setField(1);
		gameBoard[2][2].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		gameBoard[2][0].setField(1);
		gameBoard[1][1].setField(1);
		gameBoard[0][2].setField(1);
		gameBoard[0][2].setOccupied(true);

		assertTrue(bean.winCheck());
		
		bean.resetBoard();

		// Random test negative possibility

		gameBoard[2][0].setField(1);
		gameBoard[0][1].setField(1);
		gameBoard[0][2].setField(1);
		gameBoard[0][2].setOccupied(false);

		assertFalse(bean.winCheck());
		
		bean.resetBoard();
		
		gameBoard[2][0].setField(1);
		gameBoard[0][1].setField(1);
		gameBoard[0][2].setField(1);
		gameBoard[0][2].setOccupied(true);

		assertFalse(bean.winCheck());
		
		bean.resetBoard();

	}
	// Integration Tests

	@Before
	public void initBoardforPlayRoundMethod() {
		bean.initBoard();
	}

	// playRound Integrationtest. Methods involved: playRound(), checkMove(),
	// setMove(),

	@Test
	public void playRoundTest() {
		// Insert all possible moves.

		for (int i = 1; i < 10; i++) {
			assertTrue(bean.playRound(i));
		}
		// Critical value Test
		assertFalse(bean.playRound(0));
		assertFalse(bean.playRound(10));
	}
	
	@Before
	public void initBoardforStartRoundMethod() {
		bean.initBoard();
	}

	// playRound Integrationtest. Methods involved: playRound(), checkMove(),
	// setMove(),

	@Test
	public void startRoundTest() {
		// Insert all possible moves.

		for (int i = 1; i < 10; i++) {
			assertTrue(con.startRound(i));
		}
		// Critical value Test
		assertFalse(bean.playRound(0));
		assertFalse(bean.playRound(10));
	}

}