import java.util.Scanner;
/**
 * Class to test all the methods in other classes
 * @author Ashily Varghese
 *
 */
public class Test {
	static Cell[][] grid = new Cell[9][9];
	public static void main(String args[]){
		
		// Testing getPeers method
		/*Cell[][] cl = new Cell[9][9];
		for(int r=0; r<9; r++){
			for(int c=0; c<9; c++){
				Cell cells = new Cell();
				cells.setValue("0");
				cells.setIndex(r, c);
				//System.out.println(cells.getIndex().getRow() + " " + cells.getIndex().getCol());
				cl[r][c] = cells;
			}
		}
		for(int a=0; a<9; a++){
			for(int b=0; b<9; b++){
				Index[] inde = cl[a][b].getPeers();
				System.out.println("peers of (" + a + "," + b + ")");
				for(int d=0; d<20; d++){
					System.out.println("(" + inde[d].getRow() + "," + inde[d].getCol() + ")");
				}
			}
		}*/
	
		// Testing assignValues method
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
		
		Solve search = new Solve();
		for(int a=0; a<7; a++){
			search.assignValues(grid);
		}
		
		// testing TestTree class and methods
		/*if(!search.isSolved(grid))
		{
			TestTree testing = new TestTree();
			SudokuNode root = new SudokuNode();
			root.setPuzzle(grid);
			root.setParent(null);
			testing.makingTree(root);
		}*/
		
		// testing backtracking2 method
		
		
		// Printing out the puzzle
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
		if(search.isSolved(grid)){
			System.out.println("solved");
		}else
			System.out.println("not solved");
		
	}
}

