
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board checkMat = new Board();

		checkMat.cloneBoard(board.board);

		for (int i = 0; i < BOARD_SIZE; i++) {

			if (((checkMat.board[i].getColor() == playerColor))
					&& checkMat.board[i].isAlive()) {

				for (int y = 0; y < 8; y++) {

					for (int x = 0; x < 8; x++) {

						if (isValidPosition(x, y,
								checkMat, i)) {

							checkIsThereMat(checkMat,
									nameKing,
									enemiColor,
									playerColor, board);

							for (int k = 0; k < BOARD_SIZE; k++) {

								checkMat.board[k]
										.setAlive(board.board[k]
												.isAlive());
								checkMat.board[k]
										.setX(board.board[k]
												.getX());
								checkMat.board[k]
										.setY(board.board[k]
												.getY());

							}

						}

					}

				}

			}
		}

		System.out.println("moveAllLegalCounter:"
				+ moveAllLegalCounter);
		System.out.println("matCounter:" + matCounter);
		if (moveAllLegalCounter == matCounter) {

			// resumeGame = false;
			System.out.println(nameKing + " å â ÌÀÒ");
		}
		matCounter = 0;
		moveAllLegalCounter = 0;
	}

}
