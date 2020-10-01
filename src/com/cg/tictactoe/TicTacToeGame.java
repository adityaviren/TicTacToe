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
		board[userMove()]=player_element;
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

	/**
	 * Show the game board
	 */
	public static void showBoard() {
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("---------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("---------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	/**
	 * returns if index is empty
	 */
	public static boolean isEmpty(int index) {
		return board[index] != ' ';
	}
	
	/**
	 * User enters move
	 */
	public static int userMove() {
		boolean loop = true;
		int index=0;
		while (loop) {
			System.out.println("Enter the index where you want to place marker");
			index = Integer.parseInt(scanner.nextLine());
			if (index >0 && index<10) {
			boolean check = isEmpty(index);
			if (check == false)
				System.out.println("position not empty");
			else {
				System.out.println("position filled");
				loop = false;
			}
			}
			else 
				System.out.println("Enter valid index from 1 to 9");
		}
		return index;
	}

}