package util.treesandgraphs;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Set<Vertex> adjVertices = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    public void addVertex(String label) {
        adjVertices.add(new Vertex(label));
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.remove(v);
        edges.removeIf(edge -> edge.dest.equals(v) || edge.src.equals(v));
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        Edge edge = new Edge(v1, v2);
        adjVertices.add(v1);
        adjVertices.add(v2);
        edges.add(edge);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        edges.removeIf(edge ->
            (edge.src.equals(v2) && edge.dest.equals(v1)) || (edge.src.equals(v1) && edge.dest.equals(v2))
        );
    }

    public List<Vertex> getAdjVertices(String label) {
        return edges.stream().filter(edge -> edge.src.equals(new Vertex(label))).map(Edge::getDest).collect(Collectors.toList());
    }

    public List<Vertex> getVertices(){
        return adjVertices.stream().collect(Collectors.toList());
    }
}
