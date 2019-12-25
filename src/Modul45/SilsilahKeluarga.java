import basic.*;

import java.util.Scanner;

public class SilsilahKeluarga {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Tree silsilah = new Tree();
        silsilah.addAncestor("David");
        silsilah.addchild("David", "Diki");
        silsilah.addchild("David", "Budi");
        silsilah.addchild("Budi", "Rido");
        silsilah.addchild("Budi", "Rozi");
        silsilah.addchild("Rozi", "Adam");
        silsilah.addchild("Rozi", "Ande");
        silsilah.addchild("Adam", "Falah");
        silsilah.addchild("Diki", "Naim");
        silsilah.addchild("Naim", "Wahyu");
        silsilah.addchild("Naim", "Zikri");
        silsilah.addchild("Wahyu", "Aziz");
        System.out.println("Masukkan nama orang pertama : ");
        String orang1 = in.next();
        System.out.println("Masukkan nama orang pertama : ");
        String orang2 =in.next();
        System.out.println("Hubungan antara orang pertama dan kedua : ");
        silsilah.findRelation(orang1, orang2);


    }
}

//      david
//     /      \
//     budi     diki
//    /   \        \
//  rido  rozi     naim
//        / \       /   \
//      adam ande wahyu zikri
//       /           \
//     falah         aziz


