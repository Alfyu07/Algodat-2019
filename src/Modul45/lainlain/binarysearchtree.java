package lainlain;
import java.util.Scanner;
import java.util.Stack;

class LLnode{
   int data;
   LLnode next;
   public  LLnode(int data){
       this.data = data;
   }
}
class Treenode{
   LLnode head;
   LLnode tail;
   String mhs,nim,dsn,nodsn;
   Treenode left;
   Treenode right;
   public Treenode(String mhs,String nim, String dsn, String nodsn){
       this.mhs = mhs;
       this.nim = nim;
       this.dsn = dsn;
       this.nodsn = nodsn;
   }
   void insert(String namabaru, String nimbaru, String dsnbaru , String nodsnbaru){
       if(mhs.compareToIgnoreCase(namabaru)>0){
           if(left == null){
               left = new Treenode(namabaru,nimbaru,dsnbaru,nodsnbaru);
           }else{
               left.insert(namabaru,nimbaru,dsnbaru,nodsnbaru);
           }
       }else{
           if(right == null){
               right = new Treenode(namabaru,nimbaru,dsnbaru,nodsnbaru);
           }else{
               right.insert(namabaru,nimbaru,dsnbaru,nodsnbaru);
           }
       }
   }


   void contain(String cari){
       if(mhs.equalsIgnoreCase(cari)){
           System.out.println(mhs + " " + nim + " " + dsn + " " + nodsn);
           return;
       }else{
           if(mhs.compareToIgnoreCase(cari)>0){
               if(left == null){
                   System.out.println("Tidak ditemukan");
                   return;
               }else{
                   left.contain(cari);
               }
           }else{
               if(right == null){
                   System.out.println("Tidak ditemukan");
                   return;
               }else{
                   right.contain(cari);
               }
           }
       }
   }
   void postOrderprint(){
       if(left != null){
           left.postOrderprint();
       }
       if(right != null){
           right.postOrderprint();
       }
       System.out.println(mhs + " " + nim + " " + dsn + " " + nodsn);
   }
   void inOrderprint(){
       if(left != null){
           left.inOrderprint();
       }
       System.out.println(mhs + " " + nim + " " + dsn + " " + nodsn);
       if(right != null){
           right.inOrderprint();
       }
   }
   void printLL(){
       LLnode bantu = head;
       while(bantu != null){
           System.out.print(bantu.data + " ");
           bantu = bantu.next;
       }
       System.out.println();
   }
   void preOrderprint(int cari){
       Stack<Treenode> stack = new Stack<>();
       stack.add(root);
       while(!stack.isEmpty()){

       }

   }
}


public class binarysearchtree {
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int pilih = -1;
       int root = 0;
       String nama, nim, dosen, nodsn;
       Treenode tree = new Treenode("pandu", "018017","pak ariyan", "83231");
       while(pilih != 0) {
           System.out.println("========= Pilih Menu =========");
           System.out.println("1. Tambah data");
           System.out.println("2. Cari data");
           System.out.println("3. Tampilkan data");
           System.out.println("0. Keluar");
           System.out.print("pilih : ");
           pilih = in.nextInt();
           switch (pilih) {
               case 1:
                   System.out.println("======= TAMBAH DATA ======= ");
                   System.out.print("Masukkan nama mahasiswa : ");
                   nama = in.next();
                   System.out.print("Masukkan nim mahasiswa : ");
                   nim = in.next();
                   System.out.print("Masukkan dosen pembinbing  : ");
                   dosen = in.next();
                   System.out.print("Masukkan no telp dosen pembimbing : ");
                   nodsn = in.next();
                   tree.insert(nama,nim,dosen,nodsn);
                   break;
               case 2:
                   System.out.println("======= CARI DATA ======= ");
                   System.out.print("Masukkan data yang dicari : ");
                   String cari  = in.next();
                   tree.contain(cari);
                   break;
               case 3:
                   System.out.println("Inorder : ");
                   tree.inOrderprint();
                   System.out.println();
                   System.out.println("PreOrder : ");
//                    tree.preOrderprint();
                   System.out.println();
                   System.out.println("Postorder : ");
                   tree.postOrderprint();
                   System.out.println();
                   break;
               case 0:
                   break;
               default:
                   System.out.println("salah masukan");
           }
       }
       System.out.println("========== Terima Kasih ==========");

   }
}
