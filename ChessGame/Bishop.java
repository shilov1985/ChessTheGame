import java.awt.Color;

public class Bishop extends Warrior {

	public Bishop(int startX, int startY, String symbol, Color color,
			boolean isAlive, String name) {
		super(startX, startY, symbol, color, isAlive, name);
	
	}

	@Override
	public boolean moveIsLegal(int newX, int newY,BattleField board) {

		super.moveIsLegal(newX, newY,board);
		if ((Math.abs(newX - this.getX()) == (Math.abs(newY - this.getY())))) {

			return true;
		}

		return false;
	}

}
