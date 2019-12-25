package lainlain;

import  java.util.Scanner;

class ExpressionTree{
   class TreeNode{
       char data;
       TreeNode left;
       TreeNode right;
       TreeNode(char data){
           this.data = data;
       }
   }
   class StackNode{
       StackNode next;
       TreeNode node;
       public StackNode(TreeNode node){
           this.node = node;
       }
   }
   private  static StackNode Top;
   public ExpressionTree(){
       Top = null;
   }
   private void push(TreeNode masuk){
       if(Top == null){
           Top = new StackNode(masuk);
           return;
       }
       StackNode baru2 = new StackNode(masuk);
       baru2.next = Top;
       Top = baru2;
   }
   private TreeNode pop(){
       if(Top == null){
           System.out.println("Error");
       }else{
           TreeNode baru = Top.node;
           Top = Top.next;
           return baru;
       }
       return null;
   }
   private void insert(char value){
      try {
          if (angka(value)){
              TreeNode baru2 = new TreeNode(value);
              push(baru2);
          }else if(operator(value)) {
              TreeNode baru2 = new TreeNode(value);
              baru2.left = pop();
              baru2.right = pop();
              push(baru2);
          }
      }catch (Exception e){
          System.out.println("Error");
      }
   }
   public void bentukinfix(String tes){
       for(int i = 0; i<tes.length(); i++){
           insert(tes.charAt(i));
       }
   }

   public void bentuktree(String tes){
       for(int i = tes.length()-1; i>= 0; i--){
           insert(tes.charAt(i));
       }
   }
   private void postOrder(TreeNode baru){
       if(baru != null){
           postOrder(baru.left);
           postOrder(baru.right);
           System.out.print(baru.data);
       }
   }
   public void postFix()
   private void inOrder(TreeNode baru){
       if(baru != null){
           postOrder(baru.left);
           System.out.print(baru.data);
           postOrder(baru.right);
       }
   }
   public void infix(){
       postOrder(Top.node);
   }
   private void preOrder(TreeNode baru){
       if(baru != null){
           postOrder(baru.left);
           System.out.print(baru.data);
           postOrder(baru.right);
       }
   }
   public void prefix(){
       postOrder(Top.node);
   }
   private boolean angka(char angka){
       return (angka>= '0' && angka<='9') || (angka >='A' && angka <='Z') ||(angka >='a' && angka <='z');
   }
   private boolean operator(char angka){
       return angka == '+' || angka == '*' || angka == '-' || angka == '/' ;
   }
}

public class ExpressionTreeTest{
   public static void main(String[] args) {
       System.out.println();
       Scanner in = new Scanner(System.in);
       System.out.println("Masukkan data prefix : ");
       ExpressionTree tree = new ExpressionTree();
       tree.bentuktree(in.next());
       System.out.println("\nPostfix : ");
       tree.postFix();
       System.out.println("\nInfix : ");
       tree.infix();
       System.out.println("\nPrefix : ");
       tree.prefix();

   }
}