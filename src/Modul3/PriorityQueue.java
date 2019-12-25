package Modul3;

import Basic.Node;
import Basic.Vertex;

public class PriorityQueue {
    public Node head;
    public Node tail;
    public boolean isEmpty(){
        return head == null;
    }

    public void addpriority(int data){
        Node baru = new Node(data);
        if (head == null) {
            head = tail = baru;
            return;
        }
        Node bantu = head;
        while(bantu != null){
            if(head.number > baru.number){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(tail.number <= baru.number){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(baru.number >= bantu.number && baru.number < bantu.next.number ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }
    }
    public void addpriority(Vertex data, int [] weight){
        Node baru = new Node(data);
        if (head == null) {
            head = tail = baru;
            return;
        }
        Node bantu = head;
        while(bantu != null){
            if(weight[head.data.label] > weight[baru.data.label]){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(weight[tail.data.label] <= weight[baru.data.label]){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(weight[baru.data.label] >= weight[bantu.data.label] && weight[baru.data.label] < weight[bantu.next.data.label] ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }
    }
    public void addpriority(String nama,int number ){
        Node baru = new Node(number,nama);
        if (head == null) {
            head = tail = baru;
            return;
        }
        Node bantu = head;
        while(bantu != null){
            if(head.data.label > baru.data.label){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(tail.data.label <= baru.data.label){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(baru.data.label >= bantu.data.label && baru.data.label < bantu.next.data.label ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }

    }
    public int dequeue(){
        int simpan = head.number;
        if(head == null){
            return -1;
        }else if(head == tail){
            head = null;
        }else{
            head = head.next;
        }
        return simpan;
    }
    public void display(){
        Node bantu = head;
        while(bantu != null){
            System.out.println(bantu.nama + "(" + bantu.number + ")");
            bantu = bantu.next;
        }
    }
}
