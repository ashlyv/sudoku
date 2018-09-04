import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Main class gets the inuput from the user, has a 2D Cell array that stores
 * the user input.
 * @author ashley
 *
 */
public class Main{
	
	static Cell[][] grid = new Cell[9][9];
	public static void main(String args[]){
		
		System.out.println("Enter the numbers by space between the rows");
		System.out.println("Enter zeros for open cells");
		
		Scanner sc = new Scanner(System.in);
		String values = sc.nextLine();
		String[] parts = values.split(" "); 
		
		for(int row=0; row<9; row++){
			String str = parts[row];
			for(int col=0; col<9; col++){
				char ch = str.charAt(col);
				String s = Character.toString(ch);
				Cell c = new Cell();
				c.setValue(s);
				c.setIndex(row, col);
				grid[row][col] = c;
			}
		}
		
		//Calling assignValues() method 
		// to solve easy puzzles
		Solve test_puzzle = new Solve();
		for(int i=0; i< 7; i++){
			test_puzzle.assignValues(grid);
		}
		
		
		//first index is (0,0)
		Index in = new Index();
		in.setRow(0);
		in.setColumn(0);
		test_puzzle.backtracking(grid, in);
		
		for(int r=0; r<9; r++){
			for(int c=0; c<9; c++){
				if(c==0){
					System.out.println();
				 }
				
				System.out.print(grid[r][c].getValues());
				if(grid[r][c].getComplete() == true){
					System.out.print("t");
				}else
					System.out.print("f");
				int l = grid[r][c].getValues().length();
				for(int g=0; g<(8-l); g++){
					System.out.print(" ");
				}
				
				if(c%3 == 2){
					System.out.print("| ");
				}
			}
		}
		
		// if the puzzle is solved then print out solved
		if(test_puzzle.isSolved(grid)){
			System.out.println("solved");
		}else
			System.out.println("not solved");
		
	}
}
