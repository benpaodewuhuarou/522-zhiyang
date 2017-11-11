package weiqi;

import java.awt.*;

import weiqi.Board.PositionState;
import weiqi.Board.*;

public class Draw {
	private int x, y;
	private int grid;
	private Board ba;

	public Draw(Board ba, int x, int y) {
		this.ba = ba;
		grid = ba.getGrid();
		this.x = ba.transform(x);
		this.y = ba.transform(y);
		System.out.println(x);
		System.out.println(this.x);
	}

	public void drop(Graphics g) {
		if (ba.getPositionState(x, y) == PositionState.EMPTY) {
			if (ba.getChessColor() == true) {
				g.setColor(Color.BLACK);
				ba.draw(g, x * grid , grid * y);
				ba.setPosition(PositionState.BLACK, x, y);
				ba.setChessColor(false);
			} else if (ba.getChessColor() == false) {
				g.setColor(Color.WHITE);
				ba.draw(g, x * grid , grid * y);
				ba.setPosition(PositionState.WHITE, x, y);
				ba.setChessColor(true);
			}
		}
	}

}

