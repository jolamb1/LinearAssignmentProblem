package proj4;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project4 {
	
	public static void main(String[] args) {
		
		Scanner input = null;
		int[][] matrix;
		File file = null;
		
		//check number of arguments
		if(args.length != 1) {
			System.out.println("Invalid number of arguments");
			System.exit(-1);
		}
		//check file path
		try {
		file = new File(args[0]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(-1);	
		}
		
		int side = input.nextInt();
		input.nextLine();
		matrix = new int[side][side];
		
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				matrix[i][j] = input.nextInt();
			}
			if (input.hasNext()) {
				input.nextLine();
			}
		}
		
		BinaryHeap<Solution> openList = new BinaryHeap<Solution>();
		int counter = 1;
		//adding initial values to the heap
		for (int k = 0; k < side;k++) {
			OrderedPair starter = new OrderedPair(k,0);
			Solution soln = new Solution(side);
			soln.addSoln(starter, 0);
			soln.addTotal(matrix[k][0]);
			openList.insert(soln);
			counter++;
		}
		
		Solution temp;
		
		
		Solution finalSol;
		while (1 < 2) {
			temp = openList.findMin();
			openList.deleteMin();
			
			if (temp.isFull() == true) {
				finalSol = temp;
				break;
			} else {
				
				
				OrderedPair[] tempSolnList = new OrderedPair[side];
				for (int l = 0; l < side;l++) {
					tempSolnList[l] = temp.solnList[l];
				}
				ArrayList<Integer> cantUse = new ArrayList<Integer>();
				//finds the rows that have already been assigned
				for (OrderedPair p: tempSolnList) {
					if (p != null){ 
					cantUse.add(p.getX());
					}
				}
				int colToUse = 0;
				//finds the column to assign an agent to
				for (int m = 0; m < side; m++) {
					
					if (tempSolnList[m] == null) {
						colToUse = m;
						break;
					}
					
				}
				
				for (int n = 0; n < side; n++) {
					
					Solution tempSol = new Solution(side);
					for (OrderedPair q: tempSolnList) {
						if (q != null) {
						tempSol.addSoln(q, q.getY());
						tempSol.addTotal(matrix[q.getX()][q.getY()]);
						}
					}
				
					if (cantUse.contains(n)==false) {
						tempSol.addSoln(new OrderedPair(n,colToUse), colToUse);
						tempSol.addTotal(matrix[tempSol.solnList[colToUse].getX()][tempSol.solnList[colToUse].getY()]);
						openList.insert(tempSol);
						counter++;
					} else {
					}
					
					
					
				}
				
				
				
			}
			
		}
		
		System.out.println("The number of agents: "+side);
		System.out.println("The total number of partial solutions generated: "+counter);
		System.out.println("The final size of openList: "+openList.getCurrentSize());
		System.out.print("The solution found: ( ");
		for (OrderedPair g : finalSol.solnList) {
			System.out.print(g+" ");
		}
		System.out.println(")");
		System.out.println("The cost of the Solution: "+finalSol.getTotal());
			
				
				
			}
			
			
		
	}


