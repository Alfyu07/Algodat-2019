package  Modul7;
import Basic.*;
class ResponModul6{
    static int jumlahwarna(int[] color) {
        for(int i = 0; i<color.length; i++){
            for(int j = i+1; j<color.length; j++){
                if(color[i] > color[j]){
                    int tmp = color[i];
                    color[i] = color[j];
                    color[j] = tmp;
                }
            }
        }

        int count = 1;
        for (int i = 0; i < color.length - 1; i++) {
            if (color[i] != color[i + 1]) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Graph respon = new Graph(10);
        respon.addEdge(0,1,3);
        respon.addEdge(0,6,1);
        respon.addEdge(0,9,4);
        respon.addEdge(1,3,10);
        respon.addEdge(9,3,3);
        respon.addEdge(9,6,6);
        respon.addEdge(3,7,11);
        respon.addEdge(5,7,4);
        respon.addEdge(5,6,8);
        respon.addEdge(7,2,3);
        respon.addEdge(7,8,6);
        respon.addEdge(5,8,2);
        respon.addEdge(6,4,14);
        respon.addEdge(5,4,2);
        respon.addEdge(8,4,1);
        for(int i = 0; i<respon.v; i++){
            for(int j = 0; j<respon.v; j++){
                respon.djikstra(i,j);
            }
        }

        int [] color = respon.Graphcoloring();
        int maxcolor = jumlahwarna(color);
        System.out.println("jumlah warna : " + maxcolor);
    }
}