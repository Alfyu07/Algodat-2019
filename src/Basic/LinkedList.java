package Basic;

public class LinkedList {
    public Node head;
    public Node tail;
    public boolean isEmpty(){
        return head == null;
    }
    public void addfirst(Vertex data){
        Node baru = new Node(data);
        if(head == null){
            head = baru;
        }else{
            baru.next = head;
            head = baru;
        }
    }
    public void addfirst(int data){
        Node baru = new Node(data);
        if(head == null){
            head = baru;
        }else{
            baru.next = head;
            head = baru;
        }
    }
    public void addlast(Vertex data){
        Node baru = new Node(data);
        if(head == null) {
            head = tail =baru;
        }else{
            tail.next = baru;
            tail = baru;
        }
    }
    public void remove(int currentdata){
        Node current = head;
        Node prev = null;
        if(current.number == currentdata){
            head = head.next;
            return;
        }
        while(current != null && current.number != currentdata){
            prev = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        prev.next = current.next;
    }
    public void addpriority(int data){
        Node baru = new Node(data);
        if (head == null) {
            head = tail = baru;
            return;
        }
        Node bantu = head;
        while(bantu != null){
            if(head.number > baru.number){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(tail.number <= baru.number){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(baru.number >= bantu.number && baru.number < bantu.next.number ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }
    }

    public void addpriority(Vertex data, int [] weight){
        Node baru = new Node(data);
        if (head == null) {
            head = tail = baru;
            return;
        }
        Node bantu = head;
        while(bantu != null){
            if(weight[head.data.label] > weight[baru.data.label]){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(weight[tail.data.label] <= weight[baru.data.label]){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(weight[baru.data.label] >= weight[bantu.data.label] && weight[baru.data.label] < weight[bantu.next.data.label] ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }
    }
    public int removeint(){
        int simpan = head.number;
        if(head == null){
            return -1;
        }else if(head == tail){
            head = null;
        }else{
            head = head.next;
        }
        return simpan;
    }

    public Vertex remove(){
       Node simpan = head;
       if(head == null){
          return null;
       }else if(head == tail){
           head = null;
       }else{
            head = head.next;
       }
       return simpan.data;
    }
    public void display(){
        Node bantu = head;
        while(bantu != null){
            if(bantu == head){
                System.out.print(bantu.data.kota);
            }else{
                System.out.print(" -> " + bantu.data.kota);
            }
            bantu = bantu.next;
        }
        System.out.println();
    }

}
