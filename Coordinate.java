class Coordinate{
	//Instance Variables:
	private int xCoordinate;
	private int yCoordinate;
	private int squareValue;
	private int valueAtCoordinate;
	private boolean valueLocked;
	
	//Constructors:
	Coordinate(int x, int y){
		xCoordinate = x; 
		yCoordinate = y; 
		squareValue = calculateSquareValue(x, y); 
		valueAtCoordinate = 0; 
		valueLocked = false;
	}
	
	//Methods:
	public int calculateSquareValue(int x, int y){
		squareValue = ((x-1)/3 + ((y-1)/3)*3)+1;
		return squareValue; 
	}
	
	
	public int getXCoordinate(){return xCoordinate;} 
	public int getYCoordinate(){return yCoordinate;} 
	public int getSquareValue(){return squareValue;}
	public int getValueAtCoordinate(){return valueAtCoordinate;}
	public boolean getValueLocked(){return valueLocked;}
	
	public void setXCoordinate(int newX){xCoordinate = newX;}
	public void setYCoordinate(int newY){yCoordinate = newY;}
	public void setSquareValue(int newSquareValue){squareValue = newSquareValue;}
	public void setValueAtCoordinate(int newValueAtCoordinate){valueAtCoordinate = newValueAtCoordinate;}
	public void setValueLocked(boolean locked){valueLocked = locked;}
	
	public void printCoordinateInfo(Coordinate coordinate){
		System.out.println("Coordinates: (" + getXCoordinate() + ", " + getYCoordinate() + ")");
		System.out.println("Square Value: " + getSquareValue()); 
		System.out.println("Value at Coordinate: " + getValueAtCoordinate());
		System.out.println("Locked: " + getValueLocked());
		System.out.print("\n");
	}
}