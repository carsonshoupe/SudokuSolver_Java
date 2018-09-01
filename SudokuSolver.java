class SudokuSolver{
	//Instance Variables:
	private SudokuBoard originalBoard;
	private SudokuBoard workingBoard; 
	private Coordinate[] orderedCoordinatesOfWorkingBoard = new Coordinate[81];

	//Constructors:
	SudokuSolver(SudokuBoard inputBoard){
		this.originalBoard = inputBoard; 
		this.workingBoard = this.originalBoard.clone(); 
				
		int orderedCoordinatesCounter = 0;  //Updating orderedCoordinatesOfWorkingBoard
		Coordinate [][] workingBoardCoordinates = this.workingBoard.getCoordinates(); 
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				this.orderedCoordinatesOfWorkingBoard[orderedCoordinatesCounter] = workingBoardCoordinates[xCounter][yCounter];
				orderedCoordinatesCounter++;
			}
		}
	}
	
	//Solver:
	public SudokuBoard solve(){
		this.exceptionCatcher(); 
		
		//System.out.println("It got past the exceptionCatcher");
		
		int tracker = 0; //tracks where in the orderedCoordinatesOfWorkingBoard the solver is. 
		
		int firstUnlockedCoordinate = 0;
		for (int counter = 0; counter < 81; counter++){
			if (orderedCoordinatesOfWorkingBoard[counter].getValueLocked() == true){
				continue; 
			}
			else{
				firstUnlockedCoordinate = counter;
				break;
			}
		}
		
		System.out.println("First Unlocked Coordinate: " + orderedCoordinatesOfWorkingBoard[firstUnlockedCoordinate]); 
		
		while (tracker != 81){
			//System.out.println("The tracker is at " + tracker);
			
			if (this.orderedCoordinatesOfWorkingBoard[tracker].getValueLocked() == true){
				tracker++;
				continue;
			}
			
			//workingBoard.printSudokuBoard();
			
			int checkValue = this.orderedCoordinatesOfWorkingBoard[tracker].getValueAtCoordinate()+1;
			//System.out.println("The tracker is at " + tracker);
			//System.out.println("The checkValue is at " + checkValue);
			
			while(checkValue < 10){
				if(checkAll(checkValue, this.orderedCoordinatesOfWorkingBoard[tracker], this.workingBoard) == true){
					this.orderedCoordinatesOfWorkingBoard[tracker].setValueAtCoordinate(checkValue);
					//System.out.println("checkValue: " + checkValue);
					//workingBoard.printSudokuBoard();
					tracker++;
					break;
				}
				else{
					checkValue++;
					//System.out.println("The checkValue was updated to " + checkValue);
				}
			}
			
			try{		//catching unsolveable boards
				if (firstUnlockedCoordinate==tracker && checkValue == 10){
					throw new InvalidBoard(); 
				}
			}
			catch (InvalidBoard unsolveableBoardException){
				System.out.println("This board is unsolvable. Reconsider board and try again");
			}
			
			if(checkValue == 10){
				//workingBoard.printSudokuBoard();
				this.orderedCoordinatesOfWorkingBoard[tracker].setValueAtCoordinate(0); 
				tracker--; 
				while(this.orderedCoordinatesOfWorkingBoard[tracker].getValueLocked() == true){
					tracker--;
				}
			}
		}
		return this.workingBoard; 
	}
	
	//Methods: 
	public Coordinate[] getOrderedCoordinatesOfWorkingBoard(){
		return this.orderedCoordinatesOfWorkingBoard;
		}
	
	public boolean checkXRow(int checkValue, Coordinate inputCoordinate, SudokuBoard inputSudokuBoard){
		int xCoordinate = inputCoordinate.getXCoordinate(); 
		Coordinate[][] sudokuBoardCoordinates = inputSudokuBoard.getCoordinates(); 
		
		for (int yCounter = 0; yCounter < 9; yCounter++){
			int currentValue = sudokuBoardCoordinates[xCoordinate-1][yCounter].getValueAtCoordinate(); 
			if (sudokuBoardCoordinates[xCoordinate-1][yCounter].equals(inputCoordinate)){
				continue;
			}
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
	}
	
	public boolean checkYRow(int checkValue, Coordinate inputCoordinate, SudokuBoard inputSudokuBoard){
		int yCoordinate = inputCoordinate.getYCoordinate(); 
		Coordinate[][] sudokuBoardCoordinates = inputSudokuBoard.getCoordinates(); 
		
		for (int xCounter = 0; xCounter < 9; xCounter++){
			int currentValue = sudokuBoardCoordinates[xCounter][yCoordinate-1].getValueAtCoordinate(); 
			if (sudokuBoardCoordinates[xCounter][yCoordinate-1].equals(inputCoordinate)){
				continue;
			}
			if (checkValue == currentValue){
				return false; 
			}
		}
		return true; 
		}
	
	public boolean checkSquare(int checkValue, Coordinate inputCoordinate, SudokuBoard inputSudokuBoard){
		int checkSquareValue = inputCoordinate.getSquareValue(); 
		
		Coordinate[][] sudokuBoardCoordinates = inputSudokuBoard.getCoordinates(); 
		
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				Coordinate checkCoordinate = sudokuBoardCoordinates[yCounter][xCounter];
				if (checkCoordinate.equals(inputCoordinate)){
				continue;
			}
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
		
		
	public void exceptionCatcher(){
		try{
			for (int counter = 0; counter < 81; counter++){
				Coordinate testCoordinate = this.orderedCoordinatesOfWorkingBoard[counter]; 
				if (testCoordinate.getValueLocked() == true){
					if (checkAll(testCoordinate.getValueAtCoordinate(), testCoordinate, this.originalBoard) == false){
						System.out.println("This coordinate threw the exception: ");
						testCoordinate.printCoordinate();
						throw new InvalidBoard(); 
					}
				}
			}
		}
		catch (InvalidBoard invalidBoardException){
			System.out.println("Caught invalid board.  Reenter board and try again.");
		}
	}
	
	
}
	