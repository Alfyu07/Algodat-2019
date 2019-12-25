//package lainlain;
//
//import java.util.Scanner;
//
//class expressiontree{
//
//    class treenode {
//        char data;
//        treenode left, right;
//
//        public treenode(char data) {
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }
//    class stacknode{
//        treenode node;
//        stacknode next;
//
//        public stacknode(treenode node) {
//            this.node = node;
//        }
//    }
//    private static stacknode Top;
//
//    public expressiontree(){
//        Top=null;
//    }
//    private void push(treenode baru){
//        if(Top==null){
//            Top = new stacknode(baru);
//        }
//        else {
//            stacknode rindu = new stacknode(baru);
//            rindu.next = Top;
//            Top=rindu;
//        }
//    }
//    private treenode pop(){
//        if(Top==null){
//            System.out.println("Kosong Hehe");
//        }
//        else{
//            treenode apus = Top.node;
//            Top=Top.next;
//            return apus;
//        }
//        return null;
//    }
//    private boolean angka(char angka){
//        return (angka>= '0' && angka<='9') || (angka >='A' && angka <='Z') ||(angka >='a' && angka <='z');
//    }
//    private boolean operator(char op){
//        return op=='+' || op=='*' || op=='-' || op=='/';
//    }
////    private void insert(char nilai){
////        try {
////            if(angka(nilai)){
////                treenode nadir = new treenode(nilai);
////                push(nadir);
////            }
////            else if(operator(nilai)){
////                treenode nadir = new treenode(nilai);
////                nadir.left = pop();
////                nadir.right = pop();
////                push(nadir);
////            }
////        }
////        catch (Exception e){
////            System.out.println("Gagal hehe");
////        }
////    }
//    private void insert(char nilai){
//        try {
//            if(angka(nilai)){
//                treenode nadir = new treenode(nilai);
//                push(nadir);
//            }
//            else if(operator(nilai)){
//                treenode nadir = new treenode(nilai);
//                nadir.left = pop();
//                nadir.right = pop();
//                push(nadir);
//            }
//        }
//        catch (Exception e){
//            System.out.println("Gagal hehe");
//        }
//    }
//    public void bentuktree(String nama){
//        for(int i=nama.length()-1; i>= 0; i--){
//            insert(nama.charAt(i));
//        }
//
//    }
//    private void postorder(treenode baru){
//        if(baru!=null){
//            postorder(baru.left);
//            postorder(baru.right);
//            System.out.print(baru.data);
//        }
//    }
//    public void postfix(){
//        postorder(Top.node);
//    }
//    private void inorder(treenode baru){
//        if(baru!=null){
//            inorder(baru.left);
//            System.out.print(baru.data);
//            inorder(baru.right);
//        }
//    }
//    public void infix(){
//        inorder(Top.node);
//    }
//    private void preorder(treenode baru){
//        if(baru!=null){
//            System.out.print(baru.data);
//            preorder(baru.left);
//            preorder(baru.right);
//        }
//    }
//    public void prefix(){
//        preorder(Top.node);
//    }
//}
//public class TreeHaidar{
//    public static void main(String[] args) {
//        expressiontree tree = new expressiontree();
//
//        Scanner in = new Scanner(System.in);
//        System.out.println("Masukkan Data prefix : ");
//        tree.bentuktree(in.next());
//        System.out.println("Prefixnya : ");
//        tree.prefix();
//        System.out.println();
//        System.out.println("Infixnya : ");
//        tree.infix();
//        System.out.println();
//        System.out.println("PostFixnya : ");
//        tree.postfix();
//    }
//
//}