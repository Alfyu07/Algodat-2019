class Node{
    int data;
    Node next;
    public Node (int data) {
        this.data = data;
    }
}
class Linkedlist{
    Node head;
    Node tail;
    void addfirst(int data){
        Node baru = new Node(data);
        if(head == null){
            head = tail = baru;
            return;
        }
        baru.next = head;
        head = baru;
    }
    void addlast(int data){
        Node baru = new Node(data);
        if(head == null){
            head = tail = baru;
            return;
        }
        tail.next = baru;
        tail = baru;
    }
    void addafter(int data, int curr){
        if(head == null){
            return;
        }
        Node baru = new Node(data);
        Node bantu = head;
        while(bantu != null && bantu.data != curr){
            bantu = bantu.next;
        }
        if(bantu == head){
            baru.next = head;
            head = baru;
            return;
        }
        baru.next = bantu.next;
        bantu.next = baru;
    }
    void disp(){
        Node bantu = head;
        while(bantu != null){
            System.out.println(bantu.data);
            bantu = bantu.next;
        }
    }

}

public class reversearray {
    static boolean binarysearch(int [] arr, int cari){
        return search(0,arr.length, arr, cari);
    }
    static boolean search(int low, int high, int [] arr, int cari){
        int mid = (low + high)/2;
        System.out.println(arr[mid]);
        if(low == high && arr[mid] != cari){
            return false;
        }
        if(cari > arr[mid]){
            return search(mid, high, arr, cari);
        }if(arr[mid] == cari){
            return true;
        }else{
            return search(low, mid, arr, cari);
        }

    }
    public static void main(String[] args) {
//        int [] arr = {1,2,3,4,5,6,7,8,9};
//        System.out.println(binarysearch(arr,9));
        Linkedlist test = new Linkedlist();
        test.addfirst(9);
        test.addlast(10);
        test.addafter(11,10);
        test.disp();

    }
}
