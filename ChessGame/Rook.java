import java.awt.Color;

public class Rook extends Warrior {

	public Rook(int startX, int startY, String symbol, Color color,
			boolean isAlive, String name) {
		super(startX, startY, symbol, color, isAlive, name);

	}

	@Override
	public boolean moveIsLegal(int newX, int newY,BattleField board) {

		super.moveIsLegal(newX, newY, board);
		if ((Math.abs(newX - this.getX()) <= 7)
				&& (Math.abs(newY - this.getY()) == 0)
				|| (Math.abs(newY - this.getY()) <= 7)
				&& (Math.abs(newX - this.getX()) == 0)) {

			return true;
		}

		return false;
	}

}
