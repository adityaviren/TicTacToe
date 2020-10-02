package com.cg.tictactoe;

import java.util.*;

public class TicTacToeGame {
	static Scanner scanner = new Scanner(System.in);

	public static final int head = 1;
	public static final int tail = 0;

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
	public static void computerMove(char[] board, ArrayList<Integer> valid_positions, char computer_element,
			char player_element) {
		boolean check = false;
		// checking if a move gets win
		for (int iterator = 0; iterator < valid_positions.size(); iterator++) {
			board[valid_positions.get(iterator)] = computer_element;
			if (isWinner(board, computer_element)) {
				valid_positions.remove(iterator);
				check = true;
				break;
			} else
				board[valid_positions.get(iterator)] = ' ';
		}
		// checking if opponent gets a winning move
		if (check == false) {
			for (int iterator = 0; iterator < valid_positions.size(); iterator++) {
				board[valid_positions.get(iterator)] = player_element;
				if (isWinner(board, player_element)) {
					board[valid_positions.get(iterator)] = computer_element;
					valid_positions.remove(iterator);
					check = true;
					break;
				} else
					board[valid_positions.get(iterator)] = ' ';
			}
		}

		Random random = new Random();
		// makes move to a random corner if available
		if (check == false) {
			ArrayList<Integer> valid_corners = new ArrayList<Integer>();
			for (int iterator = 0; iterator < valid_positions.size(); iterator++) {
				if (valid_positions.get(iterator) == 1 || valid_positions.get(iterator) == 3
						|| valid_positions.get(iterator) == 7 || valid_positions.get(iterator) == 9) {
					valid_corners.add(valid_positions.get(iterator));
				}
			}
			if (valid_corners.size() > 0) {
				int position = (int) (random.nextInt(valid_corners.size()));
				board[valid_corners.get(position)] = computer_element;
				valid_positions.remove(valid_corners.get(position));
				check = true;
			}

		}
		// takes mid slot if available
		if (check == false) {
			if (valid_positions.contains(5)) {
				board[5] = computer_element;
				valid_positions.remove(valid_positions.indexOf(5));
				check = true;
			}
		}
		// if no winning move, no opponent winning move, no available corners or mid,
		// TAKE ANY SIDES
		if (check == false) {
			System.out.println(valid_positions);
			int position = (int) (random.nextInt(valid_positions.size()));
			board[valid_positions.get(position)] = computer_element;
			valid_positions.remove(position);

		}
	}

	/**
	 * toss for first move
	 */
	public static int firstTurn() {
		Random random = new Random();
		int toss = (int) random.nextInt(2);
		return (toss == head) ? head : tail;
	}

	/**
	 * check if winner by element
	 */
	public static boolean isWinner(char[] b, char el) {
		return ((b[1] == b[2] && b[3] == b[2] && b[2] == el) || (b[4] == b[5] && b[5] == b[6] && b[5] == el)
				|| (b[7] == b[8] && b[8] == b[9] && b[8] == el) || (b[1] == b[4] && b[4] == b[7] && b[4] == el)
				|| (b[2] == b[5] && b[5] == b[8] && b[5] == el) || (b[3] == b[6] && b[6] == b[9] && b[6] == el)
				|| (b[1] == b[5] && b[5] == b[9] && b[5] == el) || (b[3] == b[5] && b[5] == b[7] && b[5] == el));
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToeGame");
		char board[] = createBoard();
		char player_element = selectElement();
		char computer_element = (player_element == 'X') ? 'O' : 'X';
		System.out.println("Player element is " + player_element + " and Computer element is " + computer_element);
		ArrayList<Integer> valid_positions = new ArrayList<Integer>();
		for (int iterator = 1; iterator <= 9; iterator++) {
			valid_positions.add(iterator);
		}
		int toss = firstTurn();
		String message = (toss == 1) ? "User" : "Computer";
		System.out.println(message + " gets the first turn");

		boolean is_winner = false, toggle;
		toggle = (toss == 1) ? true : false;
		int no_of_turns = 0;

		while (valid_positions.size() > 0 && no_of_turns < 9) {
			if (toggle) {
				userMove(board, valid_positions, player_element);
				showBoard(board);
				is_winner = isWinner(board, player_element);
				if (is_winner == true) {
					System.out.println("PLAYER WON");
					break;
				}
				no_of_turns++;
				toggle = !toggle;

			} else {
				computerMove(board, valid_positions, computer_element, player_element);
				showBoard(board);
				is_winner = isWinner(board, computer_element);
				if (is_winner == true) {
					System.out.println("COMPUTER WON");
					break;
				}
				no_of_turns++;
				toggle = !toggle;
			}
			if (no_of_turns < 9)
				System.out.println("Turn change");

		}
		if (valid_positions.size() == 0 && is_winner == false) {
			System.out.println("THE GAME TIED");
		}
		scanner.close();
	}

}
