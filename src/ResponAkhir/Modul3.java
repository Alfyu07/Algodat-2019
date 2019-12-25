package ResponAkhir;

import java.util.Scanner;

class node{
    String nama;
    node next;
    node tail;
    public node(String nama) {
        this.nama = nama;
    }
}
class Stack{
    node top;
    void push(String nama){
        node baru = new node(nama);
        if(top == null){
            top = baru;
        }else{
            baru.next= top;
            top = baru;
        }
    }
    String pop(){
        if(top == null){
            System.out.println("Stack kosong");
            return " ";
        }
        String simpan = top.nama;
        if(top.next == null){
            top = null;
        }else{
            top = top.next;
        }
        return simpan;
    }
    void display(){
        if(top == null){
            return;
        }else{
            node bantu = top;
            while(bantu != null){
                System.out.print(bantu.nama + " ");
                bantu = bantu.next;
            }
            System.out.println();
        }
    }
}
class Queue{
    node head, tail;
    void enqueue(String nama){
        node baru = new node(nama);
        if(head == null){
            head = tail =  baru;
        }else{
            tail.next = baru;
            tail = baru;
        }
    }
    String dequeue(){
        if(head == null){
            System.out.println("Stack kosong");
            return " ";
        }
        String simpan = head.nama;
        if(head.next == null){
            head = null;
        }else{
            head = head.next;
        }
        return simpan;
    }
    void display(){
        if(head == null){
            return;
        }else{
            node bantu = head;
            while(bantu != null){
                System.out.print(bantu.nama + " ");
                bantu = bantu.next;
            }
            System.out.println();
        }
    }
}
public class Modul3 {
    public static void main(String[] args) {
        String [] hewan ={"Meong", "Kelinci","Rusa","Gagak","Serigala","Orang Utan","Kumbang","Cacing","Jerry","Kambing"};
        Scanner in = new Scanner(System.in);
        Stack steksatu = new Stack();
        Stack stekdua= new Stack();
        Queue quesatu = new Queue();
        Queue quedua = new Queue();
        for(int i = 0; i < 10; i++){
            steksatu.push(hewan[i]);
        }
        System.out.println("Isi Stack satu : ");
        steksatu.display();
        System.out.println();
        for(int i = 0; i<5; i++){
            stekdua.push(steksatu.pop());
        }
        System.out.println("Isi Stack dua : ");
        stekdua.display();
        System.out.println();
        for(int i = 0; i < 10; i++){
            quesatu.enqueue(hewan[i]);
        }
        System.out.println("Isi Queue dua : ");
        quesatu.display();
        System.out.println();

        for(int i = 0; i<5; i++){
            quedua.enqueue(quesatu.dequeue());
        }
        System.out.println("Isi Queue dua : ");
        quedua.display();


    }
}


/*
    - buat 2 stack 2 queue
    - stack pertama push 10 nama heawan
    - queue pertama enquee 10 nama hewan
    - stack ke 2 -> ambil 5 nama hewan dari stack 1 masukin ke stack 2
    - queue ke 2 -> ambil 5 nama hewan dari queue 1 masukin ke queue 2
 */