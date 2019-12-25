package Basic;

import java.util.Arrays;

public class Graph {
    public Vertex head;
    public Vertex tail;
    public int v = 0;
    String[] nama  = {"A","B","C","D","E","F","G","H","I","J"};
    public void addVertex(int label, String kota) {
        Vertex baru = new Vertex(label, kota);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        v++;
    }
    public void addVertex(int label) {
        Vertex baru = new Vertex(label);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        v++;
    }
    public Graph(int v){

        for(int i = 0; i<v; i++){
            addVertex(i,nama[i]);
        }
    }

    public Graph() {
    }

    public Vertex findver(int src) {
        Vertex cur = head;
        while (cur != null) {
            if (cur.label == src) {
                break;
            }
            cur = cur.next;
        }
        return cur;
    }

    public void addEdge(int src, int dest, int weight) {
        Vertex asal = findver(src);
        Vertex tujuan = findver(dest);
        Edge bantu = asal.edge;
        if (bantu == null) {
            asal.edge = new Edge(tujuan, weight);
        } else {
            while (bantu.nextEdge != null) {
                bantu = bantu.nextEdge;
            }
            bantu.nextEdge = new Edge(tujuan, weight);
        }
        Edge bantu2 = tujuan.edge;
        if (bantu2 == null) {
            tujuan.edge = new Edge(asal, weight);
        } else {
            while (bantu2.nextEdge != null) {
                bantu2 = bantu2.nextEdge;
            }
            bantu2.nextEdge = new Edge(asal, weight);
        }
    }

    public int[] degree() {
        int[] derajat = new int[v];
        for (int i = 0; i < v; i++) {
            Vertex cur = findver(i);
            Edge bantu = cur.edge;
            while (bantu != null) {
                derajat[i] += 1;
                bantu = bantu.nextEdge;
            }
        }
        return derajat;
    }
    public int[] Graphcoloring(int src) {
        int[] result = new int[v];
        boolean[] visited = new boolean[v];
        LinkedList que = new LinkedList();
        boolean[] available = new boolean[v];
        Arrays.fill(available, true);
        result[src] = 0;
        Vertex asal = findver(src);
        que.addlast(asal);
        while(!que.isEmpty()){
            Vertex cur = que.remove();
            Edge bantu = cur.edge;
            while(bantu != null){
                if (result[bantu.end.label] != -1) {
                    available[result[bantu.end.label]] = false;
                }
                if(!visited[bantu.end.label]){
                    que.addlast(bantu.end);
                }
                bantu = bantu.nextEdge;
            }
            int color = 0;
            for (; color < v; color++) {
                if (available[color]) {
                    break;
                }
            }
            result[cur.label] = color;
            Arrays.fill(available, true);
            visited[cur.label] = true;

        }




//        for (int i = 1; i < v; i++) {
//            Vertex cur = findver(i);
//            Edge bantu = cur.edge;
//            while (bantu != null) {
//                if (result[bantu.end.label] != -1) {
//                    available[result[bantu.end.label]] = false;
//                }
//                bantu = bantu.nextEdge;
//            }
//            int color = 0;
//            for (; color < v; color++) {
//                if (available[color]) {
//                    break;
//                }
//            }
//            result[cur.label] = color;
//            Arrays.fill(available, true);
//        }
        return result;
    }

    public int[] Graphcoloring() {
        int[] result = new int[v];
        Arrays.fill(result, -1);
        boolean[] available = new boolean[v];
        Arrays.fill(available, true);
        result[0] = 0;
        for (int i = 1; i < v; i++) {
            Vertex cur = findver(i);
            Edge bantu = cur.edge;
            while (bantu != null) {
                if (result[bantu.end.label] != -1) {
                    available[result[bantu.end.label]] = false;
                }
                bantu = bantu.nextEdge;
            }
            int color = 0;
            for (; color < v; color++) {
                if (available[color]) {
                    break;
                }
            }
            result[cur.label] = color;
            Arrays.fill(available, true);
        }
        return result;
    }

    public void djikstra(int src, int tujuan) {
        int[] jarak = new int[v];
        int[] prev = new int[v];
        LinkedList helper = new LinkedList();
        LinkedList jalur = new LinkedList();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (i == src) {
                jarak[i] = 0;
            } else {
                jarak[i] = Integer.MAX_VALUE;
            }
            prev[i] = -1;
        }
        int UkeV = 0; //jarak antar 2 Basic.node yang dicek (u - v)
        Vertex asal = findver(src);
        helper.addpriority(asal, jarak);
        while (!helper.isEmpty()) {
            Vertex cur = helper.remove();
            Edge bantu = cur.edge;
            while (bantu != null) {
                UkeV = jarak[cur.label] + bantu.weight;
                if (UkeV < jarak[bantu.end.label]) {
                    jarak[bantu.end.label] = UkeV;
                    prev[bantu.end.label] = cur.label;
                }
                if (!visited[bantu.end.label]) {
                    helper.addpriority(bantu.end, jarak);

                }
                bantu = bantu.nextEdge;
            }
            visited[cur.label] = true;
        }
        System.out.println("Dari " + nama[src] + " ke " + nama[tujuan] + " :");
        int simpan = tujuan;
        while(simpan != -1){
            jalur.addfirst(findver(simpan));
            simpan = prev[simpan];
        }
        jalur.display();
    }
    public void printAdj(){
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
}
