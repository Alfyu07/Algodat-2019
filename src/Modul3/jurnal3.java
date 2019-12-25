import java.util.Scanner;

class tumpuk {
    class node {
        String elemen;
        node next;
        public node(String elemen) {
            this.elemen = elemen;
        }
    }
    node top;
    boolean isEmpty(){
        return top == null;
    }
    void push(String elemen) {
        node baru = new node(elemen);
        if (isEmpty()) {
            top = baru;
            return;
        }
        baru.next = top;

        top = baru;
    }
    String pop(){
        if(isEmpty()){
            return"";
        }
        String atas = top.elemen;
        top = top.next;

        return atas;
    }
    String gettop(){
        return top.elemen;
    }
}

public class jurnal3 {
    static int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        if (operator == '^') {
            return 3;
        }
        return -1;
    }

    static void toPrefix(String operasi) {
        String tmp = "";
        tumpuk temp = new tumpuk();
        for (Character now : operasi.toCharArray()) {
            if (now == '+' || now == '-' || now == '/' || now == '*') {
                String opand1 = temp.pop();
                String opand2 = temp.pop();
                tmp = "";
                tmp += now ; tmp+=opand2; tmp+=opand1;
                temp.push(tmp);
            } else {
                tmp = "";
                tmp += now;
                temp.push(tmp);
            }
        }
        System.out.println("Prefix : " + temp.top.elemen);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        tumpuk operator = new tumpuk();
        tumpuk operand = new tumpuk();
        System.out.println("Masukkan Notasi Infix : ");
        String operasi = in.next();
        String hasil = "";
        String tmp = "";
        for (int i = 0; i < operasi.length(); i++) {
            char now = operasi.charAt(i);
            if (now == ('+') || now == ('*') || now == ('-') || now == ('/')) {
                while (operator.top != null && priority(operator.gettop().charAt(0)) >= priority(now)) {
                    hasil += operator.pop();
                }
                tmp = "";
                tmp += now;
                operator.push(tmp);
            } else if (now == '(') {
                tmp = "";
                tmp += now;
                operator.push(tmp);
            } else if (now == ')') {
                while (operator.gettop().charAt(0) != '(') {
                    hasil += operator.pop();
                }
                operator.pop();
            } else {
                hasil += now;
            }
        }
        while (operator.top != null) {
            hasil = hasil + operator.pop();
        }
        System.out.println("Postfix : " + hasil);
        toPrefix(hasil);
    }
}