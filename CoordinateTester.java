class CoordinateTester{

public static void main(String args[]){
	Coordinate testCoordinate1 = new Coordinate(3, 7); 
	
	Coordinate testCoordinate2 = new Coordinate(3, 7); 
	
	Coordinate testCoordinate3 = new Coordinate(1, 1); 
	
	System.out.println(testCoordinate1.equals(testCoordinate2)); 
	
	System.out.println(testCoordinate1.equals(testCoordinate3));
	
	testCoordinate1.printCoordinate(); 
	
	testCoordinate2.printCoordinate(); 
	
	testCoordinate1.setValueAtCoordinate(3); 
	
	testCoordinate1.printCoordinate(); 
	
	testCoordinate2.printCoordinate(); 
}
}