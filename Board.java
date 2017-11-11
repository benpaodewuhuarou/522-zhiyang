package weiqi;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JPanel {

	public enum PositionState {
		EMPTY, BLACK, WHITE
	};

	private ArrayList<Draw> chess;
	
	private PositionState[][] board = new PositionState[20][20];
	
	private int grid = 40;
	
	private boolean ChessColor = false;

	public boolean getChessColor() {
		return ChessColor;
	}

	public void setChessColor(boolean ChessColor) {
		 this.ChessColor=ChessColor;
	}
	
	public int getGrid() {
		return grid;
	}

	public void setPosition(PositionState p, int x, int y) {
		board[x][y] = p;
	}

	public PositionState getPositionState(int x, int y) {
		return board[x][y];
	}

	public int transform(int a) {
		return (int)(a+0.5*grid) / grid ;
		
	}

	public void draw(Graphics g, int x, int y) {
		g.fillOval(x-getGrid()/2, y-getGrid()/2, getGrid(), getGrid());
	}

	public Board() {
		
		for(PositionState[] p:board){
			Arrays.fill(p,PositionState.EMPTY);
		}
		
		setPreferredSize(new Dimension(grid * 21, grid * 21));
		MyMouseListener ml = new MyMouseListener();
		addMouseListener(ml);
		addMouseMotionListener(ml);
	}

	public void paint(Graphics g) {
		chess = new ArrayList<>(1024);
		for (int i = grid; i < grid * 20; i +=grid) {
			g.drawLine(i, grid, i, grid * 19);
			g.drawLine(grid, i, grid * 19, i);
		}
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {
		private int x, y;
		private Draw current;

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Graphics g = getGraphics();
			x = e.getX();
			y = e.getY();
			current = new Draw(Board.this, x, y);
			current.drop(g);

		}

	}
}