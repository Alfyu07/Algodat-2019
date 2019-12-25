package lainlain;

import java.util.Random;
import java.util.Scanner;

class node{
   String nama;
   int nim;
   stack bukupinjam;
   node next;
   public node(String nama, int nim){
       this.nama = nama;
       this.nim = nim;
   }
   public void setBukupinjam(stack bukupinjam) {
       this.bukupinjam = bukupinjam;
   }
}
class stack{
   class buku{
       String judul;
       buku next;
       public buku(String judul){
           this.judul = judul;
       }
   }
   buku top;
   boolean isEmpty(){
       return top == null;
   }
   void push(String judul){
       buku baru = new buku(judul);
       if(top == null){
           top = baru;
           return;
       }
       baru.next = top;
       top = baru;
   }
   String pop(){
          if(top == null){
              System.out.println("kosong");
          }else if(top.next == null){
              top = null;
          }else{
              String simpan = top.judul;
              top = top.next;
              return simpan;
          }
      return null;
   }
   void display(){
       buku bantu = top;
       int i = 1;
       while(bantu != null){
           System.out.println(i+". " +bantu.judul);
           bantu = bantu.next;
           i++;
       }
   }
}
class Queue{
   node first;
   node last;
   void enqueue(String nama, int nim){
       node baru = new node(nama, nim);
       if(first == null){
           first = last = baru;
           return;
       }
       last.next = baru;
       last = baru;
   }
   void enqueue(node baru){
       if(first == null){
           first = last = baru;
           return;
       }
       last.next = baru;
       last = baru;
   }
   void sortqueue(){
       node bantu= first;
       while(bantu != null){
           node bantu2 = bantu.next;
           while (bantu2 != null){
               if(bantu.nim > bantu2.nim){
                   int tmp = bantu.nim;
                   bantu.nim = bantu2.nim;
                   bantu2.nim = tmp;

                   String temp = bantu.nama;
                   bantu.nama = bantu2.nama;
                   bantu2.nama = temp;
               }

               bantu2 = bantu2.next;
           }
           bantu = bantu.next;
       }
   }
   node dequeue(){
       if(first == null){
           System.out.println("Kosong");
       }else if(first.next == null){
           node simpan = first;
           first = last = null;
           return simpan;
       }else{
           node simpan = first;
           first = first.next;
           return simpan;
       }
       return null;
   }
   boolean isEmpty(){
       return first == null;
   }
   void display(){
       if(first == null){
           System.out.println("Antrian kosong");
           return;
       }
       node bantu = first;
       while(bantu != null){
           System.out.println("[" + bantu.nama +" "+ bantu.nim +"]" );
           bantu = bantu.next;
       }
   }
}

public class Respon3 {

   public static void main(String[] args) {
       Random rand = new Random();
       Scanner in = new Scanner(System.in);
       Queue acak = new Queue();
       Queue setelahminjam = new Queue();
       stack pinjambuku;


       /* bang saya males masukin nama setiep kali run jadinya saya buat kek gini*/
       String [] kelompok = {"Ayu", "Awal", "Wahyu","Yan","Mira","Haidar","Fikri","Yuli"};
       int [] nim = {8,37,60,95,35,32,98,45};
       String[] judulbuku = {"Algodat", "Basis Data", "Jaringan komputer", "Metode Nuemrik", "Java", "C++", "SQL", "Web"};
       System.out.println("Anggota Kelompok 10 berbaris acak di depan perpus");

       //acak barisan
       int i = 0;
       int k = 0;

       while(i < kelompok.length){
           acak.enqueue(kelompok[i], nim[i]);
           i++;
       }
       System.out.println("Barisan Perpus yang masih acak");
       acak.display();
       System.out.println("==============================");
       System.out.println("3 Orang pertama mengambil buku");
       System.out.println("=====================================");
       int jdl = judulbuku.length;
       for( i = 0; i<3; i++){
           node simpan = acak.dequeue();
           pinjambuku = new stack();
           for(k = 0; k<5; k++){
               pinjambuku.push(judulbuku[rand.nextInt(jdl)]);
           }
           simpan.setBukupinjam(pinjambuku);
           System.out.println("\nbuku yang dipinjam  "+ simpan.nama +" :");
           simpan.bukupinjam.display();
           setelahminjam.enqueue(simpan);
       }

       System.out.println("\n===========================================");
       System.out.println("Barisan Setelah diurutkan : ");
       acak.sortqueue();
       acak.display();
       System.out.println("\n===========================================");
      while(!acak.isEmpty()){
          node simpan = acak.dequeue();
          pinjambuku = new stack();
          for(k = 0; k<5; k++){
              pinjambuku.push(judulbuku[rand.nextInt(8)]);
          }
          simpan.setBukupinjam(pinjambuku);
          System.out.println("\nbuku yang dipinjam  "+ simpan.nama +" :");
          simpan.bukupinjam.display();
          setelahminjam.enqueue(simpan);
       }
       setelahminjam.sortqueue();

       System.out.println("\nDaftar Siswa yang meminjam buku : ");
       System.out.println("=====================================");
      while(!setelahminjam.isEmpty()){
           node simpan = setelahminjam.dequeue();
           System.out.println("\n[" + simpan.nama + " " +simpan.nim + " ] meminjam : ");
           simpan.bukupinjam.display();
      }
   }
}
