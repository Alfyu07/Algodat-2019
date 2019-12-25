//import StackQueue.*;
//import java.util.Scanner;
//
//public class TowerOfHanoi {
//
//    static Stack tujuan (String pilih, Stack A, Stack B, Stack C){
//       if(pilih.charAt(0) == 'A' || pilih.charAt(0) == 'a'){
//           return A;
//       }
//       if(pilih.charAt(0) == 'B' || pilih.charAt(0) == 'b'){
//           return B;
//       }
//       if(pilih.charAt(0) == 'C' || pilih.charAt(0) == 'c') {
//           return C;
//       }
//       return null;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Stack A = new Stack();
//        Stack B = new Stack();
//        Stack C = new Stack();
//        int movee = 1;
//        System.out.print("Masukkan jumlah piringan : ");
//        int jml = in.nextByte();
//        for(int i = jml; i >= 1; i--){
//            A.Specialpush(i);
//        }
//        while(A.getTop() != null || B.getTop() != null){
//            System.out.print("A : ");
//            A.show();
//            System.out.print("B : ");
//            B.show();
//            System.out.print("C : ");
//            C.show();
//            System.out.println("===================");
//            System.out.print("Pindah dari : ");
//            String pilih = in.next();
//            int move = tujuan(pilih,A,B,C).peek();
//            System.out.print("Pindah ke : ");
//            String ke  = in.next();
//            boolean berhasil = tujuan(ke,A,B,C).Specialpush(move);
//            if(berhasil == true) {
//                tujuan(pilih, A, B, C).Specialpop();
//            }
//            movee++;
//        }
//        System.out.println("Menang!!!\nAnda menang pada langkah ke : " + movee);
//
//    }
//}
