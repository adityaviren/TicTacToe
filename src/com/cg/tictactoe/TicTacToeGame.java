package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner scanner = new Scanner(System.in);

	private static char[] board = new char[10];

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToeGame");
		char TicTacToeboard[] = createBoard();
		char player_element = selectElement();
		char computer_element = (player_element == 'X') ? 'O' : 'X';
		System.out.println("Player element is " + player_element + " and Computer element is " + computer_element);
		showBoard();
		boolean loop = true;
		int index;
		while (loop) {
			System.out.println("enter the index where you want to place marker");
			index = Integer.parseInt(scanner.nextLine());
			boolean check = isEmpty(index);
			if (check == false)
				System.out.println("position not empty");
			else {
				board[index] = player_element;
				System.out.println("position filled");
				loop = false;
			}
		}
		showBoard();
		scanner.close();

	}

	/**
	 * Created board
	 */
	public static char[] createBoard() {

		for (int iterator = 1; iterator < board.length; iterator++) {
			board[iterator] = Character.MIN_VALUE;
		}
		return board;
	}

	/**
	 * Select X or O for player
	 */
	public static char selectElement() {
		System.out.println("Enter X or O as your element");
		return Character.toUpperCase(scanner.nextLine().charAt(0));
	}

	public static void showBoard() {
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("---------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("---------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	public static boolean isEmpty(int index) {
		if (board[index] == ' ')
			return false;
		else
			return true;
	}

}