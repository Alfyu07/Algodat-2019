package Modul45;
import Modul45.basic.*;

public class Respon {
    static int priority(String kelas){
        if(kelas == "S") return 1;
        if(kelas == "A") return 2;
        if(kelas == "B") return 3;
        if(kelas == "C") return 4;
        if(kelas == "D") return 5;
        if(kelas == "E") return 6;
        return 7;
    }

    static void sortpriority(LinkedList resp){
        Node i = resp.head;
        Node j;
        while(i != null){
            j = i.next;
            while(j != null){
                if(i.priority > j.priority){
                    int tmp = i.data;
                    i.data = j.data;
                    j.data = tmp;
                    String temp = i.nama;
                    i.nama = j.nama;
                    j.nama = temp;
                    int temporary = i.priority;
                    i.priority = j.priority;
                    j.priority = temporary;

                }
                j = j.next;
            }
            i  = i.next;
        }
    }
    static void sortlevel(LinkedList resp){
        Node i = resp.head;
        Node j;
        while(i != null){
            j = i.next;
            while(j != null){
                if(i.priority == j.priority && i.data < j.data){
                    int tmp = i.data;
                    i.data = j.data;
                    j.data = tmp;
                    String temp = i.nama;
                    i.nama = j.nama;
                    j.nama = temp;
                    int temporary = i.priority;
                    i.priority = j.priority;
                    j.priority = temporary;

                }
                j = j.next;
            }
            i  = i.next;
        }
    }
    public static void main(String[] args) {
        LinkedList resp = new LinkedList();
        resp.addlast(24, "S");
        resp.addlast(50, "S");
        resp.addlast(35, "S");
        resp.addlast(40, "S");
        resp.addlast(25, "C");
        resp.addlast(30, "C");
        resp.addlast(29, "C");
        resp.addlast(20, "A");
        resp.addlast(25,"B");
        resp.addlast(30,"B");

        System.out.println("Data Awal : ");
        resp.display();
        Node bantu = resp.head;
        while(bantu != null){
            bantu.setPriority(priority(bantu.nama));
//            System.out.println(bantu.priority);
            bantu = bantu.next;
        }
        System.out.println("Data Akhir : ");
//        System.out.println();
        sortpriority(resp);
        sortlevel(resp);
        resp.display();

    }
}
