import Basic.Edge;

class Edgy{
    int weight;
    int source;
    int destination;
    public Edgy(int source, int destination,int weight ) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }
}
class Node{
    Object data;
    Node next;
    Node prev;
    public Node(Object data) {
        this.data = data;
    }
}
class Linkedlist<T>{
    Node head, tail;
    void addlast(Object data){
        Node baru = new Node(data);
        if(head == null){
            head = tail = baru;
        }else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
    }
    void addfirst(Object data){
        Node baru = new Node(data);
        if(head == null){
            head = tail = baru;
        }else{
            baru.next = head;
            head.prev = baru;
            head = baru;
        }
    }
    void addpriority(Object data){
        Node baru = new Node(data);
        if(head == null){
            head = tail = baru;
        }else{
            Node bantu = head;
        }
    }
}
class Graph{
    int size;
    Linkedlist<Edgy> [] adjlist;

    public Graph(int size) {
        this.size = size;
        adjlist = new Linkedlist[size];
        for(int i = 0; i<size; i++){
            adjlist[i] = new Linkedlist<>();
        }
    }
    public void addEdge(int src, int dest, int weight){
        adjlist[src].addlast(new Edgy(src,dest,weight));
        adjlist[dest].addlast(new Edgy(dest,src,weight));
    }
    public void printAdjList(){
        for(int i = 0; i<size; i++){
            System.out.print("[" + i + "] -> head" );
            Node bantu = adjlist[i].head;
            while(bantu != null){
                Edgy data = (Edgy)bantu.data;
                System.out.print( " -> " + data.destination );
                bantu = bantu.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);
        graph.printAdjList();
//        graph.DFS(0);
//        System.out.println();
//        graph.BFS(0);
    }

}
