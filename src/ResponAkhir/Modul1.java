//package ResponAkhir;
//
//import java.util.Scanner;
//
//class node{
//    int data;
//    node next;
//
//    public node(int data) {
//        this.data = data;
//    }
//}
//class linkedlist{
//    node head;
//    node tail;
//    void addlast(int data){
//        node baru = new node(data);
//        if(head == null){
//            head = tail = baru;
//        }else{
//            tail.next = baru;
//            baru = tail;
//        }
//    }
//    void addfirst(int data){
//        node baru = new node(data);
//        if(head == null){
//            head = tail = baru;
//        }else{
//            baru.next = head;
//            head = baru;
//        }
//    }
//    void display(){
//        node bantu = head;
//        while(bantu != null){
//            System.out.println(bantu.data);
//            bantu = bantu.next;
//        }
//    }
//}
//public class Modul1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Masukkan tanggal lahir (8 digit) : ");
//        int tanggal = in.nextInt();
//        linkedlist save = new linkedlist();
//        int [] lahir = new int[8];
//        int x = lahir.length-1;
//        while(tanggal != 0){
//            lahir[x] = tanggal % 10;
//            tanggal/= 10;
//            x--;
//        }
//        int [] tmp = new int[8];
//        for(int j = 0; j<lahir.length; j++){
//            tmp[j] = lahir[j];
//        }
//
////        for(int i = 0; i<lahir.length; i++){
////            save.addlast(lahir[i]);
////        }
//
//        for(int i = 0; i<tmp.length; i++){
//            for(int j = i+1; j<tmp.length; j++){
//                if(tmp[i] > tmp[j]){
//                    int temp = tmp[i];
//                    tmp[i] = tmp[j];
//                    tmp[j] = temp;
//                }
//            }
//        }
//        int max = 0;
//        for(int i = 0; i<tmp.length; i++){
//            max = i+1;
//            boolean sama = false;
//            for(int j = i+1; j<tmp.length; j++){
//               if(tmp[i] == tmp[j]){
//                   max = j;
//                   sama = true;
//               }else if(!sama && tmp[i] != tmp[j]){
//                   save.addlast(tmp[i]);
//                   save.addlast(tmp[j]);
//                   break;
//               }
//            }
//            i = max;
//        }
//
//        System.out.println("Tampilan Akhir : ");
//        save.display();
//
//    }
//}
//
///* 25072000 // urut 0002257 //simpan data pertama, curr = 0
//    buatin saya program inputannya array dengan dapat mengeluarkan output linkedlist
//    - input tanggal lahir secara array tambah salah satu angka pilih salah di bagian tanggal lahir
//    - tampilinnya angka yang ndak berulang terus outputnya di linked list
// */