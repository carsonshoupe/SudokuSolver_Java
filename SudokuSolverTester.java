class SudokuSolverTester{
	
	//testboard Numbers: 409300000500407000017680000000000520108000603065000000000076350000209008000004906 -- hard 10
	//200007603000030080003000000810000060097206830030000024000000400070050000604300007
	//000200700060004000020089301280003006005000200300600058106870040000100080008006000 -- very hard 48
public static void main(String args[]){
	SudokuBoard testSudokuBoard = new SudokuBoard("120456789003000000000000000000000000000000000000000000000000000000000000000000000"); 
	
	testSudokuBoard.printSudokuBoard(); 
	
	SudokuSolver solver = new SudokuSolver(testSudokuBoard); 
	/*
	Coordinate[] coordinatesArray = solver.getOrderedCoordinatesOfWorkingBoard(); 
	for (int counter = 0; counter < 81; counter++){
		System.out.println(coordinatesArray[counter]); 
	}
	 */
	 
	SudokuBoard solvedSudokuBoard = new SudokuBoard();
	 
	try{
		solvedSudokuBoard = solver.solve();
	}
	catch(UnsolveableBoardException e){
		System.out.println(e.getMessage());
		System.out.println("We caught the exception!");
	}	
	
	testSudokuBoard.printSudokuBoard(); 
	
	solvedSudokuBoard.printSudokuBoard();
}
}