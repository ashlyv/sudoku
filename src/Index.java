/**
 * This class implements an index(row and column) of a cell
 * @author Ashily Varghese
 *
 */
public class Index {
	private int row;
	private int column;
/**
 *  This constructs an index with a specified row 
 *  and column	
 * @param r the row of the cell
 * @param c the column of the cell
 */
	public Index(int r, int c){
		row = r;
		column = c;
	}
/**
 *  This constructs an empty index
 */
	public Index(){
		
	}

	public void setRow(int r){
		row = r;
	}
	public void setColumn(int c){
		column = c;
	}
/**
 * This returns the row of the cell
 * @return the row of the cell
 */
	public int getRow(){
		return row;
	}
	public int getCol(){
		return column;
	}
}
