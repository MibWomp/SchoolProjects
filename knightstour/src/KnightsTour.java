
public class KnightsTour {
	public static void main(String[] args) {
		int[][] fiveBoard = new int[5][5];
		tour(fiveBoard,2,2,1);
	}
	
	private static void displayGrid(int[][] myGrid){
		int rowSize = myGrid.length;
		int colSize = myGrid[0].length;
		for(int row = 0; row < rowSize; row++)
		{  for(int col = 0; col < colSize; col++)
			System.out.printf(" %d ",myGrid[row][col]);//myGrid[row][col] = "";
		System.out.println();
		}
		System.out.println();
	}
	public static boolean tour(int[][] board, int row, int col, int count) {
		if(row>board.length-1||row<0||col>board[0].length-1||col<0) { //out of bounds
			return false;
		}
		if(board[row][col]>0) { //already been there
			return false;
		}
		board[row][col]=count;
		if(count==board.length*board[0].length) { //found solution
			displayGrid(board);
			board[row][col]=0;
			return true;
		}
		if(!(tour(board,row-2,col+1,count+1)||tour(board,row-1,col+2,count+1)||tour(board,row+1,col+2,count+1)
		||tour(board,row+2,col+1,count+1)||tour(board,row+2,col-1,count+1)||tour(board,row+1,col-2,count+1)
		||tour(board,row-1,col-2,count+1)||tour(board,row-2,col-1,count+1))) { //if all return false, no more paths
			board[row][col]=0;
			return false;
		}
		//reached here then solution is found for all branches. backtrack.
		board[row][col]=0;
		return false;
	}
}
