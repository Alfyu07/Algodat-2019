package Modul45.basic;

public class Node {
    public int data;
    public int priority;
    public String nama;
    public Node next;
    Node mid;
    public Node prev;
    public Node (int data){
        this.data = data;
    }

    public Node(int data, String nama) {
        this.data = data;
        this.nama = nama;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
