class SudokuBoard{
	//Instance Variables:
	private Coordinate[][] coordinates = new Coordinate[9][9];
	private String boardInputAsString; 
	
	//Constructors:
	// Test board Numbers: 200007603000030080003000000810000060097206830030000024000000400070050000604300007
	
	SudokuBoard(String boardAsNumbers){
		boardInputAsString = boardAsNumbers; 
		int locationCounter = 0; //This var is the location in the string of boardAsNumbers
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				coordinates[xCounter][yCounter] = new Coordinate(xCounter+1, yCounter+1);
				
				char tempChar = boardAsNumbers.charAt(locationCounter);
				int tempInt = Integer.parseInt(String.valueOf(tempChar)); //converting the charAt char to an int
				
				coordinates[xCounter][yCounter].setValueAtCoordinate(tempInt); 
				
				if (tempInt !=0){
					coordinates[xCounter][yCounter].setValueLocked(true); //locking preset values
				}					
				
				locationCounter++;
			}
		}
	}
	
	SudokuBoard(){
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				coordinates[xCounter][yCounter] = new Coordinate(xCounter+1, yCounter+1);
			}
		}
	}
	
	//Methods:
	public void printSudokuBoard(SudokuBoard currentBoard){
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				Coordinate[][] currentCoordinates = getCoordinates(currentBoard);
				System.out.print(currentCoordinates[xCounter][yCounter].getValueAtCoordinate()); 
				System.out.print("   ");
			}
			System.out.print("\n"); 
		}
	}
	
	public Coordinate[][] getCoordinates(SudokuBoard currentBoard){return coordinates;} 
	
	public void setCoordinates(Coordinate[][] updatedCoordinates){coordinates = updatedCoordinates;}
	
	public SudokuBoard cloneSudokuBoard(SudokuBoard inputBoard){
		SudokuBoard outputBoard = new SudokuBoard(inputBoard.boardInputAsString);
/* 		Coordinate[][] inputBoardCoordinates = inputBoard.getCoordinates(inputBoard); 
		
		Coordinate[][] outputBoardCoordinates = new Coordinate[inputBoardCoordinates.length][]; 
		for (int r = 0; r < inputBoardCoordinates.length; r++){
			outputBoardCoordinates[r] = inputBoardCoordinates[r].clone(); 
		}
		
		outputBoard.setCoordinates(outputBoardCoordinates);  */
		
		return outputBoard; 
	}
		
	
public static void main(String args[]){
	SudokuBoard TestBoard = new SudokuBoard("200007603000030080003000000810000060097206830030000024000000400070050000604300007");
	
/* 	Coordinate[][] testCoordinates = TestBoard.getCoordinates(TestBoard);
	for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				testCoordinates[xCounter][yCounter].printCoordinateInfo(testCoordinates[xCounter][yCounter]);
			}
	}
				 */
	
	
	System.out.println("TestBoard: ");
	TestBoard.printSudokuBoard(TestBoard); 
	
	SudokuBoard TestBoardClone = new SudokuBoard();
	System.out.println("TestBoardClone before Clone: ");
	TestBoardClone.printSudokuBoard(TestBoardClone); 
	
	TestBoardClone = TestBoard.cloneSudokuBoard(TestBoard); 
	
	System.out.println("TestBOardClone After Clone: ");
	TestBoardClone.printSudokuBoard(TestBoardClone); 
	
	System.out.println("Updating Test Board to see if it affects clone...");
	TestBoard.getCoordinates(TestBoard)[0][1].setValueAtCoordinate(9); 
	
	System.out.println("TestBoard: ");
	TestBoard.printSudokuBoard(TestBoard);
	
	System.out.println("TestBoardClone After Update: ");
	TestBoardClone.printSudokuBoard(TestBoardClone);
}
}