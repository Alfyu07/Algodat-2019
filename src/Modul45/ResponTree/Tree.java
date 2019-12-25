package ResponTree;

public class Tree {
    TreeNode root;

    public void addchild(int nim, String nama){
        TreeNode baru = new TreeNode(nim,nama);
        if(root == null){
            root = baru;
        }else{
            TreeNode bantu = root;
            while(true){
                if(nim < bantu.data){
                    if(bantu.left == null){
                        bantu.left = baru;
                        return;
                    }else{
                        bantu = bantu.left;
                    }
                }else{
                    if(bantu.right == null){
                        bantu.right = baru;
                        break;
                    }else{
                        bantu = bantu.right;
                    }
                }
            }
        }
    }
    void findnode(int nim){
        TreeNode parent = root;
        while(true){
            if(parent.data == nim){
                System.out.print(parent.nama + " (" + parent.data + ") ");
                return;
            }
            if(nim < parent.data){
                if(parent.left == null){
                    System.out.println("Data Tidak Ditemukan ");
                    return;
                }else{
                    parent = parent.left;
                }
            }else{
                if(parent.right == null){
                    System.out.println("Data Tidak Ditemukan ");
                    return;
                }else{
                    parent = parent.right;
                }
            }
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
    public void inOrderprint(){
        inOrderprint(root);
    }
    private void inOrderprint(TreeNode parent){
        if(parent.left != null){
            inOrderprint(parent.left);
        }
        System.out.println(parent.nama +"( " +parent.data + ")" );
        if(parent.right != null){
            inOrderprint(parent.right);
        }
    }
    public void preOrderprint(){
        preOrderprint(root);
    }
    private void preOrderprint(TreeNode parent){
        System.out.println(parent.nama +"( " +parent.data + ")" );
        if(parent.left != null){
            preOrderprint(parent.left);
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
        if(parent.right != null){
            postOrderprint(parent.right);
        }
        System.out.println(parent.nama +"( " +parent.data + ")" );
    }
}
