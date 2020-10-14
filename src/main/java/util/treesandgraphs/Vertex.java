package util.treesandgraphs;

import java.util.Objects;
import java.util.Set;

public class Vertex {
    String label;
    State state = State.Unvisited;

    public Vertex(String label) {
        this.label = label;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex graphNode = (Vertex) o;
        return Objects.equals(label, graphNode.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
