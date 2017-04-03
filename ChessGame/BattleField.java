import java.awt.Color;

public class BattleField extends Warrior {
	Warrior[] army;
	Warrior[] clonings;

	BattleField() {
		this.army = new Warrior[32];
		this.army = gatherWarriors();
	}

	public Warrior[] gatherWarriors() {
		Warrior[] allWarriors = {
				new King(3, 0, "blackking.png", Color.black, true, "◊≈–≈Õ ÷¿–"),
				new King(3, 7, "whiteking.png", Color.white, true, "¡ﬂÀ ÷¿–"),
				new Pawn(0, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Pawn(1, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Pawn(2, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Pawn(3, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Pawn(4, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Pawn(5, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Pawn(6, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Pawn(7, 6, "whitepawn.png", Color.white, true, "¡ﬂÀ¿ œ≈ÿ ¿"),
				new Rook(0, 7, "whiterook.png", Color.white, true, "¡ﬂÀ “Œœ"),
				new Rook(7, 7, "whiterook.png", Color.white, true, "¡ﬂÀ “Œœ"),
				new  night(1, 7, "whiteknight.png", Color.white, true,
						"¡ﬂÀ  ŒÕ"),
				new  night(6, 7, "whiteknight.png", Color.white, true,
						"¡ﬂÀ  ŒÕ"),
				new Bishop(2, 7, "whitebishop.png", Color.white, true,
						"¡ﬂÀ Œ‘»÷≈–"),
				new Bishop(5, 7, "whitebishop.png", Color.white, true,
						"¡ﬂÀ Œ‘»÷≈–"),
				new Queen(4, 7, "whitequeen.png", Color.white, true,
						"¡ﬂÀ¿ ÷¿–»÷¿"),
				// iniciate black piece
				new Pawn(0, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Pawn(1, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Pawn(2, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Pawn(3, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Pawn(4, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Pawn(5, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Pawn(6, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Pawn(7, 1, "blackpawn.png", Color.black, true,
						"◊≈–Õ¿ œ≈ÿ ¿"),
				new Rook(0, 0, "blackrook.png", Color.black, true, "◊≈–≈Õ “Œœ"),
				new Rook(7, 0, "blackrook.png", Color.black, true, "◊≈–≈Õ “Œœ"),
				new  night(1, 0, "darkknight.png", Color.black, true,
						"◊≈–≈Õ  ŒÕ"),
				new  night(6, 0, "darkknight.png", Color.black, true,
						"◊≈–≈Õ  ŒÕ"),
				new Bishop(2, 0, "blackbishop.png", Color.black, true,
						"◊≈–≈Õ Œ‘»÷≈–"),
				new Bishop(5, 0, "blackbishop.png", Color.black, true,
						"◊≈–≈Õ Œ‘»÷≈–"),
				new Queen(4, 0, "blackqueen.png", Color.black, true,
						"◊≈–Õ¿ ÷¿–»÷¿") };
		return allWarriors;

	}

	public BattleField clone(BattleField battle) {
		BattleField cloneBattle = new BattleField();
		Warrior[] newWarriors = {
				new King(battle.army[0].getX(), battle.army[0].getY(),
						battle.army[0].getSymbol(), battle.army[0].getColor(),
						battle.army[0].isAlive(), battle.army[0].getName()),
				new King(battle.army[1].getX(), battle.army[1].getY(),
						battle.army[1].getSymbol(), battle.army[1].getColor(),
						battle.army[1].isAlive(), battle.army[1].getName()),
				new Pawn(battle.army[2].getX(), battle.army[2].getY(),
						battle.army[2].getSymbol(), battle.army[2].getColor(),
						battle.army[2].isAlive(), battle.army[2].getName()),
				new Pawn(battle.army[3].getX(), battle.army[3].getY(),
						battle.army[3].getSymbol(), battle.army[3].getColor(),
						battle.army[3].isAlive(), battle.army[3].getName()),
				new Pawn(battle.army[4].getX(), battle.army[4].getY(),
						battle.army[4].getSymbol(), battle.army[4].getColor(),
						battle.army[4].isAlive(), battle.army[4].getName()),
				new Pawn(battle.army[5].getX(), battle.army[5].getY(),
						battle.army[5].getSymbol(), battle.army[5].getColor(),
						battle.army[5].isAlive(), battle.army[5].getName()),
				new Pawn(battle.army[6].getX(), battle.army[6].getY(),
						battle.army[6].getSymbol(), battle.army[6].getColor(),
						battle.army[6].isAlive(), battle.army[6].getName()),
				new Pawn(battle.army[7].getX(), battle.army[7].getY(),
						battle.army[7].getSymbol(), battle.army[7].getColor(),
						battle.army[7].isAlive(), battle.army[7].getName()),
				new Pawn(battle.army[8].getX(), battle.army[8].getY(),
						battle.army[8].getSymbol(), battle.army[8].getColor(),
						battle.army[8].isAlive(), battle.army[8].getName()),
				new Pawn(battle.army[9].getX(), battle.army[9].getY(),
						battle.army[9].getSymbol(), battle.army[9].getColor(),
						battle.army[9].isAlive(), battle.army[9].getName()),
				new Rook(battle.army[10].getX(), battle.army[10].getY(),
						battle.army[10].getSymbol(),
						battle.army[10].getColor(), battle.army[10].isAlive(),
						battle.army[10].getName()),
				new Rook(battle.army[11].getX(), battle.army[11].getY(),
						battle.army[11].getSymbol(),
						battle.army[11].getColor(), battle.army[11].isAlive(),
						battle.army[11].getName()),

				new  night(battle.army[12].getX(), battle.army[12].getY(),
						battle.army[12].getSymbol(),
						battle.army[12].getColor(), battle.army[12].isAlive(),
						battle.army[12].getName()),
				new  night(battle.army[13].getX(), battle.army[13].getY(),
						battle.army[13].getSymbol(),
						battle.army[13].getColor(), battle.army[13].isAlive(),
						battle.army[13].getName()),
				new Bishop(battle.army[14].getX(), battle.army[14].getY(),
						battle.army[14].getSymbol(),
						battle.army[14].getColor(), battle.army[14].isAlive(),
						battle.army[14].getName()),
				new Bishop(battle.army[15].getX(), battle.army[15].getY(),
						battle.army[15].getSymbol(),
						battle.army[15].getColor(), battle.army[15].isAlive(),
						battle.army[15].getName()),
				new Queen(battle.army[16].getX(), battle.army[16].getY(),
						battle.army[16].getSymbol(),
						battle.army[16].getColor(), battle.army[16].isAlive(),
						battle.army[16].getName()),
				// iniciate black piece
				new Pawn(battle.army[17].getX(), battle.army[17].getY(),
						battle.army[17].getSymbol(),
						battle.army[17].getColor(), battle.army[17].isAlive(),
						battle.army[17].getName()),
				new Pawn(battle.army[18].getX(), battle.army[18].getY(),
						battle.army[18].getSymbol(),
						battle.army[18].getColor(), battle.army[18].isAlive(),
						battle.army[18].getName()),
				new Pawn(battle.army[19].getX(), battle.army[19].getY(),
						battle.army[19].getSymbol(),
						battle.army[19].getColor(), battle.army[19].isAlive(),
						battle.army[19].getName()),
				new Pawn(battle.army[20].getX(), battle.army[20].getY(),
						battle.army[20].getSymbol(),
						battle.army[20].getColor(), battle.army[20].isAlive(),
						battle.army[20].getName()),
				new Pawn(battle.army[21].getX(), battle.army[21].getY(),
						battle.army[21].getSymbol(),
						battle.army[21].getColor(), battle.army[21].isAlive(),
						battle.army[21].getName()),
				new Pawn(battle.army[22].getX(), battle.army[22].getY(),
						battle.army[22].getSymbol(),
						battle.army[22].getColor(), battle.army[22].isAlive(),
						battle.army[22].getName()),
				new Pawn(battle.army[23].getX(), battle.army[23].getY(),
						battle.army[23].getSymbol(),
						battle.army[23].getColor(), battle.army[23].isAlive(),
						battle.army[23].getName()),
				new Pawn(battle.army[24].getX(), battle.army[24].getY(),
						battle.army[24].getSymbol(),
						battle.army[24].getColor(), battle.army[24].isAlive(),
						battle.army[24].getName()),
				new Rook(battle.army[25].getX(), battle.army[25].getY(),
						battle.army[25].getSymbol(),
						battle.army[25].getColor(), battle.army[25].isAlive(),
						battle.army[25].getName()),
				new Rook(battle.army[26].getX(), battle.army[26].getY(),
						battle.army[26].getSymbol(),
						battle.army[26].getColor(), battle.army[26].isAlive(),
						battle.army[26].getName()),
				new  night(battle.army[27].getX(), battle.army[27].getY(),
						battle.army[27].getSymbol(),
						battle.army[27].getColor(), battle.army[27].isAlive(),
						battle.army[27].getName()),
				new  night(battle.army[28].getX(), battle.army[28].getY(),
						battle.army[28].getSymbol(),
						battle.army[28].getColor(), battle.army[28].isAlive(),
						battle.army[28].getName()),
				new Bishop(battle.army[29].getX(), battle.army[29].getY(),
						battle.army[29].getSymbol(),
						battle.army[29].getColor(), battle.army[29].isAlive(),
						battle.army[29].getName()),
				new Bishop(battle.army[30].getX(), battle.army[30].getY(),
						battle.army[30].getSymbol(),
						battle.army[30].getColor(), battle.army[30].isAlive(),
						battle.army[30].getName()),

				new Queen(battle.army[31].getX(), battle.army[31].getY(),
						battle.army[31].getSymbol(),
						battle.army[31].getColor(), battle.army[31].isAlive(),
						battle.army[31].getName()) };
		
		clonings = newWarriors;
		return cloneBattle;
	}

	public Warrior getWarrior(Warrior[] army, int x, int y) {

		for (int w = 0; w < army.length; w++) {
			if (army[w].getX() == x && army[w].getY() == y && army[w].isAlive()) {
				return army[w];
			}
		}
		return null;
	}

	public boolean hasLiveWarrior(BattleField arena, int toX, int toY) {

		int aliveWarrior = 0;
		for (int w = 0; w < 32; w++) {
			if (arena.army[w].getX() == toX && arena.army[w].getY() == toY
					&& arena.army[w].isAlive()) {
				aliveWarrior++;
			}
		}

		if (aliveWarrior == 0) {
			return false;
		} else {
			return true;
		}

	}

}
