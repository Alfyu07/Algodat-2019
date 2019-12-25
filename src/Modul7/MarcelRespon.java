package Modul7;

import Basic.Graph;
import Basic.LinkedList;

import java.util.Arrays;

public class MarcelRespon {
   static String setwarna(int number){
       if(number == 0) return "Merah";
       if(number == 1) return "Biru";
       if(number == 2) return "Hijau";
       if(number == 3) return "Kuning";
       return "gak ada";
   }
   public static void main(String[] args) {
       Graph resp = new Graph(11);
       int [] prev = new int[11];
       int [] color = new int[11];
       Arrays.fill(color, -1);
       int [] degree = new int[11];
       LinkedList jalur = new LinkedList();
       resp.addEdge(1,4,11);
       resp.addEdge(1,3,15);
       resp.addEdge(1,5,1);
       resp.addEdge(2,5,9);
       resp.addEdge(2,6,19);
       resp.addEdge(3,6,7);
       resp.addEdge(3,7,17);
       resp.addEdge(4,8,12);
       resp.addEdge(5,4,14);
       resp.addEdge(5,9,2);
       resp.addEdge(6,10,4);
       resp.addEdge(7,6,16);
       resp.addEdge(5,8,13);
       resp.addEdge(9,6,3);
       resp.addEdge(10,7,15);
       degree = resp.degree();
       int indexmax = degree[0];
       for(int i = 1; i<11; i++){
           if(degree[i] > indexmax){
               indexmax = degree[i];
           }
       }

       resp.djikstra(1,prev);
       int tujuan = 10;
       while(tujuan != -1){
           jalur.addfirst(tujuan);
           tujuan = prev[tujuan];
       }
       jalur.display();

       color = resp.Graphcoloring();

       for(int i = 1; i<11; i++){
           if(i != -1){
               System.out.println("[" + i + "] -> " + setwarna(color[i]));
           }
       }
   }

}
