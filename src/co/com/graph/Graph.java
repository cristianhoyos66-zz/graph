package co.com.graph;

import java.util.*;

public class Graph {

  private Map<Vertex, List<Vertex>> adjVertices;

  public Graph() {
    adjVertices = new HashMap<>();
  }

  public Map<Vertex, List<Vertex>> getAdjVertices() {
    return adjVertices;
  }

  public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
    this.adjVertices = adjVertices;
  }

  public void addVertex(String label) {
    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
  }

  public void removeVertex(String label) {
    Vertex vertex =  new Vertex(label);
    adjVertices.values().stream().forEach(value -> value.remove(vertex));
    adjVertices.remove(vertex);
  }

  public void addEdge(String label1, String label2) {
    Vertex v1 =  new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    adjVertices.get(v1).add(v2);
    adjVertices.get(v2).add(v1);
  }

  public void removeEdge(String label1, String label2) {
    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    List<Vertex> eV1 = adjVertices.get(v1);
    List<Vertex> eV2 = adjVertices.get(v2);
    if (eV1 != null)
      eV1.remove(v2);
    if (eV1 != null)
      eV2.remove(v1);
  }

  public Graph createGraph() {
    Graph graph = new Graph();
    graph.addVertex("Bob");
    graph.addVertex("Alice");
    graph.addVertex("Mark");
    graph.addVertex("Rob");
    graph.addVertex("Maria");
    graph.addEdge("Bob", "Alice");
    graph.addEdge("Bob", "Rob");
    graph.addEdge("Alice", "Mark");
    graph.addEdge("Rob", "Mark");
    graph.addEdge("Alice", "Maria");
    graph.addEdge("Rob", "Maria");
    return graph;
  }

  public List<Vertex> getAdjVertices(String label) {
    return adjVertices.get(new Vertex(label));
  }

  public Set<String> depthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<>();
    Stack<String> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      String vertex = stack.pop();
      if (!visited.contains(vertex)) {
        visited.add(vertex);
        for (Vertex v : graph.getAdjVertices(vertex)) {
          stack.push(v.getLabel());
        }
      }
    }
    return visited;
  }

  public Set<String> breadthFirstTraversal(Graph graph, String root) {
    Set<String> visited = new LinkedHashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(root);
    visited.add(root);
    while (!queue.isEmpty()) {
      String vertex = queue.poll();
      for (Vertex v : graph.getAdjVertices(vertex)) {
        if (!visited.contains(v.getLabel())) {
          visited.add(v.getLabel());
          queue.add(v.getLabel());
        }
      }
    }
    return visited;
  }

}
