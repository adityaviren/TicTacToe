package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	static Scanner scanner= new Scanner(System.in);
	
	private static char[] board = new char[10];
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToeGame");
		char TicTacToeboard[] = createBoard();
		char player_element=selectElement();
		scanner.close();
		char computer_element = (player_element == 'X') ? 'O' : 'X';
		System.out.println("Player element is " + player_element + " and Computer element is " + computer_element);
		showBoard();
		
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
		for(int line1 = 1; line1<4 ; line1++) {
			System.out.print(board[line1]);
		}
		System.out.println();
		for(int line2 = 4; line2<7 ; line2++) {
			System.out.print(board[line2]);
		}
		System.out.println();
		for(int line3 = 7; line3<10 ; line3++) {
			System.out.print(board[line3]);
		}
		System.out.println();
	}
	
}