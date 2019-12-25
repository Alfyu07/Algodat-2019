package Modul3;

import Basic.Stack;
public class jurnal1{
    public static void main(String[] args) {
        Stack hangA = new Stack();
        Stack hangB = new Stack();
        Stack landas = new Stack();
        System.out.println("==================================================");
        System.out.println("pesawat 123, 666, 737, 369, berada di hanggar A :");
        hangA.push("wantutri", 123);
        hangA.push("seventriseven", 737);
        hangA.push("trisixnain", 369);
        hangA.push("sixsixsix", 666);
        hangA.show();
        System.out.println("\npesawat 648, 400 berada di hanggar A :");
        hangB.push("fourzerozero", 400);
        hangB.push("sixfoureight", 648);
        hangB.show();

        //186 221 lepas landas belum
        landas.push("tutuwan",221);
        landas.push("waneightsix",186);
        System.out.println("\npesawat yang saat ini lepas landas : ");
        landas.show();
        //666 lepas landas
        int kode666 = hangA.getTop().number;
        String pesawat666 = hangA.popString();
        landas.push(pesawat666, kode666);
        System.out.println("\npesawat " + pesawat666 + " dengan kode " + kode666 + " lepas landas");
        int kode648 = hangB.getTop().number;
        String pesawat648 = hangB.popString();
        landas.push(pesawat648,kode648);
        System.out.println("pesawat " + pesawat648 + " dengan kode " + kode648 + " lepas landas");
        System.out.println("\npesawat yang saat ini lepas landas : ");
        landas.show();

        System.out.println("\npesawat 186 masuk ke hangar B :");
        hangB.push("waneightsix", 186);
        hangB.show();
        System.out.println("\npesawat 666 masuk ke hangar B :");
        hangB.push("sixsixsix", 666);
        hangB.show();
        System.out.println("\npesawat 221 masuk ke hangar A :");
        hangA.push("tutuwan", 221);
        hangA.show();

        kode648 = landas.getTop().number;
        pesawat648 = landas.popString();
        System.out.println("pesawat " + pesawat648 + " dengan kode " + kode648 + " hilang kontak ");
        System.out.println("\npesawat yang saat ini lepas landas : ");
        landas.show();
    }
}