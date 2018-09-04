import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * This class solves the sudoku puzzle
 * @author Ashily Varghese
 *
 */
public class Solve {
	 Deque<Index> index_stack = new ArrayDeque<Index>();
	 Deque<String> string_stack = new ArrayDeque<String>();
/**
 * This goes through each cell and finds all the possible values a cell can have
 * @param puzzle is a 2D array of cells
 * @return the puzzle with all the possible values a cell can have
 */
	 public Cell[][] assignValues(Cell[][] puzzle){
		for(int r=0; r<9; r++){
			 for(int c=0; c<9; c++){
				 String value = puzzle[r][c].getValues();
				 // if a cell is completed, then set complete to true
				 if(value.length() == 1 && (!value.equals("0"))){
					puzzle[r][c].setComplete(true);
				 }else if(value.length() > 1 || value.equals("0")){
					puzzle[r][c].setComplete(false);
					Index[] peers = puzzle[r][c].getPeers();
					String valuesetafterelimination = puzzle[r][c].removePeerValues(puzzle, r, c, peers, null);
					puzzle[r][c].setValue(valuesetafterelimination);
					if(valuesetafterelimination.length() == 1){
						puzzle[r][c].setComplete(true);
					}
				}
			 }
		 }
		 return puzzle;
	 }
	 
/**
 * Goes through all the cells and check the value of complete(field) in Cells
 * and returns true if all cells are completed(has the right digit in the cell)
 * 
 * @param puzzle the Sudoku puzzle that has to be checked
 * @return true if the Sudoku puzzle is solved, false otherwise.
 */
	 public boolean isSolved(Cell[][] puzzle){
		 boolean solved = true;
		 for(int row=0; row<9; row++){
			 for(int col=0; col<9; col++){
				 if(!puzzle[row][col].getComplete()){
					 solved = false;
					 return solved;
				 }
			}
		}
		 return solved;
	 }
/**
 * 
 * @param puzzle the unsolved puzzle
 * @param in the index where the backtracking starts
 */
	 // This method does the backtracking algorithm and returns a solved puzzle
	 	public void backtracking(Cell[][] puzzle, Index in){
	 		for(int r=in.getRow(); r<9; r++){
	 			for(int c=in.getCol(); c<9; c++){
	 				String values = puzzle[r][c].getValues();
	 				
	 				// if there are no values to select from then call the function again
	 				if(values.length() == 0){
	 					System.out.println("null value rows and cols are " + "("+ r + "," + c+ ")");
	 					if(!index_stack.isEmpty()){
	 						Index popped_index = index_stack.pop();
	 						
	 						System.out.println("popped index is " + popped_index.getRow() + popped_index.getCol());
	 						backtracking(puzzle, popped_index);
	 					}
	 				}
	 				// if there are values to select from and the cell is not completed 
	 			if(values != null && puzzle[r][c].getComplete() == false){
	 				index_stack.push(puzzle[r][c].getIndex());
	 				System.out.println("stack contents are " + r + c);
	 				String str = Character.toString(values.charAt(0));
	 				puzzle[r][c].setValue(str);
	 				String rem_string = values.replace(values, str);
	 				string_stack.push(rem_string);
	 							
	 				// remove that value from the peers
	 				Index[] peers = puzzle[r][c].getPeers();
	 				for(int i=0; i<peers.length; i++){
	 					int row = peers[i].getRow();
	 					int col = peers[i].getCol();
	 					if(puzzle[row][col].getComplete() == false){
	 										
	 					String newvalue = puzzle[row][col].getValues().replace(str, "");
	 					System.out.println("row = " + r + "col = " + c + "k = " );
	 					System.out.println("("+ row +"," + col + ") " + puzzle[row][col].getValues() + "| Removing " + str + " Rest is " + newvalue);
	 									
	 					puzzle[row][col].setValue(newvalue);
	 					System.out.println(puzzle[row][col].getValues());
	 					System.out.println("_______________________________________________");
	 									
	 					// Adding the removed valueback after backtracking
	 					for(int a=0; a< peers.length; a++){
	 						int ro = peers[a].getRow();
	 						int cl = peers[a].getCol();
	 						if(puzzle[ro][cl].getComplete() == false && ro > r && cl > c){
	 						//use removepeervalue method
	 						}
	 											
	 					}
	 									
	 				}
	 										                                 
	 			}
	 						
	 		}
	 	}
	}
	 		
	 	
 }
}
