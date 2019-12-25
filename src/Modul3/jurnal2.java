import Modul3.PriorityQueue;

public class jurnal2 {
    public static void main(String[] args) {
        PriorityQueue antrian = new PriorityQueue();
        antrian.addpriority("Jason",1);
        antrian.addpriority("Meg", 4);
        antrian.addpriority("Piper",10);
        antrian.addpriority("Thalia",1);
        antrian.addpriority("Percy",3);
        antrian.addpriority("Will",7);
        antrian.addpriority("Connor",12);
        antrian.addpriority("Travis",12);
        antrian.addpriority("Nico",13);
        System.out.println("Antrian setelah di panggil : ");
        antrian.display();
    }
}