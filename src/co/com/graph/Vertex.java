package co.com.graph;

public class Vertex {

  private String label;

  public Vertex(String label) {
    this.label = label;
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
    if (!(o instanceof Vertex)) return false;

    Vertex vertex = (Vertex) o;

    return label != null ? label.equals(vertex.label) : vertex.label == null;
  }

  @Override
  public int hashCode() {
    return label != null ? label.hashCode() : 0;
  }

}
