package com.cg.tictactoe;

public class TicTacToeGame {

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToeGame");
		char board[] =CreateBoard();
	}
	//Creating the board
	public static char[] CreateBoard() {
		char[] board = new char[10];
		for (int iterator = 1; iterator < board.length; iterator++) {
			board[iterator] = Character.MIN_VALUE;
		}
		return board;
	}
}