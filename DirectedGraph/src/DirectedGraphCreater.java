/**
 * DirectedGraphCreater Version 1.0(a)
 * @author zhenxu
 * This program takes in your directed graph instruction data,
 * and then put it into an adjacent matrix form. It performs the
 * transpose of the matrix in order to find the inverse directed
 * graph.
 */


public class DirectedGraphCreater {
	// data field
	private int[][] adjMat;	// adjacentMatrix

	/**
	 * Constructor: initiate the length of adjacent matrix
	 * @param numOfVertex the total number of vertices in the graph
	 */
	public DirectedGraphCreater(int numOfVertex) {
		adjMat = new int[numOfVertex + 1][numOfVertex + 1];
	}
	
	/**
	 * This method takes in a start vertex and an end vertex and
	 * create an edge between these two vertices by marking it in
	 * the adjacent matrix.
	 * @param start the index notation of the start vertex
	 * @param end the index notation of the end vertex
	 */
	public void makeEdge(int start, int end) {
		this.adjMat[start][end] = 1;
	}
	
	/**
	 * This method takes the adjacent matrix and transpose it, in other words,
	 * inverse directions of all the edges.
	 * @return the graph with inverse edges
	 */
	public int[][] transpose() {
		int length = this.adjMat[0].length;
		int[][] adjMatT = new int[length][length];
		for (int i = 1; i < length; i++) {
			for (int j = 1; j < length; j++) {
				adjMatT[i][j] = this.adjMat[j][i];
			}
		}
		return adjMatT;
	}
	
	/**
	 * This method returns the adjacency matrix
	 * @return the adjacency matrix that we created
	 */
	public int[][] returnGraph() {
		return this.adjMat;
	}
	
	/**
	 * This method print out the graph in adjacency matrix form.
	 * @param mat the adjacency matrix that needs to be printed out
	 */
	public void printMat(int[][] mat) {
		int length = this.adjMat[0].length;
		System.out.println("The adjacency matrix for the graph is");
		System.out.print("  ");
		for (int i = 1; i < length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 1; i < length; i++) {
			System.out.print(i + " ");
			for (int j = 1; j < length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
