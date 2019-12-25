import java.util.Random;

class node {
   int data;
   node next;
   node prev;
   public node (int data){
       this.data = data;
   }
}
class LinkedList {
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
   public int bubbleSort(){
       int sign = 0;
       node i = head;
       node j;
       sign++;
       while(i != null){
           j = i.next;
           while(j != null){
               if(i.data > j.data){
                   int tmp = i.data;
                   i.data = j.data;
                   j.data = tmp;

               }
               j = j.next;
               sign++;
           }
           i = i.next;

       }
       System.out.println("Bubble Sort selesai pada proses ke : " + sign);
       return sign;
   }
   public  int selectionSort(){
       node i = head;
       node j,k = null;
       int sign = 0;
       while(i != null){
           j = i; int min = Integer.MAX_VALUE;
           int tmp = i.data;
           while(j != null){
               if(j.data < min){
                   min = j.data;
                   k = j;
               }
               j = j.next;
           }
           i.data = k.data;
           k.data = tmp;
           sign++;
           i = i.next;
       }
       System.out.println("Selection Sort selesai pada proses ke : " + sign);
       return sign;
   }
   public int insertionSort(){
       node i = head.next;
       node j;
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
       System.out.println("insertion sort selesai pada proses ke : " + sign);
       return sign;
   }
}

public class jurnal1 {
   static void copylist (LinkedList awal, LinkedList hasil){
       node bantu = awal.head;
       node bantu2 = hasil.head;
       while(bantu != null){
           bantu2.data = bantu.data;
           bantu = bantu.next;
           bantu2.next = bantu2.next;
       }
   }
   public static void main(String[] args) {
       Random rand = new Random();
       int min = Integer.MAX_VALUE;
       int sign [] = new int[3];
       LinkedList awal = new LinkedList();
       LinkedList list = awal;
       for(int i = 0; i<21; i++){
           awal.addlast(rand.nextInt(100));
       }

       System.out.println("\nNomor pemain yang masih acak : ");
       awal.display();
       System.out.println("\nBubble Sort : ");
       System.out.println("=======================");
       sign[0] = list.bubbleSort();
       min = Math.min(min,sign[0]);
       list.display();
       System.out.println("\nSelection Sort : ");
       System.out.println("=======================");
       copylist(awal,list);
       sign[1] = list.selectionSort();
       min = Math.min(min,sign[1]);
       list.display();
       System.out.println("\nInsertion Sort : ");
       System.out.println("=======================");
       copylist(awal,list);
       sign[2] = list.insertionSort();
       min = Math.min(min,sign[2]);
       list.display();
       System.out.println("\nMenampilkan pemain starter : ");
       node bantu = list.head;
       for(int i = 0; i<11; i++){
           System.out.print(bantu.data + " ");
           bantu = bantu.next;
       }
       System.out.println();
           if(min == sign[0]){
               System.out.println("\nAlgoritma Sorting paling efsien : Bubble Sort");
           }else if(min == sign[1]){
               System.out.println("\nAlgoritma Sorting paling efsien : Selection Sort");
           }else{
               System.out.println("\nAlgoritma Sorting paling efsien : Insertion Sort");
           }



   }
}
