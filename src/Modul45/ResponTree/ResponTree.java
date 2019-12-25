package ResponTree;

import java.util.Scanner;

public class ResponTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] arraynim = {18060, 18056, 19092, 19023, 19034, 19028,  19038, 19054, 19065, 19067,
                19028, 19045, 18029, 20023, 17034, 17352, 16083, 16834, 15034, 15032};
        String [] arraynama = {"Alfyu", "Mare", "Dyne","Ayu","Mira","Haidar","Yan", "Fikri","Awal","Yuli",
                "Aghi", "Cani", "Aghil","Afif","Jumhur","Ridho","Pandu", "Iqbal","Syahid","Sulthon"};
        Tree resp = new Tree();
        for(int i = 0; i<arraynim.length; i++){
            resp.addchild(arraynim[i], arraynama[i]);
        }
        String nama;
        int nim;
        int pilih = -1;
        while(pilih != 0){
            System.out.println("\n=========== MENU ===========");
            System.out.println("1. Tambah data");
            System.out.println("2. Cari data");
            System.out.println("3. Tampilkan data");
            System.out.println("4. Delete data");
            System.out.print("Pilih : ");
            pilih = in.nextInt();
            switch (pilih){
                case 1:
                    System.out.print("Masukkan nama mahasiswa : ");
                    nama = in.next();
                    System.out.print("Masukkan nim mahasiswa : ");
                    nim = in.nextInt();
                    resp.addchild(nim,nama);
                    break;
                case 2:
                    System.out.print("Masukkan nim yang dicari : ");
                    resp.findnode(in.nextInt());
                    break;
                case 3:
                    System.out.println("InOrderPrint : ");
                    resp.inOrderprint();
                    System.out.println();
                    System.out.println("PreOrderPrint : ");
                    resp.preOrderprint();
                    System.out.println();
                    System.out.println("PosOrderPrint : ");
                    resp.postOrderprint();
                    break;
                case 4:
                    System.out.println("Masukkan data yang akan dihapus : ");
                    resp.delete(in.nextInt());
                    break;

            }

        }


    }
}
