import java.awt.Color;

public class Game {

	private static Color currentColor;
	private static int enemiX, enemiY, kingX, kingY;
	private final static int BATTLE_FIELD_SIZE = 32;
	private static int chessPiecesNumberCounter;
	private BattleField battleState;
	private int moveAllLegalCounter, matCounter;

	public Game() {
		super();

		currentColor = Color.white;

	}

	public String getColorName(Color color) {
		String col = null;
		if (color == Color.white) {
			col = "БЕЛИТЕ";

		} else if (color == Color.black) {
			col = "ЧЕРНИТЕ";
		}
		return col;
	}

	public boolean pawnGetAttack(Warrior warrior, Warrior enemy) {
		boolean isKill = false;

		if (warrior.getColor() != enemy.getColor()) {

			System.out.println(warrior.getName() + " взема " + enemy.getName());

			warrior.conquer(enemy);
			enemy.setAlive(false);
			isKill = true;

		}
		return isKill;
	}

	public boolean hasLivePiece(BattleField battleField, int toX, int toY) {

		int count = 0;
		for (int j = 0; j < BATTLE_FIELD_SIZE; j++) {
			if (battleField.army[j].getX() == toX
					&& battleField.army[j].getY() == toY
					&& battleField.army[j].isAlive()) {
				count++;
			}
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}

	}



	/**
	 * This method kill the opponent figure if move is legal and colors are
	 * different.Here is special attack method for all pawns.
	 */

	public boolean doAttack(Warrior warrior, BattleField battleField,
			int enemiX, int enemiY) {
		boolean isMoved = false;
		Warrior enemy = new Warrior();

		enemy = battleField.getWarrior(battleField.army, enemiX, enemiY);

		int warriorX = warrior.getX();
		int warriorY = warrior.getY();

		// Here filter all pawns and check all other pieces
		if (!(warrior.getName().equals("ЧЕРНА ПЕШКА"))
				&& !(warrior.getName().equals("БЯЛА ПЕШКА"))) {
			System.out.println(enemy.getColor());
			if ((warrior.getColor() != enemy.getColor())) {

				warrior.conquer(enemy);
				enemy.setAlive(false);
				isMoved = true;

			}

		}
		System.out.println("--------------------------------" + isMoved);
		// This code represent takes moves of all pawns
		if ((warrior.getName().equals("БЯЛА ПЕШКА"))) {

			if (((enemiX == warriorX + 1) && (enemiY == warriorY - 1))) {
				System.out.println("Бяла пешка проверява надясно");
				isMoved = pawnGetAttack(warrior, enemy);
			} else

			if ((((enemiX == warriorX - 1) && (enemiY == warriorY - 1)))) {
				System.out.println("Бяла пешка проверява наляво");
				isMoved = pawnGetAttack(warrior, enemy);
			} else {

				if (hasLivePiece(battleField, enemiX, enemiY)) {
					isMoved = false;
					// BattleField.BattleField[pieceIndex].move(toX, toY);
				}

			}

			// /////////////////BLACK--PIECES//////////////////

		} else if ((warrior.getName().equals("ЧЕРНА ПЕШКА"))) {

			if (((enemiX == warriorX + 1) && (enemiY == warriorY + 1))) {
				System.out.println("ЧЕРНА ПЕШКА проверява надясно");
				isMoved = pawnGetAttack(warrior, enemy);
			} else

			if ((((enemiX == warriorX - 1) && (enemiY == warriorY + 1)))) {
				System.out.println("ЧЕРНА ПЕШКА проверява наляво");
				isMoved = pawnGetAttack(warrior, enemy);
			} else {
				if (hasLivePiece(battleField, enemiX, enemiY)) {
					isMoved = false;
					// BattleField.BattleField[pieceIndex].move(toX, toY);
				}
			}
		}

		return isMoved;
	}

	// //////////////color------------------------color/////////////////////////
	public void colorSwitch(Warrior warrior, Warrior[] army) {

		if (warrior.getColor() == Color.white) {
			currentColor = Color.black;
		} else {
			currentColor = Color.white;
		}
	}

	public void checkChessMat(String nameKing, Color playerColor,
			BattleField battleField) {

		Color enemiColor = null;
		if (playerColor.equals(Color.black)) {
			enemiColor = Color.white;
		} else if (playerColor.equals(Color.white)) {
			enemiColor = Color.black;
		}

		/**
		 * Here check for king position and takes coordinate to him.
		 */

		for (int pcsIndex = 0; pcsIndex < BATTLE_FIELD_SIZE; pcsIndex++) {
			if (battleField.army[pcsIndex].getName().equals(nameKing)) {
				kingX = battleField.army[pcsIndex].getX();
				kingY = battleField.army[pcsIndex].getY();

				for (int enemi = 0; enemi < BATTLE_FIELD_SIZE; enemi++) {
					if (battleField.army[enemi].isAlive()
							&& battleField.army[enemi].getColor().equals(
									enemiColor)) {

						Warrior enemy = battleField
								.getWarrior(battleField.army,
										battleField.army[enemi].getX(),
										battleField.army[enemi].getY());

						if (enemy.moveIsLegal(kingX, kingY, battleField)) {

							System.out.println("The move is legal for:"
									+ enemy.getName()

									+ " Position:" + enemy.getX() + " "
									+ enemy.getY());

							enemiY = battleField.army[enemi].getY();
							enemiX = battleField.army[enemi].getX();

							boolean isPassageFree = checkPassage(enemy, kingX,
									kingY, battleField);

							if (isPassageFree) {

								System.out.println("The free passage  for:"
										+ enemy.getName() + " Position:"
										+ enemy.getX() + " " + enemy.getY());

								System.out.println();
								System.out
										.println(battleField.army[pcsIndex]
												.getName()
												+ " е в ШАХ старт/////////старт//////////старт////////старт////"
												+ "////старт/////////старт///////////старт////////////старт////// "
												+ battleField.army[pcsIndex]
														.getName());
								chessPiecesNumberCounter++;
								// Check for MAT.Move the king to the safe
								// position

								BattleField cloneBattle = new BattleField();

								cloneBattle.clone(battleField);

								for (int pcs = 0; pcs < BATTLE_FIELD_SIZE; pcs++) {

									if (((cloneBattle.clonings[pcs].getColor() == playerColor))
											&& cloneBattle.clonings[pcs]
													.isAlive()) {

										Warrior defender = cloneBattle
												.getWarrior(
														cloneBattle.clonings,
														cloneBattle.clonings[pcs]
																.getX(),
														cloneBattle.clonings[pcs]
																.getY());

										for (int y = 0; y < 8; y++) {

											for (int x = 0; x < 8; x++) {

												evoluateBoard(defender, x, y,
														cloneBattle);

												checkIsThereMat(cloneBattle,
														nameKing, enemiColor,
														playerColor,
														battleField);

												for (int k = 0; k < BATTLE_FIELD_SIZE; k++) {

													cloneBattle.clonings[k]
															.setAlive(battleField.army[k]
																	.isAlive());
													cloneBattle.clonings[k]
															.setX(battleField.army[k]
																	.getX());
													cloneBattle.clonings[k]
															.setY(battleField.army[k]
																	.getY());

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
									System.out.println(nameKing + " е в МАТ");
								}
								matCounter = 0;
								moveAllLegalCounter = 0;

							}
						}
					}
				}
			}
		}
	}

	public void evoluateBoard(Warrior defender, int tryToX, int tryToY,
			BattleField cloneBattle) {

		if (defender.moveIsLegal(tryToX, tryToY, cloneBattle)) {

			int prediX = defender.getX();
			int prediY = defender.getY();

			if (checkPassage(defender, tryToX, tryToY, cloneBattle)) {
				boolean isMove = false;
				// takes the oponent figure
				if (hasLivePiece(cloneBattle, tryToX, tryToY)) {
					isMove = doAttack(defender, cloneBattle, tryToX, tryToY);

				} else {
					defender.conquer(tryToX, tryToY);
					isMove = true;
				}

				if (isMove) {

					moveAllLegalCounter++;

					System.out.print(defender.getName() + " Преди :");
					System.out.print(prediX);
					System.out.print(prediY);

					System.out.print("    след :");
					System.out.print(defender.getX());
					System.out.println(defender.getY());

				}
			}
		}

	}

	public void checkIsThereMat(BattleField cloneBoard, String namePiece,
			Color oponentColor, Color selfColorCheck, BattleField BattleField) {
		// ////////////////////////////////////////////////
		// Here check for chess
		// mat////////////////////////

		boolean runCheck = true;
		for (int j1 = 0; j1 < BATTLE_FIELD_SIZE; j1++) {
			if (cloneBoard.clonings[j1].getName().equals(namePiece)) {

				for (int l1 = 0; l1 < BATTLE_FIELD_SIZE; l1++) {
					if (cloneBoard.clonings[l1].isAlive()
							&& cloneBoard.clonings[l1].getColor().equals(
									oponentColor) && runCheck) {
						Warrior enemy = cloneBoard
								.getWarrior(cloneBoard.clonings,
										cloneBoard.clonings[l1].getX(),
										cloneBoard.clonings[l1].getY());

						int matDestinationX = enemy.getX();
						int matDestinationY = enemy.getY();

						if (enemy.moveIsLegal(matDestinationX, matDestinationY,
								BattleField)) {

							int matSourceY = enemy.getY();
							int matSourceX = enemy.getX();

							if (checkPassage(enemy, matDestinationX,
									matDestinationY, cloneBoard)) {
								matCounter++;

								if (currentColor == oponentColor) {

									currentColor = selfColorCheck;
									for (int k = 0; k < BATTLE_FIELD_SIZE; k++) {

										BattleField.army[k]
												.setAlive(battleState.clonings[k]
														.isAlive());
										BattleField.army[k]
												.setX(battleState.clonings[k]
														.getX());
										BattleField.army[k]
												.setY(battleState.clonings[k]
														.getY());

									}
								}

								runCheck = false;
							}

						}

					}
				}
			}

		}
	}

	/**
	 * With this method check all move situations of the pieces and return
	 * result.The method check do we have pieces at the destination coordinate
	 * where we try to move our piece.
	 * 
	 * @return
	 * 
	 */

	public boolean checkPassage(Warrior warrior,

	int destinationX, int destinationY, BattleField BattleField) {

		int sourceX = warrior.getX();
		int sourceY = warrior.getY();
		int count = 0;
		// check vertical down to up
		if ((sourceX == destinationX) && (destinationY < sourceY)) {
			for (int k = sourceY - 1; k > destinationY; k--) {

				if (hasLivePiece(BattleField, sourceX, k)) {

					count++;
				}

			}
			// check vertical up to down
		} else if ((sourceX == destinationX) && (destinationY > sourceY)) {
			for (int k = sourceY + 1; k < destinationY; k++) {
				if (hasLivePiece(BattleField, sourceX, k)) {

					count++;
				}

			}
		} else

		// check horizontal left to right
		if ((sourceY == destinationY) && (destinationX > sourceX)) {
			for (int k = sourceX + 1; k < destinationX; k++) {
				if (hasLivePiece(BattleField, k, sourceY)) {

					count++;
				}

			}
		} else

		// check horizontal right to left
		if ((sourceY == destinationY) && (destinationX < sourceX)) {
			for (int k = sourceX - 1; k > destinationX; k--) {
				if (hasLivePiece(BattleField, k, sourceY)) {

					count++;
				}

			}
		} else

		// **********HERE CHECK ALL DIAGONALS**********//

		// check up and left
		if ((sourceY > destinationY) && (destinationX < sourceX)) {
			for (int k = sourceX - 1, k2 = sourceY - 1; k > destinationX
					&& k2 > destinationY; k--, k2--) {
				if (hasLivePiece(BattleField, k, k2)) {

					count++;
				}
			}
		} else

		// check up and right
		if ((sourceY > destinationY) && (destinationX > sourceX)) {
			for (int k = sourceX + 1, k2 = sourceY - 1; k < destinationX
					&& k2 > destinationY; k++, k2--) {
				if (hasLivePiece(BattleField, k, k2)) {

					count++;
				}

			}
		} else

		// check down and left
		if ((sourceY < destinationY) && (destinationX < sourceX)) {
			for (int k = sourceX - 1, k2 = sourceY + 1; k > destinationX
					&& k2 < destinationY; k--, k2++) {
				if (hasLivePiece(BattleField, k, k2)) {

					count++;
				}

			}
		} else

		// check down and right
		if ((sourceY < destinationY) && (destinationX > sourceX)) {
			for (int k = sourceX + 1, k2 = sourceY + 1; k < destinationX
					&& k2 < destinationY; k++, k2++) {
				if (hasLivePiece(BattleField, k, k2)) {

					count++;
				}

			}
		}

		return count == 0;

	}

	/**
	 * Here check do we have piece at destination coordinate of the piece we
	 * want to move and return result
	 */

	public boolean checkFreePassage(int valueX, int valueY,
			Warrior[] BattleField) {
		boolean isFreePassage = true;
		int couterPos = 0;
		for (int j = 0; j < BATTLE_FIELD_SIZE; j++) {
			// Here we proceed with
			// searching...
			if ((BattleField[j].getX() == valueX)
					&& (BattleField[j].getY() == valueY)
					&& BattleField[j].isAlive()) {
				couterPos++;
				System.out.println("There is live piece on: "
						+ BattleField[j].getX() + " " + BattleField[j].getY());
				isFreePassage = false;
				break;
			}

		}
		System.out.println(couterPos);
		System.out.println(valueY);
		return isFreePassage;
	}

	public void play(int fromX, int fromY, int toX, int toY,
			BattleField battleField) {

		/**
		 * Here get the states of the BattleField.That need for the method which
		 * check a chess-mat situation on the BattleField.If some king is chess
		 * can move only the piece which can protect the king,and if we move
		 * another piece, the battleField will return to this states here. In
		 * mat is the same ,but we cant't move pieces any more and the
		 * battleField just freeze in this moment.
		 */

		battleState = new BattleField();
		battleState.clone(battleField);

	

			

				Warrior warrior = battleField.getWarrior(battleField.army,
						fromX, fromY);

				if (warrior.getColor() == currentColor) {

					if (warrior.moveIsLegal(toX, toY, battleField)) {

						boolean isMove = false;

						boolean isPassageFree = checkPassage(warrior, toX, toY,
								battleField);

						if (isPassageFree) {

							/**
							 * Here check do we have piece to attack.
							 */
							if (hasLivePiece(battleField, toX, toY)) {
								isMove = doAttack(warrior, battleField, toX,
										toY);
								/**
								 * If there is not piece to attack,just move.
								 */

							} else {
								warrior.conquer(toX, toY);
								isMove = true;
							}

							System.out.println(warrior.getName()
									+ "  is moved!");

							if (isMove) {

								// Here switch the color.Not possible one color
								// play
								// two
								// times!
								colorSwitch(warrior, battleField.army);

								// here check for white king chess and mat
								checkChessMat("БЯЛ ЦАР", Color.white,
										battleField);

								// here check for black king chess and mat
								checkChessMat("ЧЕРЕН ЦАР", Color.black,
										battleField);

							}
						}
					}
				}
			

		
	}

	public static Color getStartColor() {
		return currentColor;
	}

}
