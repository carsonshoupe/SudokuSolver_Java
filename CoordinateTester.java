class CoordinateTester{

public static void main(String args[]){
	Coordinate testCoordinate = new Coordinate(3, 7); 
	
	testCoordinate.printCoordinate(); 
	
	Coordinate testCoordinate2 = testCoordinate.clone(); 
	
	testCoordinate2.printCoordinate(); 
	
	testCoordinate.setValueAtCoordinate(3); 
	
	testCoordinate.printCoordinate(); 
	
	testCoordinate2.printCoordinate(); 
}
}