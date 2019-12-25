package  Modul6;
import Basic.Vertex;
import Basic.LinkedList;

class Graph{
    Vertex head;
    Vertex tail;
    int v = 0;
    void addNode(int data){ //Basic.linklist Basic.node nya
        if(head == null){
            head = tail = new Vertex(data);
            return;
        }
        tail.next = new Vertex(data);
        tail = tail.next;
        v++;
    }
    public Graph(int v){ //constructor graphnya  Graph graph = new graph(7);
        this.v = v;
        for(int i = 0; i<v; i++){
            addNode(i);
        }
    }

    Vertex findNode(int numb){
        Vertex simpan = head;
        while(simpan != null){
            if(simpan.label == numb) return simpan;
            simpan= simpan.next;
        }
        return null;
    }
    void addDirection(int src, int dest, int weight){
        try{
            Vertex cur = findNode(src);
            Vertex des = findNode(dest);
            Basic.Edge bantu = cur.edge;
            if(cur.edge == null){
                cur.edge = new Basic.Edge(des,weight);
            }else{
                while(bantu.nextEdge != null){
                    bantu = bantu.nextEdge;
                }
                bantu.nextEdge= new Basic.Edge(des, weight);
            }
        }catch (NullPointerException a){
            System.out.println("Basic.Vertex tidak ditemukan");
        }
    }
    void printAdj(){
        try{
            Vertex cur = head;
            while(cur != null){
                System.out.print("[" + cur.label+"]");
                Basic.Edge bantu = cur.edge;
                while(bantu != null){
                    System.out.print(" -> " + bantu.end.label);
                    bantu = bantu.nextEdge;
                }
                System.out.println();
                cur = cur.next;
            }
        }catch (NullPointerException e){
            System.out.print("Basic.Vertex tidak ada");
        }
    }

    void printBFS(int src){
        LinkedList que = new LinkedList();
        boolean [] visited = new boolean[v];

            Vertex root = findNode(src);
            que.addlast(root);
            visited[root.label] = true;
            while(!que.isEmpty()){
                Vertex cur = que.remove();
                System.out.print(cur.label + " ");
                Basic.Edge bantu = cur.edge;
                while(bantu != null ){
                    if(!visited[bantu.end.label]){
                        que.addlast(bantu.end);
                        visited[bantu.end.label] = true;
                     }
                    bantu = bantu.nextEdge;

                }
            }
    }
    void printDFS(int number){
        LinkedList sta = new LinkedList();
        boolean [] visited = new boolean[v];
        try{
            Vertex root = findNode(number);
            sta.addfirst(root);
            visited[root.label] = true;
            while(!sta.isEmpty()){
                Vertex cur = sta.remove();
                System.out.print(cur.label + " ");
                Basic.Edge bantu = cur.edge;
                while(bantu != null){
                    if(!visited[bantu.end.label]){
                        sta.addfirst(bantu.end);
                        visited[bantu.end.label] = true;
                    }
                    bantu = bantu.nextEdge;
                }
            }
        }catch (NullPointerException e){
            System.out.println(" Error ");
        }
    }
}
public class alfyujurnal {
    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addDirection(0, 2, 10);
        graph.addDirection(1, 3, 12);
        graph.addDirection(2, 1, 14);
        graph.addDirection(2, 9, 12);
        graph.addDirection(2, 4, 12);
        graph.addDirection(3, 4, 18);
        graph.addDirection(4, 5, 15);
        graph.addDirection(4, 6, 19);
        graph.addDirection(4, 7, 13);
        graph.addDirection(5, 9, 20);
        graph.addDirection(6, 8, 20);
        graph.addDirection(7, 8, 16);
        graph.addDirection(8, 10, 11);
        graph.addDirection(9, 10, 16);
        graph.addDirection(10, 7, 15);
        System.out.println("Print Adj List : ");
        graph.printAdj();
        System.out.println("Print BFS : ");
        graph.printBFS(0);
        System.out.println();
        System.out.println("\nPrint DFS : ");
        graph.printDFS(0);
         System.out.println();
    }
}