/**
 * This class is a general structure of a vertex in a graph
 * @author zhenxu
 *
 */
public class Vertex {
        final private int id;
        final private String name;
        final private int x;
        final private int y;


        public Vertex(int id, String name, int x, int y) {
                this.id = id;
                this.name = name;
                this.x = x;
                this.y = y;
        }
        public int getId() {
                return id;
        }
        
        public int getX() {
        	return this.x;
        }

        public int getY() {
        	return this.y;
        }
        
        public String getName() {
                return name;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Vertex other = (Vertex) obj;
                if(this.id == other.id) {
                	return true;
                } else {
                	return false;
                }
        }

        @Override
        public String toString() {
                return name;
        }

}
