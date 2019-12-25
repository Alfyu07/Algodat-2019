package lainlain;

import java.util.Random;
class Node {
    int data;
    Node next;
    Node prev;
    public Node (int data){
        this.data = data;
    }
}
class linglist {
    Node head;
    Node tail;

    public boolean isEmpty(){
        return head == null;
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
    }
    public void display(){
        Node bantu = head;
        int n = 11;
        while(bantu != null){
            System.out.print(bantu.data + " ");
            bantu = bantu.next;
        }
        System.out.println();
    }
    public int insertionSort(){
        Node i = head.next;
        Node j;
        int sign = 0;
        while(i != null){
            j = i.prev;
            int key = i.data;
            while(j != null && j.data > key){
                sign++;
                j.next.data = j.data;
                j = j.prev;
            }
            if(j == null){
                head.data = key;
            }else{
                j.next.data = key;
            }
            i = i.next;
        }
        return sign;
    }
}

public class jurnal2 {

    static boolean isFibo(int number){
        int a = 0;
        int b = 1;
        int c = 0;
        while(c < number){
            c = a+b;
            a = b;
            b = c;
        }
        if(c == number){
            return true;
        }
        return false;
    }
    static boolean isPrime(int number){
        int faktor = 0;
        for(int i = 1; i<= number; i++){
            if(number % i == 0){
                faktor++;
            }
        }
        if(faktor == 2){
            return true;
        }
        return false;
    }
    static void cariPrime(linglist list, linglist dirawat){
        Node bantu = list.head;
        while(bantu != null){
            if(isPrime(bantu.data)){
                dirawat.addlast(bantu.data);
                System.out.print(bantu.data + " ");
            }
            bantu = bantu.next;
        }
        System.out.println();
    }
    static void cariFibo(linglist list, linglist dirawat){
        Node bantu = list.head;
        while(bantu != null){
            if(isFibo(bantu.data)){
                dirawat.addlast(bantu.data);
                System.out.print(bantu.data + " ");
            }
            bantu = bantu.next;
        }
        System.out.println();
    }

    static void displayarray(int [] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Random rand = new Random();
        linglist terran= new linglist();
        linglist protoss = new linglist();
        linglist dirawat = new linglist();
        for(int i = 0; i<30; i++){
            int random = rand.nextInt(100);
            if(random > 50){
                protoss.addlast(random);
            }else{
                terran.addlast(random);
            }
        }
        System.out.println("\nData Terran : ");
        terran.display();
        System.out.println("\nData Protoss");
        protoss.display();
        System.out.println("\n=======================================");
        System.out.println("Data orang terran yang dirawat : ");
        cariPrime(terran,dirawat);
        System.out.println("\nData orang Protoss yang dirawat : ");
        cariFibo(protoss,dirawat);
        System.out.println("\nData orang-orang yang dirawat karena parasit : ");
        dirawat.display();
    }
}