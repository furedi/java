/**
 * Make a list from a matrix in spiral order.
 * 
 * @author John
 * @version 0.2
 * @date 2017.06.25
 */
// package spiral;

import java.util.LinkedList;

public class SpiralWay {
	private int maxRow;		// Upper row border
	private int maxColumn;	// Upper column border
	private int minRow;		// Lower row border
	private int minColumn;	// Lower column border
	private int row;		// Actual row
	private int column;		// Actual column	
	private char way;		// Actual way: [L]eft, [B]ottom, [R]ight, [T]op 
	
	SpiralWay(){			// Constructor
		this.setDefault();
	}
	
	private void setDefault(){
		this.maxRow=0;
		this.maxColumn=0;		
		this.minRow=0;
		this.minColumn=0;		
		this.row=minRow;
		this.column=minColumn;
		this.way='L';
	}

	public LinkedList<Integer> getSpiralList(int[][] matrix){
		this.setDefault();
		this.maxRow=matrix.length;
		this.maxColumn=matrix[0].length;
		
		// --- Store elements in spiral order!
		LinkedList<Integer> spiralList = new LinkedList<Integer>();
		
		while(spiralList.size()<matrix.length*matrix[0].length){
			// --- Collect the spiral sequence!
			spiralList.add(matrix[this.row][this.column]);
			this.next();
		}
		return spiralList;
	}	
	
	private void next(){
		switch (way) {
		case 'L':
			stepLeft();
			break;
		case 'B':
			stepBottom();
			break;
		case 'R':
			stepRight();
			break;
		case 'T':
			stepTop();
			break;
		}		
	}
	
	private void stepLeft(){
		if(column+1<maxColumn){
			column++;
		} else {
			minRow++;
			if(minRow<maxRow){
				way='B';
				stepBottom();
			}
		}
	}
	
	private void stepBottom(){
		if (row+1<maxRow) {
			row++;
		} else {
			maxColumn--;
			if(minColumn<maxColumn){
				way='R';
				stepRight();
			}
		}
	}
	
	private void stepRight(){
		if (column-1>=minColumn) {
			column--;
		} else {
			maxRow--;
			if(minRow<maxRow){
				way='T';
				stepTop();
			}
		}
	}
	
	private void stepTop(){
		if (row-1>=minRow) {
			row--;
		} else {
			minColumn++;
			if(minColumn<maxColumn){
				way='L';
				stepLeft();
			}
		}
	}	
}
