import java.util.Stack;

class simpul{
    int data;
    simpul left;
    simpul right;
    public simpul (int data) {this.data = data;}
}
class linknode{
    int data;
    linknode next;
    public linknode(int data){
        this.data = data;
    }
}
class tree{
    linknode head;
    linknode tail;
    simpul root;
    boolean isEmpty(){
        return root == null;
    }
    void insert(int data){
        insert(root,data);
    }
    void insert(simpul parent,int baru){
        if(isEmpty()) {
            root = new simpul(baru);
            return;
        }
        if(parent.data<baru){
            if(parent.right == null){
                parent.right = new simpul(baru);
            }else{
                insert(parent.right,baru);
            }
        }else{
            if(parent.left == null){
                parent.left = new simpul(baru);
            }else{
                insert(parent.left, baru);
            }
        }
    }

    public simpul getRoot() {
        return root;
    }

    simpul getNode(int cari){
        return getNode(root,cari);
    }
    simpul getNode(simpul parent, int cari){
        if(parent.data == cari){
            return parent;
        }
        if(parent.data < cari){
            if(parent.right == null){
                System.out.println("Tidak ditemukan");
                return null;
            }else{
                return getNode(parent.right,cari);
            }
        }else{
            if(parent.left == null){
                System.out.println("Tidak ditemukan");
                return null;
            }else{
                return getNode(parent.left,cari);
            }
        }
    }
    simpul getmin(simpul parent){
        if(parent.left == null){
            return parent;
        }
        return getmin(parent.left);
    }

    simpul delete(int data){
        return delete(root,data);
    }
    simpul delete(simpul parent, int data){
        if(parent == null) {
            return parent;
        }else if(data < parent.data){
            parent.left = delete(parent.left, data);
        }else if(data > parent.data){
            parent.right = delete(parent.right, data);
        }else{
            if(parent.left == null && parent.right == null){
                parent = null;
            }else if(parent.left == null){
                parent = parent.right;
            }else if(parent.right == null){
                parent = parent.left;
            }else{
                simpul temp = getmin(parent.right);
                parent.data = temp.data;
                parent.right = delete(parent.right,temp.data);
            }
        }
        return parent;
    }
    void inOrderprint(){
        inOrderprint(root);
    }
    void inOrderprint(simpul parent){
        if(parent.left != null){
            inOrderprint(parent.left);
        }
        System.out.print(parent.data + " ");
        if(parent.right != null){
            inOrderprint(parent.right);
        }
    }
    void printlist(){
        linknode bantu = head;
        while(bantu != null){
            System.out.print(bantu.data + "..");
            bantu = bantu.next;
        }
        System.out.println();
    }
    void DFS(int cari){
        Stack<simpul> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            simpul curr = stack.pop();
//            System.out.print(curr.data + " ");
            if(head == null){
                head = tail = new linknode(curr.data);
            }else{
                tail.next = new linknode(curr.data);
                tail = tail.next;
            }
            printlist();
            if(curr.data == cari) return;
            if(curr.left != null){
                stack.add(curr.left);
            }
            if(curr.right != null){
                stack.add(curr.right);
            }
        }
    }
    void postOrderprint(){
        postOrderprint(root);
    }
    void postOrderprint(simpul parent){
        System.out.print(parent.data + " ");
        if(parent.left != null){
            postOrderprint(parent.left);
        }
        if(parent.right != null){
            postOrderprint(parent.right);
        }
    }

}
public class TugasTree {
    public static void main(String[] args) {
        tree test = new tree();
        test.insert(12);
        test.insert(5);
        test.insert(15);
        test.insert(3);
        test.insert(7);
        test.insert(13);
        test.insert(17);
        test.insert(1);
        test.insert(10);
        test.insert(9);
        test.insert(11);
//        System.out.println("============= Data awal =============");
//        System.out.println("inorder : ");
//        test.inOrderprint();
//        System.out.println();
//        System.out.println("preorder : ");
        test.DFS(10);
//        System.out.println();
//        System.out.println("postorder : ");
//        test.postOrderprint();
//        System.out.println();
//        test.delete(5);
//        test.delete(15);
//        test.delete(7);
//        System.out.println("============= Data Akhir =============");
//        System.out.println("inorder : ");
//        test.inOrderprint();
//        System.out.println();
//        System.out.println("preorder : ");
//        test.DFS();
//        System.out.println();
//        System.out.println("postorder : ");
//        test.postOrderprint();
//        System.out.println();
//
//        System.out.println("getNode 10");
//        System.out.println(test.getNode(10).data);
    }
}
