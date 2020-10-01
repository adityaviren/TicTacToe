package com.cg.tictactoe;

public class TicTacToeGame {

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToeGame");
		char board[] =CreateBoard();
	}
	
	/**
	 * Created board
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int iterator = 1; iterator < board.length; iterator++) {
			board[iterator] = Character.MIN_VALUE;
		}
		return board;
	}
}