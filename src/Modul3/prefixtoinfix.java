package Modul3;

import java.util.Scanner;
import Basic.Stack;

public class prefixtoinfix {

    static String toPrefix(String operasi) {
        String tmp = "";
        Stack temp = new Stack();
        for (Character now : operasi.toCharArray()) {
            if (now == '+' || now == '-' || now == '/' || now == '*') {
                String opand1 = temp.popString();
                String opand2 = temp.popString();
                tmp = "";
                tmp += now ; tmp+=opand2; tmp+=opand1;
                temp.push(tmp);
            } else {
                tmp = "";
                tmp += now;
                temp.push(tmp);
            }
        }
        return temp.getTop().nama;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack temp = new Stack();
        System.out.println("Masukkan Postfix : ");
        String operasi = in.next();

        String prefix = toPrefix(operasi);
        System.out.println("Prefix : " + prefix);

        for(int i = prefix.length()-1; i>= 0; i--){
            String tmp = "";
            if (prefix.charAt(i) == '+' || prefix.charAt(i) == '-' || prefix.charAt(i) == '/' || prefix.charAt(i) == '*') {
                String opand1 = temp.popString();
                String opand2 = temp.popString();
                tmp = "";
                tmp+=opand1;
                tmp += prefix.charAt(i) ;
                tmp+=opand2;
                temp.push(tmp);
            } else {
                tmp = "";
                tmp += prefix.charAt(i);
                temp.push(tmp);
            }
        }
        String postfix = temp.getTop().nama;
        System.out.println("Infix : " + postfix);
    }
}
