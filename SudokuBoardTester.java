class SudokuBoardTester{
public static void main(String args[]){
	SudokuBoard testSudokuBoard = new SudokuBoard("200007603000030080003000000810000060097206830030000024000000400070050000604300007"); 
	
	SudokuBoard testSudokuBoard2 = new SudokuBoard(testSudokuBoard.getCoordinates()); 
	
	testSudokuBoard.printSudokuBoard(); 
	
	testSudokuBoard2.printSudokuBoard(); 
	
	testSudokuBoard.getCoordinates()[1][0].setValueAtCoordinate(7); 
	
	testSudokuBoard.printSudokuBoard(); 
	
	testSudokuBoard2.printSudokuBoard(); 
}
}
		