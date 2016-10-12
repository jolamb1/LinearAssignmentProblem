package proj4;

public class Solution implements Comparable<Solution> {
	OrderedPair[] solnList;
	private int total;
	
	public Solution(int i) {
		solnList = new OrderedPair[i];
		total = 0;
	}
	
	public void addSoln(OrderedPair p, int i) {
		
		solnList[i] = p;
		
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public void addTotal(int i) {
		
		total += i;
		
	}
	
	public int compareTo(Solution soln) {
		
		if (this.total > soln.total) {
			return 1;
		} else if (this.total < soln.total) {
			return -1;
		} else {
			return 0;
		}
		
		
	}
	
	public boolean isFull() {
		for (OrderedPair i: this.solnList) {
			if (i != null) {
				
			} else {
				return false;
			}
			
		}
		return true;
		
		
	}
	
	
	}
	
	
	
	

