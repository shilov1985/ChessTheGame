import java.awt.Color;

public class King extends Warrior {

	public King(int startX, int startY, String symbol, Color color,
			boolean isAlive, String name) {
		super(startX, startY, symbol, color, isAlive, name);

	}

	@Override
	public boolean moveIsLegal(int newX, int newY,BattleField board) {

		super.moveIsLegal(newX, newY, board);
		if (((Math.abs(newX - this.getX()) == 1) && (Math.abs(newY
				- this.getY())) == 0)
				|| ((Math.abs(newY - this.getY()) == 1) && (Math.abs(newX
						- this.getX())) == 0)
				|| ((Math.abs(newX - this.getX()) == 1) && (Math.abs(newY
						- this.getY()) == 1))) {

			return true;
		}

		return false;
	}

}
