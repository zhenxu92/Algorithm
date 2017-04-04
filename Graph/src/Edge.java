/**
 * Edge v 1.0
 * @author zhenxu
 * This program describes a edge structure.
 */

public class Edge implements Comparable<Edge>{
        private final int id;
        private final Vertex source;
        private final Vertex destination;
        private final double weight;

        public Edge(int id, Vertex source, Vertex destination, double weight) {
                this.id = id;
                this.source = source;
                this.destination = destination;
                this.weight = weight;
        }
        
        public Edge(int id, Vertex source, Vertex destination) {
        	this.id = id;
        	this.source = source;
        	this.destination = destination;
        	int x1 = source.getX();
        	int y1 = source.getY();
            int x2 = destination.getX();
            int y2 = destination.getY();
        	this.weight = Math.sqrt((x1-x2) * (x1-x2) + (y1-y2)*(y1-y2));
        }

        public int getId() {
                return id;
        }
        public Vertex getDestination() {
                return destination;
        }

        public Vertex getSource() {
                return source;
        }
        public double getWeight() {
                return weight;
        }

        @Override
        public String toString() {
                return source + " " + destination;
        }
        
        public int compareTo(Edge other) {
        	if(this.weight - other.weight > 0) {
        		return 1;
        	} else if (this.weight == other.weight) {
        		return 0;
        	} else {
        		return -1;
        	}
        }
}
