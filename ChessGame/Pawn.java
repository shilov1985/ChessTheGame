import java.awt.Color;

public class Pawn extends Warrior {

	private boolean isMovedOnce;
	private int firstMoveCounter;

	public Pawn(int startX, int startY, String symbol, Color color,
			boolean isAlive, String name) {
		super(startX, startY, symbol, color, isAlive, name);

		this.isMovedOnce = false;

	}

	@Override
	public boolean moveIsLegal(int newX, int newY, BattleField board) {

		super.moveIsLegal(newX, newY, board);

		boolean hasPiece = board.hasLiveWarrior(board, newX, newY);

		//
		boolean isForbiddenWhite = ((this.getY() - 2 == newY) && ((this.getX() == newX + 1) || (this
				.getX() == newX - 1)));
		boolean isForbiddenBlack = ((this.getY() + 2 == newY) && ((this.getX() == newX + 1) || (this
				.getX() == newX - 1)));

		if ((this.getColor() == Color.white) && (newY < this.getY())) {
			if (this.getY() == 6) {
				firstMoveCounter = 2;
			} else {
				firstMoveCounter = 1;
			}

			if (((Math.abs(newX - this.getX()) == 0) || (Math.abs(newX
					- this.getX()) == 1 && hasPiece))
					&& (Math.abs(newY - this.getY()) <= firstMoveCounter)
					&& !isForbiddenWhite) {

				this.setMovedOnce(true);
				return true;
			}
		} else if ((this.getColor() == Color.black) && (newY > this.getY())) {

			if (this.getY() == 1) {
				firstMoveCounter = 2;
			} else {
				firstMoveCounter = 1;
			}
			if (((Math.abs(newX - this.getX()) == 0) || (Math.abs(newX
					- this.getX()) == 1)
					&& hasPiece)
					&& (Math.abs(newY - this.getY()) <= firstMoveCounter)
					&& !isForbiddenBlack) {
				this.setMovedOnce(true);
				return true;
			}
		}

		return false;
	}

	public void setMovedOnce(boolean isMovedOnce) {
		this.isMovedOnce = isMovedOnce;
	}

}
