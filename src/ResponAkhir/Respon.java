import java.util.Scanner;
class node{
    String barang;
    node[] prev;
    node[] next;
    int jml = 0;
    public node(String barang, int jml)
    {
        this.barang = barang;
        this.jml = jml;
        this.prev = new node[jml];
        this.next = new node[jml];
    }
    int ambilJml()
    {
        return jml;
    }
}
class ayu{
    node head;
    void tambahbelakang(String nama, int posisi){
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan jumlah pointer  : ");
        int jml = in.nextInt();
        if(head == null)
        {
            head = new node(nama,jml);
            return;
        }
        if(posisi>=head.ambilJml())
        {
            System.out.println("Jumlah Pointer kurang");
            return;
        }
        node baru = new node(nama,jml);
        node bantu = head;
        while(bantu.next[posisi] != null)
        {
            bantu = bantu.next[posisi];
        }
        bantu.next[posisi] = baru;
        baru.prev[posisi] = bantu;
    }
    void tambahdepan(String nama,int posisi){
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan jumlah pointer : ");
        int jml = in.nextInt();
        if(head == null)
        {
            head = new node(nama,jml);
            return;
        }
        if(posisi>=head.ambilJml())
        {
            System.out.println("Pointer kurang");
            return;
        }
        node baru = new node(nama,jml);
        baru.next[posisi] = head;
        head.prev[posisi] = baru;
        head = baru;
    }
    void hapusdepan(int posisi){
        if(posisi>=head.ambilJml())
        {
            System.out.println("Jumlah pointer kurang");
            return;
        }
        if(head.prev[posisi] == null)
        {
            head = null;
            return;
        }
        head = head.next[posisi];
        head.prev[posisi] = null;
    }
    void removelast(int posisi){
        if(posisi>=head.ambilJml())
        {
            System.out.println("Jumlah pointer kurang");
            return;
        }
        if(head.next[posisi] == null)
        {
            head = null;
            return;
        }
        node bantu = head;
        while(bantu.next[posisi].next[posisi] != null){
            bantu = bantu.next[posisi];
        }
        bantu.next[posisi] = null;
    }
    void show(int posisi){
            node bantu = head;

            while(bantu.next[posisi] != null){
                System.out.print(bantu.barang + " ");
                bantu = bantu.next[posisi];
            }
            System.out.println(bantu.barang);
    }

}
public class Respon {
    public static void main(String[] args) {
        ayu penunjuk = new ayu();
        Scanner in = new Scanner(System.in);
        int posisi = -1;
        System.out.println("Tambah depan : ");
        System.out.println("=========================");
        System.out.print("Masukkan pada posisi : ");
        posisi = in.nextInt()-1;
        System.out.print("Masukkan nama : ");
        penunjuk.tambahdepan(in.next(), posisi);
        System.out.println("Data pada posisi ke- " + (posisi+1) + ":");
        if(penunjuk.head == null){
            System.out.println("Kosong");
        }else{
            penunjuk.show(posisi);
        }
        System.out.println("Tambah belakang ");
        System.out.println("=========================");
        System.out.print("Masukkan pada posisi : ");
        posisi = in.nextInt()-1;
        System.out.print("Masukkan pada nama : ");
        penunjuk.tambahbelakang(in.next(), posisi);
        System.out.println("Data pada posisi ke- " + (posisi+1) + ":");
        if(penunjuk.head == null){
            System.out.println("Kosong");
        }else{
            penunjuk.show(posisi);
        }
        System.out.println("Hapus depan ");
        System.out.println("=========================");
        System.out.print("Hapus depan pada posisi :");
        posisi = in.nextInt()-1;
        if(penunjuk.head == null)
        {
        System.out.println("kosong");
        }
        else
        {
        penunjuk.hapusdepan(posisi);
        }
        System.out.println("Data pada posisi ke- " + (posisi+1) + ":");
        if(penunjuk.head == null){
            System.out.println("Kosong");
        }else{
            penunjuk.show(posisi);
        }
        System.out.println("4. Hapus belakang");
        System.out.println("=========================");
        System.out.print("Hapus belakang posisi ke :");
        posisi = in.nextInt()-1;
        if(penunjuk.head == null)
        {
        System.out.println("kosong");
        }
        penunjuk.removelast(posisi);
        System.out.println("Data pada posisi ke- " + (posisi+1) + ":");
        penunjuk.show(posisi);

        System.out.println("Terimakasih");

    }
}
