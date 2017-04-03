public class AlienTehnology {
	private BattleField clonings;

	AlienTehnology() {
		clonings = new BattleField() ;
	}

	public BattleField clone(Warrior[] army) {

		Warrior[] newArmy = {
				new King(army[0].getX(), army[0].getY(), army[0].getSymbol(),
						army[0].getColor(), army[0].isAlive(), army[0]
								.getName()),
				new King(army[1].getX(), army[1].getY(), army[1].getSymbol(),
						army[1].getColor(), army[1].isAlive(), army[1]
								.getName()),
				new Pawn(army[2].getX(), army[2].getY(), army[2].getSymbol(),
						army[2].getColor(), army[2].isAlive(), army[2]
								.getName()),
				new Pawn(army[3].getX(), army[3].getY(), army[3].getSymbol(),
						army[3].getColor(), army[3].isAlive(), army[3]
								.getName()),
				new Pawn(army[4].getX(), army[4].getY(), army[4].getSymbol(),
						army[4].getColor(), army[4].isAlive(), army[4]
								.getName()),
				new Pawn(army[5].getX(), army[5].getY(), army[5].getSymbol(),
						army[5].getColor(), army[5].isAlive(), army[5]
								.getName()),
				new Pawn(army[6].getX(), army[6].getY(), army[6].getSymbol(),
						army[6].getColor(), army[6].isAlive(), army[6]
								.getName()),
				new Pawn(army[7].getX(), army[7].getY(), army[7].getSymbol(),
						army[7].getColor(), army[7].isAlive(), army[7]
								.getName()),
				new Pawn(army[8].getX(), army[8].getY(), army[8].getSymbol(),
						army[8].getColor(), army[8].isAlive(), army[8]
								.getName()),
				new Pawn(army[9].getX(), army[9].getY(), army[9].getSymbol(),
						army[9].getColor(), army[9].isAlive(), army[9]
								.getName()),
				new Rook(army[10].getX(), army[10].getY(),
						army[10].getSymbol(), army[10].getColor(), army[10]
								.isAlive(), army[10].getName()),
				new Rook(army[11].getX(), army[11].getY(),
						army[11].getSymbol(), army[11].getColor(), army[11]
								.isAlive(), army[11].getName()),

				new Ênight(army[12].getX(), army[12].getY(), army[12]
						.getSymbol(), army[12].getColor(), army[12].isAlive(),
						army[12].getName()),
				new Ênight(army[13].getX(), army[13].getY(), army[13]
						.getSymbol(), army[13].getColor(), army[13].isAlive(),
						army[13].getName()),
				new Bishop(army[14].getX(), army[14].getY(), army[14]
						.getSymbol(), army[14].getColor(), army[14].isAlive(),
						army[14].getName()),
				new Bishop(army[15].getX(), army[15].getY(), army[15]
						.getSymbol(), army[15].getColor(), army[15].isAlive(),
						army[15].getName()),
				new Queen(army[16].getX(), army[16].getY(), army[16]
						.getSymbol(), army[16].getColor(), army[16].isAlive(),
						army[16].getName()),
				// iniciate black piece
				new Pawn(army[17].getX(), army[17].getY(),
						army[17].getSymbol(), army[17].getColor(), army[17]
								.isAlive(), army[17].getName()),
				new Pawn(army[18].getX(), army[18].getY(),
						army[18].getSymbol(), army[18].getColor(), army[18]
								.isAlive(), army[18].getName()),
				new Pawn(army[19].getX(), army[19].getY(),
						army[19].getSymbol(), army[19].getColor(), army[19]
								.isAlive(), army[19].getName()),
				new Pawn(army[20].getX(), army[20].getY(),
						army[20].getSymbol(), army[20].getColor(), army[20]
								.isAlive(), army[20].getName()),
				new Pawn(army[21].getX(), army[21].getY(),
						army[21].getSymbol(), army[21].getColor(), army[21]
								.isAlive(), army[21].getName()),
				new Pawn(army[22].getX(), army[22].getY(),
						army[22].getSymbol(), army[22].getColor(), army[22]
								.isAlive(), army[22].getName()),
				new Pawn(army[23].getX(), army[23].getY(),
						army[23].getSymbol(), army[23].getColor(), army[23]
								.isAlive(), army[23].getName()),
				new Pawn(army[24].getX(), army[24].getY(),
						army[24].getSymbol(), army[24].getColor(), army[24]
								.isAlive(), army[24].getName()),
				new Rook(army[25].getX(), army[25].getY(),
						army[25].getSymbol(), army[25].getColor(), army[25]
								.isAlive(), army[25].getName()),
				new Rook(army[26].getX(), army[26].getY(),
						army[26].getSymbol(), army[26].getColor(), army[26]
								.isAlive(), army[26].getName()),
				new Ênight(army[27].getX(), army[27].getY(), army[27]
						.getSymbol(), army[27].getColor(), army[27].isAlive(),
						army[27].getName()),
				new Ênight(army[28].getX(), army[28].getY(), army[28]
						.getSymbol(), army[28].getColor(), army[28].isAlive(),
						army[28].getName()),
				new Bishop(army[29].getX(), army[29].getY(), army[29]
						.getSymbol(), army[29].getColor(), army[29].isAlive(),
						army[29].getName()),
				new Bishop(army[30].getX(), army[30].getY(), army[30]
						.getSymbol(), army[30].getColor(), army[30].isAlive(),
						army[30].getName()),

				new Queen(army[31].getX(), army[31].getY(), army[31]
						.getSymbol(), army[31].getColor(), army[31].isAlive(),
						army[31].getName()) };

		return clonings = newArmy;
	}

	public Warrior[] turnBackTime() {

		return clonings;

	}
}
