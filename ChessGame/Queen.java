import java.awt.Color;

public class Queen extends Warrior {

	public Queen(int startX, int startY, String symbol, Color color,
			boolean isAlive, String name) {
		super(startX, startY, symbol, color, isAlive, name);

	}

	@Override
	public boolean moveIsLegal(int newX, int newY,BattleField board) {

		super.moveIsLegal(newX, newY, board);
		// X axis move
		if ((Math.abs(newX - this.getX()) <= 7)
				&& (Math.abs(newY - this.getY()) == 0)
				// Y axis move
				|| (Math.abs(newY - this.getY()) <= 7)
				&& (Math.abs(newX - this.getX()) == 0)
				// diagonal move
				|| (Math.abs(newX - this.getX()) == (Math.abs(newY
						- this.getY())))) {

			return true;
		}

		return false;
	}

}
