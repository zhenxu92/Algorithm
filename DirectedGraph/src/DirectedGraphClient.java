/**
 * DirectedGraphClient Program Version 1.0(a)
 * 
 * @author zhenxu This program takes your input file of directed graph info and
 *         converted into the form of adjacent matrix, then output it.
 */

import java.util.*;
import java.io.*;

public class DirectedGraphClient {
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) throws FileNotFoundException {
		// Read in a file line by line full of pairs of
		// numbers. Then separate them out into number pairs
		// like 2 4, put it into a list.
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to Directed Graph Creater!");
		System.out.println();
		
		// open the input file from which you create your graph
		System.out.println("What is your graph data file name?");
		String fileName = console.nextLine();
		Scanner input = new Scanner(new File(fileName));
		
		// Make all the edges from input file, construct graph creator object
		List<Integer> vertices = new ArrayList<Integer>();
		while(input.hasNextInt()) {
			int vertex = input.nextInt();
			vertices.add(vertex);
		}
		int numOfVertex = Collections.max(vertices);
		DirectedGraphCreater dgcreater = new DirectedGraphCreater(numOfVertex);
		
		// Make Graph
		for(int i = 0; i < vertices.size(); i+=2) {
			dgcreater.makeEdge(vertices.get(i), vertices.get(i + 1));
		}
		
		// print out the adjacency matrix
		dgcreater.printMat(dgcreater.returnGraph());
		
		// print out the adjacency transpose matrix
		dgcreater.printMat(dgcreater.transpose());
		input.close();
		console.close();
	}
}
