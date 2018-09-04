import java.util.ArrayList;
/**
 * This class implements a cell
 * @author Ashily Varghese
 *
 */
public class Cell {
	// Value has all the numbers a cell can have
	private String value;
	// Index has the row and column of the cell
	private Index index;
	private boolean complete;



	public void setValue(String v){
		value = v;
	}
/**
 * This sets the row and column of the cell
 * @param r the row of the cell
 * @param c the column of the cell
 */
	public void setIndex(int r, int c){
		index = new Index();
		index.setRow(r);
		index.setColumn(c);
	}
	
/**
 * This sets complete to true of it is solved	
 * @param b 
 */
	public void setComplete(boolean c){
		complete = c;
	}
	
	public boolean getComplete(){
		return complete;
	}
/**
 * 	This returns the values the cell can have
 * @returns a string that has the all the possible values of the cell
 */
	public String getValues(){
		return value;
	}
/**
 * This returns the index of the cell		
 * @return the index of the cell
 */
	public Index getIndex(){
		if(index != null){
			return index;
		}
		else return null;
	}
	
	
/**
 * This returns an index array with all the peer indices.
 * @return an Index array that has the indices 
 * of the peers of a cell
 */
	public Index[] getPeers(){
		Index[] peers = new Index[20];
		int row = this.getIndex().getRow();
		int col = this.getIndex().getCol();
		
		// gets the indices of peers in the same row
		int arrayIndex = 0;
		for(int c=0; c<9; c++){
			if(c != col){
				Index p = new Index();
				p.setRow(row);
				p.setColumn(c);
				peers[arrayIndex] = p;
				arrayIndex++;
			}
		}
		
		// gets the indices of peers in the same column
		for(int r=0; r<9; r++){
			if(r != row){
				Index p = new Index();
				p.setRow(r);
				p.setColumn(col);
				peers[arrayIndex] = p;
				arrayIndex++;
			}
		}
		
		// gets the indices of the peers in the same 3 X 3 box
		int modRow = row % 3;
		int modCol = col % 3;
		
		if(modRow == 0){
			if(modCol == 0){
				//
				Index p1 = new Index();
				p1.setRow(row+1);
				p1.setColumn(col+1);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row+1);
				p2.setColumn(col+2);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row+2);
				p3.setColumn(col+1);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row+2);
				p4.setColumn(col+2);
				peers[19] = p4;
			}else if(modCol == 1){
				Index p1 = new Index();
				p1.setRow(row+1);
				p1.setColumn(col-1);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row+1);
				p2.setColumn(col+1);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row+2);
				p3.setColumn(col-1);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row+2);
				p4.setColumn(col+1);
				peers[19] = p4;
			}else if(modCol == 2){
				Index p1 = new Index();
				p1.setRow(row+1);
				p1.setColumn(col-2);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row+1);
				p2.setColumn(col-1);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row+2);
				p3.setColumn(col-2);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row+2);
				p4.setColumn(col-1);
				peers[19] = p4;
			}
		}
		else if(modRow == 1){
			if(modCol == 0){
				Index p1 = new Index();
				p1.setRow(row-1);
				p1.setColumn(col+1);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row-1);
				p2.setColumn(col+2);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row+1);
				p3.setColumn(col+1);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row+1);
				p4.setColumn(col+2);
				peers[19] = p4;
				
			}else if(modCol == 1){
				Index p1 = new Index();
				p1.setRow(row-1);
				p1.setColumn(col-1);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row-1);
				p2.setColumn(col+1);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row+1);
				p3.setColumn(col-1);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row+1);
				p4.setColumn(col+1);
				peers[19] = p4;
				
			}else if(modCol == 2){
				Index p1 = new Index();
				p1.setRow(row-1);
				p1.setColumn(col-2);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row-1);
				p2.setColumn(col-1);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row+1);
				p3.setColumn(col-2);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row+1);
				p4.setColumn(col-1);
				peers[19] = p4;
			}
		}
		else if(modRow == 2){
			if(modCol == 0){
				Index p1 = new Index();
				p1.setRow(row-2);
				p1.setColumn(col+1);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row-2);
				p2.setColumn(col+2);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row-1);
				p3.setColumn(col+1);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row-1);
				p4.setColumn(col+2);
				peers[19] = p4;
				
			}else if(modCol == 1){
				Index p1 = new Index();
				p1.setRow(row-2);
				p1.setColumn(col-1);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row-2);
				p2.setColumn(col+1);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row-1);
				p3.setColumn(col-1);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row-1);
				p4.setColumn(col+1);
				peers[19] = p4;
			}else if(modCol == 2){
				Index p1 = new Index();
				p1.setRow(row-2);
				p1.setColumn(col-2);
				peers[16] = p1;
				Index p2 = new Index();
				p2.setRow(row-2);
				p2.setColumn(col-1);
				peers[17] = p2;
				Index p3 = new Index();
				p3.setRow(row-1);
				p3.setColumn(col-2);
				peers[18] = p3;
				Index p4 = new Index();
				p4.setRow(row-1);
				p4.setColumn(col-1);
				peers[19] = p4;
			}
		}
		return peers;
	}
/**
 * Removes that values from peer Cells
 * @param puzzle the puzzle
 * @param peers an array with indcies of all the peers
 * @param row the row of the cell
 * @param col the column of the cell
 * @return the string after eliminating the values
 */
	public String removePeerValues(Cell[][] puzzle, int row, int col, Index[] peers, String initialSet){
		
		if(initialSet == null){
			initialSet = "123456789";
		}
		for(int i=0; i<20; i++){
			int r = peers[i].getRow();
			int c = peers[i].getCol();
			String peerValue =  puzzle[r][c].getValues();
			if(puzzle[r][c].getComplete() == true){
				initialSet = initialSet.replace(peerValue, "");
			}
		}
		return initialSet;
		
	}
	
}
