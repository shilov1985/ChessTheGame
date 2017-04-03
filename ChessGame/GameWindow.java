import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import com.sun.org.apache.bcel.internal.generic.ISUB;

public class GameWindow {
	private JLabel label;
	private JPanel panel;
	private JLayeredPane pan;
	private int fromX, fromY, toX, toY;
	private static JFrame frame;
	private static JTextArea whiteTakenFiguresField, blackTakenFiguresField,
			whiteOrBlackTurnInfoField;
	BattleField board;
	private static JToggleButton[][] buttons1;

	public GameWindow() {
		super();
		board = new BattleField();
		Game game = new Game();

		panel = new JPanel();
		panel.setLayout(null);
		whiteTakenFiguresField = new JTextArea();
		blackTakenFiguresField = new JTextArea();
		frame = new JFrame("Chess  game");
		frame.setContentPane(panel);
		frame.setLayout(null);
		frame.setSize(550, 700);
		frame.setResizable(false);
		// panel.add(infoAndResultField, 1, 0);
		panel.add(whiteTakenFiguresField, 1, 0);
		panel.add(blackTakenFiguresField, 1, 0);
		whiteTakenFiguresField.setBounds(30, 10, 480, 35);
		whiteTakenFiguresField.setBackground(new Color(255, 228, 181));
		whiteTakenFiguresField.setFont(new Font("Sanse Serif", Font.BOLD, 30));
		whiteTakenFiguresField.setEditable(false);
		blackTakenFiguresField.setBounds(30, 590, 480, 35);
		blackTakenFiguresField.setBackground(new Color(255, 228, 181));
		blackTakenFiguresField.setFont(new Font("Sanse Serif", Font.BOLD, 30));
		blackTakenFiguresField.setEditable(false);
		whiteOrBlackTurnInfoField = new JTextArea();
		whiteOrBlackTurnInfoField.setBounds(280, 630, 240, 30);
		whiteOrBlackTurnInfoField.setOpaque(true);
		whiteOrBlackTurnInfoField.setFont(new Font("Sanse Serif", Font.ITALIC,
				18));
		whiteOrBlackTurnInfoField.setEditable(false);
		whiteOrBlackTurnInfoField.setBackground(new Color(218, 165, 32));
		frame.add(whiteOrBlackTurnInfoField);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int colorCounter = 2;

		JLabel[] arrNumbers1 = new JLabel[] { new JLabel("8"), new JLabel("7"),
				new JLabel("6"), new JLabel("5"), new JLabel("4"),
				new JLabel("3"), new JLabel("2"), new JLabel("1") };

		JLabel[] arrLetters = new JLabel[] { new JLabel("A"), new JLabel("B"),
				new JLabel("C"), new JLabel("D"), new JLabel("E"),
				new JLabel("F"), new JLabel("G"), new JLabel("H") };

		buttons1 = new JToggleButton[8][8];

		for (int i = 0, boundsX = 80, boundsArrNumbers = 105; i < 8; i++, boundsX += 60, boundsArrNumbers += 60) {

			panel.add(arrNumbers1[i]);
			arrNumbers1[i].setBounds(10, boundsArrNumbers, 10, 10);
			panel.add(arrLetters[i]);
			arrLetters[i].setBounds(boundsArrNumbers - 52, 570, 10, 10);

			for (int j = 0, boundsY = 30; j < 8; j++, boundsY += 60) {
				buttons1[i][j] = new JToggleButton();

				panel.add(buttons1[i][j]);

				buttons1[i][j].setFont(new Font("Sanse Serif",
						Font.CENTER_BASELINE, 25));
				buttons1[i][j].setBounds(boundsY, boundsX, 60, 60);
				colorCounter++;
				if (colorCounter % 2 == 0) {
					buttons1[i][j].setBackground(new Color(220, 110, 58));
				} else {
					buttons1[i][j].setBackground(new Color(242, 236, 158));
				}

			}
			colorCounter--;
		}

		updateGameFrameButtonSymbols();

		boolean isGetFromXFromY = true;
		boolean isGetToXToY = false;
		int count = 0;
		fromX = -1;
		fromY = -1;
		Color colorTemp = null;

		pan.setBounds(30, 80, 60, 60);
		frame.setVisible(true);

		while (true) {

			if (isGetFromXFromY) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (buttons1[i][j].isSelected()
								&& buttons1[i][j].getIcon() != null) {

							fromX = j;
							fromY = i;
							buttons1[i][j].setSelected(false);
							isGetFromXFromY = false;
							isGetToXToY = true;
							count++;
							colorTemp = buttons1[fromY][fromX].getBackground();
							break;
						} else {
							buttons1[i][j].setSelected(false);
						}
					}
				}
			}

			if (fromX != -1 && fromY != -1) {
				buttons1[fromY][fromX].setBackground(new Color(60, 200, 120));
			}

			if (isGetToXToY) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {

						if (buttons1[i][j].isSelected()) {
							isGetToXToY = false;
							toX = j;
							toY = i;
							buttons1[i][j].setSelected(false);

						}
					}
				}
			}

			if (isGetToXToY == false && isGetFromXFromY == false) {

				game.play(fromX, fromY, toX, toY, board);

				for (int i = 0; i < 32; i++) {
					// System.out.println(board.getBoard()[i].getName()+" "+
					// board.getBoard()[i].getX()+"-"+
					// / board.getBoard()[i].getY());
				}

				updateGameFrameButtonSymbols(fromX, fromY, toX, toY, board);

				isGetFromXFromY = true;
				System.out.println("Íà ðåä ñà:"
						+ getColorName(Game.getStartColor()));
				whiteOrBlackTurnInfoField.setText("  Íà ðåä ñà:"
						+ getColorName(Game.getStartColor()));
				buttons1[fromY][fromX].setBackground(colorTemp);
				fromX = -1;
				fromY = -1;
				toX = 0;
				toY = 0;

			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public static String getColorName(Color color) {
		String col = null;
		if (color == Color.white) {
			col = "ÁÅËÈÒÅ";
		} else if (color == Color.black) {
			col = "×ÅÐÍÈÒÅ";
		}
		return col;
	}

	public void updateGameFrameButtonSymbols(int fromX, int fromY, int toX,
			int toY, BattleField board) {

		for (int t = 0; t < 32; t++) {

			if (board.army[t].getX() == toX && board.army[t].getY() == toY
					&& board.army[t].isAlive()) {

				buttons1[fromY][fromX].setIcon(null);

				label = new JLabel(new ImageIcon(board.army[t].getSymbol()));
				label.setBounds(0, 0, 60, 60);
				pan = new JLayeredPane();
				pan.setLayer(pan, 2);
				pan.setOpaque(false);

				panel.add(pan, 1);
				pan.add(label);

			}
		}
		updateGameFrameButtonSymbols();

		whiteTakenFiguresField.setText("");
		blackTakenFiguresField.setText("");

	}

	public void updateGameFrameButtonSymbols() {

		whiteTakenFiguresField.setText("");
		blackTakenFiguresField.setText("");
		for (int i = 0; i < 32; i++) {

			if (board.army[i].isAlive()) {

				buttons1[board.army[i].getY()][board.army[i].getX()]
						.setIcon(new ImageIcon(board.army[i].getSymbol()));

			} else {
				if (board.army[i].getColor() == Color.white) {
					whiteTakenFiguresField.append(board.army[i].getSymbol());
				} else {
					blackTakenFiguresField.append(board.army[i].getSymbol());
				}
			}
		}
	}

	public static void main(String[] args) {
		new GameWindow();

	}

}
