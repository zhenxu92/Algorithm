/**
 * Graph v 1.0
 * 
 * This class is general implementation of graph structure
 * using list of edges and vertices, of which more functions
 * can be implemented. 
 * 
 * @author zhenxu
 * 11/18/16
 *
 */

import java.util.List;

public class Graph {
        private final List<Vertex> vertexes;
        private final List<Edge> edges;

        public Graph(List<Vertex> vertexes, List<Edge> edges) {
                this.vertexes = vertexes;
                this.edges = edges;
        }
        
        public void addEdge(Edge e) {
        	edges.add(e);
        	if(!vertexes.contains(e.getSource()))
        		vertexes.add(e.getSource());
        	if(!vertexes.contains(e.getDestination()))
        		vertexes.add(e.getDestination());
        }
        

        public List<Vertex> getVertexes() {
                return vertexes;
        }

        public List<Edge> getEdges() {
                return edges;
        }



}