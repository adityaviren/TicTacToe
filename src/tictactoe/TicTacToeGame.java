package tictactoe;

public class TicTacToeGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to TicTacToeGame");
		uc1CreateBoard();
	}
	public static void uc1CreateBoard() {
		char[] board = new char[10];
		for(int i=1;i<10;i++) {
			board[i]=Character.MIN_VALUE;
		}
	}
}