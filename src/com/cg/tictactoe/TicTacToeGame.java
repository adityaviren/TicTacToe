package com.cg.tictactoe;

import java.util.*;

public class TicTacToeGame {
	static Scanner scanner = new Scanner(System.in);

	public static final int head = 1;
	public static final int tail = 0;
	public static enum Player {user,computer};
	/**
	 * Created board
	 */
	public static char[] createBoard() {
		char[] tictactoeboard = new char[10];
		for (int iterator = 1; iterator < tictactoeboard.length; iterator++) {
			tictactoeboard[iterator] = ' ';
		}
		return tictactoeboard;
	}

	/**
	 * Select X or O for player
	 */
	public static char selectElement() {
		System.out.println("Enter X or O as your element");
		return Character.toUpperCase(scanner.nextLine().charAt(0));
	}

	/**
	 * Show the game board
	 */
	public static void showBoard(char[] board) {
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("---------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("---------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	/**
	 * returns if index is empty
	 */
	public static boolean isEmpty(char[] board, int index) {
		return board[index] == ' ';
	}

	/**
	 * User enters move
	 */
	public static void userMove(char[] board, ArrayList<Integer> valid_positions, char player_element) {
		while (true) {
			System.out.println("Enter one of the unfilled positions");
			int index = Integer.parseInt(scanner.nextLine());
			if (valid_positions.contains(index)) {
				board[index] = player_element;
				valid_positions.remove(valid_positions.indexOf(index));
				break;
			}
		}

	}

	/**
	 * computer makes move
	 */
	public static void computerMove(char[] board, ArrayList<Integer> valid_positions, char computer_element) {
		Random random = new Random();
		int position = (int) (random.nextInt(valid_positions.size()));
		System.out.println(valid_positions.size());
		System.out.println(position);
		
		board[valid_positions.get(position)] = computer_element;
		valid_positions.remove(valid_positions.get(position));

	}

	/**
	 * toss for first move
	 */
	public static Player firstTurn() {
		Random random = new Random();
		int toss = (int) random.nextInt(2);
		return (toss == head) ? Player.user:Player.computer;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToeGame");
		char board[] = createBoard();
		char player_element = selectElement();
		char computer_element = (player_element == 'X') ? 'O' : 'X';
		System.out.println("Player element is " + player_element + " and Computer element is " + computer_element);
		showBoard(board);
		ArrayList<Integer> valid_positions = new ArrayList<Integer>();
		for (int iterator = 1; iterator <= 9; iterator++) {
			valid_positions.add(iterator);
		}
		Player player = firstTurn();
		System.out.println(player + " gets the first turn");
		for (int iterator = 1; iterator <= 9; iterator++) {
			if (player==player.user) {
				userMove(board, valid_positions, player_element);
				showBoard(board);
				System.out.println(valid_positions);
				computerMove(board, valid_positions, computer_element);
				showBoard(board);
				System.out.println(valid_positions);
			} else {
				computerMove(board, valid_positions, computer_element);
				showBoard(board);
				System.out.println(valid_positions);
				userMove(board, valid_positions, player_element);
				showBoard(board);
				System.out.println(valid_positions);
			}
		}
		scanner.close();
	}

}
