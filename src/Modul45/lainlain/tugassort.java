package lainlain;

import java.util.Random;
class node {
    int data;
    node next;
    node prev;
    public node (int data){
        this.data = data;
    }
}
class lingling {
    node head;
    node tail;
    int size = 0;
    public boolean isEmpty(){
        return head == null;
    }
    public void addlast(int data){
        node baru = new node(data);
        if(isEmpty()){
            head = tail = baru;
        }else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        size++;
    }
    public void display(){
        node bantu = head;
        int n = 11;
        while(bantu != null){
            System.out.print(bantu.data + " ");
            bantu = bantu.next;
        }
        System.out.println();
    }
}

public class tugassort {
    static boolean isPrime(int number){
        int faktor = 0;
        for(int i = 1; i<=number; i++){
            if(number % i == 0) faktor++;
        }
        if(faktor == 2) return true;
        return false;
    }
    static boolean isGenap(int number){
        return number%2 == 0;
    }
    static void bubbleSort(lingling list){
        node i = list.head;
        node j;
        while(i != null){
            j = i.next;
            while(j != null){
                if(isGenap(j.data) && i.data > j.data){
                    int tmp = i.data;
                    i.data = j.data;
                    j.data = tmp;

                }
                j = j.next;
            }
            i = i.next;

        }
    }
    static  void selectionSort(lingling list){
        node i = list.head;
        node j,k = null;
        while(i != null){
            j = i; int min = Integer.MAX_VALUE;
            int tmp = i.data;
            while(j != null){
                if(isPrime(j.data) && j.data < min){
                    min = j.data;
                    k = j;
                }
                j = j.next;
            }
            i.data = k.data;
            k.data = tmp;
            i = i.next;
        }
    }
    static void insertionSort(lingling list){
       node i = list.tail.prev;
       node j;
       while(i != null){
           j = i.next;
           int key = i.data;
           if(!isGenap(i.data)){
               while(j != null){
                   if(!isGenap(j.data) && j.data <= key){
                       break;
                   }
                   j.prev.data = j.data;
                   j = j.next;
               }
               if(j == null){
                   list.tail.data = key;
               }else{
                   j.prev.data = key;
               }
           }
           i = i.prev;
       }

    }
    static void copylist(lingling awal, lingling hasil){
        node i = awal.head;
        node j = hasil.head;
        while(i != null){
            j.data = i.data;
            i = i.next;
            j = j.next;
        }
    }
    public static void main(String[] args) {
        lingling awal = new lingling();
        lingling list  = new lingling();
        Random rand = new Random();
        for(int i = 0; i<10; i++){
            int acak = rand.nextInt(100);
            if(acak == 0){
                acak = rand.nextInt(100);
                i--;
            }
            awal.addlast(acak);
            list.addlast(acak);
        }

        System.out.println("================= Display Awal =================");
        awal.display();
        System.out.println("\nGenap di kiri pake bubble sort : ");
        bubbleSort(list);
        list.display();

        copylist(awal,list);
        System.out.println("\nGanjil di kanan insertion sort : ");
        insertionSort(list);
        list.display();

        copylist(awal,list);
        System.out.println("\nprima di kiri selection sort : ");
        selectionSort(list);
        list.display();
        for(int i = 0; i<100; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }
}
