package Basic;

public class Edge{
    public int weight;
    public Vertex end;
    public Edge nextEdge;
    public Edge (Vertex end, int weight){
        this.end = end;
        this.weight = weight;
    }
}
