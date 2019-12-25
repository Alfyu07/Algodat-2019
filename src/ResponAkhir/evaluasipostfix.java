class nud{
    int chara;
    nud next;
    public nud(int chara){this.chara = chara;}
}

class stack{
    nud top;
    void push(int chara){
        nud baru = new nud(chara);
        if(top == null){
            top  = baru;
            return;
        }
        baru.next = top;
        top = baru;
    }
    int pop(){
        if(top == null){
            return ' ';
        }
        int simpan = top.chara;
        top = top.next;
        return simpan;
    }
}
public class evaluasipostfix {
    static boolean isOperator(char cur){
        if(cur == '*'|| cur == '/'|| cur == '+'||cur == '-'||cur == '^'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        stack bantu = new stack();
        String exp = "523-9*+";
        String e = "5";
        int hasil = 0;
        for(int i = 0; i<exp.length(); i++){
            if(isOperator(exp.charAt(i))){
                int oper1 = bantu.pop();
                int oper2 = bantu.pop();
                switch (exp.charAt(i)){
                    case '+':
                        oper2 +=oper1;
                        break;
                    case '/':
                        oper2/=oper1;
                        break;
                    case'*':
                        oper2*=oper1;
                        break;
                    case '-':
                        oper2-=oper1;
                        break;
                }
               bantu.push(oper2);
            }else{
                bantu.push(exp.charAt(i) - '0');
            }
        }
        System.out.println(bantu.top.chara);
    }
}
