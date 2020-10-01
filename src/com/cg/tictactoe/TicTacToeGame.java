package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToeGame");
		char board[] = createBoard();
		char player_element=selectElement();
		char computer_element;
		if(player_element=='X')
			computer_element='O';
		else
			computer_element='X';
		System.out.println("Player element is " + player_element + " and Computer element is " + computer_element);
		
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

	/**
	 * Select X or O for player
	 */
	public static char selectElement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter X or O as your element");
		char element = (sc.nextLine()).charAt(0);
		element=Character.toUpperCase(element);
		System.out.println(element);
		sc.close();
		return element;
	}
}