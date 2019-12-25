package Basic;

public class Stack {
    private Node bottom;
    private Node top;
    public int peek(){
        return top.number;
    }

    public Node getTop() {
        return top;
    }

    public Node getBottom() {
        return bottom;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public boolean Specialpush(int number){
        Node baru = new Node(number);
        if(top == null){
            bottom = top = baru;
            return true;
        }
        if(peek() < number){
            System.out.println("ora iso");
            return false;
        }
        top.next = baru;
        top = baru;
        return true;
    }
    public void push(String data){
     Node baru = new Node(data);
        if (isEmpty()) {
            top = baru;
            return;
        }
        baru.next = top;

        top = baru;
    }
    public void push(String nama, int number){
        Node baru = new Node(number,nama);
        if (isEmpty()) {
            top = baru;
            return;
        }
        baru.next = top;

        top = baru;
    }
    public void pushInt(String data){
        Node baru = new Node(data);
        if (isEmpty()) {
            top = baru;
            return;
        }
        baru.next = top;
        top = baru;
    }
    public String popString(){
        Node current = top;
        if ( current == null ){
            System.out.println("Tidak ada node");
            return "" ;
        }
        String tmp = top.nama;
        top = top.next;
        return tmp;
    }
    public int Specialpop(){
        int simpan = top.number;
        Node bantu = bottom;
        while(bantu.next != null && bantu.next != top){
            bantu = bantu.next;
        }
        if(bantu.next == null){
            bottom = null;
            top = bottom;
        }else{
            bantu.next = null;
            top = bantu;
        }
        return simpan;
    }

    public void show(){
        Node bantu = bottom;
        while(bantu != null){
            System.out.print(bantu.number + " ");
            bantu = bantu.next;
        }
        System.out.println();
    }
}
