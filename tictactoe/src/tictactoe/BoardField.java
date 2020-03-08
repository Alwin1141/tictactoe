package tictactoe;

public class BoardField {
	private int field;
	private boolean occupied;
//Test
	public BoardField() {
		field = 0;
		occupied = false;
	}

	public int getField() {

		return field;
	}

	public void setField(int field) {

		this.field = field;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
}
