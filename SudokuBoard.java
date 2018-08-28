class SudokuBoard{
	//Instance Variables:
	private Coordinate[][] coordinates = new Coordinate[9][9]; 
	
	//Constructors:
	// Test board Numbers: 200007603000030080003000000810000060097206830030000024000000400070050000604300007
	
	SudokuBoard(String boardAsNumbers){
		int locationCounter = 0; //This var is the location in the string of boardAsNumbers
		for (int yCounter = 0; yCounter<9; yCounter++){
			for (int xCounter = 0; xCounter<9; xCounter++){
				coordinates[xCounter][yCounter] = new Coordinate(xCounter+1, yCounter+1);
				
				char tempChar = boardAsNumbers.charAt(locationCounter);
				int tempInt = Integer.parseInt(String.valueOf(tempChar)); //converting the charAt string to an int
				
				coordinates[xCounter][yCounter].setValueAtCoordinate(tempInt); 
				locationCounter++;
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
	
public static void main(String args[]){
	SudokuBoard TestBoard = new SudokuBoard("200007603000030080003000000810000060097206830030000024000000400070050000604300007");
	
	TestBoard.printSudokuBoard(TestBoard); 
}
}