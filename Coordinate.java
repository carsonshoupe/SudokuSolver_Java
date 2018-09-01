class Coordinate{
	//Instance Variables:
	private int xCoordinate;
	private int yCoordinate;
	private int squareValue;
	private int valueAtCoordinate;
	private boolean valueLocked;
	
	//Constructors:
	Coordinate(int x, int y){
		this.xCoordinate = x; 
		this.yCoordinate = y; 
		this.squareValue = Coordinate.calculateSquareValue(x, y); 
		this.valueAtCoordinate = 0; 
		this.valueLocked = false;
	}
	
	//Methods:
	public static int calculateSquareValue(int x, int y){
		return ((x-1)/3 + ((y-1)/3)*3)+1; 
	}
	
	
	public int getXCoordinate(){return this.xCoordinate;} 
	public int getYCoordinate(){return this.yCoordinate;} 
	public int getSquareValue(){return this.squareValue;}
	public int getValueAtCoordinate(){return this.valueAtCoordinate;}
	public boolean getValueLocked(){return this.valueLocked;}
	
	public void setXCoordinate(int newX){this.xCoordinate = newX;}
	public void setYCoordinate(int newY){this.yCoordinate = newY;}
	public void setSquareValue(int newSquareValue){this.squareValue = newSquareValue;}
	public void setValueAtCoordinate(int newValueAtCoordinate){this.valueAtCoordinate = newValueAtCoordinate;}
	public void setValueLocked(boolean locked){valueLocked = locked;}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Coordinate)){
			//System.out.println("Returned false because second half of equality statement is not a coordinate");
			return false;
		}
		
		Coordinate anotherCoordinate = (Coordinate) o;
		
		if (this.getXCoordinate() == anotherCoordinate.getXCoordinate() && this.getYCoordinate() == anotherCoordinate.getYCoordinate()){
			return true;
		}
		else{
			//System.out.println("Returned false because coordinate locations were not the same");
			return false;
		}
	}
	
	@Override
	public Coordinate clone(){
		Coordinate outputCoordinate = new Coordinate(this.getXCoordinate(), this.getYCoordinate()); 
		outputCoordinate.setValueAtCoordinate(this.getValueAtCoordinate()); 
		outputCoordinate.setValueLocked(this.getValueLocked()); 
		return outputCoordinate;
	}
	
	@Override
	public String toString(){
		String resultString = "Coordinates: (" + getXCoordinate() + ", " + getYCoordinate() + ")\n" + "Square Value: " + getSquareValue() + "\n" + "Value at Coordinate: " + getValueAtCoordinate() + "\n" + "Locked: " + getValueLocked() + "\n";
		
		return resultString; 
	}
	
	public void printCoordinate(){System.out.println(this.toString());}
}