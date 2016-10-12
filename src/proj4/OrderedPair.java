package proj4;

public class OrderedPair {
	
	private int x,y;
	
	public OrderedPair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	
	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}



	public String toString() {
		return "("+(x+1)+","+(y+1)+")";
	}

}
