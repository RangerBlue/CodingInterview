package util.treesandgraphs;

public class Edge {
    public Vertex src;
    public Vertex dest;

    public Edge(Vertex src, Vertex dest) {
        this.src = src;
        this.dest = dest;
    }

    public Vertex getSrc() {
        return src;
    }

    public void setSrc(Vertex src) {
        this.src = src;
    }

    public Vertex getDest() {
        return dest;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }
}
