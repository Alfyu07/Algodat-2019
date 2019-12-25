import basic.*;
public class TernaryTree {
    public static void main(String[] args) {
        Tree ternary = new Tree();
        int n = 12;
        int [] umur = {14,16,18,14,15,30,13,28,4017,15,17,55};
        int temp[] = new int[n];

        for(int i = 0; i<n; i++){
            temp[i] = umur[i];
        }

        String nama[] = {"Hazel","Lester","Reyna","Lavinia","Dakota","Don","Meg",
                "Grover","Apollo","Thalia","Piper","Rick"};
        String gender[] = {"Female","Male","Female","Female","Male","Male","Female",
                "Male","Male","Female","Female","Male"};
        //bubble sort for finding root
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(temp[i] > temp[j]){
                    int tmp = temp[i];
                    temp[i] = temp[j];
                    temp[j] = tmp;
                }
            }
        }
        int mid = n/2;
        int umurroot = temp[mid];
//        System.out.println(umurroot);
        int root = 0;
        for(int i  = 0; i<n; i++){
            if(umur[i] == umurroot){
                root = i;
                break;
            }
        }
        ternary.addchild(umur[root], nama[root], gender[root]);
        for(int i = 0; i<10; i++){
            if(i != root){
                ternary.addchild(umur[i],nama[i],gender[i]);
            }
        }
        System.out.println("inorder print : ");
        ternary.inOrderprint();

        System.out.println("\npostorder print : ");
        ternary.postOrderprint();

        System.out.println("\npreorder print : ");
        ternary.preOrderprint();


    }
}