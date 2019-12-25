import java.util.Scanner;

class Vertex {
    int data;
    Edge sisi;
    Vertex next;
    Vertex (int data){
        this.data = data;
    }
}
class Edge {
    int weight;
    Edge ednext;
    Vertex dest;
    Edge (Vertex dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }
}
class ResponSharah {
    Vertex head;
    Vertex tail;
    int size = 0;
    ResponSharah (int list){
        for(int i=0; i<list; i++){
            size++;
            addVer(i);
        }
    }
    void addVer (int numb){
        Vertex newVer = new Vertex(numb);
        if (head == null){
            head = tail = newVer;
        } else {
            tail.next = newVer;
            tail = newVer;
        }
    }
    Vertex findVer(int find){
        Vertex curr = head;
        while(curr != null){
            if (curr.data == find){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
    void showVer(){
        Vertex curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        } System.out.println();
    }
    void addEdge(int source, int destination, int bobot){
         try{
        Vertex src = findVer(source);
        Vertex des = findVer(destination);
        Edge tali = src.sisi;

        if (tali == null){
            src.sisi = new Edge(des, bobot);
        } else {
            while(tali.ednext != null){
                tali = tali.ednext;
            }
            tali.ednext = new Edge(des, bobot);
        }
         }
         catch (NullPointerException e){
             System.out.println(" Error ");
         }
    }
    void adjList(){
        // try{
        Vertex curr = head;

        while(curr != null){
            Edge road = curr.sisi;
            System.out.print(curr.data);
            while(road != null){
                System.out.print("-> "+road.dest.data+" ("+road.weight+") ");
                road = road.ednext;
            }
            System.out.println();
            curr = curr.next;
        }
    }
    // catch (NullPointerException e){
    //     System.out.println(" Error ");
    // }
    // }
    // void bfs()

    public static void main(String[] args) {
        ResponSharah yeet = new ResponSharah(10);
        System.out.println("a");

        yeet.addEdge(0, 2, 10);
        yeet.addEdge(1, 3, 12);
        yeet.addEdge(2, 1, 14);
        yeet.addEdge(2, 9, 12);
        yeet.addEdge(2, 4, 12);
        yeet.addEdge(3, 4, 18);
        yeet.addEdge(4, 5, 15);
        yeet.addEdge(4, 6, 19);
        yeet.addEdge(4, 7, 13);
        yeet.addEdge(5, 9, 20);
        yeet.addEdge(6, 8, 20);
        yeet.addEdge(7, 8, 16);
        yeet.addEdge(8, 10, 11);
        yeet.addEdge(9, 10, 16);
        yeet.addEdge(10, 7, 15);
        yeet.showVer();
        yeet.adjList();
    }
}