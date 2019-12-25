package basic;

public class TreeNode {
    public int data;
    public String nama;
    public String gender;
    public TreeNode left;
    public TreeNode mid;
    public TreeNode right;

    public TreeNode(int data, String nama) {
        this.data = data;
        this.nama = nama;
    }

    public TreeNode(String nama) {
        this.nama = nama;
    }

    public TreeNode(int data, String nama, String gender) {
        this.data = data;
        this.nama = nama;
        this.gender = gender;
    }

}
