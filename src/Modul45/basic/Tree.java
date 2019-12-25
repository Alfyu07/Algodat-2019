package basic;
import java.util.LinkedList;

public class Tree {
    TreeNode root;

    public void addchild(int data, String nama, String gender){
        TreeNode parent = root;
        if(root == null){
            root = new TreeNode(data, nama, gender);
            return;
        }
        while (true){
            if(data < parent.data){
                if(parent.left == null){
                    parent.left = new TreeNode(data,nama,gender);
                    return;
                }else{
                    parent = parent.left;
                }
            }else if(parent.data == data){
                if(parent.mid == null){
                    parent.mid = new TreeNode(data,nama,gender);
                    return;
                }else{
                    parent = parent.mid;
                }
            }else{
                if(parent.right == null){
                    parent.right = new TreeNode(data,nama,gender);
                    return;
                }else{
                    parent = parent.right;
                }
            }
        }
    }
    TreeNode bfs(String bapak){
        TreeNode parent = root;
        LinkedList<TreeNode> que = new LinkedList();
        que.add(parent);
        while(!que.isEmpty()){
            TreeNode cur = que.pop();
            if(cur.nama == bapak){
                return cur;
            }
            if(cur.left != null){
                que.add(cur.left);
            }
            if(cur.right != null){
                que.add(cur.right);
            }
        }
        return null;
    }
    int bfs(String bapak, String anak){
        TreeNode parent = root;
        boolean dad = false;
        boolean  child1 = false;
        boolean  child2 = false;
        LinkedList<TreeNode> que = new LinkedList();
        String nm_bapak1 ="";
        String nm_bapak2 ="";
        que.add(parent);
        while(!que.isEmpty()){
            TreeNode cur = que.pop();
            if(cur.nama.equalsIgnoreCase(bapak)){
//                if(child1 || child2) dad = false;
                dad = true;
            }
            if(cur.left != null){
                if(cur.left.nama.equalsIgnoreCase(anak)) {
                    nm_bapak1 = cur.nama;
                    child1 =  true;
                }else if(cur.left.nama.equalsIgnoreCase(bapak)) {
                    nm_bapak2 = cur.nama;
                    child2 = true;
                }
                que.add(cur.left);
            }
            if(cur.right != null){
                if(cur.right.nama.equalsIgnoreCase(anak)) {
                    nm_bapak1 = cur.nama;
                    child1 =  true;
                    break;
                }else if(cur.right.nama.equalsIgnoreCase(bapak)){
                    nm_bapak2 = cur.nama;
                    child2 =  true;
                    break;
                }
                que.add(cur.right);

            }
        }

        if(dad && child1 || dad && child2){
            return 0;
        }
        if(child1 && child2){
            if(nm_bapak1.equalsIgnoreCase(nm_bapak2))
                return 1;
            else return 2;
        }
        return 3;
    }
    public void addAncestor(String baru){
        if(root == null){
            root = new TreeNode(baru);
        }
    }
    public void addchild(String bapak, String baru){
        TreeNode parent = bfs(bapak);
        if(parent == null){
            System.out.println("nama bapak nya salah");
            return;
        }
        if(parent.right != null && parent.left != null){
            System.out.println(bapak + " sudah punya dua anak");
            return;
        }
        if (parent.left == null) {
            parent.left = new TreeNode(baru);
        } else {
            parent.right = new TreeNode(baru);
        }

    }
    TreeNode getmin(TreeNode parent){
        if(parent.left == null){
            return parent;
        }
        return getmin(parent.left);
    }
    TreeNode delete(int data){
        return delete(root,data);
    }
    TreeNode delete(TreeNode parent, int data){
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
                TreeNode temp = getmin(parent.right);
                parent.data = temp.data;
                parent.right = delete(parent.right,temp.data);
            }
        }
        return parent;
    }
    public void findRelation(String orang1, String orang2){
        int levelor1 = getLevel(root,orang1);
        int levelor2 = getLevel(root,orang2);
        int relation = levelor1 - levelor2;
        int bloodline = bfs(orang1,orang2);
        String hasil = "";
        //-1 or1 adalah bapak atau paman
        //-2 berarti orang pertama adalah kakeknya, 2 berarti orang ke dua adalah kakeknya
        //<-3 orang pertama adalah buyut, >3 orang ke2 adalah buyut
        if(relation == 0){
            if(bloodline == 1) hasil = "saudara";
            else if(bloodline == 2) hasil = "sepupu";
        }else if(relation == -1){
            if(bloodline == 0) hasil = "bapak";
            else hasil = "paman";
        }else if(relation == 1){
            if(bloodline == 0) hasil = "anak";
            else hasil = "keponakan";
        }else if(relation == -2){
            hasil = "kakek";
        }else if(relation == 2){
            hasil = "cucu";
        }else if(relation <= -3){
            hasil = "buyut";
        }else if(relation >=3){
            hasil = "cicit";
        }
        System.out.println(orang1 +" adalah " + hasil + " dari " + orang2);
    }
    public int getLevel(TreeNode root, String key){
        return getLevel(root,key, 1);
    }
    private int getLevel(TreeNode parent, String key, int level){
        if(parent == null){
            return 0;
        }
        if(parent.nama.equalsIgnoreCase(key)){
            return level;
        }
        int result = getLevel(parent.left, key, level+ 1);
        if(result != 0){
            return result;
        }
        result = getLevel(parent.right, key, level+ 1);
        return result;


    }
    public void inOrderprint(){
        inOrderprint(root);
    }
    private void inOrderprint(TreeNode parent){
        if(parent.left != null){
            inOrderprint(parent.left);
        }
        System.out.println(parent.nama + " (" +parent.gender+ ") " + parent.data + " Y.O");
        if(parent.mid != null){
            inOrderprint(parent.mid);
        }
        if(parent.right != null){
            inOrderprint(parent.right);
        }
    }
    public void preOrderprint(){
        preOrderprint(root);
    }
    private void preOrderprint(TreeNode parent){
        System.out.println(parent.nama + " ( " +parent.gender+ " ) " + parent.data + " Y.O ");
        if(parent.left != null){
            preOrderprint(parent.left);
        }
        if(parent.mid != null){
            preOrderprint(parent.mid);
        }
        if(parent.right != null){
            preOrderprint(parent.right);
        }
    }
    public void postOrderprint(){
        postOrderprint(root);
    }
    private void postOrderprint(TreeNode parent){
        if(parent.left != null){
            postOrderprint(parent.left);
        }
        if(parent.mid != null){
            postOrderprint(parent.mid);
        }
        if(parent.right != null){
            postOrderprint(parent.right);
        }
        System.out.println(parent.nama + "( " +parent.gender+ " ) " + parent.data + " Y.O ");
    }
}
