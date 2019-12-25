package Basic;

public class Vertex{
    public int label;
    public String kota;
    public Vertex next;
    public Edge edge;
    public Vertex(int label, String kota) {
        this.label = label;
        this.kota = kota;
    }

    public Vertex(int label) {
        this.label = label;
    }
}
