package lainlain;

class Treenode{
   int data;
   Treenode left;
   Treenode right;
   public Treenode(int data){
       this.data = data;
   }
   void insert(int number){
       if(number < data){
           if(left == null){
               left = new Treenode(number);
           }else{
               left.insert(number);
           }
       }else if(number >= data){
           if(right == null){
               right = new Treenode(number);
           }else{
               right.insert(number);
           }
       }
   }
   boolean contains(int value){
       if(value == data){
           return true;
       }else if(value < data){
           if(left == null){
               return false;
           }else{
               return left.contains(value);
           }
       }else{
           if(right == null){
               return false;
           }else{
               return right.contains(value);
           }
       }
   }
   void inOrderPrint(){
       if(left != null){
           left.inOrderPrint();
       }
       System.out.print(data + " ");
       if(right != null){
           right.inOrderPrint();
       }
   }
   void postOrderPrint(){
       if(left != null){
           left.postOrderPrint();
       }
       if(right != null){
           right.postOrderPrint();
       }
       System.out.print(data + " ");
   }

   void preOrderPrint(){
       System.out.print(data + " ");
       if(left != null){
           left.postOrderPrint();
       }
       if(right != null){
           right.preOrderPrint();
       }
   }
}
class binarysearchtree{
   Treenode root;

}

public class binarytree {
   public static void main(String[] args) {
       Treenode tree = new Treenode(5);
       tree.insert(1);
       tree.insert(2);
       tree.insert(3);
       tree.insert(4);
       tree.insert(5);
       tree.insert(5);
       tree.insert(6);
       tree.insert(7);
//        tree.inOrderPrint();
//        System.out.println();
//        tree.preOrderPrint();
//        System.out.println();
       tree.inOrderPrint();

   }

}
