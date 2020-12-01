/*
 * Erstellt am 19.11.2020
 * 
 * Author: Viktor Engelowsi
 */

package ve.ttt;

import java.util.Scanner;


public class Game {
	
	private static char[] tic = new char[9];
	private char player = 'O';
	private boolean won = false;
	private boolean full = false;
	
	Scanner in = new Scanner(System.in);
	
	
	public Game() {
		createField();
		
		while(!won && !full) {
			
			turn();
			changePlayer();
		}
		
		
		System.out.println("\n\nGame over!");
	}
	
	
	private void turn() {
		
		if(!checkWon().equals("")) {
			
			won = true;
			printField();
			System.out.println(checkWon());
			return;
		}
		
		if(checkFull()) {
			
			printField();
			return;
		}
		
		else {
		
			printField();
			System.out.println("\n\nPlayer " + player +" position: ");
			
			int i = Integer.parseInt(in.nextLine()) - 1;
			
			if(tic[i] == '.') tic[i] = player;
			
			else{
				
				System.out.println("\nInvalid move!");
				turn();
			}
		}
	}
	
	
	private String checkWon() {
		
		if(tic[0] == 'O' && tic[1] == 'O' && tic[2] == 'O') return "O won!";
		if(tic[0] == 'X' && tic[1] == 'X' && tic[2] == 'X') return "X won!";
		
		if(tic[3] == 'O' && tic[4] == 'O' && tic[5] == 'O') return "O won!";
		if(tic[3] == 'X' && tic[4] == 'X' && tic[5] == 'X') return "X won!";
		
		if(tic[6] == 'O' && tic[7] == 'O' && tic[8] == 'O') return "O won!";
		if(tic[6] == 'X' && tic[7] == 'X' && tic[8] == 'X') return "X won!";
		
		if(tic[0] == 'O' && tic[4] == 'O' && tic[8] == 'O') return "O won!";
		if(tic[0] == 'X' && tic[4] == 'X' && tic[8] == 'X') return "X won!";
		
		if(tic[2] == 'O' && tic[4] == 'O' && tic[6] == 'O') return "O won!";
		if(tic[2] == 'X' && tic[4] == 'X' && tic[6] == 'X') return "X won!";
		
		return "";
	}
	
	
	private boolean checkFull() {
		
		full = true;
		
		for(char i : tic) {
			
			if(i == '.') {
					
				full = false;
				break;
			}
			
			else {
				
				full = true;
			}
		}
		
		return full;
	}
	
	
	private void changePlayer() {
		
		if(player == 'O') player = 'X';
		else player = 'O';
	}
	
	
	private void createField() {
		
		for(int i = 0; i < tic.length; i++) {
			tic[i] = '.';
		}
	}
	
	
	private void printField() {
		
		for(int i = 0; i < tic.length; i++) {
			
			if(i%3 == 0) System.out.println("");
			
			System.out.print(tic[i]);
		}
	}
	

	public static void main(String[] args) {
		
		new Game();
	}
}
