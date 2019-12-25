package Modul45.basic;

public class LinkedList {
    public Node head;
    public Node tail;
    int size = 0;
    public boolean isEmpty(){
        return head == null;
    }
    public void addlast(int data, String nama){
        Node baru = new Node(data,nama);
        if(isEmpty()){
            head = tail = baru;
        }else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        size++;
    }
    public void addlast(int data){
        Node baru = new Node(data);
        if(isEmpty()){
            head = tail = baru;
        }else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        size++;
    }
    public void addfirst(int data, String nama){
        Node baru = new Node(data, nama);
        if(isEmpty()){
            head = tail = baru;
        }else {
            baru.next = head;
            head.prev = baru;
            head = baru;
        }
        size++;
    }
    public void addfirst(int data){
        Node baru = new Node(data);
        if(isEmpty()){
            head = tail = baru;
        }else {
            baru.next = head;
            head.prev = baru;
            head = baru;
        }
        size++;
    }
    public Node getIndex(int index){
        Node bantu = head;
        for(int i = 0; i<index; i++){
            bantu = bantu.next;
        }
        return bantu;
    }
    public void removeFirst(){
        if(isEmpty()){
            return;
        }
        if(head.next == null){
            head = null;
        }else{
            head = head.next;
            head.prev = null;
        }
    }
    public void removelast(){
        if(isEmpty()){
            return;
        }
        if(head.prev == null){
            head = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
    }
    public Node getMid(){
        int mid = size/2;
        Node bantu = head;
        for(int i = 0; i<mid; i++){
            bantu = bantu.next;
        }
        return bantu;
    }
    public void display(){
        Node bantu = head;
        while(bantu != null){
            System.out.print(" (" +bantu.nama +")lvl." +bantu.data + " - ");
            bantu = bantu.next;
        }
        System.out.println();
    }

}
