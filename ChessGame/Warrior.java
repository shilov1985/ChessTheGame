import java.awt.Color;
import java.awt.Point;

public class Warrior {

	private int x, y;
	private boolean isAlive;
	private String symbol;
	private Color color;
	private String name;

	public Warrior(int startX, int startY, String symbol, Color color,
			boolean isAlive, String name) {
		super();

		this.x = startX;
		this.y = startY;
		this.symbol = symbol;
		this.color = color;
		this.isAlive = isAlive;
		this.name = name;

	}

	public Warrior() {
		super();

	}

	public void conquer(Warrior enemy) {

		this.x = enemy.getX();
		this.y = enemy.getY();

	}

	public void conquer(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public boolean moveIsLegal(int newX, int newY, BattleField board) {
		if (newX >= 0 && newY >= 0 && newX < 8 && newY < 8) {
			return true;
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
		if (isAlive == false) {
			this.x = -1;
			this.y = -1;
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
