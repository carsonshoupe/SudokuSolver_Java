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
		
		int tracker = 0; //tracks where in the orderedCoordinatesOfWorkingBoard the solver is. 
		
		while (tracker != 81){
			if (orderedCoordinatesOfWorkingBoard[tracker].getValueLocked() == true){
				tracker++;
				continue;
			}
			
			int checkValue = orderedCoordinatesOfWorkingBoard[tracker].getValueAtCoordinate();
			
			while(checkValue < 10){
				if(checkAll(checkValue, orderedCoordinatesOfWorkingBoard[tracker], workingBoard) == true){
					orderedCoordinatesOfWorkingBoard[tracker].setValueAtCoordinate(checkValue);
					tracker++;
					break;
				}
				else{
					checkValue++;
				}
			}
			if(checkValue == 10){
				orderedCoordinatesOfWorkingBoard[tracker].setValueAtCoordinate(0); 
				tracker--; 
				while(orderedCoordinatesOfWorkingBoard[tracker].getValueLocked() == true){
					tracker--;
				}
			}
		}
		workingBoard.printSudokuBoard(workingBoard); 
	}

	
	//Methods: 
	public boolean checkXRow(int checkValue, Coordinate inputCoordinate, SudokuBoard inputSudokuBoard){
		int xCoordinate = inputCoordinate.getXCoordinate(); 
		Coordinate[][] sudokuBoardCoordinates = inputSudokuBoard.getCoordinates(inputSudokuBoard); 
		
		for (int yCounter = 0; yCounter < 9; yCounter++){
			int currentValue = sudokuBoardCoordinates[xCoordinate-1][yCounter].getValueAtCoordinate(); 
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
	}
	
	public boolean checkYRow(int checkValue, Coordinate inputCoordinate, SudokuBoard inputSudokuBoard){
		int yCoordinate = inputCoordinate.getYCoordinate(); 
		Coordinate[][] sudokuBoardCoordinates = inputSudokuBoard.getCoordinates(inputSudokuBoard); 
		
		for (int xCounter = 0; xCounter < 9; xCounter++){
			int currentValue = sudokuBoardCoordinates[xCounter][yCoordinate-1].getValueAtCoordinate(); 
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
		}
	
	public boolean checkSquare(int checkValue, Coordinate inputCoordinate, SudokuBoard inputSudokuBoard){
		int checkSquareValue = inputCoordinate.getSquareValue(); 
		
		Coordinate[][] sudokuBoardCoordinates = inputSudokuBoard.getCoordinates(inputSudokuBoard); 
		
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				Coordinate checkCoordinate = sudokuBoardCoordinates[yCounter][xCounter];
				if (checkSquareValue == checkCoordinate.getSquareValue()){
					if (checkValue == checkCoordinate.getValueAtCoordinate()){
						return false;
					}
				}
			}
		}
		return true;
		}				
		
	public boolean checkAll(int checkValue, Coordinate inputCoordinate, SudokuBoard inputSudokuBoard){
		if (checkXRow(checkValue, inputCoordinate, inputSudokuBoard) && checkYRow(checkValue, inputCoordinate, inputSudokuBoard) && checkSquare(checkValue, inputCoordinate, inputSudokuBoard) == true){
			return true; 
		}
		return false; 
		}
		

	
	
	
	//Main: 
	public static void main(String args[]){
		
		//one testboard: "409300000500407000017680000000000520108000603065000000000076350000209008000004906" -- Success
		SudokuBoard TestBoard = new SudokuBoard("000200700060004000020089301280003006005000200300600058106870040000100080008006000");
		
		SudokuSolver Solver = new SudokuSolver(TestBoard);
		
		
		
	}
}
				
	