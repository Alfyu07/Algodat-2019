package UdinRespon;

class kota{
    String nama;
    int label;
    kota next;
    jalan jalan;
    public kota (int label, String nama){
        this.label = label;
        this.nama = nama;
    }
}

class jalan{
    kota tujuan;
    jalan nextj;
    double jarak;
    public jalan(double jarak, kota tujuan){
        this.jarak = jarak;
        this.tujuan = tujuan;
    }
}
class node{
    int number;
    kota data;
    node prevnode;
    node nextnode;
    public node (kota data){
        this.data = data;
    }
    public node (int number){
        this.number = number;
    }
}
class queue{
    node head, tail;
    void addpiority(kota data, double [] jarak){
        node baru = new node(data);
        if(head == null){
            head = tail = baru;
        }else{
            node bantu = head;
            while(bantu != null){
                if(jarak[head.data.label] > jarak[baru.data.label]){
                    baru.nextnode = head;
                    head.prevnode = baru;
                    head = baru;
                    return;
                }else if(jarak[tail.data.label] <= jarak[baru.data.label]){
                    tail.nextnode = baru;
                    baru.prevnode = tail;
                    tail = baru;
                    return;
                }else if(jarak[baru.data.label] >= jarak[bantu.data.label] && jarak[baru.data.label] < jarak[bantu.nextnode.data.label]){
                    baru.nextnode = bantu.nextnode;
                    baru.prevnode = bantu;
                    bantu.nextnode.prevnode = baru;
                    bantu.nextnode = baru;
                    return;
                }
                bantu = bantu.nextnode;
            }
        }
    }
    void addlast(kota data){
        node baru = new node(data);
        if(head == null){
            head = tail = baru;
        }else{
            tail.nextnode = baru;
            baru.prevnode = tail;
            tail = baru;
        }
    }
    kota remove(){
        kota simpan = head.data;
        if(head == null){
            return null;
        }else if(head == tail){
            head = null;
        }else{
            head = head.nextnode;
        }
        return simpan;
    }
    void display(){
        node bantu = head;
        while(bantu != null){
            if(bantu == head){
                System.out.print(bantu.data.nama);
            }else{
                System.out.print(" -> " + bantu.data.nama);
            }
            bantu = bantu.nextnode;
        }
        System.out.println();
    }
}

class pulau{
    kota head, tail;
    int size = 0;
    void add(int label, String nama){
        if (head ==  null){
            head = tail = new kota(label, nama);
        }
        else {
            tail.next = new kota(label, nama);
            tail = tail.next;
        }
        size++;
    }

    kota carikota(String asal){
        kota now = head;
        while (now!=null){
            if (now.nama.equalsIgnoreCase(asal)){
                return now;
            }
            now = now.next;
        }
        return null;
    }
    kota carikota(int asal){
        kota now = head;
        while (now!=null){
            if (now.label == asal){
                return now;
            }
            now = now.next;
        }
        return null;
    }

    void tambahjalan(double jarak, int dari, int ke){
        kota asal = carikota(dari);
        kota tujuan = carikota(ke);

        jalan sekarang = asal.jalan;
        if (asal.jalan== null){
            asal.jalan = new jalan (jarak, tujuan);
        }
        else {
            while (sekarang.nextj != null){
                sekarang = sekarang.nextj;
            }
            sekarang.nextj=new jalan(jarak, tujuan);
        }

        jalan sekarang2 = tujuan.jalan;
        if (tujuan.jalan == null){
            tujuan.jalan = new jalan (jarak, asal);
        }
        else {
            while (sekarang2.nextj != null){
                sekarang2 = sekarang2.nextj;
            }
            sekarang2.nextj=new jalan(jarak, asal);
        }
    }

    double [] dijkstra(String src, int [] prev){
        double [] jarak = new double [size];
        boolean [] visited = new boolean[size];
        queue que = new queue();
        double UkeV = 0;
        kota asal = carikota(src);
        for(int i = 0; i<size; i++){
            if(i == asal.label){
                jarak[i] = 0;
            }else{
                jarak[i] = Integer.MAX_VALUE;
            }
        }
        prev[asal.label] = -1;
        que.addpiority(asal, jarak);
        while(que.head != null){
            kota cur = que.remove();
            visited[cur.label] = true;
            jalan bantu = cur.jalan;
            while(bantu != null){
                UkeV = jarak[cur.label] + bantu.jarak;
                if(UkeV < jarak[bantu.tujuan.label]){
                    jarak[bantu.tujuan.label] = UkeV;
                    prev[bantu.tujuan.label] = cur.label;
                }
                if(!visited[bantu.tujuan.label]){
                    que.addpiority(bantu.tujuan, jarak);
                }
                bantu = bantu.nextj;
            }
        }
        return jarak;
    }
}

public class respon{
    public static void main(String[] args) {
        String [] kotaa = {"Pagutan","Lingkar","Pagesangan","Sekarbela",
                "Ampenan","Kekalik","Sriwijaya","Unram"};
        pulau respon = new pulau();
        int jumlah = 8;
        for(int i = 0; i<kotaa.length; i++){
            respon.add(i, kotaa[i]);
        }
        int[] prev = new int[kotaa.length];
        respon.tambahjalan( 7.3 , 0, 1);
        respon.tambahjalan( 3 , 0, 2);
        respon.tambahjalan( 6 , 0, 3);
        respon.tambahjalan( 8.4 , 2, 5);
        respon.tambahjalan( 15 , 1, 4);
        respon.tambahjalan( 5 , 3, 6);
        respon.tambahjalan( 5 , 3, 6);
        respon.tambahjalan( 3.5 , 4, 7);
        respon.tambahjalan( 1, 5, 7);
        respon.tambahjalan( 2 , 6, 7);
        double [] jarak = respon.dijkstra("Unram", prev);
        double min = jarak[0];
        int indexmin = 0;
        for(int i = 1; i<jarak.length; i++){
            if( jarak[i]< min && jarak[i] != 0){
                min = jarak[i];
                indexmin = i;
            }
        }

        System.out.println("Jalur yang ada : ");
        for(int asal = 0; asal<7; asal++){
            queue jalur = new queue();
            int simpan = asal;
            while(simpan != -1){
                jalur.addlast(respon.carikota(simpan));
                simpan = prev[simpan];
            }
            jalur.display();
            System.out.println("total jarak : " + jarak[asal] + " km");
        }
        queue jalur = new queue();
        while(indexmin != -1){
            jalur.addlast(respon.carikota(indexmin));
            indexmin = prev[indexmin];
        }
        System.out.println("\nJalur terdekat : ");
        jalur.display();
    }
}