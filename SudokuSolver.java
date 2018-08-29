class SudokuSolver{
	//Instance Variables:
	private SudokuBoard originalBoard;
	private SudokuBoard workingBoard; 
	private Coordinate[] orderedCoordinatesOfWorkingBoard = new Coordinate[81];

	//Constructors:
	SudokuSolver(SudokuBoard inputBoard){
		
		//Setup for Solver:
		originalBoard = inputBoard; 
		workingBoard = originalBoard.cloneSudokuBoard(originalBoard); 
				
		
		int orderedCoordinatesCounter = 0;  //Updating orderedCoordinatesOfWorkingBoard
		Coordinate [][] workingBoardCoordinates = workingBoard.getCoordinates(workingBoard); 
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				orderedCoordinatesOfWorkingBoard[orderedCoordinatesCounter] = workingBoardCoordinates[xCounter][yCounter];
				orderedCoordinatesCounter++;
			}
		}
		
		//Testing:
		
/* 		for (int testCounter = 0; testCounter<81; testCounter++){
			orderedCoordinatesOfWorkingBoard[testCounter].printCoordinateInfo(orderedCoordinatesOfWorkingBoard[testCounter]); 
		} */
		
		//Solving: 
		
		
		
		
		
	}
	
	//Methods: 
	
	public static void main(String args[]){
		SudokuBoard TestBoard = new SudokuBoard("200007603000030080003000000810000060097206830030000024000000400070050000604300007");
		
		SudokuSolver Solver = new SudokuSolver(TestBoard);
		
		
		
	}
}
				
	