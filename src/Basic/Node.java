package Basic;

public class Node {
    public int number;
    public String nama;
    public Vertex data;
    public Node next;
    public Node prev;
    public Node(Vertex data){
        this.data = data;
    }

    public Node(int number, String nama) {
        this.number = number;
        this.nama = nama;
    }

    public Node(String nama) {
        this.nama = nama;
    }

    public Node(int number) {
        this.number = number;
    }
}
