//package ResponAkhir;
//
//import java.util.Random;
//
//class node{
//    int data;
//    node next;
//    node prev;
//
//    public node(int data) {
//        this.data = data;
//    }
//}
//class Circular{
//    node head, tail;
//    void setCirc(){
//        head.prev = tail;
//        tail.next = head;
//    }
//    boolean isEmpty(){
//        return head == null;
//    }
//    void addlast(int data){
//        node baru = new node(data);
//        if(head == null){
//            head = tail = baru;
//        }else{
//            tail.next = baru;
//            baru.prev = tail;
//            tail = baru;
//        }
//        setCirc();
//    }
//    void removefirst(){
//        if(head == null){
//            return;
//        }else if(head == tail){
//            head = null;
//            tail = null;
//        }else{
//            head = head.next;
//        }
//        setCirc();
//    }
//    void removelast(){
//        if(head == null){
//            return;
//        }else if(head == tail){
//            head = tail = null;
//        }else{
//            tail = tail.prev;
//        }
//        setCirc();
//    }
//    void display(){
//        node bantu = head;
//        while(true){
//            System.out.print(bantu.data + " ");
//            if(bantu.next == head) break;
//            bantu = bantu.next;
//        }
//        System.out.println();
//    }
//}
//public class Modul2 {
//    public static void main(String[] args) {
//        Random rand = new Random();
//        Circular resp = new Circular();
//        for(int i = 0; i<10; i++){
//            resp.addlast(rand.nextInt(10));
//        }
//        resp.display();
//        try{
//            while(!resp.isEmpty()){
//                resp.removefirst();
////                resp.removelast();
//                resp.display();
//            }
//        }catch(NullPointerException e){
//            System.out.println("finish");
//        }
//    }
//}
///*
//buat circular linked list
//- tambah data bebas
//- tampilkan hapus semuanya
//- tampilkan lagi
// */